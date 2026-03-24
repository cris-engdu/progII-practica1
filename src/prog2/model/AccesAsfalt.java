package prog2.model;

public class AccesAsfalt extends Acces{
    private float metresQuadratsAsfalt;
    public AccesAsfalt(String nom, boolean accessibilitat, boolean operatiu, float metresQuadratsAsfalt) {
        super(nom, accessibilitat, operatiu);
        this.metresQuadratsAsfalt = metresQuadratsAsfalt;
    }

}
