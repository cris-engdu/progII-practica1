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
        llistaAllotjaments.add(new Bungalow(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred));
    }

    @Override
    public void afegirBungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi) {
        llistaAllotjaments.add(new BungalowPremium(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi));
    }

    @Override
    public void afegirGlamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, String material, boolean casaMascota) {
        llistaAllotjaments.add(new Glamping(nom_, idAllotjament_, mida, habitacions, placesPersones, material, casaMascota));
    }

    @Override
    public void afegirMobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, boolean terrassaBarbacoa) {
        llistaAllotjaments.add(new MobilHome(nom_, idAllotjament_, mida, habitacions, placesPersones, terrassaBarbacoa));
    }

    public Allotjament buscarAllotjament(String idAllotjament) {
        Iterator itrAllotjaments = llistaAllotjaments.iterator();
        while (itrAllotjaments.hasNext()) {
            Allotjament allot = (Allotjament) itrAllotjaments.next();
            if (allot.getId().equals(idAllotjament)) {
                return allot;
            }
        }
        return null;
    }

    public Client buscarClient(String dni) {
        Iterator itrClients = llistaClients.iterator();
        while (itrClients.hasNext()) {
            Client client = (Client) itrClients.next();
            if (client.getDni().equals(dni)) {
                return client;
            }
        }
        return null;
    }

    @Override
    public void afegirReserva(String id_, String dni_, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {
        // Buscar client, si no existeix llançar ExcepcioReserva
        Client clientNou = null;
        if (buscarClient(dni_) == null) {
            throw new ExcepcioReserva("El client amb DNI " + dni_ + " no existeix");
        } else {
            clientNou = buscarClient(dni_);
        }

        // Buscar allotjament de la mateixa manera
        Allotjament allotNou = null;
        if (buscarAllotjament(id_) == null) {
            throw new ExcepcioReserva("L'allotjament amb id " + id_ + " no existeix");
        } else {
            allotNou = buscarAllotjament(id_);
        }
        LlistaReserves.afegirReserva(allotNou, clientNou, dataEntrada, dataSortida);
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
        if (llistaAllotjaments.size() == 0) {
            return null;
        }
        Allotjament allEstadaCurta = llistaAllotjaments.get(0);
        for (int i=0;i<llistaAllotjaments.size();i++){
            Allotjament all=llistaAllotjaments.get(i);
            if (all.getEstadaMinima(temp)< allEstadaCurta.getEstadaMinima(temp)){
                allEstadaCurta=all;
            }
        }
        return allEstadaCurta;
    }

    public static InAllotjament.Temp getTemporada(LocalDate data) {
        int mes = data.getMonthValue();
        int dia = data.getDayOfMonth();
        if ((mes > 3 && mes < 9) || (mes == 3 && dia >= 21) || (mes == 9 && dia <= 20)) {
            return InAllotjament.Temp.ALTA;
        } else {
            return InAllotjament.Temp.BAIXA;
        }
    }
}
