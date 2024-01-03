package Service;

import Model.Pracownik;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PracownikServiceIntegrationTest {

    @Test
    void list() {
        //arrange
        PracownikService pracownikService = new PracownikService();
        //act
        List<Pracownik> pracownikList = pracownikService.list();
        //assert
        Assertions.assertNotNull(pracownikList, "pracownikList is NULL");
    }

    @Test
    void listWithPracownicy() {
        //arrange
        PracownikService pracownikService = new PracownikService();
        //act
        Pracownik pierwszyPracownik = pracownikService.create(new Pracownik());
        Pracownik drugiPracownik = pracownikService.create(new Pracownik());
        List<Pracownik> pracownikList = pracownikService.list();
        //assert
        Assertions.assertNotNull(pracownikList, "pracownikList is NULL");
    }

    @Test
    void read() {
        //arrange
        PracownikService pracownikService = new PracownikService();
        //act
        Pracownik pierwszyPracownik = pracownikService.create(new Pracownik());
        Pracownik drugiPracownik = pracownikService.create(new Pracownik());
        List<Pracownik> pracownikList = pracownikService.list();
        Pracownik readPracownik = pracownikService.read(pracownikList.get(0).getId());
        //assert
        Assertions.assertNotNull(readPracownik, "readPracownik is NULL");
    }
}