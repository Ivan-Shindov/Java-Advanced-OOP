package CardPower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

        String rank = buff.readLine();
        String suit = buff.readLine();

        CardRank cardRank = CardRank.valueOf(rank);
        CardSuit cardSuit = CardSuit.valueOf(suit);

        int power = cardRank.getPower() + cardSuit.getPower();

        System.out.printf("Card name: %s of %s; Card power: %d",
                cardRank.name(),cardSuit.name(),power);

    }
}
