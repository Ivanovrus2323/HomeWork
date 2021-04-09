package HomeWorkJ6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

    public ChatServer(){
        ServerSocket serv = null;
        Socket sock = null;
        try {
            serv = new ServerSocket(9001);
            System.out.println("Server start");
            sock = serv.accept();
            System.out.println("Client connect");
            new Client(sock, "Server");
            while(true){
                if(sock.isClosed()){
                    break;
                }
            }
            serv.close();
            System.exit(0);
        } catch (IOException e) {
            System.out.println("error");
        } finally {
            try {
                serv.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new ChatServer();
    }
}