import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.glu.GLUquadric;
import javax.swing.*;
import java.awt.*;


public class Shapes extends GLJPanel implements GLEventListener{
    GL2 gl;

    private static String TITLE = "Shape Window";
    private static final int width = 500;
    private static final int height = 500;


    public static void main(String[] args) {
        JFrame cWindow = new JFrame(TITLE);
        Shapes cubePanel = new Shapes();
        cWindow.setContentPane(cubePanel);
        cWindow.pack();
        cWindow.setLocation(400,400);
        cWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cWindow.setVisible(true);
        cubePanel.requestFocusInWindow();


    }
    public Shapes(){
        super(new GLCapabilities(null));
        setPreferredSize(new Dimension(width,height));
        addGLEventListener(this);
    }
    public void dispose(GLAutoDrawable drawable){

    }
    public void reshape(GLAutoDrawable drawable,int x, int y,int width, int height){

    }


 /*   public void createSphere(GL2 gl, double radius, int slices, int stacks) {
    GLU glu = new GLU();
    GLUquadric quad = glu.gluNewQuadric();
    glu.gluSphere(quad,radius,slices,stacks);
    System.out.println(quad);
    }*/

    public void createSquare(GL2 gl,double r, double g, double b){
        // Werte für die Erstellung eines Faces des Würfels werden weitergegeben
        gl.glColor3d(r,g,b);
        gl.glBegin(GL2.GL_TRIANGLE_FAN);
        gl.glVertex3d(-0.5, -0.5, 0.5);
        gl.glVertex3d(0.5, -0.5, 0.5);
        gl.glVertex3d(0.5, 0.5, 0.5);
        gl.glVertex3d(-0.5, 0.5, 0.5);
        gl.glEnd();

    }
    public void createCube(GL2 gl2, double size){
        gl2.glPushMatrix();
        gl2.glScaled(size,size,size);

        createSquare(gl2,0,0,1);
        gl2.glPushMatrix();
        gl2.glRotated(90,0,1,0);
        createSquare(gl2,0,0,1);
        gl2.glPopMatrix();

        gl2.glPushMatrix();
        gl2.glRotated(-90,1,0,0);
        createSquare(gl2,0,0,1);
        gl2.glPopMatrix();

        gl2.glPushMatrix();
        gl2.glRotated(180,0,1,0);
        createSquare(gl2,0,0,1);
        gl2.glPopMatrix();

        gl2.glPushMatrix();
        gl2.glRotated(-90,0,1,0);
        createSquare(gl2,0,0,1);
        gl2.glPopMatrix();

        gl2.glPushMatrix();
        gl2.glRotated(90,1,0,0);
        createSquare(gl2,0,0,1);
        gl2.glPopMatrix();


    }
    public void init(GLAutoDrawable drawable){
        GL2 gl = drawable.getGL().getGL2();
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glOrtho(-1,1,-1,1,-1,1);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glClearColor(0,0,0,1);
        gl.glEnable(GL.GL_DEPTH_TEST);
    }
    public void display(GLAutoDrawable drawable) {

        GL2 gl2 = drawable.getGL().getGL2(); // The object that contains all the OpenGL methods.

        gl2.glClear( GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT );

        gl2.glLoadIdentity();             // Set up modelview transform.
        gl2.glRotated(0,0,0,1);
        gl2.glRotated(-15,0,1,0);
        gl2.glRotated(15,1,0,0);

        createCube(gl2,1);

    }
}