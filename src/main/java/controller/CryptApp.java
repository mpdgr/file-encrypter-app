package controller;

import view.CryptFrame;
import view.MainPanel;

import javax.swing.*;
import java.awt.*;

public class CryptApp {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            CryptFrame frame = new CryptFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            MainPanel mainPanel = new MainPanel();
            frame.add(mainPanel);
            frame.setVisible(true);
        });




    }
}
