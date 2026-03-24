package prog2.model;

public class CamiTerra extends AccesTerra{
    public CamiTerra(String nom, boolean accessibilitat, boolean operatiu, float longitud) {
        super(nom, accessibilitat, operatiu, longitud);
        setAccessibilitat(false);
    }
}
