package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;

public abstract class Acces   implements InAcces{
    private String nom;
    private boolean estat;
    private boolean accessibilitat;
    private LlistaAllotjaments llistaAllotjaments;

    public Acces(String nomacc,boolean estat,boolean accessibilitat, LlistaAllotjaments llistaAllotjaments) {

        this.nom=nomacc;
        this.estat=estat;
        this.accessibilitat=accessibilitat;
        this.llistaAllotjaments=llistaAllotjaments;

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
    public boolean isAccessibilitat() {
        return this.accessibilitat;
    }

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
}
