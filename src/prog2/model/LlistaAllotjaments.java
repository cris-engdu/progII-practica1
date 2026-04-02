package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;

public class LlistaAllotjaments implements InLlistaAllotjaments{
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

    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        String resultat="";
        for (Allotjament a:llistaAllotjaments){
            if (a.isOperatiu() && estat.equals("Operatiu") || !a.isOperatiu() && estat.equals("No Operatiu")){
                resultat+=a.toString();

            }
        }
        if (resultat.equals("")){
            throw new ExcepcioCamping("Error, no hi cap allotjament amb aquest estat");
        }

        return resultat;
    }

    public String llistarAllotjamentsTots() throws ExcepcioCamping {
        String resultat="";

        for (Allotjament a:llistaAllotjaments){
            resultat+=a.toString();
        }
        if (resultat.equals("")){
            throw new ExcepcioCamping("No hi ha cap allotjament.");
        }

        return resultat;
    }

    @Override
    public boolean containsAllotjamentOperatiu() {

         for (Allotjament a:llistaAllotjaments){
             if (a.isOperatiu()){
                return true;

             }
         }
         return false;
    }


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
