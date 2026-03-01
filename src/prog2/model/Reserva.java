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
        return allotjament;
    }
    @Override
    public Client getClient() {
        return client;
    }
    @Override
    public LocalDate getDataEntrada() {
        return dataEntrada;
    }
    @Override
    public LocalDate getDataSortida() {
        return dataSortida;
    }
    @Override
    public void setAllotjament_(Allotjament allotjament_) {
       this.allotjament=allotjament_;

    }
    @Override
    public void setClient(Client client_) {
        this.client=client_;

    }
    @Override
    public void setDataEntrada(java.time.LocalDate dataEntrada_) {
        this.dataEntrada=dataEntrada_;

    }
    @Override
    public void setDataSortida(java.time.LocalDate dataSortida_) {
        this.dataSortida=dataSortida_;
    }

}