public class Gast implements java.io.Serializable {
    private String vorname;
    private String nachname;
    private int alter;
    private int preis;
    private boolean mitglied;
    private boolean freiereintritt;

    Gast(String vorname,String nachname,int alter,boolean freieintritt,boolean mitglied){
        this.vorname=vorname;
        this.nachname=nachname;
        this.alter=alter;
        this.freiereintritt=freieintritt;
        this.mitglied=mitglied;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public int getEintrittspreis(){
        if (freiereintritt){
            return 0;
        }else if(alter<19){
            return 15;
        }else {
            return 20;
        }
    }
    public String getFullName(){
        return vorname+" "+nachname;
    }
}
