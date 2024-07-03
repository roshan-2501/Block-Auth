package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "qrdocs")
public class QrDetailsPojo implements Serializable {
	@Id
	@GeneratedValue
	private long id;
	private String email, documents;

	public QrDetailsPojo(String email, String documents) {
		super();
		this.email = email;
		this.documents = documents;
	}

	public QrDetailsPojo() {
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

	public String getDocuments() {
		return documents;
	}

	public void setDocuments(String documents) {
		this.documents = documents;
	}

}
