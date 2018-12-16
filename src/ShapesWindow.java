import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ShapesWindow {
    JFrame sWindow;
    ShapesTest sPanel;
    Cube cube;
    double dBew;
    public void  springen(){


    }
    public ShapesWindow(){
        sWindow = new JFrame();
        sPanel = new ShapesTest();

        sWindow.setFocusable(true);
        sWindow.setVisible(true);
        sWindow.getContentPane().add(sPanel, BorderLayout.CENTER);
        sWindow.setSize(new Dimension(600,600));
    }

    public void animation(){

    }

}
