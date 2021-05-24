import java.util.*;

  // A Purse holds a collection of Coins 
public class Purse { 
    private ArrayList coins; 

    public Purse() { 
        coins = new ArrayList(); 
    }

    // adds aCoin to the purse 
    public void add(Coin aCoin) { 
        coins.add(aCoin); 
    } 

    // returns total value of all coins in purse 
    public double getTotal() {
        double keepTotal = 0;
        for(int i = 0; i < coins.size(); i++){
            Coin myCoin = (Coin) coins.get(i);
            keepTotal += myCoin.getValue();
        }
        
        return keepTotal;
    } 



    // returns the number of coins in the Purse that matches aCoin 
    // (both myName & myValue) 
    public int count(Coin aCoin) {
        int numberOfCoins = 0;
        for(int i = 0; i < coins.size(); i++){
            Coin myCoin = (Coin) coins.get(i);
                        
            if(aCoin.equals(myCoin)) {
                numberOfCoins++;
            }            
            
            /* OR we could do it like this
            if((myCoin.getValue() == aCoin.getValue()) && (myCoin.getName() == aCoin.getName()))
            {
                numberOfCoins++;
            }
            */
        }
        return numberOfCoins;
    } 
}

