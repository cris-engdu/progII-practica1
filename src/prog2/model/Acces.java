package prog2.model;

import java.util.ArrayList;

public abstract class Acces extends Allotjament implements InAcces{
    private ArrayList<Allotjament> llistaAllotjaments ;
    public Acces(String nom, String id, long estada_min_alta, long estada_min_baixa, boolean operatiu, String ilum) {
        super(nom, id, estada_min_alta, estada_min_baixa, operatiu, ilum);
        this.llistaAllotjaments=new ArrayList<>();

    }




    @Override
    public void afegirAllotjament(Allotjament allotjament) {
        llistaAllotjaments.add(allotjament);
    }

    @Override
    public void tancarAcces() {
        operatiu=false;
    }

    @Override
    public void obrirAcces() {

    }

    @Override
    public boolean isAccessibilitat() {
        return false;
    }

    @Override
    public String getNom() {
        return this.nom;
    }

    @Override
    public boolean getEstat() {
        return operatiu;
    }

    @Override
    public LlistaAllotjaments getAAllotjaments() {
        return null;
    }
}
