package Model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
public class Produkt extends Element{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    Date dataProdukcji;
    @ManyToMany(mappedBy = "produkty")
    private List<Magazyn> magazyny;
    @ManyToOne
    @JoinColumn(name = "faktura_id")
    private Faktura faktura;
}
