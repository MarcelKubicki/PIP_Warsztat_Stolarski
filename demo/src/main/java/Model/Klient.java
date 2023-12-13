package Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Klient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String imie;
    private String nazwisko;
    private String adres;
    private String nrTelefonu;
    @OneToMany(mappedBy = "klient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Faktura> faktury;
}
