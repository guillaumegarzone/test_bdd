package testbdd1.model;

import java.io.Serializable;
import java.util.List;

public class Personne implements Serializable {

	private static final long serialVersionUID = 3283521297227675920L;

	private String id;

	private String nom;

	private String prenom;

	private String adresse;

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

	public String getId() {
		return id;
	}

	public Personne() {
	}

	public Personne(String string) {
		this.id = string;
	}

	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom
				+ ", adresse=" + adresse + ", projets=" + projets + "]";
	}

}
