

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Tisch implements java.io.Serializable,Comparable {
    private int tischnummer;
    private int size;
    private int freieplaetze;
    private ArrayList<Gast> personen=new ArrayList<Gast>();

    Tisch(int tischnummer, int size){
        this.tischnummer=tischnummer;
        this.size=size;
    }
    public void resetGaeste(){
        int temp=personen.size();
        for (int i = 0; i <temp ; i++) {
           personen.remove(0);
        }
    }
    public void printTischmitglieder(){
        System.out.println();
        for (int i = 0; i < personen.size() ; i++) {
            System.out.println("\t" + (i + 1) + ". " + personen.get(i).getFullName());
        }
    }
    public void addGast(Gaestegruppe a){
        ArrayList<Gast> temp=a.getGruppe();
        for (int i = 0; i <a.getSize(); i++) {
         personen.add(temp.get(i));
           // System.out.println("person hinzugefügt");
        }

    }

    public ArrayList<Gast> getSizende(){
      return personen;
    }

    public int getFreieplaetze() {
        freieplaetze=size-personen.size();
        return freieplaetze;
    }

    public int getSize() {
        return size;
    }

    public int getTischnummer() {
        return tischnummer;
    }


    public String toString(){

        return ("Tischnummer: "+tischnummer+" Maximale besetzungszahl: "+size+" Freie plaeze: "+freieplaetze);
    }


    @Override
    public int compareTo(@NotNull Object o) {
        int vergleicher=((Tisch)o).getFreieplaetze();
        return this.getFreieplaetze()-vergleicher;
    }
}
