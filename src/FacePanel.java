import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class FacePanel extends JPanel {
    public BufferedImage image;
    int c = 0;

    public FacePanel(){
        super();
    }

    public void setFace(BufferedImage img){
        image = img;
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        if(this.image==null){
            System.out.println("Das JPanel ist leer.");
            return;
        }
        g.drawImage(this.image,10,10,this.image.getWidth(),this.image.getHeight(),null);
    }

}

