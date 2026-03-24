package prog2.model;

public class AccesTerra extends Acces{
    private float longitud;
    public AccesTerra(String nom, boolean accessibilitat, boolean operatiu, float longtiud) {
        super(nom, accessibilitat, operatiu);
        this.longitud = longtiud;
    }
}
