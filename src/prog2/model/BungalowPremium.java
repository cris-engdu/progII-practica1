package prog2.model;

import java.nio.charset.IllegalCharsetNameException;

public class BungalowPremium extends Bungalow {
    private String codiWifi;
    private boolean serveisExtra;

    public BungalowPremium(String nom, String id, boolean operatiu, String ilum, float mida, int num_habitacions, int capacitat_places, int parking, boolean terrassa, boolean televisio, boolean aire_fred, boolean serveisExtra, String codiWifi) {
        super(nom, id, operatiu, ilum, mida, num_habitacions, capacitat_places, parking, terrassa, televisio, aire_fred);
        this.codiWifi=codiWifi;
        this.serveisExtra= serveisExtra;
    }
    //getters
    public String getCodiWifi(){
        return this.codiWifi;
    }

    public boolean isServeisExtra(){
        return this.serveisExtra;
    }

    //setters
    public void setCodiWifi(String codi){
        this.codiWifi=codi;
    }
    public void setServeisExtra(Boolean extra){
        this.serveisExtra=extra;
    }


    public boolean correcteFuncionament() {
        return this.isAire_fred() && this.codiWifi.length() >= 8 && codiWifi.length() <= 16;
    }
    public String toString(){
        return super.toString() +"Bungalow Premium{codiWifi=" +codiWifi+ ", serveisExtres=" +serveisExtra+ "}";
    }
}
