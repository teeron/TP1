import java.io.File;
import java.util.Scanner;

public class ListFolder {
    private Scanner scanner;
    private String extention;
    private String a;
    private int c;

    public ListFolder(){
        scanner = new Scanner(System.in);
        extention = "";
        a = "";
        c = 0;
    }

    public File askPathToFolder(){

        System.out.println("Folder Path : ");
        File file = new File(scanner.nextLine());

        while(!file.exists() || !file.isDirectory()){
            if(!file.exists()){
                System.out.println("Sorry, this file does not exist.");
            }
            else if(!file.isDirectory()){
                System.out.println("Sorry, this is not a folder path.");
            }
            System.out.println("Enter the folder path again : ");
            file = new File(scanner.nextLine());
        }

        return  file;
    }

    public String askExtentionToPath(){
        System.out.println("Search by extention ? (Y/N)");
        a = scanner.nextLine();

        if(a.equals("Y") || a.equals("y")){
            System.out.println("Extention : ");
            extention = scanner.nextLine();

            while(extention.indexOf('.')<0){
                System.out.println("Enter the extention correctly (like .extention) please :");
                extention = scanner.nextLine();
            }
        }

        return extention;
    }

    public void searchFiles(File file, String extention){

        File[] listOfFiles = file.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                if(listOfFiles[i].getName().indexOf(extention) > 0) {
                    System.out.println("File " + listOfFiles[i].getName());
                }
                else if(extention.equals("")){
                    System.out.println("File " + listOfFiles[i].getName());
                }
            }
            else if (listOfFiles[i].isDirectory() && extention.equals("")) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }

            else{
                c++;
            }
        }
        if(c+1 == listOfFiles.length){
            System.out.println("No such extention found in the folder.");
        }
    }
}
