package org.iesam.primeresconsultes;

import java.util.List;

public interface StudentDao {
	public Student findById(int id);
	public Student findByName(String name);
	public List<Student> findAll();
	public List<Student> orderByCognom1Cognom2Nom();
	public void save(Student student);
	public void update(Student student);
	public void delete(Student student);
	public List<Student> findAprovats();
	public double mitjaEdat();
	public List<Student> findBeginNameWith(String letter);
	public List<Student> findExcellentQualification();
	public long countStudents();
	public List<Student> predicates();
}
