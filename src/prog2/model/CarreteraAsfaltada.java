package prog2.model;

public class CarreteraAsfaltada extends AccesAsfaltat {
    private float pesmaxim;
    public CarreteraAsfaltada(String nomacc, boolean estat , double m2, float pesmaxim) {
        super(nomacc, estat, m2);
        this.pesmaxim = pesmaxim;
    }
    @Override
    public boolean isAccessibilitat(){
        return true;
    }
//getter i setter de pes maxim
    public float getPesmaxim() {
        return this.pesmaxim;
    }

    public void setPesmaxim(float pesmaxim) {
        this.pesmaxim = pesmaxim;
    }

    @Override
    public String toString() {
        return super.toString() + "Carreterra asfaltada{ pes maxim: " +this.pesmaxim;
    }
}
