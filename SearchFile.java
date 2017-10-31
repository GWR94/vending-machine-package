package vendingMachine;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by james on 19/07/2017.
 */
class SearchFile {
    static int returnCoin(String input) throws IOException {
        Scanner s = new Scanner(new BufferedReader(new FileReader("src/vendingMachine/coins.txt")));
        int output = 0;
        while(s.hasNext()) {
            if(s.next().equals(input + ":")) {
                output = s.nextInt();
            }
        }
        s.close();
        return output;
    }

    static void updateCoinsToMachine(String coin, int oldValue, int changedValue) {
        String coinOutput = coin + ": ";
        int updatedValue = oldValue - changedValue;

        try {
            Path path = Paths.get("src/vendingMachine/coins.txt");
            Charset charset = StandardCharsets.UTF_8;

            String content = new String(Files.readAllBytes(path), charset);
            content = content.replaceAll(coinOutput + oldValue, coinOutput + updatedValue);
            Files.write(path, content.getBytes(charset));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void addOneCoin(String coin) {
        String coinOutput = coin + ": ";

        try {
            Path path = Paths.get("src/vendingMachine/coins.txt");
            Charset charset = StandardCharsets.UTF_8;

            String content = new String(Files.readAllBytes(path), charset);
            content = content.replaceAll(coinOutput + returnCoin(coin), coinOutput + (returnCoin(coin) + 1));
            Files.write(path, content.getBytes(charset));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static void addCoins(String coin, int amount) {
        String coinOutput = coin + ": ";

        try {
            Path path = Paths.get("src/vendingMachine/coins.txt");
            Charset charset = StandardCharsets.UTF_8;

            String content = new String(Files.readAllBytes(path), charset);
            content = content.replaceAll(coinOutput + returnCoin(coin), coinOutput + (returnCoin(coin) + amount));
            Files.write(path, content.getBytes(charset));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void removeOneCoin(String coin) {
        String coinOutput = coin + ": ";

        try {
            Path path = Paths.get("src/vendingMachine/coins.txt");
            Charset charset = StandardCharsets.UTF_8;

            String content = new String(Files.readAllBytes(path), charset);
            content = content.replaceAll(coinOutput + returnCoin(coin), coinOutput + (returnCoin(coin) - 1));
            Files.write(path, content.getBytes(charset));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void removeCoins(String coin) {
        String coinOutput = coin + ": ";

        try {
            Path path = Paths.get("src/vendingMachine/coins.txt");
            Charset charset = StandardCharsets.UTF_8;

            String content = new String(Files.readAllBytes(path), charset);
            content = content.replaceAll(coinOutput + returnCoin(coin), coinOutput + 0);
            Files.write(path, content.getBytes(charset));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    static double getCurrentMoney() {
        double amount = 0;
        try {
            amount = returnCoin("£2")*200 + returnCoin("£1")*100 + returnCoin("50p")*50 + returnCoin("20p")*20
                    + returnCoin("10p")*10 + returnCoin("5p")*5 + returnCoin("2p")*2 + returnCoin("1p");

        } catch(IOException e) {
            e.printStackTrace();
        }
        return amount / 100;
    }

    static Map<String, Integer> removeAll() {
        Map<String, Integer> coins = new HashMap<>();
        try {
            coins.put("£2", returnCoin("£2"));
            coins.put("£1", returnCoin("£1"));
            coins.put("50p", returnCoin("50p"));
            coins.put("20p", returnCoin("20p"));
            coins.put("10p", returnCoin("10p"));
            coins.put("5p", returnCoin("5p"));
            coins.put("2p", returnCoin("2p"));
            coins.put("1p", returnCoin("1p"));

            removeCoins("£2");
            removeCoins("£1");
            removeCoins("50p");
            removeCoins("20p");
            removeCoins("10p");
            removeCoins("5p");
            removeCoins("2p");
            removeCoins("1p");

        } catch(Exception e) {
            e.printStackTrace();
        }

        return coins;
    }

    public static boolean lowFunds() {
        boolean lowFunds = false;
        try {
            if(getCurrentMoney() < 20.00) {
                lowFunds = true;
            }
            else if(returnCoin("£2") < 5 || returnCoin("£1") < 5 || returnCoin("50p") < 5 ||
                    returnCoin("20p") < 5 || returnCoin("10p") < 8 || returnCoin("5p") < 10 ||
                    returnCoin("2p") < 10 || returnCoin("1p") < 12) {
                lowFunds = true;
            }
            else {
                lowFunds = false;
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        return lowFunds;
    }
}

