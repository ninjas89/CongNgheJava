package tdtu.edu.un.WG26.web.dto;


public class CartDTO {
	private String email;
	private String appName;
	private String genre;
	private String tagName;
	private String downloadPath;
	
	public CartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartDTO(String email, String appName, String genre, String tagName, String downloadPath) {
		super();
		this.email = email;
		this.appName = appName;
		this.genre = genre;
		this.tagName = tagName;
		this.downloadPath = downloadPath;
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

	public String getDownloadPath() {
		return downloadPath;
	}

	public void setDownloadPath(String downloadPath) {
		this.downloadPath = downloadPath;
	}

	@Override
	public String toString() {
		return "CartDTO [email=" + email + ", appName=" + appName + ", genre=" + genre + ", tagName=" + tagName
				+ ", downloadPath=" + downloadPath + "]";
	}
	
	
	
	
	
}
