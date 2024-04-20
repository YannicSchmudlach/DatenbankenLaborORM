package de.hska.iwii.db1.jpa;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

@Entity 
@Table (name = "kunden")
public class Kunde {
	public Kunde(String vorname, String nachname, String email) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.email = email;
	}

	@Id
	@Column(name = "kundenID",nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int kundenID;
	@NotNull
	@Column(name = "vorname")
	private String vorname;
	@NotNull
	@Column(name = "nachname")
	private String nachname;
	@NotNull
	@Email
	@Column(name = "email")
	private String email;

	@OneToMany(mappedBy = "kunde")
	private Set<Buchung> buchungen = new HashSet<>();

	public Kunde() {

	}

	public int getKundenID() {
		return kundenID;
	}

	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public void setKundenID(int kundenID) {
		this.kundenID = kundenID;
	}

	public Set<Buchung> getBuchungen() {
		return buchungen;
	}

	public void setBuchungen(Set<Buchung> buchungen) {
		this.buchungen = buchungen;
	}
}
