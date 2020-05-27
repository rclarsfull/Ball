import java.util.ArrayList;


public class Ball implements java.io.Serializable {

    ArrayList<Tisch> tische=new ArrayList<Tisch>();
    ArrayList<Gaestegruppe> unverteiletGaeste=new ArrayList<Gaestegruppe>();
    ArrayList<Gaestegruppe> alleGaestegruppen=new ArrayList<Gaestegruppe>();
    String name;
    String datum;

 Ball(){

}
 Ball(String name,String datum){
 this.datum=datum;
 this.name=name;
 }
 public void addTisch(Tisch a){
     tische.add(a);
 }

 public void addGaestegruppe(Gaestegruppe a){
     unverteiletGaeste.add(a);
     alleGaestegruppen.add(a);
 }

    public String getName() {
        return name;
    }

    public String getDatum() {
        return datum;
    }

    public ArrayList<Gaestegruppe> getUnverteiletGaeste() {
        return unverteiletGaeste;
    }

    public ArrayList<Tisch> getTische() {
        return tische;
    }

public void addTisch(){
    int tischnummer;
    int size;
    System.out.println();
    System.out.println();
    System.out.println();
    tischnummer=Einlesen.readInt("Geben sie die gewuenschte Tischnummer an");
    size=Einlesen.readInt("Geben sie die maximal moegliche Besetzungszahl von dem Tisch an");
     tische.add(new Tisch(tischnummer, size));
}
public void addGast(){
    String vorname;
    String nachname;
    int alter;
    boolean freieintritt;
    boolean mitglied;
    do {
        System.out.println();
        vorname = Einlesen.readString("Geben sie den Vornamen ein");
        nachname = Einlesen.readString("Geben sie den Nachnamen ein");
        alter = Einlesen.readInt("Geben sie das Alter ein");
        freieintritt = Einlesen.readBoolean("Hat der Gast freien Eintritt?         [true/false]");
        mitglied = Einlesen.readBoolean("Ist der Gast ein ofizielles TZO Mitglied? [true/false] ");
        System.out.println();
        System.out.println();
        System.out.println("Überprüfen sie die Angaben:");
        System.out.println();
        System.out.println("Name: " + vorname + " " + nachname);
        System.out.println("Alter: " + alter);
        System.out.println("Freieintritt: " + freieintritt);
        System.out.println("Mitglied im TZO: " + mitglied);
        System.out.println();
    }while (Einlesen.readBoolean("Moechten sie sie Eingaben verändern? [true/false]"));
    System.out.println();
     unverteiletGaeste.add(new Gaestegruppe(new Gast(vorname,nachname,alter,freieintritt,mitglied)));
}
public void addGaesteGruppe(){
    String vorname;
    String nachname;
    int alter;
    boolean freieintritt;
    boolean mitglied;
     int naechsteGruppe=unverteiletGaeste.size();
     do {
         int gruppengroeße = Einlesen.readInt("Geben Sie die Gruppengröße an");
         unverteiletGaeste.add(new Gaestegruppe());
         for (int i = 0; i < gruppengroeße; i++) {
             do {
                 System.out.println();
                 vorname = Einlesen.readString("Geben sie den Vornamen ein");
                 nachname = Einlesen.readString("Geben sie den Nachnamen ein");
                 alter = Einlesen.readInt("Geben sie das Alter ein");
                 freieintritt = Einlesen.readBoolean("Hat der Gast freien Eintritt?         [true/false]");
                 mitglied = Einlesen.readBoolean("Ist der Gast ein ofizielles TZO Mitglied? [true/false] ");
                 System.out.println();
                 System.out.println();
                 System.out.println("Überprüfen sie die Angaben:");
                 System.out.println();
                 System.out.println("Name: " + vorname + " " + nachname);
                 System.out.println("Alter: " + alter);
                 System.out.println("Freieintritt: " + freieintritt);
                 System.out.println("Mitglied im TZO: " + mitglied);
                 System.out.println();
             } while (Einlesen.readBoolean("Möchten sie sie Eingabe verändern? [true/false]"));
             System.out.println();
             unverteiletGaeste.get(naechsteGruppe).addGast(new Gast(vorname, nachname, alter, freieintritt, mitglied));
         }
         System.out.println();
         System.out.println();
         unverteiletGaeste.get(naechsteGruppe).printGruppe();
     }while (Einlesen.readBoolean("Möchten sie sie Eingabe verändern? [true/false]"));

}
public void printAlleUnverteilteGäste(){
    for (Gaestegruppe a:unverteiletGaeste) {
        a.printGruppe();
    }
}
public void printGruppen(){
    System.out.println("Alle Gruppen: ");
    System.out.println();
    System.out.println();
    for (int g = 0; g < unverteiletGaeste.size(); g++) {
        Gaestegruppe temp=unverteiletGaeste.get(g);
        System.out.println("Gruppe " + (g + 1) + ": "+"\t\t(groesse:"+temp.getSize()+")");
        System.out.println();
        temp.printGruppe();
        System.out.println();
    }
}
public void printTische(){
        System.out.println("Alle Tische: ");
        System.out.println();
        System.out.println();
        sortTischeNachTischnummer();
        for (int g = 0; g < tische.size(); g++) {
            Tisch temp=tische.get(g);
            System.out.println("Tisch " + temp.getTischnummer() + ": "+"\t\t(groesse:"+temp.getSize()+")[Freie Sitze:"+temp.getFreieplaetze()+"]");
            System.out.println();
            temp.printTischmitglieder();
            System.out.println();
        }
    }
public void delTisch(){
sortTischeNachTischnummer();
int tischnummer=Einlesen.readInt("Geben sie die Tischnummer von dem zu löschenden Tisch ein");
boolean kontrolle=false;
    for (Tisch a:tische) {
        if(a.getTischnummer()==tischnummer){
            tische.remove(a);
            kontrolle=true;
        }
    }
    if(kontrolle){
        System.out.println("Alle Tische mit der Tischnummer "+tischnummer+" wurden entfernt.");
    }else{
        System.out.println("FEHLER!!");
        System.out.println("Es wurde kein Tisch mit der Tischnummer gedunden.");
    }
    }
public void sortTischeNachTischnummer(){
     int temp=tische.size();
     Tisch ablage1;
    for (int j = 0; j <tische.size() ; j++) {
        temp+=-1;
        for (int i = 0; i < temp ; i++) {
           if (tische.get(i).getTischnummer()!=tische.get(i+1).getTischnummer()){
               if (tische.get(i).getTischnummer()>tische.get(i+1).getTischnummer()){
                   ablage1=tische.get(i);
                   tische.set((i),tische.get(i+1));
                   tische.set((i+1),ablage1);
               }
           }
        }
    }
    }
public void sortNachGruppengoesse(){
        int hilfe=unverteiletGaeste.size();
        Gaestegruppe ablage1;
        for (int j=0;j<unverteiletGaeste.size() ;j++ ) {
            hilfe+=-1;
            for (int i=0;i<hilfe ;i++ ) {
                if (unverteiletGaeste.get(i).getSize()!= unverteiletGaeste.get(i+1).getSize()) {
                    if (unverteiletGaeste.get(i).getSize() > unverteiletGaeste.get(i+1).getSize()) {
                        ablage1=unverteiletGaeste.get(i);
                        unverteiletGaeste.set(1,unverteiletGaeste.get(i+1));
                        unverteiletGaeste.set(i+1,ablage1);
                    } // end of if
                } // end of if
            } // end of for
        } // end of for
    }
public void verteilenAnTische(){
    for (int i = unverteiletGaeste.size()-1; i <= 0; i--) {
        Gaestegruppe temp=unverteiletGaeste.get(i);
        boolean fehler=false;
        int z=0;
        for (z = 0; tische.get(z).getFreieplaetze() < temp.getSize(); z++) {
            if (z>tische.size()){
                fehler=true;
                break;
            }
        }
        if (fehler){
            System.out.println("FEHLER: Kein Tisch ist gross genug um die Gruppe "+i+". auf einen Tisch zu verteilen.");
            System.out.println("Bitte erst Gruppe teilen oder neuen Tisch anlegen.");
            break;
        }else{
            tische.get(z).addGast(temp);
            unverteiletGaeste.remove(i);
        }
    }
}
public void resetTischverteilung(){
     unverteiletGaeste=alleGaestegruppen;
    for (Tisch a:tische) {
        a.resetGaeste();
    }
}
}
