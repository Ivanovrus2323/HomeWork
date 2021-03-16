package HomeWork7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame{

    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 500;
    private static final int WINDOW_POS_X = 800;
    private static final int WINDOW_POS_Y = 300;

    private SettingsWindow settingsWindow;
    MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocation(WINDOW_POS_X, WINDOW_POS_Y);
        setTitle("игра крестики нолики(MainWindow)");
        setResizable(true);

        settingsWindow = new SettingsWindow();

        JButton btnStart = new JButton("Star new game");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        JButton btnExit = new JButton("Exit game");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        JPanel panelButton = new JPanel();


        panelButton.setLayout(new GridLayout(1,2));
        panelButton.add(btnStart);
        panelButton.add(btnExit);

        add(panelButton, BorderLayout.SOUTH);

        setVisible(true);
    }






}
