package prog2.model;

public class Bungalow extends Casa {
    private int parking; //1 o 2 places
    private boolean terrassa;
    private boolean televisio;
    private boolean aire_fred;

    public Bungalow(String nom, String id, long estada_min_alta, long estada_min_baixa, mides mida, int num_habitacions, int capacitat_places
            , int parking, boolean terrassa, boolean televisio, boolean aire_fred) {
        super(nom, id, estada_min_alta, estada_min_baixa, mida, num_habitacions, capacitat_places);
        this.parking = parking;
        this.terrassa = terrassa;
        this.televisio = televisio;
        this.aire_fred = aire_fred;
    }
    // getters
    public int getParking() {
        return parking;
    }

    public boolean isTerrassa() {
        return terrassa;
    }

    public boolean isTelevisio() {
        return televisio;
    }

    public boolean isAire_fred() {
        return aire_fred;
    }

    //setters
    public void setParking(int p){
        this.parking=p;
    }
    public void setTerrassa(boolean terr){
        this.terrassa=terr;
    }
    public void setTelevisio(boolean tel){
        this.televisio=tel;
    }
    public void setAire_fred(boolean aire_fred){
        this.aire_fred=aire_fred;
    }
    @Override
    public boolean correcteFuncionament() {
        return aire_fred;
    }

}

