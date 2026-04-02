package prog2.vista;

import java.util.Scanner;

/**
 *
 * @author lauraigual
 */
public class IniciadorCamping {
    
    /**
     * @param args the command line arguments
     */
        public static void main(String[] args) throws ExcepcioCamping {
        // Definim el nom del càmping
        String nomCamping = "Green";

        // Creem un objecte de la vista i li passem el nom del càmping
        VistaCamping vistaCamping = new VistaCamping(nomCamping);
     
        Scanner sc =  new Scanner(System.in);

        // Inicialitzem l'execució de la vista
        vistaCamping.gestioCamping(sc);
    }
}
