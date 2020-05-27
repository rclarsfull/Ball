import java.util.Scanner;

public class Menue1 implements java.io.Serializable{
    public static void auswahl(){
        Scanner eingabe=new Scanner(System.in);
        String [] menuepunkte= {"Neuen Ball planen","Bereits angelegten Ball laden","Schliessen"};

        boolean wid=true;
        while (wid) {
            System.out.println("Waehlen sie mithilfe der Nummer den Menuepunkt aus.");
            for (int i = 0; i < menuepunkte.length; i++) {
                System.out.println((i + 1) + ". " + menuepunkte[i]);
            }

            switch (eingabe.nextInt()) {
                case 1:
                    String name=Einlesen.readString("Geben sie einen Namen ein");
                    String datum=Einlesen.readString("Geben die das Ball datum ein");
                    Ball veranstaltung=new Ball(name,datum);
                    Speichern.spreichern(veranstaltung);
                    System.out.println("BAll erstellt!!");
                    MenueBallbearbeitung.auswahl(veranstaltung);
                    break;
                case 2:
                    //System.out.println("Geben sie den Namen der zu ladenen dartei ein (ohne Darteiendung)");
                    veranstaltung=Speichern.laden();
                    System.out.println("Ball geladen!!");
                    MenueBallbearbeitung.auswahl(veranstaltung);
                    break;
                case 3:
                    wid=false;
                    break;
                default:
                    System.out.println("Falsche Eingabe!!");
                    break;
            }
        }

    }
}
