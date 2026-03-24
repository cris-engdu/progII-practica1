package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;

public class Camping implements InCamping {
    private String nomCamping;
    private ArrayList<Allotjament> llistaAllotjaments ;

    public Camping(String nomCamping){
        this.nomCamping=nomCamping;
        this.llistaAllotjaments=new ArrayList<>();


    }
    @Override
    public String getNomCamping() {
        return "";
    }

    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        return "";
    }

    @Override
    public String llistarAccessos(String infoEstat) throws ExcepcioCamping {
        return "";
    }

    @Override
    public String llistarTasquesManteniment() throws ExcepcioCamping {
        return "";
    }

    @Override
    public void afegirTascaManteniment(int num, String tipus, String idAllotjament, String data, int dies) throws ExcepcioCamping {

    }

    @Override
    public void completarTascaManteniment(int num) throws ExcepcioCamping {

    }

    @Override
    public int calculaAccessosNoAccessibles() {
        return 0;
    }

    @Override
    public float calculaMetresTerra() {
        return 0;
    }

    @Override
    public void save(String camiDesti) throws ExcepcioCamping {

    }

    @Override
    public void inicialitzaDadesCamping() {

    }
}
}


