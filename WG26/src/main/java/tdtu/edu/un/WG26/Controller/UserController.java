package tdtu.edu.un.WG26.Controller;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class UserController {
	
	@Id
	@Column
	private String EMAIL;
	@Column
	private String HO;
	@Column
	private String TEN;
	@Column
	private Date NGAYTAO;
	@Column
	private String GIOITINH;
	@Column
	private Integer SOTIEN;
	@Column
	private String MATKHAU;
	@Column
	private String ROLE;
	@Column
	private String SDT;
	@Column
	private String URL;
	
//GETER SETTER
	
	public String getHO() {
		return HO;
	}
	public void setHO(String hO) {
		HO = hO;
	}
	public String getTEN() {
		return TEN;
	}
	public void setTEN(String tEN) {
		TEN = tEN;
	}
	public Date getNGAYTAO() {
		return NGAYTAO;
	}
	public void setNGAYTAO(Date nGAYTAO) {
		NGAYTAO = nGAYTAO;
	}
	public String getGIOITINH() {
		return GIOITINH;
	}
	public void setGIOITINH(String gIOITINH) {
		GIOITINH = gIOITINH;
	}
	public Integer getSOTIEN() {
		return SOTIEN;
	}
	public void setSOTIEN(Integer sOTIEN) {
		SOTIEN = sOTIEN;
	}
	public String getMATKHAU() {
		return MATKHAU;
	}
	public void setMATKHAU(String mATKHAU) {
		MATKHAU = mATKHAU;
	}
	public String getROLE() {
		return ROLE;
	}
	public void setROLE(String rOLE) {
		ROLE = rOLE;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	@Override
	public String toString() {
		return "UserController [EMAIL=" + EMAIL + ", HO=" + HO + ", TEN=" + TEN + ", NGAYTAO=" + NGAYTAO + ", GIOITINH="
				+ GIOITINH + ", SOTIEN=" + SOTIEN + ", MATKHAU=" + MATKHAU + ", ROLE=" + ROLE + ", SDT=" + SDT
				+ ", URL=" + URL + "]";
	}
	
	
	
	
	
}
