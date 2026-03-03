package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class LlistaReserves implements InLlistaReserves{//instancia de reserva

    private ArrayList<Reserva> reserves;
    public LlistaReserves(){
        this.reserves=new ArrayList<>();
    }

    private boolean allotjamentDisponible(Allotjament allotjament, LocalDate dataEntrada,LocalDate dataSortida){
        for (Reserva reserva : reserves) {
            if (reserva.getAllotjament_().getId().equals(allotjament.getId())) {
                if (dataEntrada.isBefore(reserva.getDataSortida()) &&
                        dataSortida.isAfter(reserva.getDataEntrada())) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isEstadaMinima(Allotjament allotjament, LocalDate dataEntrada,LocalDate dataSortida){
        long estada= ChronoUnit.DAYS.between(dataEntrada,dataSortida);
        MonthDay iniciTempBaixa = MonthDay.of(9, 21);
        MonthDay finTempBaixa = MonthDay.of(3, 20);
        MonthDay dataEntradaMD = MonthDay.from(dataEntrada);
        MonthDay dataSortidaMD = MonthDay.from(dataSortida);
        InAllotjament.Temp temp;
        if ((!dataEntradaMD.isBefore(iniciTempBaixa) || !dataEntradaMD.isAfter(finTempBaixa)) && //data de entrada a dins de l'interval
                (!dataSortidaMD.isBefore(iniciTempBaixa) || !dataSortidaMD.isAfter(finTempBaixa)) && // data de sortida a dins de l'interval
                    (dataSortida.getYear() - dataEntrada.getYear() < 2)) {
            temp = InAllotjament.Temp.BAIXA;
        } else {
            temp = InAllotjament.Temp.ALTA;
        }
        if (estada >= allotjament.getEstadaMinima(temp)) { return true; } else { return false;}
    }
    @Override
    public void afegirReserva(Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {
            if(!allotjamentDisponible(allotjament,dataEntrada,dataSortida)){
                throw new ExcepcioReserva("L'allotjament amb identificador" +allotjament.getId() + " no esta disponible en la data" +
                        "demanada " +dataEntrada+ " pel client " +client.getNom()+ " amb DNI " +client.getNom()+ " .");
            }
            if (!isEstadaMinima(allotjament,dataEntrada,dataSortida)){
                throw new ExcepcioReserva("Les dates sol·licitades pel client " +client.getNom()+ " amb " +
                        "DNI: " +client.getDni()+ " no compleixen l'estada minima per l'allotjament amb identificador " +allotjament.getId()+ " .");

            }
            reserves.add(new Reserva(allotjament,client,dataEntrada,dataSortida));
    }

    @Override
    public int getNumReserves() {
        return reserves.size();
    }
}
