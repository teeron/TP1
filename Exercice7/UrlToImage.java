import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class UrlToImage {
    String imageUrl;
    String name;
    URL url;
    InputStream in;
    OutputStream out;
    Scanner scanner;

    public UrlToImage() throws IOException {
        imageUrl = null;
        name = null;
        scanner = new Scanner(System.in);
    }

    public void display(){
        System.out.println("URL : ");
        imageUrl = scanner.nextLine();
        if(imageUrl != null){
            imageUrl = "https://" + imageUrl;
            System.out.println("How do you want to name your image ?");
            System.out.println("Exemple : image-name.jpg");
            name = scanner.nextLine();
            if (name != null && name.indexOf(".jpg")>1 || name.indexOf(".png")>1){
                try {
                    setImageUrl(imageUrl);
                    setName(name);
                    createImageFromUrl();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else{
                System.out.println("Oups something went wrong, try again please.");
                display();
            }
        }
        else{
            display();
        }
    }

    public void createImageFromUrl() throws IOException {
        url = new URL(imageUrl);
        in = new BufferedInputStream(url.openStream());
        out = new BufferedOutputStream(new FileOutputStream(name));

        for ( int i; (i = in.read()) != -1; ) {
            out.write(i);
        }
        in.close();
        out.close();
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setName(String name) {
        this.name = name;
    }
}
