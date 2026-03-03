package prog2.model;

public class Parcela extends Allotjament {
    private float mida; //mida en m^2
    private boolean connexio_electrica; //

    public Parcela(String nom, String id, float mida, boolean connexio_electrica) {
        super(nom, id);
        this.mida = mida;
        this.connexio_electrica = connexio_electrica;
    }


    //getters

    public float getMida(){
        return this.mida;
    }

    public boolean isConnexioElectrica(){
        return this.connexio_electrica;
    }

    //setters
    public void setMida(long m){
        this.mida=m;
    }
    public void setConnexioElectrica(boolean conne_elec){
        this.connexio_electrica=conne_elec;
    }

    public boolean correcteFuncionament(){
        return connexio_electrica;
    }
}
