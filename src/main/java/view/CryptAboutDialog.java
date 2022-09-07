package view;

import config.Config;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class CryptAboutDialog extends JDialog{
    //default size
    private final static int WIDTH = Config.getSizeReference() / 3;
    private final static int HEIGHT = Config.getSizeReference() / 5;

    //TODO:ICON DIALOGS
    public CryptAboutDialog(Frame owner) throws IOException {
        super(owner, true);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("FileCrypt");
        setLocationRelativeTo(owner);
        setIconImage(new ImageIcon("src/main/resources/icons/crypticon.png").getImage());
        JPanel messagePanel = new JPanel();
        messagePanel.setBackground(Config.getColor());

        messagePanel.setAlignmentY(Component.CENTER_ALIGNMENT);
        messagePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        String about =
                """
                <html>
                	<head>
                		<style>
                			p {align: left; margin: 3px;}
                		</style>
                	</head>
                	<body>
                		<p style="margin-top: 8px"><b>FileCrypt</b></p>
                		<p>Version: 1.0</p>
                		<p>Encryption algorithm: AES/CBC/PKCS5Padding</p>
                		<p>Key lenght: 256 bits</p>
                		<p>
                			Author:
                			<a href="mailto:michal.m.podgorski@gmail.com">
                                michal.m.podgorski@gmail.com</a>
                		</p>
                		<p>
                			Source code:
                			<a href="https://github.com/mpdgr/FileCrypt">
                                https://github.com/mpdgr/FileCrypt</a>
                		</p>
                	</body>
                </html>
                """;

        JEditorPane jEditorPane = new JEditorPane("text/html", about);
        jEditorPane.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
        jEditorPane.setEditable(false);
        jEditorPane.setOpaque(false);
        jEditorPane.addHyperlinkListener(event ->
        {
            if (HyperlinkEvent.EventType.ACTIVATED.equals(event.getEventType())) {
                try {
                    Desktop.getDesktop().browse(event.getURL().toURI());
                } catch (IOException | URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        });

        messagePanel.add(jEditorPane);
        add(messagePanel);
        setVisible(true);
    }
}
