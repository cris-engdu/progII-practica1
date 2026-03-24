package prog2.model;

public class CarreterraTerra extends AccesTerra{
    private float amplada;
    public CarreterraTerra(String nom, boolean accessibilitat, boolean operatiu, float longitud, float amplada) {
        super(nom, accessibilitat, operatiu, longitud);
        setAccessibilitat(true);
        this.amplada = amplada;
    }
}
