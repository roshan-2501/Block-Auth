package service;

import java.util.List;
import hibernate.util.HibernateUtil;
import model.QRPojo;
import model.QrDetailsPojo;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class AuthDao implements MethodIntrface {

	@Override
	public boolean saveQrRequest(QRPojo qrPojo) {
		boolean result = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			tx.begin();
			Criteria cr = session.createCriteria(QRPojo.class);
			cr.add(Restrictions.eq("email", qrPojo.getEmail()));
			cr.add(Restrictions.eq("requestType", qrPojo.getRequestType()));
			List<QRPojo> list = cr.list();
			if (list.isEmpty()) {
				session.save(qrPojo);
				result = true;
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public List<QRPojo> loadRequests(String type) {
		List<QRPojo> list = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			tx.begin();
			Criteria cr = session.createCriteria(QRPojo.class);
			cr.add(Restrictions.eq("requestType", type));
			list = cr.list();
			tx.commit();

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<QRPojo> loadRequests(String email, String type) {
		List<QRPojo> list = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			tx.begin();
			Criteria cr = session.createCriteria(QRPojo.class);
			cr.add(Restrictions.eq("email", email));
			cr.add(Restrictions.eq("requestType", type));
			list = cr.list();
			tx.commit();

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public boolean saveQrDetisl(QrDetailsPojo detailsPojo) {
		boolean result = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			tx.begin();
			Criteria cr = session.createCriteria(QrDetailsPojo.class);
			cr.add(Restrictions.eq("email", detailsPojo.getEmail()));
			List<QrDetailsPojo> list = cr.list();
			if (list.isEmpty()) {
				session.save(detailsPojo);
				result = true;
			} else {
				QrDetailsPojo pojo = list.get(0);
				pojo.setDocuments(detailsPojo.getDocuments());
				session.update(pojo);
				result = true;
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;

	}

	@Override
	public List<QrDetailsPojo> retriveQrDetails(String email) {
		List<QrDetailsPojo> list = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			tx.begin();
			Criteria cr = session.createCriteria(QrDetailsPojo.class);
			cr.add(Restrictions.eq("email", email));
			list = cr.list();
			tx.commit();

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public boolean issueProofs(String email, String type) {
		boolean result = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			tx.begin();
			Criteria cr = session.createCriteria(QRPojo.class);
			cr.add(Restrictions.eq("email", email));
			cr.add(Restrictions.eq("requestType", type));
			cr.add(Restrictions.eq("status", "pending"));
			List<QRPojo> list = cr.list();
			if (!list.isEmpty()) {
				QRPojo qrPojo = list.get(0);
				qrPojo.setStatus("issued");
				session.update(qrPojo);
				result = true;
			}
			tx.commit();

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public boolean deleteUserInfo(String email) {
		boolean result = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			tx.begin();
			Criteria cr = session.createCriteria(QrDetailsPojo.class);
			cr.add(Restrictions.eq("email", email));
			List<QrDetailsPojo> list = cr.list();
			QrDetailsPojo pojo = list.get(0);
			session.delete(pojo);
			result = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public List<QRPojo> loadRequestsByEmail(String email) {
		List<QRPojo> list = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			tx.begin();
			Criteria cr = session.createCriteria(QRPojo.class);
			cr.add(Restrictions.eq("email", email));
			list = cr.list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
}
