package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;

public class LlistaAccessos implements InLlistaAccessos{
    private ArrayList<Acces> llistaaccessos;

    public LlistaAccessos(){
        this.llistaaccessos = new ArrayList<>();
    }
    @Override
    public void afegirAcces(Acces acc) throws ExcepcioCamping {

          for (Acces a: llistaaccessos){
              if (a.equals(acc)) {
                  throw new ExcepcioCamping("L'acces ja existeix");
              }
          }

            llistaaccessos.add(acc);
    }

    @Override
    public void buidar() {
        llistaaccessos.clear();

    }

    @Override
    public String llistarAccessos(boolean estat) throws ExcepcioCamping {
        String imprimir="";
        for (Acces a: llistaaccessos){
            if (a.getEstat()==estat){
                imprimir += a.toString();
            }
        }
        if (imprimir.equals("")){
            throw new ExcepcioCamping(("No hi cap acces amb aquest estat"));
        }

        return imprimir;
    }

    @Override
    public void actualitzaEstatAccessos() throws ExcepcioCamping {
        for (Acces a: llistaaccessos){
            if (a.getAAllotjaments().containsAllotjamentOperatiu()){
                a.obrirAcces();
            }else{
                a.tancarAcces();
            }
        }
    }

    @Override
    public int calculaAccessosNoAccessibles() throws ExcepcioCamping {
        int cont=0;
        for (Acces a: llistaaccessos){
            if (!a.isAccessibilitat()){
                cont++;
            }
        }
        return cont;
    }

    @Override
    public float calculaMetresTerra() throws ExcepcioCamping {
        float metres=0;

        for (Acces a: llistaaccessos){
            if (a instanceof AccesTerra){
                metres+= (float) ((AccesTerra) a).getLongitud();
            }
        }
        return metres;
    }
}
