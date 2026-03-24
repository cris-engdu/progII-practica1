package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Acces   implements InAcces, Serializable {
    private String nom;
    private boolean estat;
    private boolean accessibilitat;
    private LlistaAllotjaments llistaAllotjaments;

    public Acces(String nomacc,boolean estat) {

        this.nom=nomacc;
        this.estat=estat;
        this.accessibilitat= isAccessibilitat();
        this.llistaAllotjaments=new LlistaAllotjaments();

    }




    @Override
    public void afegirAllotjament(Allotjament allotjament)  {
        this.llistaAllotjaments.afegirAllotjament(allotjament);
    }

    @Override
    public void tancarAcces() {

        this.estat=false;
    }

    @Override
    public void obrirAcces() {
    this.estat=true;
    }

    @Override
    public abstract boolean isAccessibilitat();

    @Override
    public String getNom() {
        return this.nom;
    }

    @Override
    public boolean getEstat() {
        return estat;
    }

    @Override
    public LlistaAllotjaments getAAllotjaments() {
        return this.llistaAllotjaments;
    }

    public String toString(){
        return "Nom: " +this.nom+ ", estat: " +(this.estat ? "obert" : "tancat")+ ", accessibilitat: " +this.accessibilitat;
    }
}
