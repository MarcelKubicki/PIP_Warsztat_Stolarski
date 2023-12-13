package Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Magazyn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany
    @JoinTable(
            name = "magazyn_produkt",
            joinColumns = @JoinColumn(name = "magazyn_id"),
            inverseJoinColumns = @JoinColumn(name = "produkt_id"))
    private List<Produkt> produkty;
    @ManyToMany(mappedBy = "magazyny")
    private List<ZakladStolarski> zaklady;
}
