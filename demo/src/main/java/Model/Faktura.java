package Model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
public class Faktura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date data;

    @ManyToOne
    @JoinColumn(name = "pracownik_id")
    private Pracownik pracownik;
    @ManyToOne
    @JoinColumn(name = "klient_id")
    private Klient klient;
    @ManyToOne
    @JoinColumn(name = "zakładStolarski_id")
    private ZakladStolarski zakladStolarski;
    @OneToMany(mappedBy = "faktura", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Zlecenie> zlecenia;
    @OneToMany(mappedBy = "faktura", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Produkt> produkty;
    private double koszt;
}
