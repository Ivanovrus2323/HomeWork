package HomeWorkChat;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

public class Client {
    private static final int HISTORY_LIMIT = 10;
    private static final String END_LINE = "   --- End of session ---";

    @FXML
    Button btnSend;
    @FXML
    TextArea txtAreaMsg;
    @FXML
    TextArea txtAreaChat;

    private String msg;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private File fileHistory;
    private BufferedWriter bwToFileHistory;

    @FXML
    public void initialize() throws IOException {
        txtAreaMsg.textProperty().addListener((observable, oldValue, newValue) ->
                btnSend.setDisable(observable.getValue().isEmpty()));

        socket = new Socket(ChatConstants.HOST, ChatConstants.PORT);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

        Thread thread = new Thread(() -> {
            try {
                while (true) {
                    String strFromServer = in.readUTF();
                    if (strFromServer.startsWith(ChatConstants.AUTH_SUCCESS)) {
                        prepareHistoryInput(strFromServer);
                        break;
                    }
                    txtAreaChat.appendText(strFromServer + "\n");
                }

                txtAreaChat.clear();
                loadHistory();


                while (true) {
                    String strFromServer = in.readUTF();
                    if (strFromServer.equals(ChatConstants.STOP_WORD)) {
                        break;
                    }
                    txtAreaChat.appendText(strFromServer + "\n");
                    bwToFileHistory.write(strFromServer + "\n");
                    bwToFileHistory.flush();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    bwToFileHistory.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Platform.exit();
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    @FXML
    public void btnClicked(ActionEvent actionEvent) {
        sendMessage();
    }

    @FXML
    public void txtAreaSendMsg(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            keyEvent.consume();
            sendMessage();
        }
    }

    private void sendMessage() {
        try {
            if (!(msg = txtAreaMsg.getText().trim()).isEmpty()) {
                txtAreaMsg.clear();
                out.writeUTF(msg);
                txtAreaChat.setScrollTop(Double.MAX_VALUE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void prepareHistoryInput(String strFromServer) throws IOException {
        String[] parts = strFromServer.split("\\s+");
        fileHistory = new File("history_" + parts[1] + ".txt");

        if (!fileHistory.exists()) fileHistory.createNewFile();

        bwToFileHistory = new BufferedWriter(new FileWriter(fileHistory, true));
    }


    private void saveHistory() {

        try {
            if (!fileHistory.exists()) fileHistory.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileHistory, true))) {


            List<String> list = Arrays.stream(txtAreaChat.getText().split("\\n"))
                    .collect(Collectors.toCollection(ArrayList::new));


            Iterator<String> iter = list.iterator();
            int endLinePos = 0;
            for (int i = 1; i <= list.size(); i++) {
                if (iter.next().equals(END_LINE)) {
                    endLinePos = i;
                }
            }


            bw.write(list.stream()
                    .skip(endLinePos)
                    .collect(Collectors.joining("\n"))
            );
            bw.write("\n" + END_LINE + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void loadHistory() {
        if (!fileHistory.exists()) return;

        try {

            long countLines = Files.lines(fileHistory.toPath()).count();


            if (countLines > HISTORY_LIMIT) {
                txtAreaChat.appendText("... " + (countLines - HISTORY_LIMIT) + " more lines\n");
            } else {
                countLines = HISTORY_LIMIT;
            }


            Files.lines(fileHistory.toPath())
                    .skip(countLines - HISTORY_LIMIT)
                    .forEach(str -> txtAreaChat.appendText(str + "\n"));

        } catch (IOException e) {
            e.printStackTrace();
        }




    }

}