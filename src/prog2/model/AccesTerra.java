package prog2.model;

public class AccesTerra extends Acces{
        private float longitud;

    public AccesTerra(String nomacc, boolean estat ,float longitud) {
        super(nomacc, estat );
        this.longitud=longitud;
    }
//getter i setter de la variable longitud
    public double getLongitud() {
        return this.longitud;
    }
    public void setLongitud(float longitud) {
        this.longitud=longitud;
    }

    @Override
    public boolean isAccessibilitat() {
        return false;
    }

    @Override
    public String toString() {
        return super.toString() +"Acces terra amb longitud " +longitud+ " metres";
    }
}
