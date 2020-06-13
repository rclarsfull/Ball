import java.io.*;
import java.util.Scanner;

public class Speichern {
    public static void spreichern(Ball a){
           try(FileOutputStream fos=new FileOutputStream(a.getDatum()+" "+a.getName()+".txt") ;
           ObjectOutputStream oos=new ObjectOutputStream(fos)){
               oos.writeObject(a);
           } catch (FileNotFoundException e) {
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           }
    }

    public static void ueberschreiben(Ball a){
        File temp=new File(a.getDatum()+" "+a.getName()+".txt");
        try(FileOutputStream fos=new FileOutputStream(temp) ;
            ObjectOutputStream oos=new ObjectOutputStream(fos)){
            oos.writeObject(a);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Ball laden(){
        try (FileInputStream fis=new FileInputStream(Einlesen.readString("Geben sie den Namen der Dartei mit der Darteiendung '.ser' ein"));
        ObjectInputStream ois=new ObjectInputStream(fis)){
            return (Ball) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Dartei nicht gefunden");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("1");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("2");
        }
        System.out.println("Lade-Fehler!!!");
        return new Ball();

    }
}

