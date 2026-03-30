package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;

public class Camping implements InCamping {
    private String nomCamping;
    private LlistaAllotjaments llistaAllotjaments ;
    private LlistaAccessos llistaAccessos;

    public Camping(String nomCamping){
        this.nomCamping=nomCamping;
        this.llistaAllotjaments=new LlistaAllotjaments();
        this.llistaAccessos=new LlistaAccessos();


    }
    @Override
    public String getNomCamping() {
        return this.nomCamping;
    }

    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
       return llistaAllotjaments.llistarAllotjaments(estat);


    }

    @Override
    public String llistarAccessos(String infoEstat) throws ExcepcioCamping {
        return llistaAccessos.llistarAccessos(infoEstat.equals("Obert"));
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
        try {
            return llistaAccessos.calculaAccessosNoAccessibles();
        } catch (ExcepcioCamping e) {
           return 0;

        }
    }

    @Override
    public float calculaMetresTerra() {
        try {
            return llistaAccessos.calculaMetresTerra();
        } catch (ExcepcioCamping e) {
            return 0;

        }

    }

    @Override
    public void save(String camiDesti) throws ExcepcioCamping {

    }

    @Override
    public void inicialitzaDadesCamping() {
    llistaAllotjaments=new LlistaAllotjaments();
    llistaAccessos=new LlistaAccessos();
    }
}



