package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "verification")
public class QRPojo implements Serializable {

	@Id
	@GeneratedValue
	private long id;
	private String email, requestType, qrcode, status;

	public QRPojo(String email, String requestType, String qrcode, String status) {
		super();
		this.email = email;
		this.requestType = requestType;
		this.qrcode = qrcode;
		this.status = status;
	}

	public QRPojo() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getQrcode() {
		return qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
