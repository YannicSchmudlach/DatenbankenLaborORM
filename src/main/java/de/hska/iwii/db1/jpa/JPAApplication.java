package de.hska.iwii.db1.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JPAApplication {
    private EntityManagerFactory entityManagerFactory;

    public JPAApplication() {
        Logger.getLogger("org.hibernate").setLevel(Level.ALL);
        entityManagerFactory = Persistence.createEntityManagerFactory("DB1");
    }

    public void testFlights() {
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static void main(String[] args) {
        JPAApplication app = new JPAApplication();
        EntityManager em = app.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        Kunde kunde1 = new Kunde("Peter", "Meier", "Peter@Meier.com");
        Kunde kunde2 = new Kunde("Alex", "ander", "Alex@ander.com");

        LocalDate date1 = LocalDate.of(2022, 9, 11);
        LocalDate date2 = LocalDate.of(2022, 12, 31);
        LocalDate date3 = LocalDate.of(2022, 3, 1);

        Flug f1 = new Flug("1daeds", date1, "Berlin");
        Flug f2 = new Flug("2sad1223", date2, "Frankfurt");
        Flug f3 = new Flug("3sad322", date3, "Stuttgart");

        Buchung buchung1 = new Buchung(kunde1, f1, java.time.LocalDate.now(), 1);
        Buchung buchung2 = new Buchung(kunde2, f1, java.time.LocalDate.now(), 1);

        Buchung buchung3 = new Buchung(kunde1, f3, java.time.LocalDate.now(), 1);
        Buchung buchung4 = new Buchung(kunde2, f2, java.time.LocalDate.now(), 1);

        buchung1.setKunde(kunde1);
        kunde1.getBuchungen().add(buchung1);
        f1.getBuchungen().add(buchung1);
        buchung1.setFlug(f1);

        buchung2.setKunde(kunde2);
        kunde2.getBuchungen().add(buchung2);
        f1.getBuchungen().add(buchung2);
        buchung2.setFlug(f1);

        buchung3.setKunde(kunde1);
        kunde1.getBuchungen().add(buchung3);
        f3.getBuchungen().add(buchung3);
        buchung2.setFlug(f3);

        buchung4.setKunde(kunde2);
        kunde2.getBuchungen().add(buchung4);
        f1.getBuchungen().add(buchung4);
        buchung4.setFlug(f2);

        em.persist(kunde1);
        em.persist(kunde2);
        em.persist(f1);
        em.persist(f2);
        em.persist(f3);

        em.persist(buchung1);
        em.persist(buchung2);
        em.persist(buchung3);
        em.persist(buchung4);


        em.getTransaction().commit();


        app.testFlights();


        String sql = "SELECT k.nachname, " +
                "b.anzahl_gebuchte_Plaetze," +
                "b.datum, " +
                "f.nummer," +
                "f.startFlughafen," +
                "f.startZeit " +
                "FROM Kunde k \n" +
                "JOIN Buchung b ON b.kunde = k\n" +
                "JOIN Flug f ON f = b.flug";
        Iterator rowIter = em.createQuery(
                sql).getResultList().iterator();
        while (rowIter.hasNext()) {
            Object[] row = (Object[]) rowIter.next();
            String nachname = (String) row[0];
            Integer anzahl_gebuchte_Plaetze = (Integer) row[1];
            LocalDate datum = (LocalDate) row[2];
            String nummer = (String) row[3];
            String startFlughafen = (String) row[4];
            LocalDate startZeit = (LocalDate) row[5];
            System.out.printf("Nachname:\n%s\nanzahl gebuchter Plätze:\n%s\n Datum %s\nFlugnummer:\n %s\nStart Flug:\n %s\nStart Zeit:\n%s", nachname, anzahl_gebuchte_Plaetze, datum, nummer, startFlughafen, startZeit);
        }

        em.close();
        app.entityManagerFactory.close();
    }
}
