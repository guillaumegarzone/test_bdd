package testbdd1.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Personne {

	@Id
	private int id;

	private String nom;

	private String prenom;

	private String adresse;

	@OneToMany
	private List<Projet> projets;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public List<Projet> getProjets() {
		return projets;
	}

	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}

	public Integer getId() {
		return id;
	}

	public Personne() {
	}

	public Personne(int i) {
		this.id = i;
	}

	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom
				+ ", adresse=" + adresse + ", projets=" + projets + "]";
	}

}
