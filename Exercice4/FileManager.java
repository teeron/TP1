import java.io.*;
import java.nio.channels.FileChannel;
import java.util.Scanner;

public class FileManager {
    private String content;
    protected String quit;
    private Scanner scanner;
    protected Writer fileWriter;
    protected File fileSource;
    protected String choice;
    protected File fileDestination;

    public FileManager(){
        content = null;
        quit = null;
        scanner = new Scanner(System.in);
        try {
            fileWriter = new FileWriter("fichier.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileSource = new File("fichier.txt");
        choice = null;
        fileDestination = new File("fichierCopie.txt");
    }

    public void displayChoice(){
        System.out.println("MENU : ");
        System.out.println("'a / A' ===> Write in a new file.");
        System.out.println("'b / B' ===> Copy Content of a file.");
        System.out.println("'quit'  ===> Leave the application.");
        choice = scanner.nextLine();

        if(choice.equals("a") || choice.equals("A")){
            displayWriteFileManager();
        }
        else if(choice.equals("b") || choice.equals("B")){
            copyFile(fileSource, fileDestination);
        }
        else if(choice.equals("quit")){
            System.out.println("GoodBye, see you soon !");
        }
        else{
            System.out.println("Wrong choice, try again please.");
            displayChoice();
        }
    }

    public String displayWriteFileManager(){
        System.out.println("Write the content : ");
        System.out.println("Write 'quit' to go back to Menu.");
        content = scanner.nextLine();

        while(content.isEmpty()){
            System.out.println("Write the content : ");
            content = scanner.nextLine();
        }

        if(content.equals("quit")){
            quit();
        }
        else{
            writeFile(content);
        }

        return content;
    }

    public void writeFile(String content){
        try {
            fileWriter.write(content+System.getProperty( "line.separator" ));
        } catch (IOException e) {
            e.printStackTrace();
        }

        displayWriteFileManager();;
    }

    public void copyFile(File fileSource, File fileDestination) {
        try {
            FileChannel source = new FileInputStream(fileSource).getChannel();
            FileChannel destination = new FileOutputStream(fileDestination, true).getChannel();
            destination.position( destination.size() );
            source.transferTo(0, source.size(), destination);
            source.close();
            destination.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Successfully copied " + fileSource.getName() + " content into " + fileDestination.getName() + " !");
        displayChoice();
    }

    public void quit(){
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        displayChoice();
    }
}