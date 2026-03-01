package prog2.model;

public class Casa extends Allotjament{
    public enum mides{
        PETITA,MITJANA,GRAN;
    }

    private mides mida;
    private int num_habitacions;
    private int capacitat_places;

    public Casa(String nom, String id, long estada_min_alta, long estada_min_baixa,mides mida, int num_habitacions, int capacitat_places) {
        super(nom, id, estada_min_alta, estada_min_baixa);
        this.mida=mida;
        this.num_habitacions=num_habitacions;
        this.capacitat_places=capacitat_places;
    }

    public mides getMida(){
        return mida;
    }

    public int getNum_habitacions(){
        return num_habitacions;
    }
    public int getCapacitat_places(){
        return capacitat_places;
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
