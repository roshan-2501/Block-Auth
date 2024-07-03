package service;

import java.util.List;

import model.CertificatesPojo;
import model.QrPojo;
import model.UserPojo;

public interface ServerInterface {

	boolean accept(String email, String uid);

	boolean decline(String email);

	List<UserPojo> loadRequests();

	List<UserPojo> loadPendingRequests();

	List<CertificatesPojo> loadDocumentRequests();

	List<CertificatesPojo> loadDocumentRequests(String email);

	boolean acceptOrDecline(String email, String type);

	List<QrPojo> loadQr();

	boolean QrAcceptOrDecline(String email, String reason, String qrcode);
}
