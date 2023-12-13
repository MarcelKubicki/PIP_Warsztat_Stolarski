package Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Material extends Element {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String producent;
    @ManyToMany(mappedBy = "materialy")
    private List<Zlecenie> zlecenia;
    @ManyToOne
    @JoinColumn(name = "faktura_id")
    private Faktura faktura;
}
