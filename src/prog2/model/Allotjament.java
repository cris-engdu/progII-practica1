package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.Serializable;
import java.time.LocalDate;

public class Allotjament implements InAllotjament, Serializable {
    public enum iluminacion{
        ALTA("100%"), MITJANA("50%"), RES("0%");

        //creem una variable privada i final que no es modifica perque els tests reben el percentatge i no el nom.
        private final String val;
    /*llavors fem una funció on passem la variable per modificar el percentatge*/
        iluminacion(String s) {
            this.val=s;
        }
        /*aqui la utilitzem per tal de retornar-nos el valor numeric de la il·luminacio*/
        public String getVal(){
            return val;
        }

        /*aqui per ultim, farem una funcio on si es crida busquem si el percentatge esta en les diferents opcions que tenim i si esta
        el retornem sino una excepcio d'error*/
        public static iluminacion fromString(String text) throws ExcepcioCamping {
            for (iluminacion il:iluminacion.values()){
                if (il.val.equals(text)){
                    return il;
                }
            }

           throw new ExcepcioCamping("Error, valor d' l·luminacio incorrecte");
        }

          }
    private String nom;
    private String id;
    private long estada_min_alta;
    private long estada_min_baixa;
    private boolean operatiu;
    private iluminacion Iluminacio;



    public Allotjament(String nom, String id, long estada_min_alta, long estada_min_baixa,boolean operatiu,String ilum)  {
        this.nom = nom;
        this.id = id;
        this.estada_min_alta = estada_min_alta;
        this.estada_min_baixa = estada_min_baixa;
        this.operatiu=operatiu;
        // Aqui en el constructor cridem a un try catch per tal de fer que si el valor passat per iluminacio es correcte ja que nomes son 3 opcions correctes, 100,50 0 %
        try {
            this.Iluminacio=iluminacion.fromString(ilum);
        } catch (ExcepcioCamping e) {
            throw new RuntimeException(e);
        }

    }
//get nom
    @Override
    public String getNom() {
        return this.nom;
    }
//set nom
    @Override
    public void setNom(String nom_p) {
        this.nom = nom_p;
    }
//get i setter d'id
    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id_p) {
        this.id = id_p;
    }
//estada minima
    @Override
    public long getEstadaMinima(Temp temp) {
        if (temp==Temp.ALTA){
            return this.estada_min_alta;
        }else {
            return this.estada_min_baixa;
        }
    }
    @Override
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_) {
        this.estada_min_alta=estadaMinimaALTA_;
        this.estada_min_baixa=estadaMinimaBAIXA_;
    }
    //getter i setter de operatiu
    public boolean isOperatiu(){
        return this.operatiu;
    }
    public void setOperatiu(boolean operatiu){
        this.operatiu=operatiu;
    }
//getter i setter d'iluminacio
    /*En el getter el fem string ja que retornem el valor numeric del percentatge utilitzant un getter definit al principi*/
    public String  getIluminacio(){
        return this.Iluminacio.getVal();
    }
    public void setIluminacio(iluminacion iluminacio){
        this.Iluminacio = iluminacio;
    }




/*aqui assignem a cada tasca el seu valor d'il·luminacio*/
    @Override
    public void tancarAllotjament(TascaManteniment tasca) {
            this.operatiu=false;
            this.Iluminacio=switch (tasca.getTipus()){
                case Reparacio -> iluminacion.MITJANA;
                case Neteja -> iluminacion.ALTA;
                case RevisioTecnica -> iluminacion.MITJANA;
                case Desinfeccio -> iluminacion.RES;
            };
    }

    @Override
    public void obrirAllotjament() {
        this.operatiu=true;
        this.Iluminacio=iluminacion.ALTA;


    }



    public String toString() {
        String str = "Nom=" + this.getNom() + ", Id=" + this.getId() + ", estada mínima en temp ALTA: " +
                this.getEstadaMinima(InAllotjament.Temp.ALTA) + ", estada mínima en temp BAIXA: " +
                this.getEstadaMinima(InAllotjament.Temp.BAIXA) + ", estat operatiu: " +(this.operatiu ? "Si" : "No")+ ", iluminacio: " +this.Iluminacio.getVal();
        return str;
    }
}
