package Model;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MebelTest {

    @Test
    void obliczObjetosc_PrawidloweParametry_ObliczonaObjetosc() {
        Mebel mebel = new Mebel(1, "Czarny", 100.0, 200.0, 50.0, 1, "Stojąca kuchenna", 2, 0);

        double objetosc = mebel.obliczObjetosc();

        assertEquals(100.0 * 200.0 * 50.0, objetosc);
    }

    @Test
    void obliczMaterial_StojacaKuchenna_ZmodyfikowaneWysokosc() {
        Mebel mebel = new Mebel(2, "Biały", 80.0, 150.0, 40.0, 1, "stojaca kuchenna", 2, 0);

        mebel.obliczMaterial();

        assertEquals(150.0 - 8.0, mebel.getWysokosc());
    }


    @Test
    void obliczMaterial_StojacaKuchenna_ZawieraElementyIAkcesoria() {
        Mebel mebel = new Mebel(3, "Drewniany", 120.0, 200.0, 60.0, 1, "Stojąca kuchenna", 3, 0);

        mebel.obliczMaterial();

        List<Element> elementy = mebel.getElementy();
        List<Akcesorium> akcesoria = mebel.getAkcesoria();

        assertNotNull(elementy);
        assertNotNull(akcesoria);
        assertFalse(elementy.isEmpty());
        assertFalse(akcesoria.isEmpty());
    }

    @Test
    void obliczMaterial_InnyTypMebel_ZawieraElementyIAkcesoria() {
        Mebel mebel = new Mebel(4, "Brązowy", 90.0, 180.0, 30.0, 1, "Szafka nocna", 0, 2);

        mebel.obliczMaterial();

        List<Element> elementy = mebel.getElementy();
        List<Akcesorium> akcesoria = mebel.getAkcesoria();

        assertNotNull(elementy);
        assertNotNull(akcesoria);
        assertFalse(elementy.isEmpty());
        assertFalse(akcesoria.isEmpty());
    }

}
