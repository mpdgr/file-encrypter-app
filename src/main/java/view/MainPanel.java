package view;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    EncryptWindowPanel encryptWindowPanel;
    AddFileEncryptPanel addFileEncryptPanel;
    DecryptWindowPanel decryptWindowPanel;
    AddFileDecryptPanel addFileDecryptPanel;
    EncryptButtonPanel encryptButtonPanel;
    DecryptButtonPanel decryptButtonPanel;

    public MainPanel(){

        this.setSize(CryptFrame.getWIDTH(), CryptFrame.getHEIGHT());
        this.setBackground(Config.getColor());

        GridBagLayout GBLayout = new GridBagLayout();
        this.setLayout(GBLayout);
        int inset = CryptFrame.getWIDTH() / 100;

        TitlePanel titlePanel = new TitlePanel();
        GridBagConstraints titlePanelConstraints = new GridBagConstraints();
        titlePanelConstraints.gridx = 1;
        titlePanelConstraints.gridy = 1;
        titlePanelConstraints.gridwidth = 2;
        titlePanelConstraints.gridheight = 1;
        titlePanelConstraints.weightx = 100;
        titlePanelConstraints.weighty = 100;
        titlePanelConstraints.insets.set(inset, inset * 2, inset, inset * 2);
        titlePanelConstraints.fill = GridBagConstraints.BOTH;
        this.add(titlePanel, titlePanelConstraints);

        EncryptLabelPanel encryptLabelPanel = new EncryptLabelPanel();
        GridBagConstraints encryptLabelPanelConstraints = new GridBagConstraints();
        encryptLabelPanelConstraints.gridx = 1;
        encryptLabelPanelConstraints.gridy = 2;
        encryptLabelPanelConstraints.gridwidth = 1;
        encryptLabelPanelConstraints.gridheight = 1;
        encryptLabelPanelConstraints.weightx = 100;
        encryptLabelPanelConstraints.weighty = 100;
        encryptLabelPanelConstraints.insets.set(inset, inset * 2, inset, inset);
        encryptLabelPanelConstraints.fill = GridBagConstraints.BOTH;
        this.add(encryptLabelPanel, encryptLabelPanelConstraints);

        DecryptLabelPanel decryptLabelPanel = new DecryptLabelPanel();
        GridBagConstraints decryptLabelPanelConstraints = new GridBagConstraints();
        decryptLabelPanelConstraints.gridx = 2;
        decryptLabelPanelConstraints.gridy = 2;
        decryptLabelPanelConstraints.gridwidth = 1;
        decryptLabelPanelConstraints.gridheight = 1;
        decryptLabelPanelConstraints.weightx = 100;
        decryptLabelPanelConstraints.weighty = 100;
        decryptLabelPanelConstraints.insets.set(inset, inset, inset, inset * 2);
        decryptLabelPanelConstraints.fill = GridBagConstraints.BOTH;
        this.add(decryptLabelPanel, decryptLabelPanelConstraints);

        EncryptWindowPanel encryptWindowPanel = new EncryptWindowPanel();
        GridBagConstraints encryptWindowPanelConstraints = new GridBagConstraints();
        encryptWindowPanelConstraints.gridx = 1;
        encryptWindowPanelConstraints.gridy = 3;
        encryptWindowPanelConstraints.gridwidth = 1;
        encryptWindowPanelConstraints.gridheight = 1;
        encryptWindowPanelConstraints.weightx = 100;
        encryptWindowPanelConstraints.weighty = 100;
        encryptWindowPanelConstraints.insets.set(inset, inset * 2, inset, inset);
        encryptWindowPanelConstraints.fill = GridBagConstraints.BOTH;
        this.add(encryptWindowPanel, encryptWindowPanelConstraints);

        DecryptWindowPanel decryptWindowPanel = new DecryptWindowPanel();
        GridBagConstraints decryptWindowPanelConstraints = new GridBagConstraints();
        decryptWindowPanelConstraints.gridx = 2;
        decryptWindowPanelConstraints.gridy = 3;
        decryptWindowPanelConstraints.gridwidth = 1;
        decryptWindowPanelConstraints.gridheight = 1;
        decryptWindowPanelConstraints.weightx = 100;
        decryptWindowPanelConstraints.weighty = 100;
        decryptWindowPanelConstraints.insets.set(inset, inset, inset, inset * 2);
        decryptWindowPanelConstraints.fill = GridBagConstraints.BOTH;
        this.add(decryptWindowPanel, decryptWindowPanelConstraints);

        AddFileEncryptPanel addFileEncryptPanel = new AddFileEncryptPanel();
        GridBagConstraints addFileEncryptPanelConstraints = new GridBagConstraints();
        addFileEncryptPanelConstraints.gridx = 1;
        addFileEncryptPanelConstraints.gridy = 4;
        addFileEncryptPanelConstraints.gridwidth = 1;
        addFileEncryptPanelConstraints.gridheight = 1;
        addFileEncryptPanelConstraints.weightx = 100;
        addFileEncryptPanelConstraints.weighty = 100;
        addFileEncryptPanelConstraints.insets.set(inset, inset * 3, inset, inset);
        addFileEncryptPanelConstraints.fill = GridBagConstraints.BOTH;
        this.add(addFileEncryptPanel, addFileEncryptPanelConstraints);

        AddFileDecryptPanel addFileDecryptPanel = new AddFileDecryptPanel();
        GridBagConstraints addFileDecryptPanelConstraints = new GridBagConstraints();
        addFileDecryptPanelConstraints.gridx = 2;
        addFileDecryptPanelConstraints.gridy = 4;
        addFileDecryptPanelConstraints.gridwidth = 1;
        addFileDecryptPanelConstraints.gridheight = 1;
        addFileDecryptPanelConstraints.weightx = 100;
        addFileDecryptPanelConstraints.weighty = 100;
        addFileDecryptPanelConstraints.insets.set(inset, inset * 2, inset, inset * 2);
        addFileDecryptPanelConstraints.fill = GridBagConstraints.BOTH;
        this.add(addFileDecryptPanel, addFileDecryptPanelConstraints);

        EncryptButtonPanel encryptButtonPanel = new EncryptButtonPanel();
        GridBagConstraints encryptButtonPanelConstraints = new GridBagConstraints();
        encryptButtonPanelConstraints.gridx = 1;
        encryptButtonPanelConstraints.gridy = 5;
        encryptButtonPanelConstraints.gridwidth = 1;
        encryptButtonPanelConstraints.gridheight = 1;
        encryptButtonPanelConstraints.weightx = 100;
        encryptButtonPanelConstraints.weighty = 100;
        encryptButtonPanelConstraints.insets.set(inset, inset * 2, inset, inset);
        encryptButtonPanelConstraints.fill = GridBagConstraints.BOTH;
        this.add(encryptButtonPanel, encryptButtonPanelConstraints);

        DecryptButtonPanel decryptButtonPanel = new DecryptButtonPanel();
        GridBagConstraints decryptButtonPanelConstraints = new GridBagConstraints();
        decryptButtonPanelConstraints.gridx = 2;
        decryptButtonPanelConstraints.gridy = 5;
        decryptButtonPanelConstraints.gridwidth = 1;
        decryptButtonPanelConstraints.gridheight = 1;
        decryptButtonPanelConstraints.weightx = 100;
        decryptButtonPanelConstraints.weighty = 100;
        decryptButtonPanelConstraints.insets.set(inset, inset, inset, inset * 2);
        decryptButtonPanelConstraints.fill = GridBagConstraints.BOTH;
        this.add(decryptButtonPanel, decryptButtonPanelConstraints);

        this.encryptWindowPanel = encryptWindowPanel;
        this.addFileEncryptPanel = addFileEncryptPanel;
        this.decryptWindowPanel = decryptWindowPanel;
        this.addFileDecryptPanel = addFileDecryptPanel;
        this.encryptButtonPanel = encryptButtonPanel;
        this.decryptButtonPanel = decryptButtonPanel;
    }

    public EncryptWindowPanel getEncryptWindowPanel() {
        return encryptWindowPanel;
    }

    public void setEncryptWindowPanel(EncryptWindowPanel encryptWindowPanel) {
        this.encryptWindowPanel = encryptWindowPanel;
    }

    public AddFileEncryptPanel getAddFileEncryptPanel() {
        return addFileEncryptPanel;
    }

    public void setAddFileEncryptPanel(AddFileEncryptPanel addFileEncryptPanel) {
        this.addFileEncryptPanel = addFileEncryptPanel;
    }

    public DecryptWindowPanel getDecryptWindowPanel() {
        return decryptWindowPanel;
    }

    public void setDecryptWindowPanel(DecryptWindowPanel decryptWindowPanel) {
        this.decryptWindowPanel = decryptWindowPanel;
    }

    public AddFileDecryptPanel getAddFileDecryptPanel() {
        return addFileDecryptPanel;
    }

    public void setAddFileDecryptPanel(AddFileDecryptPanel addFileDecryptPanel) {
        this.addFileDecryptPanel = addFileDecryptPanel;
    }

    public EncryptButtonPanel getEncryptButtonPanel() {
        return encryptButtonPanel;
    }

    public void setEncryptButtonPanel(EncryptButtonPanel encryptButtonPanel) {
        this.encryptButtonPanel = encryptButtonPanel;
    }

    public DecryptButtonPanel getDecryptButtonPanel() {
        return decryptButtonPanel;
    }

    public void setDecryptButtonPanel(DecryptButtonPanel decryptButtonPanel) {
        this.decryptButtonPanel = decryptButtonPanel;
    }
}
