package prog2.model;

import java.time.LocalDate;

public class Allotjament implements InAllotjament {
    public enum iluminacion{
        ALTA, MITJANA, RES
    }
    private String nom;
    private String id;
    private long estada_min_alta;
    private long estada_min_baixa;
    private boolean operatiu;
    private iluminacion Iluminacio;



    public Allotjament(String nom, String id, long estada_min_alta, long estada_min_baixa,boolean operatiu,String ilum) {
        this.nom = nom;
        this.id = id;
        this.estada_min_alta = estada_min_alta;
        this.estada_min_baixa = estada_min_baixa;
        this.operatiu=operatiu;
        this.Iluminacio=iluminacion.valueOf(ilum);

    }
//getters
    @Override
    public String getNom() {
        return this.nom;
    }

    @Override
    public void setNom(String nom_p) {
        this.nom = nom_p;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id_p) {
        this.id = id_p;
    }

    @Override
    public long getEstadaMinima(Temp temp) {
        if (temp==Temp.ALTA){
            return this.estada_min_alta;
        }else {
            return this.estada_min_baixa;
        }
    }

    public iluminacion getIluminacio(){
        return this.Iluminacio;
    }

//setters
    @Override
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_) {
            this.estada_min_alta=estadaMinimaALTA_;
            this.estada_min_baixa=estadaMinimaBAIXA_;
    }

    @Override
    public void tancarAllotjament(TascaManteniment tasca) {
            this.operatiu=false;
            this.Iluminacio=iluminacion.RES;
    }

    @Override
    public void obrirAllotjament() {
        this.operatiu=true;
        this.Iluminacio=iluminacion.ALTA;


    }

    public void setIluminacio(iluminacion iluminacio){
        this.Iluminacio = iluminacio;
    }

    @Override
    public boolean correcteFuncionament() {
        return false;
    }

    public String toString() {
        String str = "Nom=" + this.getNom() + ", Id=" + this.getId() + ", estada mínima en temp ALTA: " +
                this.getEstadaMinima(InAllotjament.Temp.ALTA) + ", estada mínima en temp BAIXA: " +
                this.getEstadaMinima(InAllotjament.Temp.BAIXA) + ".";
        return str;
    }
}
