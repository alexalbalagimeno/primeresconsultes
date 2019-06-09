package org.iesam.primeresconsultes;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class StudentDaoImp implements StudentDao {

	SessionFactory sf;

	public StudentDaoImp(SessionFactory ss) {
		this.sf = ss;
	}

	@Override
	public List<Student> findExcellentQualification() {
		Session ss = sf.openSession();
		CriteriaBuilder builder = ss.getCriteriaBuilder();
		CriteriaQuery<Student> criteria = builder.createQuery(Student.class);

		Root<Student> root = criteria.from(Student.class);
		criteria.select(root).where(builder.between(root.get("nota"), 9, 10));
		List<Student> students = ss.createQuery(criteria).getResultList();
		return students;
	}

	@Override
	public List<Student> findBeginNameWith(String letter) {
		Session ss = sf.openSession();
		CriteriaBuilder builder = ss.getCriteriaBuilder();
		CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
		Root<Student> root = criteria.from(Student.class);
		criteria.select(root).where(builder.like(root.get("nom"), letter + "%"));
		List<Student> students = ss.createQuery(criteria).getResultList();
		return students;
	}

	@Override
	public Student findById(int id) {
		Session ss = sf.openSession();
		CriteriaBuilder builder = ss.getCriteriaBuilder();
		CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
		Root<Student> root = criteria.from(Student.class);
		criteria.select(root).where(builder.equal(root.get("id"), id));
		Student student = ss.createQuery(criteria).getSingleResult();
		return student;
	}

	@Override
	public Student findByName(String name) {
		Session ss = sf.openSession();
		CriteriaBuilder builder = ss.getCriteriaBuilder();
		CriteriaQuery<Student> criteria = builder.createQuery(Student.class);

		Root<Student> root = criteria.from(Student.class);
		criteria.select(root).where(builder.equal(root.get("nom"), name));
		Student student = ss.createQuery(criteria).getSingleResult();
		return student;
	}

	@Override
	public List<Student> findAll() {
		Session ss = sf.openSession();
		CriteriaBuilder builder = ss.getCriteriaBuilder();
		CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
		Root<Student> root = criteria.from(Student.class);
		criteria.select(root);
		List<Student> students = ss.createQuery(criteria).getResultList();
		return students;

	}

	@Override
	public List<Student> findAprovats() {
		Session ss = sf.openSession();
		CriteriaBuilder builder = ss.getCriteriaBuilder();
		CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
		Root<Student> root = criteria.from(Student.class);
		criteria.select(root).where(builder.greaterThanOrEqualTo(root.get("nota"), 5));
		List<Student> students = ss.createQuery(criteria).getResultList();
		return students;
	}

	@Override
	public void save(Student student) {
		Session ss = sf.openSession();
		ss.beginTransaction();
		ss.save(student);
		ss.getTransaction().commit();
	}

	@Override
	public void update(Student student) {
		Session ss = sf.openSession();
		ss.beginTransaction();
		ss.update(student);
		ss.getTransaction().commit();
	}

	@Override
	public long countStudents() {
		Session ss = sf.openSession();
		CriteriaBuilder builder = ss.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Student> root = criteria.from(Student.class);
		criteria.multiselect(builder.count(root));
		long numStudents = ss.createQuery(criteria).getSingleResult();
		return numStudents;
	}

	@Override
	public void delete(Student student) {
		Session ss = sf.openSession();
		ss.beginTransaction();
		ss.delete(student);
		ss.getTransaction().commit();
	}

	@Override
	public double mitjaEdat() {
		Session ss = sf.openSession();
		CriteriaBuilder builder = ss.getCriteriaBuilder();
		CriteriaQuery<Double> criteria = builder.createQuery(Double.class);
		Root<Student> root = criteria.from(Student.class);
		criteria.multiselect(builder.avg(root.get("edat")));
		Double mitja = ss.createQuery(criteria).getSingleResult();
		return mitja;
	}

	@Override
	public List<Student> orderByCognom1Cognom2Nom() {
		Session ss = sf.openSession();
		CriteriaBuilder builder = ss.getCriteriaBuilder();
		CriteriaQuery<Student> criteria = builder.createQuery(Student.class);

		Root<Student> root = criteria.from(Student.class);
		criteria.select(root).orderBy(builder.asc(root.get("cognom1")), builder.asc(root.get("cognom2")),
				builder.asc(root.get("nom")));
		List<Student> students = ss.createQuery(criteria).getResultList();
		return students;
	}

	@Override
	public List<Student> predicates() {
		Session ss = sf.openSession();
		CriteriaBuilder builder = ss.getCriteriaBuilder();
		CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
		Root<Student> root = criteria.from(Student.class);
		Predicate[] predicates = new Predicate[2];
		predicates[0] = builder.greaterThanOrEqualTo(root.get("edat"), 20);
		predicates[1] = builder.like(root.get("nom"), "C%");
		criteria.select(root).where(predicates);
		List<Student> students = ss.createQuery(criteria).getResultList();
		return students;
	}
}
