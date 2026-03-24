package prog2.model;

public class CamiAsfalt extends AccesAsfalt{
    public CamiAsfalt(String nom, boolean accessibilitat, boolean operatiu, float metresQuadratsAsfalt) {
        super(nom, accessibilitat, operatiu,  metresQuadratsAsfalt);
        setAccessibilitat(false);
    }
}
