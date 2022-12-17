package tdtu.edu.un.WG26.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="app")
public class App {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column
	private String genre;
	
	@Column(name = "tag_name")
	private String tagName;

	@Column(name = "app_name")
	private String appName;
	
	@Column
	private String description;
	
	@Column(name="download_path")
	private String downloadPath;
	
	@Column(name="avatar_path")
	private String avatarPath;
	
	public App() {
		super();
	}
	
	
	public App(String genre, String tagName, String appName, String description,
		String downloadPath, String avatarPath) {
		super();
		this.genre = genre;
		this.tagName = tagName;
		this.appName = appName;
		this.description = description;
		this.downloadPath = downloadPath;
		this.avatarPath = avatarPath;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDownloadPath() {
		return downloadPath;
	}

	public void setDownloadPath(String downloadPath) {
		this.downloadPath = downloadPath;
	}

	public String getAvatarPath() {
		return avatarPath;
	}

	public void setAvatarPath(String avatarPath) {
		this.avatarPath = avatarPath;
	}

	@Override
	public String toString() {
		return "App [id=" + id + ", genre=" + genre + ", tagName=" + tagName + ", appName=" + appName + ", description="
				+ description + ", downloadPath=" + downloadPath + ", avatarPath=" + avatarPath + "]";
	}
}
	
