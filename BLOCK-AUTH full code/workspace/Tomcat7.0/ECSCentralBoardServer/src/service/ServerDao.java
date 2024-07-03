package service;

import java.util.List;
import hibernate.util.HibernateUtil;
import model.CertificatesPojo;
import model.QrPojo;
import model.UserPojo;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class ServerDao implements ServerInterface {

	@Override
	public boolean accept(String email, String uid) {
		boolean result = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			tx.begin();
			Criteria cr = session.createCriteria(UserPojo.class);
			cr.add(Restrictions.eq("email", email));
			List<UserPojo> list = cr.list();
			if (!list.isEmpty()) {
				UserPojo userPojo = list.get(0);
				userPojo.setUid(uid);
				session.update(userPojo);
				result = true;
			}
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public boolean decline(String email) {
		boolean result = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			tx.begin();
			Criteria cr = session.createCriteria(UserPojo.class);
			cr.add(Restrictions.eq("email", email));
			List<UserPojo> list = cr.list();
			if (!list.isEmpty()) {
				UserPojo userPojo = list.get(0);
				userPojo.setUid("declined");
				session.update(userPojo);
				result = true;
			}
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public List<UserPojo> loadRequests() {
		List<UserPojo> list = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			tx.begin();
			Criteria cr = session.createCriteria(UserPojo.class);
			list = cr.list();
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<UserPojo> loadPendingRequests() {
		List<UserPojo> list = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			tx.begin();
			Criteria cr = session.createCriteria(UserPojo.class);
			cr.add(Restrictions.eq("uid", "pending"));
			list = cr.list();
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;

	}

	@Override
	public List<CertificatesPojo> loadDocumentRequests() {
		List<CertificatesPojo> list = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			tx.begin();
			Criteria cr = session.createCriteria(CertificatesPojo.class);
			cr.add(Restrictions.eq("status", "pending"));
			list = cr.list();
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<CertificatesPojo> loadDocumentRequests(String email) {
		List<CertificatesPojo> list = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			tx.begin();
			Criteria cr = session.createCriteria(CertificatesPojo.class);
			cr.add(Restrictions.eq("email", email));
			list = cr.list();
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public boolean acceptOrDecline(String email, String type) {
		boolean result = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			tx.begin();
			Criteria cr = session.createCriteria(CertificatesPojo.class);
			cr.add(Restrictions.eq("email", email));
			List<CertificatesPojo> list = cr.list();
			if (!list.isEmpty()) {
				if (type.equals("accept")) {
					CertificatesPojo certificatesPojo = list.get(0);
					certificatesPojo.setStatus("approved");
					session.update(certificatesPojo);
					result = true;
				} else {
					CertificatesPojo certificatesPojo = list.get(0);
					certificatesPojo.setStatus("declined");
					session.update(certificatesPojo);
					result = true;
				}
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public List<QrPojo> loadQr() {
		List<QrPojo> list = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			tx.begin();
			Criteria cr = session.createCriteria(QrPojo.class);
			cr.add(Restrictions.eq("status", "pending"));
			list = cr.list();
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public boolean QrAcceptOrDecline(String email, String reason, String qrcode) {
		boolean result = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			tx.begin();
			Criteria cr = session.createCriteria(QrPojo.class);
			cr.add(Restrictions.eq("email", email));
			List<QrPojo> list = cr.list();
			if (!list.isEmpty()) {
				if (reason.equals("generate")) {
					QrPojo qrPojo = list.get(0);
					qrPojo.setStatus("generated");
					qrPojo.setQrcode(qrcode);
					session.update(qrPojo);
					result = true;
				} else {
					QrPojo qrPojo = list.get(0);
					qrPojo.setStatus("declined");
					session.update(qrPojo);
					result = true;
				}
			}
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}

}
