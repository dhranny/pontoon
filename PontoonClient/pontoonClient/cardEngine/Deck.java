package cardEngine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This is the method used to manage
 * the card deck
 */
public class Deck implements Deckish{
    public List<Card> cards;
    public Deck (){
        cards = create();
        shuffle();
    }

    /**
     * This is the method used tro create a
     * list of Cards that acts as the Deck.
     * @return List<Card>
     */
    public List<Card> create(){
        List<Card> cards = new ArrayList();
        for (Card.CardColor color : Card.CardColor.values()) {
            for (int value = 1; value <= 13; value++) {
                Card.CardType type = Card.CardType.PIP;
                if (value == 11)
                    type = Card.CardType.JACK;
                else if (value == 12)
                    type = Card.CardType.QUEEN;
                else if (value == 13)
                    type = Card.CardType.KING;
                cards.add(new Card(color, value < 10? value : 10, type));
            }
        }
        return cards;
    }

    /**
     * This method is used to shuffle the list of cards
     * in the deck.
     */
    public void shuffle(){
        Card temp;
        for (int i =0; i < cards.size(); i++) {
            int randomNumber = (int)(Math.random() * (cards.size() - 1));
            temp = cards.get(i);
            cards.remove(i);
            cards.add(i, cards.get(randomNumber));
            cards.remove(randomNumber);
            cards.add(randomNumber, temp);
        }
    }

    public Card deal(){
        int randomNumber = (int)Math.random() * cards.size();
        Card dealedCard = cards.get(randomNumber);
        cards.remove(randomNumber);
        return dealedCard;
    }
}
