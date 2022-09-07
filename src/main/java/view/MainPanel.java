package view;

import config.Config;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private final EncryptWindowPanel encryptWindowPanel;
    private final AddFileEncryptPanel addFileEncryptPanel;
    private final DecryptWindowPanel decryptWindowPanel;
    private final AddFileDecryptPanel addFileDecryptPanel;
    private final EncryptButtonPanel encryptButtonPanel;
    private final DecryptButtonPanel decryptButtonPanel;

    public MainPanel(){

        this.setSize(CryptFrame.getWIDTH(), CryptFrame.getHEIGHT());
        this.setBackground(Config.getColor());

        GridBagLayout GBLayout = new GridBagLayout();
        this.setLayout(GBLayout);
        int inset = CryptFrame.getWIDTH() / 100;

        TitlePanel titlePanel = new TitlePanel();
        GridBagConstraints titlePanelConstraints = new GridBagConstraints();
        setDefaultGBC(titlePanelConstraints);
        titlePanelConstraints.gridx = 1;
        titlePanelConstraints.gridy = 1;
        titlePanelConstraints.gridwidth = 2;
        titlePanelConstraints.insets.set(inset, inset * 2, inset, inset * 2);
        this.add(titlePanel, titlePanelConstraints);

        EncryptLabelPanel encryptLabelPanel = new EncryptLabelPanel();
        GridBagConstraints encryptLabelPanelConstraints = new GridBagConstraints();
        setDefaultGBC(encryptLabelPanelConstraints);
        encryptLabelPanelConstraints.gridx = 1;
        encryptLabelPanelConstraints.gridy = 2;
        encryptLabelPanelConstraints.insets.set(inset, inset * 2, inset, inset);
        this.add(encryptLabelPanel, encryptLabelPanelConstraints);

        DecryptLabelPanel decryptLabelPanel = new DecryptLabelPanel();
        GridBagConstraints decryptLabelPanelConstraints = new GridBagConstraints();
        setDefaultGBC(decryptLabelPanelConstraints);
        decryptLabelPanelConstraints.gridx = 2;
        decryptLabelPanelConstraints.gridy = 2;
        decryptLabelPanelConstraints.insets.set(inset, inset, inset, inset * 2);
        this.add(decryptLabelPanel, decryptLabelPanelConstraints);

        EncryptWindowPanel encryptWindowPanel = new EncryptWindowPanel();
        GridBagConstraints encryptWindowPanelConstraints = new GridBagConstraints();
        setDefaultGBC(encryptWindowPanelConstraints);
        encryptWindowPanelConstraints.gridx = 1;
        encryptWindowPanelConstraints.gridy = 3;
        encryptWindowPanelConstraints.insets.set(inset, inset * 2, inset, inset);
        this.add(encryptWindowPanel, encryptWindowPanelConstraints);

        DecryptWindowPanel decryptWindowPanel = new DecryptWindowPanel();
        GridBagConstraints decryptWindowPanelConstraints = new GridBagConstraints();
        setDefaultGBC(decryptWindowPanelConstraints);
        decryptWindowPanelConstraints.gridx = 2;
        decryptWindowPanelConstraints.gridy = 3;
        decryptWindowPanelConstraints.insets.set(inset, inset, inset, inset * 2);
        this.add(decryptWindowPanel, decryptWindowPanelConstraints);

        AddFileEncryptPanel addFileEncryptPanel = new AddFileEncryptPanel();
        GridBagConstraints addFileEncryptPanelConstraints = new GridBagConstraints();
        setDefaultGBC(addFileEncryptPanelConstraints);
        addFileEncryptPanelConstraints.gridx = 1;
        addFileEncryptPanelConstraints.gridy = 4;
        addFileEncryptPanelConstraints.insets.set(inset, inset * 3, inset, inset);
        this.add(addFileEncryptPanel, addFileEncryptPanelConstraints);

        AddFileDecryptPanel addFileDecryptPanel = new AddFileDecryptPanel();
        GridBagConstraints addFileDecryptPanelConstraints = new GridBagConstraints();
        setDefaultGBC(addFileDecryptPanelConstraints);
        addFileDecryptPanelConstraints.gridx = 2;
        addFileDecryptPanelConstraints.gridy = 4;
        addFileDecryptPanelConstraints.insets.set(inset, inset * 2, inset, inset * 2);
        this.add(addFileDecryptPanel, addFileDecryptPanelConstraints);

        EncryptButtonPanel encryptButtonPanel = new EncryptButtonPanel();
        GridBagConstraints encryptButtonPanelConstraints = new GridBagConstraints();
        setDefaultGBC(encryptButtonPanelConstraints);
        encryptButtonPanelConstraints.gridx = 1;
        encryptButtonPanelConstraints.gridy = 5;
        encryptButtonPanelConstraints.insets.set(inset, inset * 2, inset, inset);
        this.add(encryptButtonPanel, encryptButtonPanelConstraints);

        DecryptButtonPanel decryptButtonPanel = new DecryptButtonPanel();
        GridBagConstraints decryptButtonPanelConstraints = new GridBagConstraints();
        setDefaultGBC(decryptButtonPanelConstraints);
        decryptButtonPanelConstraints.gridx = 2;
        decryptButtonPanelConstraints.gridy = 5;
        decryptButtonPanelConstraints.insets.set(inset, inset, inset, inset * 2);
        this.add(decryptButtonPanel, decryptButtonPanelConstraints);

        this.encryptWindowPanel = encryptWindowPanel;
        this.addFileEncryptPanel = addFileEncryptPanel;
        this.decryptWindowPanel = decryptWindowPanel;
        this.addFileDecryptPanel = addFileDecryptPanel;
        this.encryptButtonPanel = encryptButtonPanel;
        this.decryptButtonPanel = decryptButtonPanel;
    }

    private void setDefaultGBC(GridBagConstraints gbc) {
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 100;
        gbc.weighty = 100;
        gbc.fill = GridBagConstraints.BOTH;
    }

    public EncryptWindowPanel getEncryptWindowPanel() {
        return encryptWindowPanel;
    }

    public AddFileEncryptPanel getAddFileEncryptPanel() {
        return addFileEncryptPanel;
    }

    public DecryptWindowPanel getDecryptWindowPanel() {
        return decryptWindowPanel;
    }

    public AddFileDecryptPanel getAddFileDecryptPanel() {
        return addFileDecryptPanel;
    }

    public EncryptButtonPanel getEncryptButtonPanel() {
        return encryptButtonPanel;
    }

    public DecryptButtonPanel getDecryptButtonPanel() {
        return decryptButtonPanel;
    }
}
