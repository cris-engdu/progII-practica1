package prog2.model;

public class Glamping extends Casa {
    private String material; //material de la tenda de campanya: fusta o tela
    private boolean casa_mascotas;

    public Glamping(String nom, String id, long estada_min_alta, long estada_min_baixa, mides mida, int num_habitacions,
                    int capacitat_places, String material, boolean casa_mascotas) {
        super(nom, id, estada_min_alta, estada_min_baixa, mida, num_habitacions, capacitat_places);
        this.material=material;
        this.casa_mascotas=casa_mascotas;
    }
    //getters
    public String getMaterial() {
        return material;
    }
    public boolean isCasa_mascotas(){
        return casa_mascotas;
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
        return casa_mascotas;
    }
}
