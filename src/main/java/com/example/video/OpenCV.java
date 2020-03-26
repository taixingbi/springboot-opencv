package com.example.video;

import nu.pattern.OpenCV;
import org.apache.tomcat.jni.File;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController

public class OpenCV {

//    static {
//        try {
//            System.load(Core.NATIVE_LIBRARY_NAME);
//        } catch (UnsatisfiedLinkError e) {
//            System.err.println("Native code library failed to load.\n" + e);
//            System.exit(1);
//        }
//    }

    //https://www.baeldung.com/java-opencv
    @RequestMapping("/")
    public String index() {
        System.out.println("NATIVE_LIBRARY_NAME! " + Core.NATIVE_LIBRARY_NAME);
        System.out.println("Welcome to OpenCV " + Core.VERSION);

        OpenCV.loadShared();
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        String PathIn= "/Users/h/Documents/images/mat.jpg";
        Imgcodecs imageCodecs = new Imgcodecs();
        Mat matrix = imageCodecs.imread(PathIn);

        String PathOut = "/Users/h/Documents/images/mat22.jpg";
        imageCodecs.imwrite(PathOut, matrix);

//        Mat m = new Mat(5, 10, CvType.CV_8UC1, new Scalar(0));


        return "Greetings from Spring Boot!";
    }


}
