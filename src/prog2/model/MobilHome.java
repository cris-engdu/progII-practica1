package prog2.model;

public class MobilHome extends Casa {
    private boolean terrassa;
    private boolean barbacoa;
    public boolean correcteFuncionament() {
        if (terrassa && barbacoa) {
            return true;
        } else {
            return false;
        }
    }
}
