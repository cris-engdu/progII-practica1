package prog2.vista;

import prog2.model.*;

import java.util.Scanner;

public class VistaCamping {
    private String nomCamping;
    private Camping camping;

    public VistaCamping(String  nomCamping) throws ExcepcioCamping {
        this.camping = new Camping(nomCamping);
        camping.inicialitzaDadesCamping();
    }

    // Opcions del menu
    static private enum OpcionsMenuPrincipal {INFO_ALLOT,INFO_ALLOT_OPERATIUS,INFO_ALLOT_NO_OPERATIUS,INFO_ACCESSOS_OBERTS,INFO_ACCESSOS_TANCATS,INFO_TASQUES,AFEGIR_TASCA,COMPLETAR_TASCA,
        NUM_ACCESSOS_NO_ACCESSIBILITAT,METRES_ACCESSOS_TERRA,GUARDAR,RECUPERAR,SORTIR};
    static private enum OpcionsSubmenu1 {MENU_S1_OPCIO1,MENU_S1_OPCIO2,MENU_S1_SORTIR};

    // Descripcions de les opcions
    static private String[] descMenuPrincipal = {"Llistar la informació de tots els allotjaments",
                                                "Llistar la informació dels allotjaments operatius",
                                                "Llistar la informació dels allotjaments no operatius",
                                                "Llistar la informació dels accessos oberts",
                                                "Llistar la informació dels accessos tancats",
                                                "Llistar la informació de les tasques de manteniments actives",
                                                "Afegir una tasca de manteniment",
                                                "Completar una tasca de manteniment",
                                                "Calcular i mostrar el número total de metres dels accessos de terra",
                                                "Guardar càmping",
                                                "Recuperar càmping",
                                                "Sortir de l'aplicació"};
    public void gestioCamping(Scanner sc) {

        // Creem l'objecte per al menú. Li passem com a primer parà metre el nom del menú
        Menu<OpcionsMenuPrincipal> menu = new Menu<OpcionsMenuPrincipal>("Menu Principal", OpcionsMenuPrincipal.values());

        // Assignem la descripció de les opcions
        menu.setDescripcions(descMenuPrincipal);

        // Obtenim una opció des del menú i fem les accions pertinents
        OpcionsMenuPrincipal opcio = null;
        do {
            // Mostrem les opcions del menú
            menu.mostrarMenu();

            // Demanem una opcio
            opcio=menu.getOpcio(sc);

            // Fem les accions necessÃ ries
            switch(opcio) {
                case INFO_ALLOT:
                    // Mostrem la llista de tots els allotjaments
                    System.out.println("Els allotjaments del camping son els següents:");

                    try {
                        String outputAllotjaments = camping.getLlistaAllotjaments().llistarAllotjamentsTots();
                        System.out.println(outputAllotjaments);
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case INFO_ALLOT_OPERATIUS:
                    // Mostrem un missatge indicant que s'ha triat aquesta opciÃ³
                    System.out.println("Els allotjaments operatius del camping son els següents: ");

                    try {
                        String outputAllotjaments = camping.getLlistaAllotjaments().llistarAllotjaments("Operatiu");
                        System.out.println(outputAllotjaments);
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case INFO_ALLOT_NO_OPERATIUS:
                    System.out.println("Els allotjaments operatius del camping son els següents: ");

                    try {
                        String outputAllotjaments = camping.getLlistaAllotjaments().llistarAllotjaments("No operatiu");
                        System.out.println(outputAllotjaments);
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case INFO_ACCESSOS_OBERTS:
                    break;
                case INFO_ACCESSOS_TANCATS:
                    break;
                case INFO_TASQUES:
                    break;
                case AFEGIR_TASCA:
                    break;
                case COMPLETAR_TASCA:
                    break;
                case NUM_ACCESSOS_NO_ACCESSIBILITAT:
                    break;
                case METRES_ACCESSOS_TERRA:
                    break;
                case GUARDAR:
                    break;
                case RECUPERAR:
                    break;
                case SORTIR:
                    System.out.println("Fins aviat!");
                    break;
            }

        } while(opcio!=OpcionsMenuPrincipal.SORTIR);
    }


}

