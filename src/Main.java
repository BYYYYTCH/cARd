import de.hshl.obj.mesh.PolygonalObject;
import de.hshl.obj.mesh.Surface;
import org.opencv.core.Core;
import de.hshl.obj.wavefront.Wavefront;

import java.nio.file.Paths;
import java.util.List;
/**
 * Main class to start the program
 */

/**
 * @author Karsten Lehn
 * @version 21.10.2016
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Load OpenCV libraries and start program
	    System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
		new VideoProcessing();
		try{
			List <PolygonalObject> obj = Wavefront.objects().ignoreMaterials().ignoreNormals().ignoreTextureCoordinates().loadFromFile(Paths.get("C:Filepath"));
			Surface surface = obj.get(0).surfaces.get(0);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
