package view;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class CryptListCellRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof File file) {
                setText(file.getName());
            }
            return this;
    }
}

