package Service;

import Model.Pracownik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PracownikServiceTest {

    @Test
    void create() {
        //arrange
        PracownikService pracownikService = new PracownikService();
        //act
        Pracownik createdPracownik = pracownikService.create(new Pracownik());
        //assert - upewniamy sie czy wartosc zwracana jest taka jaka oczekiwalismy
        Assertions.assertNotNull(createdPracownik, "createdPracownik is NULL");
    }

    @Test
    void read() {
        //arrange
        PracownikService pracownikService = new PracownikService();
        //act
        Pracownik readPracownik = pracownikService.read(1L);
        //assert
        Assertions.assertNotNull(readPracownik, "readPracownik is NULL");
    }
}