package prog2.model;

import java.time.LocalDate;

public class Reserva implements InReserva{
    private Client client;
    private Allotjament allotjament;
    private LocalDate dataEntrada;
    private LocalDate dataSortida;


    public Reserva(Allotjament allotjament,Client client,LocalDate dataEntrada,LocalDate dataSortida) {
        this.allotjament=allotjament;
        this.client=client;
        this.dataEntrada=dataEntrada;
        this.dataSortida=dataSortida;
    }

    @Override
    public Allotjament getAllotjament_() {
        // TODO Auto-generated method stub
        return allotjament;
    }
    @Override
    public Client getClient() {
        // TODO Auto-generated method stub
        return client;
    }
    @Override
    public java.time.LocalDate getDataEntrada() {
        // TODO Auto-generated method stub
        return dataEntrada;
    }
    @Override
    public java.time.LocalDate getDataSortida() {
        // TODO Auto-generated method stub
        return dataSortida;
    }
    @Override
    public void setAllotjament_(Allotjament allotjament_) {
        // TODO Auto-generated method stub
        allotjament=allotjament_;

    }
    @Override
    public void setClient(Client client_) {
        // TODO Auto-generated method stub
        client=client_;

    }
    @Override
    public void setDataEntrada(java.time.LocalDate dataEntrada_) {
        // TODO Auto-generated method stub
        dataEntrada=dataEntrada_;

    }
    @Override
    public void setDataSortida(java.time.LocalDate dataSortida_) {
        // TODO Auto-generated method stub
        dataSortida=dataSortida_;
    }

}