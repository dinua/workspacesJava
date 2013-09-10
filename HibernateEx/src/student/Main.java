package student;

import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vaannila.util.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		 insert();
		select();
	}

	public static void insert() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Address address1 = new Address("OMR Road", "Chennai", "TN",
					"600097");
			Address address2 = new Address("Ring Road", "Banglore",
					"Karnataka", "560000");
			Student student1 = new Student("Eswar", address1);
			Student student2 = new Student("Joe", address2);
			session.save(student1);
			session.save(student2);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static void select() {
		Session session = null;

		try {

			session = HibernateUtil.getSessionFactory().openSession();

			// Create Select Clause HQL
			String SQL_QUERY = "Select ad from Address ad";
			Query query = session.createQuery(SQL_QUERY);
			@SuppressWarnings("unchecked")
			Iterator<Address> ita = query.iterate();
			while (ita.hasNext()) {
				Address a = ita.next();
				System.out.println(a.getAddressId() + " " + a.getCity());
			}

			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
		}
	}

}
