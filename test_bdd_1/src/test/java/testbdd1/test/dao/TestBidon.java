package testbdd1.test.dao;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import org.junit.BeforeClass;
import org.junit.Test;

import testbdd1.dao.DaoPersonne;
import testbdd1.dao.DB;
import testbdd1.dao.PersonneDAO;
import testbdd1.model.Personne;

public class TestBidon {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() {
		EntityManager em = DB.getEm();
		// PersonneDAO dao = new PersonneDAO(null);
		DaoPersonne dao = new DaoPersonne();

		Personne p = new Personne(1);
		p.setNom("nom");
		p.setPrenom("prenom");
		p.setAdresse("adresse");

		// dao.create(p);
		dao.lazyCreate(p);

		// Personne p2 = dao.find(1);
		// assertNotNull(p2);
		// System.out.println(p2);

		Personne p3 = new Personne(3);
		p3.setNom("YOLOnom");
		p3.setPrenom("YOLOprenom");
		p3.setAdresse("YOLOadresse");
		dao.lazyCreate(p3);

		Personne p5 = new Personne(5);
		p5.setNom("YOnom");
		p5.setPrenom("YOprenom");
		p5.setAdresse("YOadresse");
		dao.lazyCreate(p5);

		System.out.println("FIND 3");
		Personne p4 = dao.find(3);
		p4.setNom("NOM_CHANGE_YOLO");
		dao.update(p4);
		assertNotNull(p4);
		p4 = dao.find(3);
		assertNotNull(p4);
		System.out.println(p4);

		// dao.getEm().getTransaction().commit();
		System.out.println("DELETE 3");
		dao.delete(p4);
		System.out.println("FIND 3");
		Personne p6 = dao.find(3);
		assertNull(p6);
		System.out.println(p6);
		// EMF.getEm().getTransaction().begin();
		// assertNotNull(EMF.getEm().find(Personne.class, 3));
	}
}
