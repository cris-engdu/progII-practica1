package prog2.model;

public class CarreterraAsfalt extends AccesAsfalt{
    private int pesMaxim;
    public CarreterraAsfalt(String nom, boolean accessibilitat, boolean operatiu, float metresQuadratsAsfalt, int pesMaxim) {
        super(nom, accessibilitat, operatiu, metresQuadratsAsfalt);
        setAccessibilitat(true);
        this.pesMaxim = pesMaxim;
    }
}
