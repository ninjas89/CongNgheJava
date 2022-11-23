package tdtu.edu.un.WG26.Model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@Column
	private String email;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "first_name")
	private String firstName;
	
	@CreatedDate
	@Column(name = "created_date", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createdDate;
	
	@Column
	private String gender;
	
	@Column(name = "cash_amount") 
	private Integer cashAmount;
	
	@Column
	private String password;
	
	@Column
	private String role;
	
	@Column(name = "phone_number")
	private String phonenNumber;
	
	@Column(name = "avatar_path")
	private String avatarPath;

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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPhonenNumber() {
		return phonenNumber;
	}

	public void setPhonenNumber(String phonenNumber) {
		this.phonenNumber = phonenNumber;
	}

	public String getAvatarPath() {
		return avatarPath;
	}

	public void setAvatarPath(String avatarPath) {
		this.avatarPath = avatarPath;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", lastName=" + lastName + ", firstName=" + firstName + ", createdDate="
				+ createdDate + ", gender=" + gender + ", cashAmount=" + cashAmount + ", password=" + password
				+ ", role=" + role + ", phonenNumber=" + phonenNumber + ", avatarPath=" + avatarPath + "]";
	}

}
