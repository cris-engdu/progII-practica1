package prog2.model;

public class CamiTerra extends AccesTerra{

    public CamiTerra(String nomacc, boolean estat, float longitud) {
        super(nomacc, estat, longitud);
    }
//modifiquem si es accesible o no
    @Override
    public boolean isAccessibilitat(){
        return false;
    }
}
