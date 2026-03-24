package prog2.model;

public class VistaCamping {
    private Camping camping;
    public VistaCamping(Camping camping) {
        camping.inicialitzaDadesCamping();
        this.camping = camping;
    }
}
