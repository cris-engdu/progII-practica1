package prog2.model;

public class CamiAsfalt extends AccesAsfalt{

    public CamiAsfalt(String nomacc, boolean estat  , double m2) {
        super(nomacc, estat, m2);
    }

    @Override
    public boolean isAccessibilitat(){
        return false;
    }


}
