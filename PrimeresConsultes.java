package org.iesam.primeresconsultes;

import java.util.List;

import org.hibernate.SessionFactory;

public class PrimeresConsultes {

	public static void main(String[] args) {

		SessionFactory ss = HibernateUtil.getSessionFactory();

		StudentDao studentDao = new StudentDaoImp(ss);

//		System.out.println("Trobar estudiant que el nom comença per...");
//		System.out.println(studentDao.findBeginNameWith("D"));
//
//		System.out.println("Guardar un estudiant");
//		Student student = new Student();
//		student.setNom("Juan Antoni");
//		student.setCognom1("Domenech");
//		student.setCognom2("Calamaro");
//		student.setEdat(22);
//		student.setNota(7);
//		studentDao.save(student);
//
//		System.out.println("Editar un estudiant");
//		Student studentEdit = new Student();
//		studentEdit.setId(15);
//		studentEdit.setNom("Carles");
//		studentEdit.setCognom1("Cirerer");
//		studentEdit.setCognom2("Montull");
//		studentEdit.setEdat(22);
//		studentEdit.setNota(9);
//		studentDao.update(studentEdit);
//
		System.out.println("Estudiants amb notes excel.lent");
		System.out.println(studentDao.findExcellentQualification());

//		System.out.println("Borrar un escudiant");
//		Student studentDelete = new Student();
//		studentDelete.setId(12);
//		studentDao.delete(studentDelete);

		System.out.println("Consulta edat mitja");
		double edatMitja = studentDao.mitjaEdat();
		System.out.println("Edat mitja es: " + edatMitja);

		System.out.println("Consulta de aprovats");
		List<Student> studentsAprovats = studentDao.findAprovats();

		for (int i = 0; i < studentsAprovats.size(); i++) {
			System.out.println(studentsAprovats.get(i).getCognom1() + " " + studentsAprovats.get(i).getCognom2() + " "
					+ studentsAprovats.get(i).getNom() + " " + studentsAprovats.get(i).getNota());
		}

		System.out.println("Consulta de ordenar per cognom1,cognom2,nom");
		List<Student> studentsOrdentats = studentDao.orderByCognom1Cognom2Nom();
		for (int i = 0; i < studentsOrdentats.size(); i++) {
			System.out.println(studentsOrdentats.get(i).getCognom1() + " " + studentsOrdentats.get(i).getCognom2() + " "
					+ studentsOrdentats.get(i).getNom());
		}

		System.out.println("Tots els estudiants");
		List<Student> studentsAll = studentDao.findAll();
		System.out.println(studentsAll);

		System.out.println("Trobar estudiant per id");
		Student studentById = studentDao.findById(15);
		System.out.println(studentById);

		System.out.println("Trobar estudiant per nom");
		Student studentByname = studentDao.findByName("Ramon");
		System.out.println(studentByname);

		System.out.println("Numero d estudiant: " + studentDao.countStudents());
		
		System.out.println("Predicats: "+studentDao.predicates());
		ss.close();
	}

}
