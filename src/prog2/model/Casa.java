package prog2.model;

public class Casa extends Allotjament{

    private float mida;
    private int num_habitacions;
    private int capacitat_places;

    public Casa(String nom, String id, boolean operatiu, String ilum, float mida,int num_habitacions,int capacitat_places) {
        super(nom, id, 0, 0, operatiu, ilum);
        this.mida=mida;
        this.num_habitacions=num_habitacions;
        this.capacitat_places=capacitat_places;
    }

    public float getMida(){
        return this.mida;
    }

    public int getNum_habitacions(){
        return this.num_habitacions;
    }
    public int getCapacitat_places(){
        return this.capacitat_places;
    }

    public void setMida(float m){
        this.mida=m;
    }
    public void setNum_habitacions( int n_h){
        this.num_habitacions=n_h;
    }
    public void setCapacitat_places(int cap_pl){
        this.capacitat_places=cap_pl;
    }
}
