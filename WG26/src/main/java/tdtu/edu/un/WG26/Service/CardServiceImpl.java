package tdtu.edu.un.WG26.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tdtu.edu.un.WG26.Model.Card;
import tdtu.edu.un.WG26.Repository.CardRepository;

@Service
public class CardServiceImpl implements CardServices {
    @Autowired
    private CardRepository cardRepository;

    @Override
    public List<Card> fetchAllCard() {
        List<Card> cardList = cardRepository.findAll();
        return cardList;
    }
    
}
