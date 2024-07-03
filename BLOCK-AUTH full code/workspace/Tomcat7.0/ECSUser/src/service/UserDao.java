package service;

import java.util.List;
import hibernate.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import model.CertificatesPojo;
import model.QrPojo;
import model.UserPojo;

public class UserDao implements MethodInterface {

	@Override
	public boolean saveUser(UserPojo userPojo) {
		boolean result = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			tx.begin();
			Criteria cr = session.createCriteria(UserPojo.class);
			cr.add(Restrictions.eq("email", userPojo.getEmail()));
			List<UserPojo> list = cr.list();
			if (list.isEmpty()) {
				session.save(userPojo);
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
	public boolean setProfile(String email, String image) {
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
				userPojo.setImage(image);
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
	public String userLogin(String email, String password) {
		String result = "no";
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			tx.begin();
			Criteria cr = session.createCriteria(UserPojo.class);
			cr.add(Restrictions.eq("email", email));
			cr.add(Restrictions.eq("password", password));
			List<UserPojo> list = cr.list();
			if (!list.isEmpty()) {
				for (UserPojo userPojo : list) {
					result = userPojo.getName() + "," + userPojo.getUid() + ","
							+ userPojo.getImage();
				}
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
	public boolean saveCertificates(CertificatesPojo certificatesPojo) {
		boolean result = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			tx.begin();
			session.save(certificatesPojo);
			result = true;
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
	public List<CertificatesPojo> loadCertificateStatus(String email) {
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
	public boolean updatePanCard(String email, String panCard,
			String panStatus, String type) {
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
				if (type.equals("pan card")) {
					CertificatesPojo certificatesPojo = list.get(0);
					certificatesPojo.setPanCard(panCard);
					certificatesPojo.setPanStatus(panStatus);
					certificatesPojo.setStatus("pending");
					session.update(certificatesPojo);
					result = true;
				} else if (type.equals("aadhar card")) {
					CertificatesPojo certificatesPojo = list.get(0);
					certificatesPojo.setAadharCard(panCard);
					certificatesPojo.setAadharStatus(panStatus);
					certificatesPojo.setStatus("pending");
					session.update(certificatesPojo);
					result = true;
				} else if (type.equals("voter id")) {
					CertificatesPojo certificatesPojo = list.get(0);
					certificatesPojo.setVoterId(panCard);
					certificatesPojo.setVoterIDStatus(panStatus);
					certificatesPojo.setStatus("pending");
					session.update(certificatesPojo);
					result = true;
				} else if (type.equals("sslc")) {
					CertificatesPojo certificatesPojo = list.get(0);
					certificatesPojo.setSslc(panCard);
					certificatesPojo.setSslcStatus(panStatus);
					certificatesPojo.setStatus("pending");
					session.update(certificatesPojo);
					result = true;
				}
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
	public boolean saveQR(QrPojo qrPojo) {
		boolean result = false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			tx.begin();
			Criteria cr = session.createCriteria(QrPojo.class);
			cr.add(Restrictions.eq("email", qrPojo.getEmail()));
			cr.add(Restrictions.eq("certificates", qrPojo.getCertificates()));
			List<QrPojo> list = cr.list();
			if (list.isEmpty()) {
				session.save(qrPojo);
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
	public List<QrPojo> loadQr() {
		List<QrPojo> list = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			tx.begin();
			Criteria cr = session.createCriteria(QrPojo.class);
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
	public List<QrPojo> loadQr(String email) {
		List<QrPojo> list = null;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			tx.begin();
			Criteria cr = session.createCriteria(QrPojo.class);
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

}
