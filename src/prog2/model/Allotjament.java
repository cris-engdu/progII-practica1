package prog2.model;

public class Allotjament implements InAllotjament {
    private String nom;
    private String id;
    private long estada_min_alta;
    private long estada_min_baixa;

    public Allotjament(String nom, String id, long estada_min_alta, long estada_min_baixa) {
        this.nom = nom;
        this.id = id;
        this.estada_min_alta = estada_min_alta;
        this.estada_min_baixa = estada_min_baixa;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public void setNom(String nom_p) {
        this.nom = nom_p;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id_p) {
        this.id = id_p;
    }

    @Override
    public long getEstadaMinima(Temp temp) {
        if (temp==Temp.ALTA){
            return estada_min_alta;
        }else {
            return estada_min_baixa;
        }
    }

    @Override
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_) {
            this.estada_min_alta=estadaMinimaALTA_;
            this.estada_min_baixa=estadaMinimaBAIXA_;
    }

    @Override
    public boolean correcteFuncionament() {
        return false;
    }
}
