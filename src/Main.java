//import de.hshl.obj.mesh.PolygonalObject;
//import de.hshl.obj.mesh.Surface;					//wo sind die hin warum funktionieren die nicht mehr ????
//import  de.hshl.obj.mesh.TriangleObject;
import de.hshl.obj.objects.TriangleObject;
import de.hshl.obj.objects.TriangleSurface;
import de.hshl.obj.wavefront.obj.PolygonalOBJBuilder;
import de.hshl.obj.wavefront.obj.Triangulator;
import javafx.scene.shape.Sphere;
import org.opencv.core.Core;
import de.hshl.obj.wavefront.Wavefront;
import  de.hshl.obj.wavefront.Wavefront.ObjectLoader;

import javax.swing.*;
import java.nio.file.Paths;
import java.util.List;

import java.util.Arrays;


/**
 * Main class to start the program
 */

/**
 * @author Karsten Lehn
 * @version 21.10.2016
 *
 *
 * @modified by Jan & Jannis Klapetz
 *
 *
 *
 */
public class Main extends StartCodeMainWindowPP {

    /**
     * @param args
     */
    public static void main(String[] args) {
        new Sphere();
        // Load OpenCV libraries and start program
        System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
        //  System.loadLibrary();  																																	 //NOCH WAS LADEN ?? // hat sich erledigt.



        Objektloader();
        //new StartCodeMainWindowPP();
        //new VideoProcessing();




       /* try{
            List <TriangleObject> obj = Wavefront.objects().ignoreTextureCoordinates().ignoreNormals().ignoreMaterials().ignoreStructures().withoutVertexIndexing().loadFromFile(Paths.get(System.getProperty("user.dir") + "/resources/objekt maya.obj"));
            TriangleObject triangleObject = obj.get(0);
            System.out.println(triangleObject.name);

            TriangleSurface triangle = triangleObject.surfaces.get(0);
            System.out.println(Arrays.toString(triangle.shape.vertices));

            //Wavefront.objects().ignoreStructures();
            //Wavefront.objects().silenceWarnings();
            //Wavefront.objects().useGroupsAsObjects();



            //Wavefront.objects().loadFromJAR("objekt maya.obj");



        }catch(Exception e){
            e.printStackTrace();
        }*/
    }




    public static void Objektloader() {
	/*	try{
			List <PolygonalObject> obj = Wavefront.objects().ignoreMaterials().ignoreStructures().ignoreNormals().ignoreTextureCoordinates().loadFromFile(Paths.get(System.getProperty("user.dir") + "/resources/objekt maya.obj")

					//"C://Users/Jannis Klapetz/Desktop/objekt maya.obj")			//Alternativer Pfad mein Desktop
			);
			//Surface surface = obj.get(0).surfaces.get(0);
			//System.out.println(surface);

			//System.out.println("klappt doch! auch ohne kamera XD");  			//first runtime versuch


			PolygonalObject cube = obj.get(0); //the only obj
			//System.out.println(cube);

			//System.out.println(obj.get(0).name);  //prints cube  name des Obj.
			//System.out.println(obj.size()); // doku setp prints "1"

			Surface cube1 = cube.surfaces.get(0);
			System.out.println(Arrays.toString(cube1.shape.vertices));


			//Wavefront.objects().useIndexedVertices(true);   			// oben in die liste einfügen für die Benutzung !
			//Wavefront.objects().silenceWarnings();
			//Wavefront.objects().useGroupsAsObjects();






		}catch(Exception e){
			e.printStackTrace();
		}
		*/
    }

}







//"C:\Users\Jannis Klapetz\Desktop\objekt maya.obj"