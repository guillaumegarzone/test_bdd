package testbdd1.model;

public class Projet {

	private String id;

	private String nom;

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
		return "Projet [id=" + id + ", nom=" + nom + "]";
	}

}
