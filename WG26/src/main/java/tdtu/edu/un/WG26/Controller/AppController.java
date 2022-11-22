package tdtu.edu.un.WG26.Controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="app")
public class AppController {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer ID;
	@Column
	private String TENAPP;
	@Column
	private Integer GIA;
	@Column
	private Integer LUOTMUA;
	@Column
	private Integer LUOTTAI;
	@Column
	private String MOTA;
	@Column
	private String LINK;
	@Column
	private Integer KICHTHUOC;
	@Column
	private String THELOAI;
	@Column
	private String DEV;
	@Column
	private String EMAILDEV;
	@Column
	private String SDT;
	@Column
	private String URL;
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getTENAPP() {
		return TENAPP;
	}
	public void setTENAPP(String tENAPP) {
		TENAPP = tENAPP;
	}
	public Integer getGIA() {
		return GIA;
	}
	public void setGIA(Integer gIA) {
		GIA = gIA;
	}
	public Integer getLUOTMUA() {
		return LUOTMUA;
	}
	public void setLUOTMUA(Integer lUOTMUA) {
		LUOTMUA = lUOTMUA;
	}
	public Integer getLUOTTAI() {
		return LUOTTAI;
	}
	public void setLUOTTAI(Integer lUOTTAI) {
		LUOTTAI = lUOTTAI;
	}
	public String getMOTA() {
		return MOTA;
	}
	public void setMOTA(String mOTA) {
		MOTA = mOTA;
	}
	public String getLINK() {
		return LINK;
	}
	public void setLINK(String lINK) {
		LINK = lINK;
	}
	public Integer getKICHTHUOC() {
		return KICHTHUOC;
	}
	public void setKICHTHUOC(Integer kICHTHUOC) {
		KICHTHUOC = kICHTHUOC;
	}
	public String getTHELOAI() {
		return THELOAI;
	}
	public void setTHELOAI(String tHELOAI) {
		THELOAI = tHELOAI;
	}
	public String getDEV() {
		return DEV;
	}
	public void setDEV(String dEV) {
		DEV = dEV;
	}
	public String getEMAILDEV() {
		return EMAILDEV;
	}
	public void setEMAILDEV(String eMAILDEV) {
		EMAILDEV = eMAILDEV;
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
	@Override
	public String toString() {
		return "AppController [ID=" + ID + ", TENAPP=" + TENAPP + ", GIA=" + GIA + ", LUOTMUA=" + LUOTMUA + ", LUOTTAI="
				+ LUOTTAI + ", MOTA=" + MOTA + ", LINK=" + LINK + ", KICHTHUOC=" + KICHTHUOC + ", THELOAI=" + THELOAI
				+ ", DEV=" + DEV + ", EMAILDEV=" + EMAILDEV + ", SDT=" + SDT + ", URL=" + URL + "]";
	}
	
	
}
	
