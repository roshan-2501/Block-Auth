package service;

import java.util.List;
import model.CertificatesPojo;
import model.QrPojo;
import model.UserPojo;

public interface MethodInterface {
	boolean saveUser(UserPojo userPojo);

	String userLogin(String email, String password);

	boolean setProfile(String email, String image);

	boolean saveCertificates(CertificatesPojo certificatesPojo);

	List<CertificatesPojo> loadCertificateStatus(String email);

	boolean updatePanCard(String email, String panCard, String status,
			String type);

	boolean saveQR(QrPojo qrPojo);

	List<QrPojo> loadQr();

	List<QrPojo> loadQr(String email);

}
