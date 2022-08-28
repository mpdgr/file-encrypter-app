package AWT;

import javax.swing.*;
import java.awt.*;

public class AddFileDecryptPanel extends JPanel {
    public AddFileDecryptPanel() {
        this.setBackground(Config.getColor());

        FlowLayout layout = new FlowLayout();
        layout.setAlignment(FlowLayout.LEFT);
        this.setLayout(layout);

        JButton buttonAdd = new AddRemoveButton("Add files...");
        this.add(buttonAdd);

        JButton buttonRemove = new AddRemoveButton("Remove files");
        this.add(buttonRemove);
    }
}
