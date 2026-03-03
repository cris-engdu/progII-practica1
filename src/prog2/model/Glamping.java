package prog2.model;

public class Glamping extends Casa {
    private String material; //material de la tenda de campanya: fusta o tela
    private boolean casa_mascotas;

    public Glamping(String nom, String id, String mida, int num_habitacions,
                    int capacitat_places, String material, boolean casa_mascotas) {
        super(nom, id, mida, num_habitacions, capacitat_places);
        this.material=material;
        this.casa_mascotas=casa_mascotas;
        this.setEstadaMinima(3, 3);
    }
    //getters
    public String getMaterial() {
        return this.material;
    }
    public boolean isCasa_mascotas(){
        return this.casa_mascotas;
    }
    //setters

    public void setMaterial(String mat){
        this.material=mat;
    }
    public void setCasa_mascotas(boolean casa_mascotas){
        this.casa_mascotas=casa_mascotas;
    }

    @Override
    public boolean correcteFuncionament() {
        return this.casa_mascotas;
    }
}
