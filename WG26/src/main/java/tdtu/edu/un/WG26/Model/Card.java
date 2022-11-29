package tdtu.edu.un.WG26.Model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="card")
public class Card {
	
	@Id
	@Column(name = "card_code")
	private String cardCode;
	
	@Column(name = "amount")
	private Integer amount;
	
	@Column
	private Integer status;

	
	public String getCardCode() {
		return cardCode;
	}



	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}



	public Integer getAmount() {
		return amount;
	}



	public void setAmount(Integer amount) {
		this.amount = amount;
	}



	public Integer getStatus() {
		return status;
	}



	public void setStatus(Integer status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "Card [cardCode=" + cardCode + ", amount=" + amount + ", status=" + status + "]";
	}
	
	
}
	
