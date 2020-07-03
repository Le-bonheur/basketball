package photo;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class ImageTest {

    static {
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {
//        Mat mat = Mat.eye(3, 3, CvType.CV_8UC1);
//        System.out.println("mat = " + mat.dump());

        var string = "  12 3 ";
        var string2 = "  12 3 ";
        System.out.println(string.isBlank());
        System.out.println(string.strip());
        System.out.println(string2.trim());

    }

}
