package Model;

import java.sql.Date;
import java.util.List;

public class Faktura {
    private long id;
    private Date data;

    private Pracownik pracownik;

    private Klient klient;

    private ZakladStolarski zakladStolarski;

    private List<Zlecenie> zlecenia;

    private List<Mebel> produkty;
    private double koszt;
}
