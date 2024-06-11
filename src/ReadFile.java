import java.io.File; 
import java.io.FileNotFoundException;
import java.util.*; 

public class ReadFile {

  public static void readFile(String filename) {
    try {
      File file = new File(filename);
      Scanner myReader = new Scanner(file);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("blad czytania pliku");
      e.printStackTrace();
    }
  }

  public static List<String> readEvent(String filename) {
    List<String> list = new ArrayList<String>(); 
    System.out.println("\n(event)");
    try {
      File file = new File(filename);
      Scanner myReader = new Scanner(file);
      Integer line = 0;
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        if (line<3) { list.add(data); }
        else if (line==3) {}
        else { System.out.println(data); };
        line += 1;
      }
      myReader.close();

    } catch (FileNotFoundException e) {
      System.out.println("blad czytania pliku");
      e.printStackTrace();
    }
    return list;
  }
}
