package prog2.model;

public class MobilHome extends Casa {
    private boolean terrassa_barbacoa;

    public MobilHome(String nom, String id, long estada_min_alta, long estada_min_baixa, boolean operatiu, String ilum, String mida, int num_habitacions, int capacitat_places,boolean terrassa_barbacoa) {
        super(nom, id, estada_min_alta, estada_min_baixa, operatiu, ilum, mida, num_habitacions, capacitat_places);

        this.terrassa_barbacoa=terrassa_barbacoa;
        this.setEstadaMinima(5, 3);


    }





    //getters

    public boolean isTerrassa_barbacoa(){
        return this.terrassa_barbacoa;
    }

    //setters

    public void setTerrassa_barbacoa(boolean terr_bar){
        this.terrassa_barbacoa=terr_bar;
    }
    public boolean correcteFuncionament() {
        return this.terrassa_barbacoa;
    }
    public String toString(){
        return super.toString() + "Mobil-home{terrassaBarbacoa= " +terrassa_barbacoa+ "}";
    }
}
