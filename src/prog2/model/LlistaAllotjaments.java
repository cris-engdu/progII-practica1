package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.Serializable;
import java.util.ArrayList;

public class LlistaAllotjaments implements InLlistaAllotjaments, Serializable {
    private ArrayList<Allotjament> llistaAllotjaments;

    public  LlistaAllotjaments() {
       this.llistaAllotjaments=new ArrayList<>();
    }

    @Override
    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {
                if (allotjament==null){
                    throw new ExcepcioCamping("L'allotjament no pot ser nul");
                }
                llistaAllotjaments.add(allotjament);
    }

    @Override
    public void buidar() {
        llistaAllotjaments.clear();;
    }

    /*en aquesta funcio com l'estat es boolea i en aquesta es String, es mira si aquest es operatiu o no i es mostra els allotjaments corresponents sino mostra un error.*/
    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        String resultat="";
        for (Allotjament a:llistaAllotjaments){
            if (a.isOperatiu() && estat.equals("Operatiu") || !a.isOperatiu() && estat.equals("No Operatiu")){
                resultat+=a.toString();
                resultat+="\n";
            }
        }
        if (resultat.equals("")){
            throw new ExcepcioCamping("Error, no hi cap allotjament amb aquest estat");
        }

        return resultat;
    }

    public String llistarAllotjamentsTots() throws ExcepcioCamping {
        if (llistaAllotjaments.isEmpty()){
            throw new ExcepcioCamping("Error,no hi ha cap allotjament.");
        }

        String resultat="";

        for (Allotjament a:llistaAllotjaments){
            resultat+=a.toString();
            resultat+="\n";
        }


        return resultat;
    }
/*retorna true or false si a la llista hi ha algu allotjament operatiu*/
    @Override
    public boolean containsAllotjamentOperatiu() {

         for (Allotjament a:llistaAllotjaments){
             if (a.isOperatiu()){
                return true;

             }
         }
         return false;
    }



    /*busca si existeix l'allotjament que es passa com a parametre*/
    @Override
    public boolean contains(Allotjament allotjament) {

        for(Allotjament a:llistaAllotjaments){
            if (a.equals(allotjament)){
               return true;
            }
        }
        return false;
    }

    @Override
    public Allotjament getAllotjament(String id) throws ExcepcioCamping {
        for (Allotjament a:llistaAllotjaments){
            if (a.getId().equals(id)){
                return a;
            }
        }
        throw new ExcepcioCamping("Error, no existeix cap allotjament amb aquest id");

    }
}
