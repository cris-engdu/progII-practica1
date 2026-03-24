package prog2.model;

import java.io.Serializable;

public class TascaManteniment implements InTascaManteniment, Serializable {
   public static enum TipusTascaManteniment{
       Repararacio,
       Neteja,
       RevisioTecnica,
       Desinfeccio
   }
   private int num_;

    @Override
    public int getNum() {
        return 0;
    }

    @Override
    public TascaManteniment.TipusTascaManteniment getTipus() {
        return null;
    }

    @Override
    public Allotjament getAllotjament() {
        return null;
    }

    @Override
    public String getData() {
        return "";
    }

    @Override
    public int getDies() {
        return 0;
    }

    @Override
    public void setNum(int num_) {

    }

    @Override
    public void setTipus(TascaManteniment.TipusTascaManteniment tipus_) {

    }

    @Override
    public void setAllotjament(Allotjament allotjament_) {

    }

    @Override
    public void setData(String data_) {

    }

    @Override
    public void setDies(int dies_) {

    }

    @Override
    public String getIluminacioAllotjament() {
        return "";
    }
}
