package prog2.model;

public class AccesAsfalt extends Acces{
    private double m2;
    public AccesAsfalt(String nomacc, boolean estat, boolean accessibilitat, double m2) {
        super(nomacc, estat, accessibilitat,new LlistaAllotjaments());
        this.m2=m2;
    }

    public double getM2() {
        return this.m2;
    }
    public void setM2(double m2){
        this.m2=m2;
    }

}
