package testbdd1.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@Entity
@DatabaseTable(tableName = "personnes")
public class Personne {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@DatabaseField(id = true)
	private String id;
	@DatabaseField
	private String nom;
	@DatabaseField
	private String prenom;
	@DatabaseField
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

	public Personne(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		String result = "";
		result += this.id + "  :  " + this.nom + " ; " + this.prenom + " ; "
				+ this.prenom + " ; " + this.projets.toString();
		return result;
	}

}
