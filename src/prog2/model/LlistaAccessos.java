package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;

public class LlistaAccessos implements InLlistaAccessos{
    private ArrayList<Acces> access;

    public LlistaAccessos(){
        access = new ArrayList<>();
    }
    @Override
    public void afegirAcces(Acces acc) throws ExcepcioCamping {

          for (Acces a: access){
              if (a.equals(acc)) {
                  throw new ExcepcioCamping("L'acces ja existeix");
              }
          }

            access.add(acc);
    }

    @Override
    public void buidar() {
        access.clear();

    }

    @Override
    public String llistarAccessos(boolean estat) throws ExcepcioCamping {
        return "";
    }

    @Override
    public void actualitzaEstatAccessos() throws ExcepcioCamping {
        for (Acces a: access){
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
        for (Acces a: access){
            if (!a.isAccessibilitat()){
                cont++;
            }
        }
        return cont;
    }

    @Override
    public float calculaMetresTerra() throws ExcepcioCamping {
        return 0;
    }
}
