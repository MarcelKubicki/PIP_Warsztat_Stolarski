package Repository;

import Model.Pracownik;
import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;


public class PracownikRepo {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    public Pracownik FindOne(long id) {
        TypedQuery<Pracownik> query = entityManager.createNamedQuery("Pracownik.byId", Pracownik.class);
        query.setParameter("employeeId", id);
        List<Pracownik> pracownicy = query.getResultList();

        return pracownicy.get(1);

    }

    public List<Pracownik> FindAll(long id) {
        TypedQuery<Pracownik> query = entityManager.createNamedQuery("Pracownik.all", Pracownik.class);
        query.setParameter("employeeId", id);
        List<Pracownik> pracownicy = query.getResultList();

        return pracownicy;

    }

    public List<Pracownik> FindByName(String Imie, String Nazwisko) {
        List<Pracownik> pracownicy = new LinkedList<>();
        if(!Imie.isEmpty() && !Nazwisko.isEmpty())
        {
            TypedQuery<Pracownik> query = entityManager.createNamedQuery("Pracownik.byImieNazwisko", Pracownik.class);
            query.setParameter("imie", Imie);
            query.setParameter("nazwisko", Nazwisko);
            pracownicy = query.getResultList();
        } else if (!Nazwisko.isEmpty()) {
            TypedQuery<Pracownik> query = entityManager.createNamedQuery("Pracownik.byNazwisko", Pracownik.class);
            query.setParameter("nazwisko", Nazwisko);
            pracownicy = query.getResultList();
        } else if (!Imie.isEmpty()) {
            TypedQuery<Pracownik> query = entityManager.createNamedQuery("Pracownik.byImie", Pracownik.class);
            query.setParameter("imie", Imie);
            pracownicy = query.getResultList();
        }else
        {
            //Błąd
        }

        return pracownicy;

    }
}
