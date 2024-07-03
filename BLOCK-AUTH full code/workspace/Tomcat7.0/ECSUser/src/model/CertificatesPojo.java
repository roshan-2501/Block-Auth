package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "certificates")
public class CertificatesPojo implements Serializable {
	@Id
	@GeneratedValue
	private long id;
	String email, panCard, panStatus, aadharCard, aadharStatus, voterId,
			voterIDStatus, sslc, sslcStatus, status;

	public CertificatesPojo(String email, String panCard, String panStatus,
			String aadharCard, String aadharStatus, String voterId,
			String voterIDStatus, String sslc, String sslcStatus, String status) {
		super();
		this.email = email;
		this.panCard = panCard;
		this.panStatus = panStatus;
		this.aadharCard = aadharCard;
		this.aadharStatus = aadharStatus;
		this.voterId = voterId;
		this.voterIDStatus = voterIDStatus;
		this.sslc = sslc;
		this.sslcStatus = sslcStatus;
		this.status = status;
	}

	public CertificatesPojo() {
		// TODO Auto-generated constructor stub
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

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public String getPanStatus() {
		return panStatus;
	}

	public void setPanStatus(String panStatus) {
		this.panStatus = panStatus;
	}

	public String getAadharCard() {
		return aadharCard;
	}

	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}

	public String getAadharStatus() {
		return aadharStatus;
	}

	public void setAadharStatus(String aadharStatus) {
		this.aadharStatus = aadharStatus;
	}

	public String getVoterId() {
		return voterId;
	}

	public void setVoterId(String voterId) {
		this.voterId = voterId;
	}

	public String getVoterIDStatus() {
		return voterIDStatus;
	}

	public void setVoterIDStatus(String voterIDStatus) {
		this.voterIDStatus = voterIDStatus;
	}

	public String getSslc() {
		return sslc;
	}

	public void setSslc(String sslc) {
		this.sslc = sslc;
	}

	public String getSslcStatus() {
		return sslcStatus;
	}

	public void setSslcStatus(String sslcStatus) {
		this.sslcStatus = sslcStatus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
