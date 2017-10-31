package vendingMachine;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by james on 19/07/2017.
 */
public class Calculations {

    public static Map<String, Integer> calculateChange(int changeDue) throws IOException {
        Map<String, Integer> change = new HashMap<>();

        SearchFile search = new SearchFile();
        Coin twoPound = new Coin("£2", 200, search.returnCoin("£2"));
        Coin onePound = new Coin("£1", 100, search.returnCoin("£1"));
        Coin fiftyPence = new Coin("50p", 50, search.returnCoin("50p"));
        Coin twentyPence = new Coin("20p", 20, search.returnCoin("20p"));
        Coin tenPence = new Coin("10p", 10, search.returnCoin("10p"));
        Coin fivePence = new Coin("5p", 5, search.returnCoin("5p"));
        Coin twoPence = new Coin("2p", 2, search.returnCoin("2p"));
        Coin onePence = new Coin("1p", 1, search.returnCoin("1p"));
        DecimalFormat df = new DecimalFormat("0.00");

        ArrayList<Coin> coins = new ArrayList<Coin>();
        coins.add(twoPound);
        coins.add(onePound);
        coins.add(fiftyPence);
        coins.add(twentyPence);
        coins.add(tenPence);
        coins.add(fivePence);
        coins.add(twoPence);
        coins.add(onePence);
        String originalChangeDue = "£" + df.format((double)(changeDue)/100);
        boolean isPossible = true;


        for (int i = 0; i < coins.size(); i++) {
            for (int j = 0; j < coins.get(i).getNumberOfCoinsBeforeTransaction(); j++) {
                if ((coins.get(i).getCoinsCurrentlyInMachine() >= 1) && (changeDue - coins.get(i).getValueOfCoin() >= 0)) {
                    changeDue -= coins.get(i).getValueOfCoin();
                    coins.get(i).addCoinsUsed();
                    coins.get(i).removeCoinsCurrentlyInMachine();
                }
            }
        }
        if(changeDue == 0) isPossible = true;
        else isPossible = false;

        if (!isPossible) {
            System.out.println("Error, can't complete transaction. Coins will be returned: ");
        }
        else {
            for (int i = 0; i < coins.size(); i++) {
                if (coins.get(i).getCoinsToBeTakenFromMachine() > 0) {
                    search.updateCoinsToMachine(coins.get(i).getNameOfCoin(), coins.get(i).getNumberOfCoinsBeforeTransaction(), coins.get(i).getCoinsToBeTakenFromMachine());
                    change.put(coins.get(i).getNameOfCoin(), coins.get(i).getCoinsToBeTakenFromMachine());
                }
            }
        }
        return change;
    }


    public static boolean isPossible(int changeDue) throws IOException {
        SearchFile search = new SearchFile();
        Coin twoPound = new Coin("£2", 200, search.returnCoin("£2"));
        Coin onePound = new Coin("£1", 100, search.returnCoin("£1"));
        Coin fiftyPence = new Coin("50p", 50, search.returnCoin("50p"));
        Coin twentyPence = new Coin("20p", 20, search.returnCoin("20p"));
        Coin tenPence = new Coin("10p", 10, search.returnCoin("10p"));
        Coin fivePence = new Coin("5p", 5, search.returnCoin("5p"));
        Coin twoPence = new Coin("2p", 2, search.returnCoin("2p"));
        Coin onePence = new Coin("1p", 1, search.returnCoin("1p"));
        DecimalFormat df = new DecimalFormat("0.00");

        ArrayList<Coin> coins = new ArrayList<Coin>();
        coins.add(twoPound);
        coins.add(onePound);
        coins.add(fiftyPence);
        coins.add(twentyPence);
        coins.add(tenPence);
        coins.add(fivePence);
        coins.add(twoPence);
        coins.add(onePence);
        String originalChangeDue = "£" + df.format((double) (changeDue) / 100);
        boolean isPossible = true;


        for (int i = 0; i < coins.size(); i++) {
            for (int j = 0; j < coins.get(i).getNumberOfCoinsBeforeTransaction(); j++) {
                if ((coins.get(i).getCoinsCurrentlyInMachine() >= 1) && (changeDue - coins.get(i).getValueOfCoin() >= 0)) {
                    changeDue -= coins.get(i).getValueOfCoin();
                    coins.get(i).addCoinsUsed();
                    coins.get(i).removeCoinsCurrentlyInMachine();
                }
            }
        }
        if (changeDue == 0) isPossible = true;
        else isPossible = false;
        return isPossible;
    }
}
