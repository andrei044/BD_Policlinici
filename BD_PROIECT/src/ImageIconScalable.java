import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageIconScalable extends ImageIcon {
    public void scaleImage(int x,int y){
        Image img= this.getImage();
        Image imgScaled=img.getScaledInstance(x,y,Image.SCALE_SMOOTH);
        //ImageIcon iconScaled=new ImageIcon(imgScaled);
        this.setImage(imgScaled);
    }

    public ImageIconScalable(String filename, String description) {
        super(filename, description);
    }

    public ImageIconScalable(String filename) {
        super(filename);
    }

    public ImageIconScalable(URL location, String description) {
        super(location, description);
    }

    public ImageIconScalable(URL location) {
        super(location);
    }

    public ImageIconScalable(Image image, String description) {
        super(image, description);
    }

    public ImageIconScalable(Image image) {
        super(image);
    }

    public ImageIconScalable(byte[] imageData, String description) {
        super(imageData, description);
    }

    public ImageIconScalable(byte[] imageData) {
        super(imageData);
    }

    public ImageIconScalable() {
    }
}
