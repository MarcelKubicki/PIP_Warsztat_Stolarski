package Model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
public class Zlecenie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //data rozpoczecia
    private Date dataZlecenia;
    @ManyToMany
    @JoinTable(
            name = "zlecenie_material",
            joinColumns = @JoinColumn(name = "zlecenie_id"),
            inverseJoinColumns = @JoinColumn(name = "material_id"))
    private List<Material> materialy;
    private double koszt;
    private boolean zrealizowano;
    @ManyToOne
    @JoinColumn(name = "faktura_id")
    private Faktura faktura;
}
