import java.util.ArrayList;

public class Gaestegruppe implements java.io.Serializable  {
    private ArrayList<Gast> gruppe=new ArrayList<Gast>();

    Gaestegruppe() {

    }
    Gaestegruppe(Gast a) {
        gruppe.add(a);
    }
    public void addGast(Gast a){
        gruppe.add(a);
    }

    public ArrayList<Gast> getGruppe() {
        return gruppe;
    }
    public void printGruppe(){
        for (int i = 0; i <gruppe.size() ; i++) {
            System.out.println((i+1)+". "+gruppe.get(i).getFullName());
        }
    }
    public int getSize(){
        return gruppe.size();
    }
}
