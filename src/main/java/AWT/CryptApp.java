package AWT;

import javax.swing.*;
import java.awt.*;

public class CryptApp {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            CryptFrame frame = new CryptFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            CryptPanel mainPanel = new CryptPanel();
            frame.add(mainPanel);
            frame.setVisible(true);
        });
    }
}
