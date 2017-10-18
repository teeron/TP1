import java.io.IOException;

public class Main {
    public static void main(String[] args){
        UrlToImage image = null;
        try {
            image = new UrlToImage();
        } catch (IOException e) {
            e.printStackTrace();
        }
        image.display();
    }
}
