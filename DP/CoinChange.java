import java.util.Scanner;
import java.util.ArrayList;

public class CoinChange {

    public static void main(String[] args) {
        
        int numberOfCoins;
        int amount;
        int[] coins;

        Scanner sc =  new Scanner(System.in);
        numberOfCoins = sc.nextInt(); // takes number of coins
        amount = sc.nextInt(); // takes amount

        coins = new int[numberOfCoins];
        for(int i=0; i<numberOfCoins; i++){
         coins[i] = sc.nextInt(); // takes each coin

        }

        sc.close();

        int[] ans = new int[amount + 1]; // Memorization array till amount index starts at 0
        // if amount was 2, then we will have indices 0 1 2

        // Fill 1 or each coin index
        for(int i=0; i<numberOfCoins; i++){
            ans[coins[i]] = 1; // sets 1 to each of the coin available
        }

        System.out.println("Minimum coins: " + result(amount, ans, coins));
        
    }

  public static int result(int amount, int ans[], int coins[]){

   // when the amount is 0
    if(amount == 0){
        return 0;
    }

    // when the amount is available as a coin
    if(ans[amount] != 0){
        return ans[amount];
    }

    // A coin is either selected or neglected
    // A coin is could be selected or neglected if it is less than or equal to amount
    // A coin is always neglected if coin is greater than amount
    // All coins must be parsed to get the best result

    for(int i=0; i<coins.length; i++){

    }

   return -1; // when no demonisition is able to get the result

  }

    
}
