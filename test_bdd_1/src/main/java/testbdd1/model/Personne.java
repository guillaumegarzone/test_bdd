package testbdd1.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Personne {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private String id;

	private String nom;

	private String prenom;

	private String adresse;

	@ManyToMany(cascade = CascadeType.PERSIST)
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

	@Override
	public String toString() {
		String result = "";
		result += this.id + "  :  " + this.nom + " ; " + this.prenom + " ; "
				+ this.prenom + " ; " + this.projets.toString();
		return result;
	}

}
