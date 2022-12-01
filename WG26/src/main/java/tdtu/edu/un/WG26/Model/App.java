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
	private Integer id;

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

	public App() {
		super();
	}

	public App(Integer id, String appName, String description, Integer price, String publisher, Integer purchaseTime,
			String downloadPath, String avatarPath) {
		super();
		this.id = id;
		this.appName = appName;
		this.description = description;
		this.price = price;
		this.publisher = publisher;
		this.purchaseTime = purchaseTime;
		this.downloadPath = downloadPath;
		this.avatarPath = avatarPath;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
		return "App [id=" + id + ", appName=" + appName + ", description=" + description + ", price=" + price
				+ ", publisher=" + publisher + ", purchaseTime=" + purchaseTime + ", downloadPath=" + downloadPath
				+ ", avatarPath=" + avatarPath + "]";
	}
}
	
