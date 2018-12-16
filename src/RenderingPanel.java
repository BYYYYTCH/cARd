import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.fixedfunc.GLMatrixFunc;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.glu.GLUquadric;
import com.jogamp.opengl.util.ImmModeSink;

public class RenderingPanel extends GLJPanel {
    GLU glu;
    GLUquadric quad;
    Cube cube;

    public RenderingPanel(){
        super(new GLCapabilities(GLProfile.getDefault()));

        this.addGLEventListener(new GLEventListener() {
            @Override
            public void init(GLAutoDrawable glAutoDrawable) {
                GL2 gl = glAutoDrawable.getGL().getGL2();

                glu = new GLU();
                quad = glu.gluNewQuadric();

                gl.glClearColor(0,0,0,1);
                gl.glEnable(GL.GL_DEPTH_TEST);
                gl.glEnable(GL.GL_BLEND);
                gl.glColor4f(1,0,0,0);
            }

            @Override
            public void dispose(GLAutoDrawable glAutoDrawable) {

            }

            @Override
            public void display(GLAutoDrawable glAutoDrawable) {
            GL2 gl = glAutoDrawable.getGL().getGL2();

            gl.glClear(GL.GL_COLOR_BUFFER_BIT);
            gl.glClear(GL.GL_DEPTH_BUFFER_BIT);
            gl.glMatrixMode(GLMatrixFunc.GL_MODELVIEW);
            glu.gluLookAt(50f,50f,10f,0f,0f,0f,0,0,1f);

            gl.glPushMatrix();
            gl.glTranslatef((float)cube.x,(float)cube.y,(float)cube.z);
            gl.glPopMatrix();
            }

            @Override
            public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

            }
        });


    }
}
