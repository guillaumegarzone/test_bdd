package testbdd1.model;

import java.util.Collection;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "personnes")
public class Personne {

	@DatabaseField(allowGeneratedIdInsert = true, generatedId = true)
	private int id;
	@DatabaseField
	private String nom;
	@DatabaseField
	private String prenom;
	@DatabaseField
	private String adresse;

	// @DatabaseField(foreign = true, foreignAutoRefresh = true,
	// foreignAutoCreate = true)
	// private Projet projet;

	@ForeignCollectionField(eager = true)
	private Collection<Projet> projets;

	// @ForeignCollectionField
	// private ForeignCollection<Projet> projets;

	// public Projet getProjet() {
	// return projet;
	// }
	//
	// public void setProjet(Projet projet) {
	// this.projet = projet;
	// }

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

	public Collection<Projet> getProjets() {
		return projets;
	}

	public void setProjets(Collection<Projet> projets) {
		this.projets = projets;
	}

	public int getId() {
		return id;
	}

	public Personne() {
	}

	public Personne(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom
				+ ", adresse=" + adresse + ", projets=" + projets + "]";
	}

}
