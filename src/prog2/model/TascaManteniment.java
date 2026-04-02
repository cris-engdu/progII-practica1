package prog2.model;

public class TascaManteniment implements InTascaManteniment{
    private int num;
    private TipusTascaManteniment tipus;
    private Allotjament allotjament;
    private String data;
    private int dies;

    public TascaManteniment(int num, TipusTascaManteniment tipus, Allotjament allotjament, String data, int dies){
        this.num = num;
        this.tipus = tipus;
        this.allotjament = allotjament;
        this.data = data;
        this.dies = dies;
    }

    @Override
    public int getNum() {
        return num;
    }

    @Override
    public TascaManteniment.TipusTascaManteniment getTipus() {
        return tipus;
    }

    @Override
    public Allotjament getAllotjament() {
        return allotjament;
    }

    @Override
    public String getData() {
        return data;
    }

    @Override
    public int getDies() {
        return dies;
    }

    @Override
    public void setNum(int num_) {
        this.num = num_;
    }

    @Override
    public void setTipus(TascaManteniment.TipusTascaManteniment tipus_) {
        this.tipus = tipus_;
    }

    @Override
    public void setAllotjament(Allotjament allotjament_) {
        this.allotjament = allotjament_;
    }

    @Override
    public void setData(String data_) {
        this.data = data_;
    }

    @Override
    public void setDies(int dies_) {
        this.dies = dies_;
    }

    @Override
    public String getIluminacioAllotjament() {
        TipusTascaManteniment tipus_allotjament = getTipus();
        String ilum;
        switch (tipus_allotjament) {
            case Reparacio -> ilum = "50%";
            case Neteja -> ilum = "100%";
            case RevisioTecnica ->  ilum = "50%";
            case Desinfeccio ->  ilum = "0%";
            default -> ilum = "100%";
        }
        return ilum;
    }

    public String toString() {
        return "Num: " + num + " Allotjament: " + allotjament.toString() + "tipus: " + tipus.toString() + "data: " + data + "dies: " + dies;
    }

    public static enum TipusTascaManteniment {
        Reparacio,
        Neteja,
        RevisioTecnica,
        Desinfeccio
    };
}
