package prog2.model;

public class Allotjament implements InAllotjament {
    private String nom;
    private int id;
    private int estada_min_alta;
    private int estada_min_baixa;

    public Allotjament(String nom, int id, int estada_min_alta, int estada_min_baixa) {
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
        nom = nom_p;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id_p) {
        id = id_p;
    }

    @Override
    public long getEstadaMinima(Temp temp) {
        return 0;
    }

    @Override
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_) {

    }

    @Override
    public boolean correcteFuncionament() {
        return false;
    }
}
