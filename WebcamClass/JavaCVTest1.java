package testone;

import org.opencv.core.*;
import org.opencv.highgui.Highgui;        
import org.opencv.highgui.VideoCapture;
public class JavaCVTest1 {

	public static void main(String[] args) {
		//opens up the native library
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		//goes to first web camera device id
    	VideoCapture camera = new VideoCapture(0); 
    	
    	//checks to see if there is a device it can use
    	if(!camera.isOpened()){
    		System.out.println("Error");
    	}
    	else {
    		//class in two parts:
    		//one: matrix header contains info of size of matrix
    		//two: pointer to matrix containing pixel values
    		Mat frame = new Mat();
    		//loop till frame is not obtained and then breaks
    	    while(true){
    	    	if (camera.read(frame)){
    	    		System.out.println("Frame Obtained");
    	    		System.out.println("Captured Frame Width " + 
    	    		frame.width() + " Height " + frame.height());
    	    		Highgui.imwrite("camera.jpg", frame);
    	    		System.out.println("OK");
    	    		break;
    	    	}
    	    }	
    	}
    	camera.release();
	}

}
