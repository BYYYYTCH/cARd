import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.glu.GLUquadric;
import com.jogamp.opengl.util.FPSAnimator;
import sun.security.provider.certpath.Vertex;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Shapes extends BufferedImagePanel {
    GL2 gl;
    private int height, width;
    private static String TITLE = "Sphere Shape Window";
    private static final int CANVAS_WIDTH = 500;
    private static final int CANVAS_HEIGHT = 500;
    private static final int FPS = 60;


    public Shapes(){
       /* GLCanvas canvas = new GLCanvas();
        GLProfile profile = GLProfile.get(GLProfile.GL3);
        GLCapabilities capabilities = new GLCapabilities(profile);
        canvas.setPreferredSize(new Dimension(CANVAS_WIDTH,CANVAS_HEIGHT));
        final FPSAnimator fA = new FPSAnimator(canvas,FPS,true);
        this.getContentPane().add(canvas);
        gl.glBegin(0);
        createSphere(gl,50,8,2);
        gl.glEnd();
        this.setVisible(true);*/
       getObjectImage();
        gl.glBegin(GL.GL_LINE_LOOP);
        gl.glLineWidth(GL.GL_LINE_WIDTH);
        //getObjectImage();
        gl.glVertex3f(0,50,50);
        gl.glVertex3f(0,0,50);
        gl.glVertex3f(50,0,50);
        gl.glColor3f(255,0,0);
        gl.glEnd();


    }

    public void createSphere(GL2 gl, double radius, int slices, int stacks) {
    GLU glu = new GLU();
    GLUquadric quad = glu.gluNewQuadric();
    glu.gluSphere(quad,radius,slices,stacks);
    System.out.println(quad);
    }
    public void createTriangle(float x, float y, float z){
        // Vertices für das Dreieck werden erstellt und gezeichnet


    }

}