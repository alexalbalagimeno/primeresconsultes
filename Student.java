package org.iesam.primeresconsultes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private int id;

	@Column
	private int edat;

	@Column
	private String nom;
	
	@Column
	private String cognom1;
	
	@Column
	private String cognom2;

	public String getCognom1() {
		return cognom1;
	}

	public void setCognom1(String cognom1) {
		this.cognom1 = cognom1;
	}

	public String getCognom2() {
		return cognom2;
	}

	public void setCognom2(String cognom2) {
		this.cognom2 = cognom2;
	}

	@Column
	private int nota;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEdat() {
		return edat;
	}

	public void setEdat(int edat) {
		this.edat = edat;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String toString() {
		return "id: " + id + "\nnom: " + nom + "\ncognom primer: " + cognom1 +  "\ncognom segon: " + cognom2 +"\nnota: " + nota + "\nedat: " + edat;
	}

}
