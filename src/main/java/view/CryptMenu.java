package view;

import config.AppProperties;
import config.Config;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class CryptMenu extends JMenuBar {
    private final JMenuItem encrypt;
    private final JMenuItem decrypt;
    private final JMenuItem openDefaultDir;
    private final JMenuItem exit;
    private final JRadioButtonMenuItem saveInCurrentDir;
    private final JRadioButtonMenuItem saveInDefaultDir;
    private final JMenuItem setDefaultDir;
    private final JMenuItem aboutFileCrypt;

    public CryptMenu(){
        super();
        setBackground(new Color(217, 221, 224));
        setBorder(BorderFactory.createEmptyBorder());

        Font sizedFont = Config.getFont().deriveFont(14f);

        /* File */

        JMenu file = new JMenu("   File");
        file.setFont(sizedFont);
        file.setBorderPainted(false);

        encrypt = new JMenuItem("   Encrypt");
        encrypt.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        menuItemFormat(encrypt);

        decrypt = new JMenuItem("   Decrypt");
        decrypt.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        menuItemFormat(decrypt);

        openDefaultDir = new JMenuItem("   Open default folder");
        menuItemFormat(openDefaultDir);
        if (AppProperties.getDefaultDir().isBlank()){
            openDefaultDir.setEnabled(false);
        }

        exit = new JMenuItem("   Exit");
        menuItemFormat(exit);

        file.add(encrypt);
        file.add(decrypt);
        file.addSeparator();
        file.add(openDefaultDir);
        file.addSeparator();
        file.add(exit);

        /* Options */

        JMenu options = new JMenu("Options");
        options.setFont(sizedFont);
        options.setBorderPainted(false);

        saveInCurrentDir = new JRadioButtonMenuItem("Save files in current folder");
        menuItemFormat(saveInCurrentDir);
        saveInCurrentDir.setSelected(true);

        saveInDefaultDir = new JRadioButtonMenuItem("Save files in default folder");
        menuItemFormat(saveInDefaultDir);
        if (AppProperties.getDefaultDir().isBlank()){
            saveInDefaultDir.setEnabled(false);
        }

        ButtonGroup saveGroup = new ButtonGroup();
        saveGroup.add(saveInCurrentDir);
        saveGroup.add(saveInDefaultDir);

        options.add(saveInCurrentDir);
        options.add(saveInDefaultDir);

        /* Settings */

        JMenu settings = new JMenu("Settings");
        settings.setFont(sizedFont);
        settings.setBorderPainted(false);

        setDefaultDir = new JMenuItem("Set default folder");
        menuItemFormat(setDefaultDir);
        settings.add(setDefaultDir);

        /* About */

        JMenu about = new JMenu("About");
        about.setFont(sizedFont);
        about.setBorderPainted(false);

        aboutFileCrypt = new JMenuItem("About FileCrypt");
        menuItemFormat(aboutFileCrypt);
        about.add(aboutFileCrypt);

        add(file);
        add(options);
        add(settings);
        add(about);
        setEnabled(true);
        setVisible(true);
    }

    private void menuItemFormat(JMenuItem c){
        Font sizedFont = Config.getFont().deriveFont(13f);
        c.setFont(sizedFont);
        c.setMargin(new Insets(25, 15, 25, 15));
        c.setIconTextGap(15);
        c.setHorizontalTextPosition(SwingConstants.LEFT);
        c.setBorderPainted(true);
    }

    public JMenuItem getEncrypt() {
        return encrypt;
    }

    public JMenuItem getDecrypt() {
        return decrypt;
    }

    public JMenuItem getExit() {
        return exit;
    }

    public JMenuItem getOpenDefaultDir() {
        return openDefaultDir;
    }

    public JRadioButtonMenuItem getSaveInCurrentDir() {
        return saveInCurrentDir;
    }

    public JRadioButtonMenuItem getSaveInDefaultDir() {
        return saveInDefaultDir;
    }

    public JMenuItem getSetDefaultDir() {
        return setDefaultDir;
    }

    public JMenuItem getAboutFileCrypt() {
        return aboutFileCrypt;
    }
}
