package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.Serializable;
import java.util.ArrayList;

//serializable per poder treballar amb fitxers
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
    public void afegirAllotjament(Allotjament allotjament) {
        //en aquesta funcio utilitzem un try catch ja que la funcio d'afegir hi es en llista d'allotjaments per tant la utilitzem
        // i com aquesta funciona amb excepcions doncs aqui fem servir un try catch perquè no ens doni cap error.
        try {
            llistaAllotjaments.afegirAllotjament(allotjament);
        } catch (ExcepcioCamping e) {
            throw new RuntimeException(e);
        }
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
