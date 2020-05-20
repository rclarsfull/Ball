import java.util.Scanner;


public class MenueBallbearbeitung implements java.io.Serializable{
    public static void auswahl(Ball veranstaltung){
        Scanner eingabe=new Scanner(System.in);
        String [] menuepunkte= {"Alle Gaeste anzeigen","Neuen Gast anlegen","Eine Gruppe von Gaesten anlegen","Gaeste an Tische verteilen","Tischverteilung loeschen","Tischverteilung anzeigen","schliessen"};

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
                    veranstaltung.sortNachGruppengoesse();
                    veranstaltung.verteilenAnTische();
                    break;
                case 5:
                    veranstaltung.resetTischverteilung();
                    break;
                case 6:
                    break;
                case 7:
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
