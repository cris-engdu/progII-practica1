package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class LlistaTasquesManteniment implements InLlistaTasquesManteniment, Serializable {
    private ArrayList<TascaManteniment> llistaTasquesManteniment;

    public  LlistaTasquesManteniment() {
        this.llistaTasquesManteniment=new ArrayList<>();
    }

    @Override
    public void afegirTascaManteniment(int num, String tipus, Allotjament allotjament, String data, int dies) throws ExcepcioCamping {
        if (!allotjament.isOperatiu()) {
            throw new ExcepcioCamping("Aquest allotjament ja té una tasca de manteniment");
        } else {
            TascaManteniment tasca = new TascaManteniment(num, TascaManteniment.TipusTascaManteniment.valueOf(tipus), allotjament, data, dies);
            this.llistaTasquesManteniment.add(tasca);
            allotjament.setOperatiu(false);

            // Cambiar valor de iluminación a allotjament
            String ilum = tasca.getIluminacioAllotjament();
            allotjament.setIluminacio(Allotjament.iluminacion.valueOf(ilum));
        }
    }

    @Override
    public void completarTascaManteniment(TascaManteniment tasca) throws ExcepcioCamping {
        boolean isTascaTrobada = llistaTasquesManteniment.remove(tasca);
        if (!isTascaTrobada) {
            throw new ExcepcioCamping("La tasca de manteniment introduïda no existeix");
        }
        tasca.getAllotjament().obrirAllotjament();
    }

    @Override
    public String llistarTasquesManteniment() throws ExcepcioCamping {
        if (llistaTasquesManteniment.isEmpty()) {
            throw new ExcepcioCamping("No hi ha tasques de manteniment.");
        }

        String strLlista = "";
        Iterator<TascaManteniment> it = llistaTasquesManteniment.iterator();
        while (it.hasNext()) {
            TascaManteniment tasca = it.next();
            strLlista += tasca.toString();
            strLlista += "\n";
        }
        return strLlista;
    }

    @Override
    public TascaManteniment getTascaManteniment(int num) throws ExcepcioCamping {
        Iterator<TascaManteniment> it = llistaTasquesManteniment.iterator();
        while (it.hasNext()) {
            TascaManteniment tasca = it.next();
            if (tasca.getNum() == num) {
                return tasca;
            }
        }
        throw new ExcepcioCamping("No existeix la tasca amb el numero " + num);
    }
}
