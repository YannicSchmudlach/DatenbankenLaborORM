package de.hska.iwii.db1.jpa;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity 
@Table (name = "fluege")
public class Flug {
	public Flug(String nummer, LocalDate startZeit, String startFlughafen) {
		this.nummer = nummer;
		this.startZeit = startZeit;
		this.startFlughafen = startFlughafen;
	}

	@Id
	@Column(name = "flugID",nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int flugID;
	@NotNull
	@Column(name = "nummer")
	private String nummer;
	@NotNull
	@Column(name = "startZeit")
	private LocalDate startZeit;
	@NotNull
	@Column(name = "startFlughafen")
	private String startFlughafen;

	@OneToMany(mappedBy = "flug")
	private Set<Buchung> buchungen = new HashSet<>();

	public Flug() {

	}


	public int getFlugID() {
		return flugID;
	}

	public String getNummer() {
		return nummer;
	}
	public void setNummer(String nummer) {
		this.nummer = nummer;
	}

	public LocalDate getStartZeit() {
		return startZeit;
	}

	public void setStartZeit(LocalDate startZeit) {
		this.startZeit = startZeit;
	}

	public String getStartFlughafen() {
		return startFlughafen;
	}
	public void setStartFlughafen(String startFlughafen) {
		this.startFlughafen = startFlughafen;
	}

	public void setFlugID(int flugID) {
		this.flugID = flugID;
	}

	public Set<Buchung> getBuchungen() {
		return buchungen;
	}

	public void setBuchungen(Set<Buchung> buchungen) {
		this.buchungen = buchungen;
	}
}
