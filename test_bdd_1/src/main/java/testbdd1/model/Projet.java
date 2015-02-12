package testbdd1.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "projets")
public class Projet {
	@DatabaseField(allowGeneratedIdInsert = true, generatedId = true)
	private int id;
	@DatabaseField
	private String nom;

	@DatabaseField(foreign = true)
	private Personne personne;

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	// @OneToMany
	// private List<Tache> taches;
	// @ManyToMany(cascade = CascadeType.PERSIST)
	// private List<Personne> responsables;
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	// @DatabaseField(foreign = true, foreignAutoCreate = true,
	// foreignAutoRefresh = true)
	// private Personne responsable;

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

	// public Personne getResponsable() {
	// return responsable;
	// }
	//
	// public void setResponsable(Personne responsable) {
	// this.responsable = responsable;
	// }

	public int getId() {
		return id;
	}

	public Projet() {
	}

	@Override
	public String toString() {
		return "Projet [id=" + id + ", nom=" + nom + ", personne="
				+ personne.getId() + "]";
	}

}
