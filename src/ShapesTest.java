import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.fixedfunc.GLLightingFunc;
import com.jogamp.opengl.fixedfunc.GLMatrixFunc;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.glu.GLUquadric;
import com.jogamp.opengl.util.gl2.GLUT;
import org.opencv.core.Mat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class ShapesTest extends GLJPanel implements GLEventListener, KeyListener {
    GL2 gl;
    GLU glu = new GLU();
    GLUquadric quad;
    private static String TITLE = "Shape Window";
    private static final int width = 500;
    private static final int height = 500;


    public static void main(String[] args) {
        JFrame cWindow = new JFrame();
        Shapes cubePanel = new Shapes();
        Shapes[] shapes = new Shapes[1];
        cWindow.setContentPane(cubePanel);
        cWindow.pack();
        cWindow.setLocation(400, 400);
        cWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cWindow.setVisible(true);
        cubePanel.requestFocusInWindow();
        for(int x = 0; x<= 10;x++){
            if(cWindow != null){
                cWindow.repaint();
            }
        }


    }
    public ShapesTest(){
        super(new GLCapabilities(GLProfile.getDefault()));
        setPreferredSize(new Dimension(width,height));
        this.addGLEventListener(new GLEventListener()
        {
            public void init(GLAutoDrawable drawable)    //**********    INIT
            {
                GL2 gl = drawable.getGL().getGL2();

                glu = new GLU();    quad = glu.gluNewQuadric();
                glu.gluQuadricDrawStyle(quad , GLU.GLU_FILL);
                glu.gluQuadricNormals(quad , GLU.GLU_SMOOTH);

                gl.glClearColor(0.0f , 0.0f , 0.0f , 1.0f);

                gl.glEnable(GL.GL_DEPTH_TEST);
                gl.glEnable(GLLightingFunc.GL_LIGHTING);
                gl.glLightModelfv(GL2ES1.GL_LIGHT_MODEL_AMBIENT , new float[] { 0.2f , 0.2f , 0.2f , 1.0f } , 0);

                gl.glEnable(GLLightingFunc.GL_LIGHT0);
            }

            public void reshape(GLAutoDrawable drawable , int x , int y , int w , int h)    //**********    RESHAPE
            {
                GL2 gl = drawable.getGL().getGL2();

                gl.glViewport(0 , 0 , w , h);

                gl.glMatrixMode(GLMatrixFunc.GL_PROJECTION);
                gl.glLoadIdentity();
                glu.gluPerspective(60.0f , (float) w / h , 1.0f , 10000000.0f);
            }

            public void display(GLAutoDrawable drawable)    //**********    DISPLAY
            {
                GL2 gl = drawable.getGL().getGL2();

                gl.glClear(GL.GL_COLOR_BUFFER_BIT);
                gl.glClear(GL.GL_DEPTH_BUFFER_BIT);

                gl.glMatrixMode(GLMatrixFunc.GL_MODELVIEW);
                gl.glLoadIdentity();
                glu.gluLookAt(  50.0f , 50.0f , 10.0f
                        , 0.0f , 0.0f , 0.0f
                        , 0.0f , 0.0f , 1.0f);

                ////------- LIGHT
                gl.glLightfv(GLLightingFunc.GL_LIGHT0 , GLLightingFunc.GL_POSITION   , new float[]{ 30.0f , 50.0f , 30.0f  , 1.0f } , 0);
                gl.glLightfv(GLLightingFunc.GL_LIGHT0 , GLLightingFunc.GL_AMBIENT   , new float[]{ 0.1f , 0.1f , 0.1f , 1.0f } , 0);
                gl.glLightfv(GLLightingFunc.GL_LIGHT0 , GLLightingFunc.GL_DIFFUSE     , new float[]{ 1.0f , 1.0f , 1.0f , 1.0f } , 0);
                gl.glLightfv(GLLightingFunc.GL_LIGHT0 , GLLightingFunc.GL_SPECULAR , new float[]{ 1.0f , 1.0f , 1.0f , 1.0f } , 0);



                ////------- ANIMATED BALLS
                  //  gl.glMaterialfv(GL.GL_FRONT_AND_BACK , GLLightingFunc.GL_AMBIENT_AND_DIFFUSE , ball[i].color , 0);

                 //   gl.glPushMatrix();    gl.glTranslatef((float)(x) , (float)(ball[i].y), (float)(ball[i].z));
                    glu.gluSphere(quad , 1.0f , 10 , 10);
                    gl.glPopMatrix();


                gl.glFlush();
            }

            public void dispose(GLAutoDrawable drawable)    //**********    DISPOSE
            {}
        } );
    }
    public void dispose(GLAutoDrawable drawable){

    }
    public void reshape(GLAutoDrawable drawable,int x, int y,int width, int height){
        GL2 gl = drawable.getGL().getGL2();
        //  gl.glViewport(0,0,width,height);
        gl.glMatrixMode(GLMatrixFunc.GL_MATRIX_MODE);
        gl.glLoadIdentity();
        // glu.gluPerspective(60f,(float)width/height,1f,10000000f);

    }
    public void keyTyped(KeyEvent k){

    }
    public void keyPressed(KeyEvent k){

    }
    public void keyReleased(KeyEvent k){

    }


    public void createSphere(GL2 gl, double radius, int slices, int stacks, double b) {
        GLU glu = new GLU();
        GLUquadric quad = glu.gluNewQuadric();
        gl.glColor3d(0,0,b);
        glu.gluSphere(quad,radius,slices,stacks);
        System.out.println(quad);
    }

    public void createSquare(GL2 gl,double r, double g, double b,double dim){
        // Werte für die Erstellung eines Faces des Würfels werden weitergegeben
        gl.glColor4f((float)r,(float)g,(float)b,1);
        gl.glBegin(GL2.GL_TRIANGLE_FAN);
        gl.glVertex3d(-dim, -dim, dim);
        gl.glVertex3d(dim, -dim, dim);
        gl.glVertex3d(dim, dim, dim);
        gl.glVertex3d(-dim, dim, dim);
        gl.glEnd();
        // gl.glFlush();
    }
    public void createCube(GL2 gl2, double size,double dim){
        gl2.glPushMatrix();
        gl2.glScaled(size,size,size);

        createSquare(gl2,0,0,1,dim);
        gl2.glPushMatrix();
        gl2.glRotated(90,0,1,0);
        createSquare(gl2,0,0,1,dim);
        gl2.glPopMatrix();

        gl2.glPushMatrix();
        gl2.glRotated(-90,1,0,0);
        createSquare(gl2,0,0,1,dim);
        gl2.glPopMatrix();

        gl2.glPushMatrix();
        gl2.glRotated(180,0,1,0);
        createSquare(gl2,0,0,1,dim);
        gl2.glPopMatrix();

        gl2.glPushMatrix();
        gl2.glRotated(-90,0,1,0);
        createSquare(gl2,0,0,1,dim);
        gl2.glPopMatrix();

        gl2.glPushMatrix();
        gl2.glRotated(90,1,0,0);
        createSquare(gl2,0,0,1,dim);
        gl2.glPopMatrix();


    }
    public void init(GLAutoDrawable drawable){
        GLU glu = new GLU();
        GL2 gl = drawable.getGL().getGL2();
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glOrtho(-1,1,-1,1,-1,1);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        // gl.glMatrixMode(GL2.GL_VIEWPORT);
        gl.glEnable(GL.GL_BLEND);
        // gl.glBlendFunc(GL.GL_DST_ALPHA,GL.GL_ONE_MINUS_SRC_COLOR);
        gl.glColor4f(1,0,0,0.1f);
        gl.glClearColor(255,255,0,1);
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);



        // gl.glEnable(GL.GL_DEPTH_TEST);
    }
    /**
     * Sprunganimation, die das Shape von Karte A nach Karte B wandern lässt.
     */
    public void sprungAnimation(GL2 gl){
        double v = 0;
        // while (Objektkoordinate1 != Objektkoordinate2 ){*Funktion}
        createCube(gl,1,0.5);
        if (v >= 100) {
            for (double x = 0; x <= 1; x += 0.1) {

                try {
                    v = (-x - 10);
                    v = (v * v) + 10;
                    // gl.glTranslatef((float)v -100,(float)v-100,0);
                    createSquare(gl, 0, 0, 1, v - 110);
                    Thread.sleep(200);


                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }
    }
    public void display(GLAutoDrawable drawable) {
        GL2 gl2 = drawable.getGL().getGL2();

        gl2.glClear( GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT );
        gl2.glLoadIdentity();             // Modelview Transformation
        // gl2.glViewport(80,80,80,1000);
        //gl2.glRotated(0,0,0,1);
        //gl2.glRotated(-15,0,1,0);
        //gl2.glRotated(15,1,0,0);
        /*for(int x =0; x<3; x++) {
            gl2.glTranslatef((float) x/10, 0, 0);
            //createSphere(gl2,1,16,16,1);
            //createCube(gl2,1,0.5);
              try {
                  Thread.sleep(500);
              }catch(Exception e){
                  e.printStackTrace();
              }
            */ // gl2.glClear(GL2.GL_COLOR_BUFFER_BIT);
        sprungAnimation(gl2);


    }
}

