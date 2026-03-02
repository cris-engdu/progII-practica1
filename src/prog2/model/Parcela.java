package prog2.model;

public class Parcela extends Allotjament {
    private float mida; //mida en m^2
    private boolean connexio_electrica; //

    public Parcela(String nom, String id, long estada_min_alta, long estada_min_baixa
            , float mida, boolean connexio_electrica) {
        super(nom, id, estada_min_alta, estada_min_baixa);
        this.mida = mida;
        this.connexio_electrica = connexio_electrica;
    }


    //getters

    public float getMida(){
        return this.mida;
    }

    public boolean isConnexio_electrica(){
        return this.connexio_electrica;
    }

    //setters
    public void setMida(long m){
        this.mida=m;
    }
    public void setConnexio_electrica(boolean conne_elec){
        this.connexio_electrica=conne_elec;
    }

    public boolean correcteFuncionament(){
        return connexio_electrica;
    }
}
