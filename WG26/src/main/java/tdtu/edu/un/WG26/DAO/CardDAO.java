package tdtu.edu.un.WG26.DAO;

import java.util.List;

import tdtu.edu.un.WG26.Model.Card;

public interface CardDAO {
	
	List<Card> get();
	
	Card get(Integer id);
	
	void save(Card card);	

}
