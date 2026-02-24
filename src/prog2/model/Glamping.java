package prog2.model;

public class Glamping extends Casa {
    private String material; //material de la tenda de campanya: fusta o tela
    private boolean casa_mascotas;

    public boolean correcteFuncionament() {
        if (casa_mascotas) {
            return true;
        } else {
            return false;
        }
    }
}
