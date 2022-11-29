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
	
}
	
