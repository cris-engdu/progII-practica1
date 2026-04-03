package prog2.model;

public class AccesAsfaltat extends Acces{
    private double m2;
    public AccesAsfaltat(String nomacc, boolean estat , double m2) {
        super(nomacc, estat);
        this.m2=m2;
    }
//getter i setter dels metres quadrats
    public double getM2() {
        return this.m2;
    }
    public void setM2(double m2){
        this.m2=m2;
    }

    @Override
    public boolean isAccessibilitat() {
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + "Acces asfalt: amb " +m2+ " m^2 d'asfalt";
    }
}
