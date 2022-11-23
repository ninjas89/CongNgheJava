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
	private Integer price;
	
	@Column(name = "purchase_time")
	private Integer purchaseTime;
	
	@Column(name = "download_time")
	private Integer downloadTime;
	
	@Column
	private String description;
	
	@Column
	private String link;
	
	@Column
	private Integer size;
	
	@Column
	private String genre;
	
	@Column
	private String author;
	
	@Column(name = "author_email")
	private String authorEmail;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column
	private String url;
	
	
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
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getPurchaseTime() {
		return purchaseTime;
	}
	public void setPurchaseTime(Integer purchaseTime) {
		this.purchaseTime = purchaseTime;
	}
	public Integer getDownloadTime() {
		return downloadTime;
	}
	public void setDownloadTime(Integer downloadTime) {
		this.downloadTime = downloadTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAuthorEmail() {
		return authorEmail;
	}
	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "App [id=" + id + ", appName=" + appName + ", price=" + price + ", purchaseTime=" + purchaseTime
				+ ", downloadTime=" + downloadTime + ", description=" + description + ", link=" + link + ", size="
				+ size + ", genre=" + genre + ", author=" + author + ", authorEmail=" + authorEmail + ", phoneNumber="
				+ phoneNumber + ", url=" + url + "]";
	}
}
	
