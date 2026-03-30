package prog2.model;

public class CarreterraTerra extends AccesTerra{
    private int amplada;

    public CarreterraTerra(String nomacc, boolean estat, double longitud,int amplada) {
        super(nomacc, estat, longitud);
        this.amplada = amplada;
    }

    public int getAmplada() {
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
