package tdtu.edu.un.WG26.Model;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="user")
public class User {
	@Id
	@Column
	@NotEmpty(message = "Vui lòng nhập email của bạn")
	private String email;
	
	@NotEmpty(message = "Vui lòng nhập Họ")
	@Column(name = "last_name")
	private String lastName;
	
	@NotEmpty(message = "Vui lòng nhập Tên")
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "created_date")
	private String createdDate;
	
	@NotEmpty(message = "Vui lòng chọn giới tính của bạn")
	@Column
	private String gender;
	
	@Column(name = "cash_amount") 
	private Integer cashAmount;
	
	@NotEmpty(message = "Vui lòng nhập mật khẩu")
	@Column
	private String password;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "avatar_path")
	private String avatarPath;

	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(
		name = "user_role",
        joinColumns = { @JoinColumn(name = "user_email", referencedColumnName = "email") },
        inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") }
	)
	private Role role;

	public User() {
		super();
	}
	
	public User(String email, String lastName, String firstName,String createdDate, String gender, String password) {
		super();
		this.email = email;
		this.lastName = lastName;
		this.firstName = firstName;
		this.createdDate = createdDate;
		this.gender = gender;
		this.password = password;
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


	public String getPhonenNumber() {
		return phoneNumber;
	}

	public void setPhonenNumber(String phonenNumber) {
		this.phoneNumber = phonenNumber;
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
				+ ", phonenNumber=" + phoneNumber + ", avatarPath=" + avatarPath + "]";
	}


}
