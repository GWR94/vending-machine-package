package vendingMachine;

/**
 * Created by james on 19/07/2017.
 */
public class Coin {
    private String nameOfCoin;
    private int valueOfCoin;
    private int numberOfCoinsBeforeTransaction;
    private int coinsToBeTakenFromMachine;
    private int coinsCurrentlyInMachine;

    public Coin(String nameOfCoin, int valueOfCoin, int coinsCurrentlyInMachine) {
        this.nameOfCoin = nameOfCoin;
        this.valueOfCoin = valueOfCoin;
        this.numberOfCoinsBeforeTransaction = coinsCurrentlyInMachine;
        this.coinsCurrentlyInMachine = coinsCurrentlyInMachine;
    }

    public int getCoinsCurrentlyInMachine() {
        return coinsCurrentlyInMachine;
    }

    public String getNameOfCoin() {
        return nameOfCoin;
    }

    public int getValueOfCoin() {
        return valueOfCoin;
    }

    public int getNumberOfCoinsBeforeTransaction() {
        return numberOfCoinsBeforeTransaction;
    }

    public void addCoinsUsed() {
        this.coinsToBeTakenFromMachine += 1;
    }

    public void removeCoinsCurrentlyInMachine() {
        this.coinsCurrentlyInMachine -= 1;
    }

    public int getCoinsToBeTakenFromMachine() {
        return coinsToBeTakenFromMachine;
    }
}
