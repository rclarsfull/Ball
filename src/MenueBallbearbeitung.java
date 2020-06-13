import java.util.Scanner;


public class MenueBallbearbeitung {
    public static void auswahl(Ball veranstaltung){
        Scanner eingabe=new Scanner(System.in);
        String [] menuepunkte= {"Untermenue Personen","Untermenue Tische","Zurueck"};

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
                    MenuePersonen.auswahl(veranstaltung);
                    break;
                case 2:
                    MenueTische.auswahl(veranstaltung);
                    break;
                case 3:
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
