package service;

import java.util.List;

import model.QRPojo;
import model.QrDetailsPojo;

public interface MethodIntrface {

	boolean saveQrRequest(QRPojo qrPojo);

	List<QRPojo> loadRequests(String type);

	List<QRPojo> loadRequests(String email, String type);

	boolean saveQrDetisl(QrDetailsPojo detailsPojo);

	List<QrDetailsPojo> retriveQrDetails(String email);

	boolean issueProofs(String email, String type);

	boolean deleteUserInfo(String email);

	List<QRPojo> loadRequestsByEmail(String email);

}
