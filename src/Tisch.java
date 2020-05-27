

import java.io.Serializable;
import java.util.ArrayList;

public class Tisch implements java.io.Serializable {
    private int tischnummer;
    private int size;
    private int freieplaetze;
    private ArrayList<Gast> personen=new ArrayList<Gast>();

    Tisch(int tischnummer, int size){
        this.tischnummer=tischnummer;
        this.size=size;
    }
    public void resetGaeste(){
        for (Gast a:personen) {
            personen.remove(a);
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
            System.out.println("person hinzugefügt");
        }

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

}
