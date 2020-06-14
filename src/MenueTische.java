import java.util.Scanner;

public class MenueTische implements java.io.Serializable {
    public static void auswahl(Ball veranstaltung){
        Scanner eingabe=new Scanner(System.in);
        String [] menuepunkte= {"Alle Gaeste anzeigen","Tischverteilung anzeigen","Neuen Tisch erzeugen","Tisch löschen","Gaeste an Tische verteilen",
                "Tischverteilung loeschen","schliessen"};

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
                    veranstaltung.printTische();
                    break;
                case 3:
                    veranstaltung.addTisch();
                    break;
                case 4:
                    veranstaltung.delTisch();
                    veranstaltung.sortTische();
                    break;
                case 5:
                    veranstaltung.sortNachGruppengoesse();
                    veranstaltung.sortTische();
                    veranstaltung.verteilenAnTische();
                    break;
                case 6:
                    veranstaltung.resetTischverteilung();
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
