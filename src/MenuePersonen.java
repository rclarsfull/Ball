import java.util.Scanner;

public class MenuePersonen implements java.io.Serializable{
    public static void auswahl(Ball veranstaltung){
        Scanner eingabe=new Scanner(System.in);
        String [] menuepunkte= {"Alle Gaeste anzeigen","Neuen Gast anlegen","Eine Gruppe von Gaesten anlegen","schliessen",};

        boolean wid=true;
        while (wid) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Waehlen sie mithilfe der Nummer den Menuepunkt aus.");
            for (int i = 0; i < menuepunkte.length; i++) {
                System.out.println((i + 1) + ". " + menuepunkte[i]);
            }

            switch (eingabe.nextInt()) {
                case 1:
                    veranstaltung.printGruppen();
                    break;
                case 2:
                    veranstaltung.addGast();
                    Speichern.ueberschreiben(veranstaltung);
                    break;
                case 3:
                    veranstaltung.addGaesteGruppe();
                    Speichern.ueberschreiben(veranstaltung);
                    break;
                case 4:
                    wid=false;
                    Speichern.ueberschreiben(veranstaltung);
                    break;
                default:
                    System.out.println("Falsche Eingabe!!");
                    break;
            }
        }

    }
}
