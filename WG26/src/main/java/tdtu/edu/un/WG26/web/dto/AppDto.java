package tdtu.edu.un.WG26.web.dto;

public class AppDto {

	private String genre;
	private String tagName;	
	private String appName;
	private String description;
	private String downloadPath;
	private String avatarPath;
	
	public AppDto() {
		super();
	}
	
	public AppDto(String genre, String tagName, String appName, String description, String downloadPath, String avatarPath) {
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
		return "AppDto [genre=" + genre + ", tagName=" + tagName + ", appName=" + appName
				+ ", description=" + description + ", downloadPath=" + downloadPath + ", avatarPath=" + avatarPath + "]";
	}
	
}
