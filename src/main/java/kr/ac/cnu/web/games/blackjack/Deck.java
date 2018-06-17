package kr.ac.cnu.web.games.blackjack;

import kr.ac.cnu.web.exceptions.NoMoreCardException;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by rokim on 2018. 5. 26..
 */
@Data
public class Deck {
    private final int number;
    private final List<Card> cardList;

    public Deck(int number) {
        this.number = number;
        this.cardList = new ArrayList<Card>();
        createCards(number);
        Collections.shuffle(cardList);
    }

    private void createCards(int number) {
        // create card for single deck
        for (int j = 0; j < number; j++) {
            for (Suit suit : Suit.values()) {
                for (int i = 1 ; i < 14; i++) {
                    Card card = new Card(i, suit);
                    cardList.add(card);
                }
            }
        }
    }

    public Card drawCard() {
        if (cardList.size() <= 10) {
            for(int i=0; i<cardList.size(); i++){
                cardList.remove(i);
            }
            createCards(number);
            Collections.shuffle(cardList);
                        throw new NoMoreCardException();
        }
        return cardList.remove(0);
    }

}
