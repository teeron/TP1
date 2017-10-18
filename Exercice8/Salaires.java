import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Salaires {
    public static void main(String[] args) {

        Personnel p = new Personnel();

        String[] myClasses = {"Vendeur","Representant","Manutentionnaire","Technicien","ManutARisque","TechnARisque"};

        // Pour tester la sauveguarde supprimer "personnelSave.ser"
        if(new File("personnelSave.ser").exists()){
            p = (Personnel) deserializeObject();
        }
        //p.afficherSalaires();

        Scanner scanner = new Scanner(System.in);
        boolean wantToLeave = false;

        while(!wantToLeave) {

            System.out.println("Que voulez-vous faire ?");
            System.out.println("s/S: permets de saisir les paramètres pour un nouvel employé");
            System.out.println("c/C: permets de lancer le calcul des salaires");
            System.out.println("q/Q : permets de quitter");

            while (!scanner.hasNext("s|S|c|C|q|Q")) {
                System.out.println("Veuillez rentrer s/S ou c/C :");
                scanner.next();
            }

            String choix = scanner.next();

            if (choix.toLowerCase().equals("s")) {
                System.out.println("1 pour créer un nouveau vendeur");
                System.out.println("2 pour créer un nouveau représentant");
                System.out.println("3 pour créer un nouveau Manutentionnaire");
                System.out.println("4 pour créer un nouveau Technicien");
                System.out.println("5 pour créer un Manutentionnaire à risque");
                System.out.println("6 pour créer un technicien à risque");

                while (!scanner.hasNextInt()) {
                    System.out.println("Veuillez rentrer un nombre :");
                    scanner.next();
                }

                int choixEmploye = scanner.nextInt();

                System.out.println("Nom : ");
                String nom = scanner.next();

                System.out.println("prenom");
                String prenom = scanner.next();

                System.out.println("age");
                int age = scanner.nextInt();

                System.out.println("date d'entrée");
                String dateEntree = scanner.next();

                System.out.println("unité");
                double unite = scanner.nextDouble();


                Employee e = null;
                try {
                    e = (Employee) Class.forName(myClasses[choixEmploye - 1]).getConstructor(String.class, String.class, int.class, String.class, double.class).newInstance(nom, prenom, age, dateEntree, unite);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                p.ajouterEmploye(e);

                p.getSize();
            } else if (choix.toLowerCase().equals("c")) {
                p.afficherSalaires();
            } else if (choix.toLowerCase().equals("q")){
                wantToLeave = true;
                serializeObject(p);
            }

        }


    }

    public static Object deserializeObject(){
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("personnelSave.ser");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);
            Object obj = objectInputStream.readObject();
            objectInputStream.close();
            return obj;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void serializeObject(Object objectToSerialize ){
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("personnelSave.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(objectToSerialize);
            fileOutputStream.close();
            objectOutputStream.close();
            System.out.println("Success");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
