package testbdd1.dao;

import testbdd1.model.Personne;

public class DaoPersonne extends DAO2<Personne, Integer> {

	public DaoPersonne() {
		super(Personne.class);
	}

	@Override
	protected void updateObj(Personne objRef, Personne objToUpdate) {
		objToUpdate.setNom(objRef.getNom());
		objToUpdate.setPrenom(objRef.getPrenom());
		objToUpdate.setAdresse(objRef.getAdresse());
		objToUpdate.setProjets(objRef.getProjets());
	}

	@Override
	protected Personne findObject(Personne obj) {
		return em.find(Personne.class, obj.getId());
	}

}
