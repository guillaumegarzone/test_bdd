package testbdd1.dao;

import testbdd1.model.Personne;

public class PersonneDao2 extends DAOjpa<Personne, Integer> {

	public PersonneDao2() {
		super(Personne.class);
	}

	@Override
	protected void updateObj(Personne toUpdate, Personne ref) {
		toUpdate.setNom(ref.getNom());
		toUpdate.setPrenom(ref.getPrenom());
		toUpdate.setAdresse(ref.getAdresse());
		toUpdate.setProjets(ref.getProjets());
	}

	@Override
	protected Integer getObjId(Personne obj) {
		return obj.getId();
	}

}
