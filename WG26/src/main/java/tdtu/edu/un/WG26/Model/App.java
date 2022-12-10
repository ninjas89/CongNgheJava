package tdtu.edu.un.WG26.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	
	@Column
	private Integer price;
	
	@Column
	private String publisher;
	
	@Column(name = "purchase_time")
	private Integer purchaseTime;
	
	@Column(name="download_path")
	private String downloadPath;
	
	@Column(name="avatar_path")
	private String avatarPath;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(
		name = "basket",
        joinColumns = { @JoinColumn(name = "app_id", referencedColumnName = "id") },
        inverseJoinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") }
		)
	private List<User> userChooseLists = new ArrayList<>();
	
	public App() {
		super();
	}
	
	public App(String genre, String tagName, String appName, String description, Integer price,
			String publisher, Integer purchaseTime, String downloadPath, String avatarPath) {
		super();
		this.genre = genre;
		this.tagName = tagName;
		this.appName = appName;
		this.description = description;
		this.price = price;
		this.publisher = publisher;
		this.purchaseTime = purchaseTime;
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Integer getPurchaseTime() {
		return purchaseTime;
	}

	public void setPurchaseTime(Integer purchaseTime) {
		this.purchaseTime = purchaseTime;
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
				+ description + ", price=" + price + ", publisher=" + publisher + ", purchaseTime=" + purchaseTime
				+ ", downloadPath=" + downloadPath + ", avatarPath=" + avatarPath + "]";
	}
}
	
