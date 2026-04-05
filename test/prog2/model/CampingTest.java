package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.vista.ExcepcioCamping;
import static org.junit.jupiter.api.Assertions.*;

class CampingTest {

    private Camping camping;

    @BeforeEach
    void setUp() throws ExcepcioCamping {
        camping = new Camping("Camping del Mar");
        camping.inicialitzaDadesCamping();
    }

    //nom
    @Test
    void testGetNomCamping() {
        assertEquals("Camping del Mar", camping.getNomCamping());
    }

    //llistar allotjaments
    @Test
    void testLlistarAllotjamentsOperatius() throws ExcepcioCamping {
        String resultat = camping.llistarAllotjaments("Operatiu");
        assertNotNull(resultat);
        assertFalse(resultat.isEmpty());
    }

    @Test
    void testLlistarAllotjamentsEstatInvalidLlancaExcepcio() {
        assertThrows(ExcepcioCamping.class, () -> camping.llistarAllotjaments("Tancat"));
    }

    //llistaraccessos
    @Test
    void testLlistarAccessosOberts() throws ExcepcioCamping {
        String resultat = camping.llistarAccessos("Obert");
        assertNotNull(resultat);
        assertFalse(resultat.isEmpty());
    }

    @Test
    void testLlistarAccessosTancats() {

        assertThrows(ExcepcioCamping.class, () -> camping.llistarAccessos("Tancat"));
    }

    @Test
    void testLlistarAccessosEstatInvalidLlancaExcepcio() {
        assertThrows(ExcepcioCamping.class, () -> camping.llistarAccessos("Invalit"));
    }

    //tasques
    @Test
    void testAfegirTascaManteniment() throws ExcepcioCamping {
        camping.afegirTascaManteniment(1, "Neteja", "ALL1", "2024-01-01", 3);
        String resultat = camping.llistarTasquesManteniment();
        assertTrue(resultat.contains("Neteja"));
    }

    @Test
    void testLlistarTasquesMantenimentBuidaLlancaExcepcio() {
        assertThrows(ExcepcioCamping.class, () -> camping.llistarTasquesManteniment());
    }

    @Test
    void testCompletarTascaManteniment() throws ExcepcioCamping {
        camping.afegirTascaManteniment(1, "Neteja", "ALL1", "2024-01-01", 3);
        camping.completarTascaManteniment(1);
        assertThrows(ExcepcioCamping.class, () -> camping.llistarTasquesManteniment());
    }

    @Test
    void testCompletarTascaInexistentLlancaExcepcio() {
        assertThrows(ExcepcioCamping.class, () -> camping.completarTascaManteniment(99));
    }

    //accessos no accessibles
    @Test
    void testCalculaAccessosNoAccessibles() throws ExcepcioCamping {
        int noAccessibles = camping.calculaAccessosNoAccessibles();
        assertTrue(noAccessibles >= 0);
    }

    @Test
    void testCalculaMetresTerra() throws ExcepcioCamping {
        float metres = camping.calculaMetresTerra();
        assertTrue(metres > 0);
    }

    //guardar i carregar
    @Test
    void testSaveILoad() throws ExcepcioCamping {
        String path = "test_camping.dat";
        camping.save(path);
        Camping carregat = Camping.load(path);
        assertEquals(camping.getNomCamping(), carregat.getNomCamping());
    }

    @Test
    void testLoadFitxerInexistentLlancaExcepcio() {
        assertThrows(ExcepcioCamping.class, () -> Camping.load("fitxer_que_no_existeix.dat"));
    }
}
