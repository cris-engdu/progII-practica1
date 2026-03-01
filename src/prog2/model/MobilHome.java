package prog2.model;

public class MobilHome extends Casa {
    private boolean terrassa_barbacoa;

    public MobilHome(String nom, String id, long estada_min_alta, long estada_min_baixa, mides mida, int num_habitacions,
                     int capacitat_places,boolean terrassa_barbacoa) {
        super(nom, id, estada_min_alta, estada_min_baixa, mida, num_habitacions, capacitat_places);
        this.terrassa_barbacoa=terrassa_barbacoa;
    }

    //getters

    public boolean isTerrassa_barbacoa(){
        return terrassa_barbacoa;
    }

    //setters

    public void setTerrassa_barbacoa(boolean terr_bar){
        this.terrassa_barbacoa=terr_bar;
    }
    public boolean correcteFuncionament() {
        return terrassa_barbacoa;
    }
}
