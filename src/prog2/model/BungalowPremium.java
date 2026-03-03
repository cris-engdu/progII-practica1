package prog2.model;

import java.nio.charset.IllegalCharsetNameException;

public class BungalowPremium extends Bungalow {
    private String codi_wifi;
    private boolean serveisExtra;

    public BungalowPremium(String nom, String id, String mida, int num_habitacions, int capacitat_places, int parking, boolean terrassa, boolean televisio,
                           boolean aire_fred, boolean serveisExtra, String codi_wifi) {
        super(nom, id, mida, num_habitacions, capacitat_places, parking, terrassa, televisio, aire_fred);
        this.serveisExtra = serveisExtra;
        this.codi_wifi=codi_wifi;
    }
    //getters
    public String getCodi_wifi(){
        return this.codi_wifi;
    }

    public boolean isServeisExtra(){
        return this.serveisExtra;
    }

    //setters
    public void setCodi_wifi(String codi){
        this.codi_wifi=codi;
    }
    public void setServeisExtra(Boolean lle_tova){
        this.serveisExtra=lle_tova;
    }


    public boolean correcteFuncionament() {
        return this.isAire_fred() && this.codi_wifi.length() >= 8 && codi_wifi.length() <= 16;
    }
}
