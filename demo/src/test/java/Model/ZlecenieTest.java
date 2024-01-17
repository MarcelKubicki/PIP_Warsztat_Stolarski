package Model;

import Model.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ZlecenieTest {

    @Test
    void obliczMaterial_PrawidloweMeble_ListyAkcesoriowElementowNiePuste() {
        Zlecenie zlecenie = new Zlecenie(1, Date.valueOf("2022-01-10"), Date.valueOf("2022-01-20"));
        List<Mebel> meble = new ArrayList<>();
        meble.add(new Mebel(1, "Czarny", 100.0, 200.0, 50.0, 1, "Stojąca kuchenna", 2, 0));
        zlecenie.setMeble(meble);

        zlecenie.obliczMaterial();

        List<Akcesorium> akcesoria = zlecenie.getListaAkcesoriow();
        List<Element> elementy = zlecenie.getListaMaterialow();

        assertNotNull(akcesoria);
        assertNotNull(elementy);
        assertFalse(akcesoria.isEmpty());
        assertFalse(elementy.isEmpty());
    }

    @Test
    void generujPDF_PrawidlowaSciezka_PlikZostalUtworzony() {
        Zlecenie zlecenie = new Zlecenie(2, Date.valueOf("2022-01-15"), Date.valueOf("2022-01-25"));
        List<Mebel> meble = new ArrayList<>();
        meble.add(new Mebel(2, "Bialy", 80.0, 150.0, 40.0, 1, "stojaca kuchenna", 2, 0));
        zlecenie.setMeble(meble);

        zlecenie.obliczMaterial();
        zlecenie.generujPDF("testowy.pdf");

        File file = new File("testowy.pdf");
        assertTrue(file.exists());

        file.delete();
    }

    @Test
    void dniDoDeadline_PrawidloweDeadline_PrawidlowyLiczbaDni() {
        Zlecenie zlecenie = new Zlecenie(3, Date.valueOf("2024-01-05"), Date.valueOf("2024-02-17"));
        Date deadLine = zlecenie.getDeadlineZlecenia();

        int dniDoDeadline = zlecenie.dniDoDeadline();
        long currentTime = System.currentTimeMillis();
        long deadlineTime = deadLine.getTime();
        long difference = deadlineTime - currentTime;
        int result = (int) (difference / (1000 * 60 * 60 * 24));

        assertEquals(result, dniDoDeadline);
    }
}
