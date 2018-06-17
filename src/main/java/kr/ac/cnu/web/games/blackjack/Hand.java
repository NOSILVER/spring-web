package kr.ac.cnu.web.games.blackjack;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rokim on 2018. 5. 26..
 */
public class Hand {
    private Deck deck;
    @Getter
    private List<Card> cardList = new ArrayList<>();

    public Hand(Deck deck) {
        this.deck = deck;
    }

    public Card drawCard() {
        Card card = deck.drawCard();
        cardList.add(card);
        return card;
    }

    public int getCardSum() {
        int cardSum = 0;
        for(int i=0; i<cardList.size(); i++){
            if(cardList.get(i).getRank()>=11) cardSum += 10;
            else cardSum += cardList.get(i).getRank();
        }
        return cardSum;
    }

    public void reset() {
        cardList.clear();
    }
}
