public class Main {
    public static void main(String[] args){
        ListFolder f = new ListFolder();
       // f.askExtentionToPath();
        f.searchFiles(f.askPathToFolder(), f.askExtentionToPath());
    }
}

