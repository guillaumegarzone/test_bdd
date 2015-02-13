package testbdd1.oldTests;
//package testbdd1.test.dao;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import testbdd1.dao.EMF;
//import testbdd1.dao.PersonneDAO;
//import testbdd1.model.Personne;
//import testbdd1.model.Projet;
//
//public class PersonneDAOBasiqueTest {
//
//	public static PersonneDAO dao;
//
//	public static Personne p;
//
//	@BeforeClass
//	public static void setUpBeforeClass() {
//		System.out.println("Creation de l'emf");
//		dao = new PersonneDAO(EMF.getEmf());
//		System.out.println("emf creee");
//	}
//
//	@Test
//	public void test() {
//		System.out.println("creation objet");
//		p = new Personne();
//		p.setNom("nom");
//		p.setPrenom("prenom");
//		p.setAdresse("adresse");
//		dao.create(p);
//		System.out.println(dao.find(p.getId()).toString());
//		List<Projet> projets = new ArrayList<Projet>();
//		Projet proj = new Projet();
//		proj.setNom("projet");
//		projets.add(proj);
//		p.setProjets(projets);
//
//		dao.update(p);
//		System.out.println(dao.find(p.getId()));
//	}
//
//	// @Test
//	// public void testFind() {
//	// fail("Not yet implemented");
//	// }
//	//
//	// @Test
//	// public void testDelete() {
//	// fail("Not yet implemented");
//	// }
//	//
//	// @Test
//	// public void testUpdate() {
//	// fail("Not yet implemented");
//	// }
//
// }
