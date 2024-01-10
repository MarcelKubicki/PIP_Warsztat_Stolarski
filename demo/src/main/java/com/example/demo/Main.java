package com.example.demo;

import Model.Element;
import Model.Mebel;
import Model.Pracownik;
import Repository.PracownikRepo;
import jakarta.persistence.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        EntityTransaction transaction = entityManager.getTransaction();
//
//
//        // Otwórz sesję
//        try {
//            //transaction.begin();
//
//            //Pracownik pracownik  = new Pracownik("John", "Doe", "Developer", 27.7);
//            //entityManager.persist(pracownik);
//
//            /*TypedQuery<Pracownik> eTypedQuery = entityManager.createNamedQuery("Employee.byName", Pracownik.class);
//
//            for(Pracownik pracownicy : eTypedQuery.getResultList()){
//                System.out.println(pracownicy);
//            }*/
//
//            //transaction.commit();
//        } finally {
//            if(transaction.isActive()){
//                transaction.rollback();
//            }
//            entityManager.close();
//            entityManagerFactory.close();
//        }
//
//        PracownikRepo pracownikRepo = new PracownikRepo();
//        List<Pracownik> pracownicy = pracownikRepo.FindByName("John","");
//        for(Pracownik pracownik : pracownicy){
//            System.out.println(pracownik.getImie() + pracownik.getNazwisko());
//        }
        Mebel szafka = new Mebel(1, "bialy", 150, 200, 50, 1, "stojaca, kuchenna", 2, 0);
        System.out.println(szafka.obliczObjetosc());
        szafka.obliczMaterial();
        List<Element> elementy = szafka.getElementy();
        for (Element element: elementy) {
            System.out.println(element);
        }

    }
}
