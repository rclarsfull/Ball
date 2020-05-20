import java.io.*;       // statt new InputStreamReader() geht auch:
                        // new FileReader ("Angabe Dateipfad mit Dateinamen") 

public class Einlesen   // zum zeilenweisen Einlesen von Ganzzahlwerten über die Tastatur geeignet,  
                        // wobei dafür "automatisch" ein zielorientierter Aufforderungstext erscheint
{
  public static int readInt(String text)
  {
    //System.in: Tastatureingabe --> Byte-Stream; 
    //Konstruktor der Klasse InputStreamReader wandelt in Unicode um.
    //Konstruktor von BufferedReader ermöglicht gepufferte String-Eingabe siehe unten
    
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
    
    System.out.print("  " + text + ": ");            //Gibt den über den String-Parameter übermittelten Text
    //(der die Art der nachfolgenden Eingabe beschreibt) aus.
    try
    {
      String s = in.readLine();
      // Die Methode readLine() der Klasse BufferedReader liest
      // den Inhalt einer Zeile als String 
      // (erkennt Zeilenende an der Entertaste).
      
      return Integer.parseInt(s);   // String s wird über die Methode parseInt der Wrapper-Klasse
      // Integer in einen int-Wert umgewandelt                               
    }                                      
    
    //Fehlerbehandlung
    catch(IOException e)
    {
      System.out.println("IO error");
      return 1;
    }
    catch(NumberFormatException e)      //passiert für jedes Zeichen ungleich Ziffer
    {
      System.out.println("NumberFormat error");
      return 1;                         // ist der Wert 1 sinnvoll?  
    }
  }
  
  public static String readString(String text)
  {
    //System.in: Tastatureingabe --> Byte-Stream; 
    //Konstruktor der Klasse InputStreamReader wandelt in Unicode um.
    //Konstruktor von BufferedReader ermöglicht gepufferte String-Eingabe siehe unten
    
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
    
    System.out.print("  " + text + ": ");            //Gibt den über den String-Parameter übermittelten Text
    //(der die Art der nachfolgenden Eingabe beschreibt) aus.
    
    try
    {
      return in.readLine();
      // Die Methode readLine() der Klasse BufferedReader liest
      // den Inhalt einer Zeile als String 
      // (erkennt Zeilenende an der Entertaste).   
      //Fehlerbehandlung
    }
    catch(IOException e)
    {
      System.out.println("IO error");
      return "IO error";
    }                                                     
  }
  
  public static boolean readBoolean(String text)
  {
    //System.in: Tastatureingabe --> Byte-Stream; 
    //Konstruktor der Klasse InputStreamReader wandelt in Unicode um.
    //Konstruktor von BufferedReader ermöglicht gepufferte String-Eingabe siehe unten
    
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
    
    System.out.print("  " + text + ": ");            //Gibt den über den String-Parameter übermittelten Text
    //(der die Art der nachfolgenden Eingabe beschreibt) aus.
    try
    {
      String s = in.readLine();
      // Die Methode readLine() der Klasse BufferedReader liest
      // den Inhalt einer Zeile als String 
      // (erkennt Zeilenende an der Entertaste).
      
      return Boolean.parseBoolean(s);   // String s wird über die Methode parseBoolean der Wrapper-Klasse
      // Boolean in einen boolean Wert umgewandelt                               
    }                                      
    
    //Fehlerbehandlung
    catch(IOException e)
    {
      System.out.println("IO error");
      return false;
    }
  }
  
  public static double readDouble(String text)
  {
    //System.in: Tastatureingabe --> Byte-Stream; 
    //Konstruktor der Klasse InputStreamReader wandelt in Unicode um.
    //Konstruktor von BufferedReader ermöglicht gepufferte String-Eingabe siehe unten
    
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
    
    System.out.print("  " + text + ": ");            //Gibt den über den String-Parameter übermittelten Text
    //(der die Art der nachfolgenden Eingabe beschreibt) aus.
    try
    {
      String s = in.readLine();
      // Die Methode readLine() der Klasse BufferedReader liest
      // den Inhalt einer Zeile als String 
      // (erkennt Zeilenende an der Entertaste).
      
      return Double.parseDouble(s);   // String s wird über die Methode parseDouble der Wrapper-Klasse
      // Double in einen double-Wert umgewandelt                               
    }                                      
    
    //Fehlerbehandlung
    catch(IOException e)
    {
      System.out.println("IO error");
      return 1;
    }
    catch(NumberFormatException e)
    {
      System.out.println("NumberFormat error");     //z.B. bei Eingabe von Komma anstelle Punkt
      return 1;              //ist der Wert 1 sinnvoll? 
    }
  }
  
}
