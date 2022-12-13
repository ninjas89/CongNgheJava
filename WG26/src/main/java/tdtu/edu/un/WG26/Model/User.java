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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="user")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name = "email")
	private String email;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "created_date")
	private String createdDate;
	
	@Column
	private String gender;
	
	@Column(name = "cash_amount") 
	private Integer cashAmount;
	
	@Column
	private String password;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "avatar_path")
	private String avatarPath;

	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(
		name = "user_role",
        joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") },
        inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") }
	)
	private Role role;
	
	@ManyToMany(mappedBy = "userChooseLists",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<App> apps = new ArrayList<>();


	public User() {
		super();
	}
	
	public User(String email, String lastName, String firstName,String createdDate, String gender, String password, String avatarPath) {
		super();
		this.email = email;
		this.lastName = lastName;
		this.firstName = firstName;
		this.createdDate = createdDate;
		this.gender = gender;
		this.password = password;
		this.avatarPath = avatarPath;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getCashAmount() {
		return cashAmount;
	}

	public void setCashAmount(Integer cashAmount) {
		this.cashAmount = cashAmount;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAvatarPath() {
		return avatarPath;
	}

	public void setAvatarPath(String avatarPath) {
		this.avatarPath = avatarPath;
	}

	
	public List<App> getApps() {
		return apps;
	}

	public void setApps(List<App> apps) {
		this.apps = apps;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", createdDate=" + createdDate + ", gender=" + gender + ", cashAmount=" + cashAmount + ", password="
				+ password + ", phoneNumber=" + phoneNumber + ", avatarPath=" + avatarPath + ", role=" + role
				+ ", apps=" + apps + "]";
	}
}
