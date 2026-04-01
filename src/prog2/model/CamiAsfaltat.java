package prog2.model;

public class CamiAsfaltat extends AccesAsfaltat {

    public CamiAsfaltat(String nomacc, boolean estat  , double m2) {
        super(nomacc, estat, m2);
    }

    @Override
    public boolean isAccessibilitat(){
        return false;
    }


}
