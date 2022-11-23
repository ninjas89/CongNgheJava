package tdtu.edu.un.WG26.Repository;

import java.util.List;

import tdtu.edu.un.WG26.Model.Card;

public interface CardRepository {
	
	List<Card> get();
	
	Card get(Integer id);
	
	void save(Card card);	

}
