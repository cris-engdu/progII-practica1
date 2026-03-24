package prog2.model;

public class AccesTerra extends Acces{
        private double longitud;

    public AccesTerra(String nomacc, boolean estat ,double longitud) {
        super(nomacc, estat );
        this.longitud=longitud;
    }

    public double getLongitud() {
        return this.longitud;
    }
    public void setLongitud(double longitud) {
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
