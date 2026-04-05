package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.Serializable;
import java.util.ArrayList;

public class LlistaAccessos implements InLlistaAccessos, Serializable {
    private ArrayList<Acces> llistaaccessos;

    public LlistaAccessos(){
        this.llistaaccessos = new ArrayList<>();
    }
    /**Funcio que s'encarrega de trobar accessos amb el mateix nom i si no els crea*/
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

    /**Aquesta funcio només s'encarrega de trobar accessos amb el mateix estat que es passa i els concatena per mostrar-ho en pantalla*/
    @Override
    public String llistarAccessos(boolean estat) throws ExcepcioCamping {
        String imprimir="";
        for (Acces a: llistaaccessos){
            if (a.getEstat()==estat){
                imprimir += a.toString();
                imprimir += "\n";
            }
        }
        if (imprimir.equals("")){
            throw new ExcepcioCamping(("No hi cap acces amb aquest estat"));
        }

        return imprimir;
    }

    @Override
    public void actualitzaEstatAccessos() throws ExcepcioCamping {
        if (llistaaccessos.isEmpty()){
            throw new ExcepcioCamping("La llista d'accessos està buida.");
        }
        for (Acces a: llistaaccessos){
            if (a.getAAllotjaments().containsAllotjamentOperatiu()){
                a.obrirAcces();
            }else{
                a.tancarAcces();
            }
        }
    }


    /**Només compta els accessos que no estan accessibles*/
    @Override
    public int calculaAccessosNoAccessibles() throws ExcepcioCamping {
        if (llistaaccessos.isEmpty()){
            throw new ExcepcioCamping("La llista d'accessos està buida.");
        }
        int cont=0;
        for (Acces a: llistaaccessos){
            if (!a.isAccessibilitat()){
                cont++;
            }
        }
        return cont;
    }

    /**Aquesta funció recorre la llista d'accessos per mirar si pertany a accesTerra i suma els seus metres de longtiud*/
    @Override
    public float calculaMetresTerra() throws ExcepcioCamping {
        if  (llistaaccessos.isEmpty()){
            throw new ExcepcioCamping("La llista d'accessos està buida");
        }

        float metres=0;

        for (Acces a: llistaaccessos){
            if (a instanceof AccesTerra){
                metres+= (float) ((AccesTerra) a).getLongitud();
            }
        }
        return metres;
    }
}
