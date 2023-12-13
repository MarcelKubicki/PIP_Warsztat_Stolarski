package Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ZakladStolarski {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String adres;
    @ManyToMany
    @JoinTable(
            name = "zaklad_magazyn",
            joinColumns = @JoinColumn(name = "zaklad_id"),
            inverseJoinColumns = @JoinColumn(name = "magazyn_id"))
    private List<Magazyn> magazyny;
    @OneToMany(mappedBy = "zakladStolarski", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pracownik> pracownicy;
    @OneToMany(mappedBy = "zakladStolarski", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Faktura> faktury;
}
