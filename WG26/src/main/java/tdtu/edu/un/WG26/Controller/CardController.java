package tdtu.edu.un.WG26.Controller;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="card")
public class CardController {
	
	@Id
	@Column
	private Integer MATHE;
	@Column
	private Integer GIA;
	@Column
	private Integer TINHTRANG;
	@Column
	private Date TIME;
	public Integer getMATHE() {
		return MATHE;
	}
	public void setMATHE(Integer mATHE) {
		MATHE = mATHE;
	}
	public Integer getGIA() {
		return GIA;
	}
	public void setGIA(Integer gIA) {
		GIA = gIA;
	}
	public Integer getTINHTRANG() {
		return TINHTRANG;
	}
	public void setTINHTRANG(Integer tINHTRANG) {
		TINHTRANG = tINHTRANG;
	}
	public Date getTIME() {
		return TIME;
	}
	public void setTIME(Date tIME) {
		TIME = tIME;
	}
	@Override
	public String toString() {
		return "CardController [MATHE=" + MATHE + ", GIA=" + GIA + ", TINHTRANG=" + TINHTRANG + ", TIME=" + TIME + "]";
	}
	
	
}
	
