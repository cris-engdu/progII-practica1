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
                        String outputAllotjaments = camping.llistarAllotjaments("Operatiu");
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
                    try {
                        System.out.println(camping.llistarAccessos("Obert"));
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case INFO_ACCESSOS_TANCATS:
                    try {
                        System.out.println(camping.llistarAccessos("Tancat"));
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case INFO_TASQUES:
                    try {
                        System.out.println(camping.llistarTasquesManteniment());
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case AFEGIR_TASCA:
                    try {
                        // Preguntar dades de la tasca a afegir a l'usuari
                        System.out.println("Introdueix el número de la tasca");
                        int numTasca = sc.nextInt();

                        System.out.println("Introdueix el id de l'allotjament on vols realitzar la tasca");
                        String idAllotjament = sc.nextLine();

                        System.out.println("Introdueix el tipus de tasca");
                        String tipusTasca =  sc.nextLine();

                        System.out.println("Introdueix la data de la tasca");
                        String dataTasca = sc.nextLine();

                        System.out.println("Introdueix els dias esperats per realitzar la tasca");
                        int diesTasca = sc.nextInt();

                        // Crear i afegir tasca
                        camping.afegirTascaManteniment(numTasca, tipusTasca, idAllotjament, dataTasca, diesTasca);

                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case COMPLETAR_TASCA:
                    try {
                        //Llistar tasques de manteniment
                        System.out.println("Tasques de manteniment actives:");
                        camping.llistarTasquesManteniment();

                        // Preguntar a l'usuari i completar tasca
                        System.out.println("Introdueix el número de la tasca que s'ha completat");
                        int num = sc.nextInt();
                        camping.completarTascaManteniment(num);

                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case NUM_ACCESSOS_NO_ACCESSIBILITAT:
                    try {
                        int cont = camping.calculaAccessosNoAccessibles();
                        System.out.println("El número d'accessos que no proporcionen accessibiltat amb vehicle son: " + cont);
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case METRES_ACCESSOS_TERRA:
                    try {
                        float cont = camping.calculaMetresTerra();
                        System.out.println("El número total de metres dels accessos de terra es: " + cont);
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case GUARDAR:
                    try {
                        System.out.println("Introdueix la ruta del fitxer on vols guardar les dades");
                        String cami = sc.nextLine();
                        camping.save(cami);
                        System.out.println("Les dades del camping s'han guardat correctament");
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case RECUPERAR:
                    try {
                        System.out.println("Introdueix la ruta del fitxer des del qual vols carregar les dades");
                        String cami = sc.nextLine();
                        this.camping = camping.load(cami);
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case SORTIR:
                    System.out.println("Fins aviat!");
                    break;
            }

        } while(opcio!=OpcionsMenuPrincipal.SORTIR);
    }
}

