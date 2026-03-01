package prog2.model;

public class Client implements InClient {
    private String nom;
    private String dni;


    public Client(String nom, String dni) {
        this.nom = nom;
        this.dni = dni;
    }

    public String toString() {

        return nom + " amb DNI: " + dni;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public String getDni() {
        return dni;
    }

    @Override
    public void setNom(String n) {
        this.nom = n;
    }

    @Override
    public void setDni(String dni) {
        this.dni = dni;
    }
}