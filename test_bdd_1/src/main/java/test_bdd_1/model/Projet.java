package test_bdd_1.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Projet {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private String id;

	private String nom;

	@OneToMany
	// private List<Tache> taches;
	@ManyToMany(cascade = CascadeType.PERSIST)
	// private List<Personne> responsables;
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	// public List<Tache> getTaches() {
	// return taches;
	// }
	//
	// public void setTaches(List<Tache> taches) {
	// this.taches = taches;
	// }
	//
	// public List<Personne> getResponsables() {
	// return responsables;
	// }
	//
	// public void setResponsables(List<Personne> responsables) {
	// this.responsables = responsables;
	// }

	public String getId() {
		return id;
	}

	public Projet() {
	}

	@Override
	public String toString() {
		String result = "";
		result += this.id + " : " + this.nom;
		return result;
	}

}
