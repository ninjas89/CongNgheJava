package tdtu.edu.un.WG26.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	@Column
	private String email;
	@Column(name = "app-name")
	private String appName;
	@Column
	private String genre;
	@Column(name="tag_name")
	private String tagName;
	@Column(name="download_path")
	private String downloadPath;
	
	public Cart() {
		super();
	}

	public Cart(String email, String appName, String genre, String tagName, String downloadPath) {
		super();
		this.email = email;
		this.appName = appName;
		this.genre = genre;
		this.tagName = tagName;
		this.downloadPath = downloadPath;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", email=" + email + ", appName=" + appName + ", genre=" + genre + ", tagName="
				+ tagName + ", downloadPath=" + downloadPath + "]";
	}


	
	
}
