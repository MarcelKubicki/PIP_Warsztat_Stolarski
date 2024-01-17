package Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PojazdTest {

    @Test
    void dodajMeble_PojazdMaWystarczajacaLadownosc_DodanoMeble() {
        Pojazd pojazd = new Pojazd("TKI2137X", "Renault", "Trafic", 10.0, 100000.0);
        Mebel mebel = new Mebel(1,"bialy", 10, 10, 20, 2, "szafka nocna", 1, 0 );

        pojazd.dodajMeble(mebel);

        assertTrue(pojazd.getPrzewozoneMeble().contains(mebel));
    }

    @Test
    void dodajMeble_PojazdNieMaWystarczajacejLadownosci_NieDodanoMebla() {
        Pojazd pojazd = new Pojazd("TKI2137X", "Renault", "Trafic", 10.0, 1000.0);
        Mebel mebel = new Mebel(2,"bialy", 15, 15, 25, 2, "szafa", 2, 0 );

        pojazd.dodajMeble(mebel);

        assertFalse(pojazd.getPrzewozoneMeble().contains(mebel));
    }

    @Test
    void mozePrzewiezc_PojazdMaWystarczajacaLadownosc_True() {
        Pojazd pojazd = new Pojazd("TKI2137X", "Renault", "Trafic", 10.0, 10000.0);
        Mebel mebel = new Mebel(2,"bialy", 10, 10, 10, 1, "szafa", 2, 0 );

        assertTrue(pojazd.mozePrzewiezc(mebel));
    }

    @Test
    void mozePrzewiezc_PojazdNieMaWystarczacejLadownosci_False() {
        Pojazd pojazd = new Pojazd("TKI2137X", "Renault", "Trafic", 10.0, 1000.0);
        Mebel mebel = new Mebel(2,"bialy", 10, 10, 10, 1, "szafa", 2, 0 );

        assertFalse(pojazd.mozePrzewiezc(mebel));
    }

    @Test
    void obliczKosztTransportu_PrawidloweParametry_ObliczonyKoszt() {
        Pojazd pojazd = new Pojazd("TK5J012", "Volkswagen", "Transporter", 11.0, 700.0);
        double odleglosc = 250.0;
        double cenaPaliwa = 4.5;

        double koszt = pojazd.obliczKosztTransportu(odleglosc, cenaPaliwa);

        assertEquals(2 * (odleglosc / 100) * 11.0 * cenaPaliwa, koszt);
    }
}
