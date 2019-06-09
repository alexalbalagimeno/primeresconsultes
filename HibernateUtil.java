package org.iesam.primeresconsultes;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		
		if (sessionFactory == null) {
			final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
			SessionFactory sessionFactory = null;
			try {
				sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
			}
			catch (Exception e) {
				// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
				// so destroy it manually.
				e.printStackTrace();
				StandardServiceRegistryBuilder.destroy( registry );
			}
			return sessionFactory;
		}
		return null;
	}
}
