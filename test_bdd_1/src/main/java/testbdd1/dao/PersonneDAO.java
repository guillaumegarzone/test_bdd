package testbdd1.dao;

import javax.persistence.EntityManagerFactory;

import testbdd1.model.Personne;

public class PersonneDAO extends DAOJpa<Personne> {

	public PersonneDAO(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Personne findObj(Object id) {
		return getEm().find(Personne.class, id);
	}

	@Override
	protected Object getIdObj(Personne obj) {
		return obj.getId();
	}

	@Override
	protected void updateObj(Personne objRef, Personne objToUpdate) {
		objToUpdate.setNom(objRef.getNom());
		objToUpdate.setPrenom(objRef.getPrenom());
		objToUpdate.setAdresse(objRef.getAdresse());
		objToUpdate.setProjets(objRef.getProjets());
		// TODO missing fields
	}

}
