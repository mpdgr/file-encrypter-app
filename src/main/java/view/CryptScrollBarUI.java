package view;

import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class CryptScrollBarUI extends BasicScrollBarUI {
    @Override
    protected void configureScrollBarColors() {
        this.thumbColor = new Color(217, 221, 224);
    }

    @Override
    protected void uninstallComponents() {
        super.uninstallComponents();
    }

    protected void removeGap() {
        this.incrGap = -18;
        this.decrGap = -18;
    }
}
