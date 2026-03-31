package prog2.model;

public class Casa extends Allotjament{

    public enum mides{ // nomes poden ser aquest tres tipus
        PETITA,MITJANA,GRAN;
    }

    private mides mida;
    private int num_habitacions;
    private int capacitat_places;

    public Casa(String nom, String id, long estada_min_alta, long estada_min_baixa, boolean operatiu, String ilum,String mida,int num_habitacions,int capacitat_places) {
        super(nom, id, estada_min_alta, estada_min_baixa, operatiu, ilum);
        this.mida= Casa.mides.valueOf(mida.toUpperCase());
        this.num_habitacions=num_habitacions;
        this.capacitat_places=capacitat_places;
    }

    public mides getMida(){
        return this.mida;
    }

    public int getNum_habitacions(){
        return this.num_habitacions;
    }
    public int getCapacitat_places(){
        return this.capacitat_places;
    }

    public void setMida(mides m){
        this.mida=m;
    }
    public void setNum_habitacions( int n_h){
        this.num_habitacions=n_h;
    }
    public void setCapacitat_places(int cap_pl){
        this.capacitat_places=cap_pl;
    }
}
