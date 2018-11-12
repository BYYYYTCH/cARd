import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;

public interface Imageoperations {



    /**
     * @author Maksymilian Hutyra
     * converting input image into greyscales
     * @param imageMat
     * @return Mat
     *
     */
    public static Mat grayscale(Mat imageMat ){

        Mat grayImg = new Mat();
        Imgproc.cvtColor(imageMat,grayImg,Imgproc.COLOR_BayerBG2BGR);

        return grayImg;
    }

    /**
     * @author Maksymilian Huyta
     * applying gaussian blur on an input Image
     * @param imageMat
     * @return
     */
    public static Mat gaussianBlur (Mat imageMat){

        Mat gausImg = new Mat();
        Size size = new Size(3,3);

        Imgproc.GaussianBlur(imageMat,gausImg,size,15);

        return gausImg;
    }

    /**
     * @autor Maksymilian Hutyra
     * applying the median filter to an Input Image
     * @param imageMat
     * @return
     */
    public static Mat medianblur(Mat imageMat){

        Mat medianImg = new Mat();
        Imgproc.medianBlur(imageMat,medianImg,5);

        return medianImg;
    }


    /**
     * @autor Maksymilian Hutyra
     * detecting edges in x and y directions and flattening the background
     * @param imageMat
     * @return
     */
    public static Mat  sobelEdges(Mat imageMat){

        if (imageMat.equals(null)){
            System.out.println("The source image is empty");
            return null;
        }else {

            Mat gausSrc = gaussianBlur(imageMat);
            Mat graySrc = grayscale(gausSrc);
            Mat sobelImgX = new Mat();
            Mat sobelImgY = new Mat();
            Mat sobelFinal = new Mat();

            //Gradient X
            Imgproc.Sobel(graySrc,sobelImgX,CvType.CV_16S,1,0,3,1,0,Core.BORDER_DEFAULT);
            //Gradient Y
            Imgproc.Sobel(graySrc,sobelImgY,CvType.CV_16S,0,1,3,1,0,Core.BORDER_DEFAULT);

            Core.addWeighted(sobelImgX,0.5,sobelImgY,0.5,0,sobelFinal);

            return sobelFinal;
        }
    }

    /**
     * @autor Maksymilian Hutyra
     * detecting the various colors through a rgb interval
     * @param ImageMat
     * @return
     */
    public static Mat colorLabelingRed(Mat ImageMat){

        Mat Gaus = gaussianBlur(ImageMat);
        Mat ImgRed = new Mat();

        Scalar lowerRed = new Scalar(30,10,10);
        Scalar upperRed = new Scalar(255,40,40);

        Core.inRange(Gaus,lowerRed,upperRed,ImgRed);

        return ImgRed;

    }
    public static Mat colorLabelingBlue(Mat ImageMat){
        Mat Gaus = gaussianBlur(ImageMat);
        Mat ImgBlue = new Mat();


        Scalar lowerBlue = new Scalar(10,10,30);
        Scalar upperBlue = new Scalar(40,40,255);

        Core.inRange(Gaus,lowerBlue,upperBlue,ImgBlue);

        return ImgBlue;
    }

    public static Mat colorLabelingGreen(Mat ImageMat){

        Mat Gaus = gaussianBlur(ImageMat);
        Mat ImgGreen = new Mat();

        Scalar lowerGreen = new Scalar(10,30,10);
        Scalar upperGreen = new Scalar(40,255,40);

        Core.inRange(Gaus,lowerGreen,upperGreen,ImgGreen);

        return ImgGreen;

    }


}

