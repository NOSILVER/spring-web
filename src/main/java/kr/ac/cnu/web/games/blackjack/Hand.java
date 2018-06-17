package kr.ac.cnu.web.games.blackjack;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public int getCardSum() { // Noeun, Jhyun 수정
        int cardSum = 0;
        for (int i = 0; i < cardList.size(); i++) {
            if (cardList.get(i).getRank() >= 11) cardSum += 10;
            else if (cardList.get(i).getRank() == 1) {
                Random r = new Random();
                int Random_Num= r.nextInt(10);
                if (Random_Num <= 5) {
                    cardSum +=1;
                } else {
                    cardSum +=11;
                }
            }
            else cardSum += cardList.get(i).getRank();
        }
        return cardSum;
    }

    public void reset() {
        cardList.clear();
    }
}
