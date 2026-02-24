package prog2.model;

public class Client implements InClient {
    private String nom;
    private String dni;


    public Client(String nom, String dni) {
        this.nom = nom;
        this.dni = dni;
    }

    public String toString() {

        return nom + " amb DNI: " + dni + "\n";
    }

    @Override
    public String getNom() {
        // TODO Auto-generated method stub
        return nom;
    }

    @Override
    public String getDni() {
        // TODO Auto-generated method stub
        return dni;
    }

    @Override
    public void setNom(String nom) {
        // TODO Auto-generated method stub
        nom = nom;
    }

    @Override
    public void setDni(String dni) {
        // TODO Auto-generated method stub
        dni = dni;
    }
}