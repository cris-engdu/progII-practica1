package prog2.model;

public class CarreteraTerra extends AccesTerra{
    private float amplada;

    public CarreteraTerra(String nomacc, boolean estat, float longitud, float amplada) {
        super(nomacc, estat, longitud);
        this.amplada = amplada;
    }

    public float getAmplada() {
        return this.amplada;
    }

    public void setAmplada(int amplada) {
        this.amplada = amplada;
    }

    @Override
    public boolean isAccessibilitat(){
        return true;
    }

    @Override
    public String toString(){
        return super.toString() + "Carretera de terra,  amplada " +this.amplada+ " metres";
    }
}
