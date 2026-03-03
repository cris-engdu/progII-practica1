package prog2.model;

import java.nio.charset.IllegalCharsetNameException;

public class BungalowPremium extends Bungalow {
    private String codi_wifi;
    private boolean llencols_tovalloles;

    public BungalowPremium(String nom, String id, mides mida, int num_habitacions, int capacitat_places, int parking, boolean terrassa, boolean televisio,
                           boolean aire_fred,String codi_wifi,boolean llencols_tovalloles) {
        super(nom, id, mida, num_habitacions, capacitat_places, parking, terrassa, televisio, aire_fred);
        this.codi_wifi=codi_wifi;
        this.llencols_tovalloles= llencols_tovalloles;
    }
    //getters
    public String getCodi_wifi(){
        return this.codi_wifi;
    }

    public boolean isLlencols_tovalloles(){
        return this.llencols_tovalloles;
    }

    //setters
    public void setCodi_wifi(String codi){
        this.codi_wifi=codi;
    }
    public void setLlencols_tovalloles(Boolean lle_tova){
        this.llencols_tovalloles=lle_tova;
    }


    public boolean correcteFuncionament() {
        return this.isAire_fred() && this.codi_wifi.length() >= 8 && codi_wifi.length() <= 16;
    }
}
