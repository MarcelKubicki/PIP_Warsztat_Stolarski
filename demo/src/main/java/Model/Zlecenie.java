package Model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

public class Zlecenie {

    private long id;
    private Date dataZlecenia;
    private List<Material> materialy;
    private double koszt;
    private boolean zrealizowano;
    private Faktura faktura;
}
