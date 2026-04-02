package prog2.model;

public class Bungalow extends Casa {
    private int parking; //1 o 2 places
    private boolean terrassa;
    private boolean televisio;
    private boolean aire_fred;

    public Bungalow(String nom, String id, boolean operatiu, String ilum, float mida, int num_habitacions, int capacitat_places
            , int parking, boolean terrassa, boolean televisio, boolean aire_fred) {
        super(nom, id, operatiu,ilum,mida,num_habitacions, capacitat_places);
        this.parking = parking;
        this.terrassa = terrassa;
        this.televisio = televisio;
        this.aire_fred = aire_fred;
        this.setEstadaMinima(7, 4);
    }
    // getters
    public int getParking() {
        return this.parking;
    }

    public boolean isTerrassa() {
        return this.terrassa;
    }

    public boolean isTelevisio() {
        return this.televisio;
    }

    public boolean isAire_fred() {
        return this.aire_fred;
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

    public boolean correcteFuncionament() {
        return aire_fred;
    }
    public String toString(){
        return super.toString() + "Bungalow{parking=" + this.parking+ " terrassa=" + this.terrassa+
                ", televisio=" +this.televisio+ "aireFred=" +aire_fred+ "}";
    }

}

