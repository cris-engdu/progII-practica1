package prog2.model;

public class Bungalow extends Casa{
    private int parking; //1 o 2 places
    private boolean terrassa;
    private boolean televisio;
    private boolean aire_fred;

    public boolean correcteFuncionament() {
        if (aire_fred) {
            return true;
        } else {
            return false;
        }
    }
}
