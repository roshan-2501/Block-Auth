package hibernate.util;

import model.CertificatesPojo;
import model.QrPojo;
import model.UserPojo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	static {
		try {
			sessionFactory = new AnnotationConfiguration().configure()
					.addAnnotatedClass(UserPojo.class).addAnnotatedClass(
							CertificatesPojo.class).addAnnotatedClass(
							QrPojo.class).buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session openSession() {
		return sessionFactory.openSession();
	}
}