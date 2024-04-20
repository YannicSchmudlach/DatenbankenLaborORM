package de.hska.iwii.db1.jpa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity 
@Table (name = "buchungen")
public class Buchung {

	public Buchung(Kunde kunde, Flug flug, LocalDate datum, int anzahl) {
		this.flug = flug;
		this.anzahl_gebuchte_Plaetze=anzahl;
		this.datum = datum;
		this.kunde=kunde;
	}

	@Id
	@Column(name = "buchungID",nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int buchungID;
	@NotNull
	@ManyToOne
	private Kunde kunde;
	@NotNull
	@ManyToOne
	private Flug flug;
	@NotNull
	@Column(name = "anzahl_gebuchte_Plaetze")
	private int anzahl_gebuchte_Plaetze;
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "datum")
	private LocalDate datum;

	public Buchung() {

	}


	public int getBuchungID() {
		return buchungID;
	}

	public Flug getFlug() {
		return flug;
	}
	public void setFlug(Flug flug) {
		this.flug = flug;
	}
	public int getAnzahl_gebuchte_Plaetze() {
		return anzahl_gebuchte_Plaetze;
	}
	public void setAnzahl_gebuchte_Plaetze(int anzahl_gebuchte_Plaetze) {
		this.anzahl_gebuchte_Plaetze = anzahl_gebuchte_Plaetze;
	}

	public LocalDate getDatum() {
		return datum;
	}

	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}

	public void setBuchungID(int buchungID) {
		this.buchungID = buchungID;
	}

	public Kunde getKunde() {
		return kunde;
	}

	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}
}
