package prog2.model;

public class CamiTerra extends AccesTerra{

    public CamiTerra(String nomacc, boolean estat, boolean accessibilitat, LlistaAllotjaments llistaAllotjaments, double longitud) {
        super(nomacc, estat, longitud);
    }

    @Override
    public boolean isAccessibilitat(){
        return false;
    }
}
