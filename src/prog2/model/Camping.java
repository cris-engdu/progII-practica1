package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Camping implements InCamping{ //instancia de llistareserves y de arraylist.. arraylist allotjament i reserva
    private String nom;
    private ArrayList<Client> llistaClients;
    private ArrayList<Allotjament> llistaAllotjaments ;
    private LlistaReserves LlistaReserves;

    public Camping(String nom){
        this.nom=nom;
        this.llistaAllotjaments=new ArrayList<>();
        this.llistaClients=new ArrayList<>();
        this.LlistaReserves=new LlistaReserves();
    }
    @Override
    public String getNom() {
        return this.nom;
    }

    @Override
    public LlistaReserves getLlistaReserves() {
        return this.LlistaReserves;
    }

    @Override
    public ArrayList<Allotjament> getLlistaAllotjaments() {
        return this.llistaAllotjaments;
    }

    @Override
    public ArrayList<Client> getLlistaClients() {
        return this.llistaClients;
    }

    @Override
    public int getNumAllotjaments() {
        return this.llistaAllotjaments.size();
    }
//propi metode llista de reserves (d'afegir)
    @Override
    public int getNumReserves() {
        return this.LlistaReserves.getNumReserves();
    }

    @Override
    public int getNumClients() {
        return this.llistaClients.size();
    }
//afegir clients
    @Override
    public void afegirClient(String nom_, String dni_) {
        llistaClients.add(new Client(nom_,dni_));
    }

    @Override
    public void afegirParcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica) {
        llistaAllotjaments.add(new Parcela(nom_,idAllotjament_,metres,connexioElectrica));
    }

    @Override
    public void afegirBungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {

    }

    @Override
    public void afegirBungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi) {

    }

    @Override
    public void afegirGlamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, String material, boolean casaMascota) {

    }

    @Override
    public void afegirMobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, boolean terrassaBarbacoa) {

    }

    @Override
    public void afegirReserva(String id_, String dni_, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {
        Allotjament allotjament=null;
        Client client=null;
        Iterator<Allotjament> it= llistaAllotjaments.iterator();

        while(it.hasNext()){
            Allotjament allot=it.next();
            if (allot.getId().equals(id_)){
                allotjament= allot;
            }
        }

        Iterator<Client> itc=llistaClients.iterator();

        while(itc.hasNext()){
            Client cli=itc.next();
            if(cli.getDni().equals(dni_)){
                client=cli;
            }
        }
        LlistaReserves.afegirReserva(allotjament,client,dataEntrada,dataSortida);
    }

    @Override
    public int calculAllotjamentsOperatius() {

        int cont=0;
        for (int i=0;i<llistaAllotjaments.size();i++){
            Allotjament all=llistaAllotjaments.get(i);
            if (all.correcteFuncionament()){
                cont++;
            }

        }
        return cont;


    }

    @Override
    public Allotjament getAllotjamentEstadaMesCurta(InAllotjament.Temp temp) {
        return null;
    }
}
