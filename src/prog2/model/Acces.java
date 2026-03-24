package prog2.model;

import java.util.ArrayList;

public abstract class Acces implements InAcces{
    private String nom;
    private boolean accessibilitat;
    private boolean operatiu;
    private ArrayList<Allotjament> llistaAllotjaments;
    public Acces(String nom, boolean accessibilitat, boolean isObert) {
        this.nom = nom;
        this.accessibilitat = accessibilitat;
        this.operatiu = isObert;
        this.llistaAllotjaments=new ArrayList<>();
    }




    @Override
    public void afegirAllotjament(Allotjament allotjament) {llistaAllotjaments.add(allotjament);
    }

    @Override
    public void tancarAcces() {
        operatiu = false;
    }

    @Override
    public void obrirAcces() { operatiu = true;}

    @Override
    public boolean isAccessibilitat() {
        return accessibilitat;
    }

    public void setAccessibilitat(boolean accessibilitat) {this.accessibilitat = accessibilitat;}

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
        return llistaAllotjaments;
    }
}
