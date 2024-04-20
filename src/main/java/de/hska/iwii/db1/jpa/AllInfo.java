package de.hska.iwii.db1.jpa;

import java.sql.Date;
import java.time.ZonedDateTime;

public class AllInfo {
    //SELECT kunden.nachname,buchungen.anzahl_gebuchte_Plaetze,buchungen.datum,fluege.nummer,fluege.startFlughafen,fluege.startZeit from kunden
    //JOIN buchungen on buchungen.kunde_kundenID=kunden.kundenID
    //JOIN fluege on flugID = buchungen.flug_flugID;

    private String nachname;
    private int anzahl_gebuchte_Plaetze;
    private Date datum;
    private String nummer;
    private String startFlughafen;
    private ZonedDateTime startZeit;

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public int getAnzahl_gebuchte_Plaetze() {
        return anzahl_gebuchte_Plaetze;
    }

    public void setAnzahl_gebuchte_Plaetze(int anzahl_gebuchte_Plaetze) {
        this.anzahl_gebuchte_Plaetze = anzahl_gebuchte_Plaetze;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getNummer() {
        return nummer;
    }

    public void setNummer(String nummer) {
        this.nummer = nummer;
    }

    public String getStartFlughafen() {
        return startFlughafen;
    }

    public void setStartFlughafen(String startFlughafen) {
        this.startFlughafen = startFlughafen;
    }

    public ZonedDateTime getStartZeit() {
        return startZeit;
    }

    public void setStartZeit(ZonedDateTime startZeit) {
        this.startZeit = startZeit;
    }
}
