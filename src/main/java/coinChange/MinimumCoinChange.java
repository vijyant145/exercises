package coinChange;

public class MinimumCoinChange {
	
	// denoms = 1, 5, 10, 25
	public static int minChangeGreedy(int[] denoms, int amount) {
		int total =0;
		if(amount ==0 )return total;
		
		int left = amount;
		
		for (int i = denoms.length - 1; i >= 0; i--) {
			if(left > denoms[i]) {
				int countOfHigh = left/denoms[i];
				total = total + countOfHigh; 
				left = left - countOfHigh*denoms[i];
			}else if (left == denoms[i]) {
				total +=1;
				left = left - denoms[i];
			};
		}
		
		
		
		
		
		return total;
		
	}
	
	public static int minCoins(int coins[],  int V) 
    { 
       // base case 
       if (V == 0) return 0; 
       
       // Initialize result 
       int res = Integer.MAX_VALUE; 
       
       // Try every coin that has smaller value than V 
       for (int i=0; i<coins.length; i++) 
       { 
         if (coins[i] <= V) 
         { 
             int sub_res = minCoins(coins,  V-coins[i]); 
       
             // Check for INT_MAX to avoid overflow and see if 
             // result can minimized 
             if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res) 
                res = sub_res + 1; 
         } 
       } 
       return res; 
    } 
	
	public static void main(String args[]) 
    { 
       int coins[] =  {1,5,6,9}; 
       int m = coins.length; 
       int V = 26; 
       System.out.println("Minimum coins required is "+ minCoins(coins,  19) ); 
       
       System.out.println("-------Greedy------");
       System.out.println(minChangeGreedy(coins, 14));
       System.out.println("-------DP------");
       System.out.println(minCoinsDP(coins, 14));
    } 
	
	
	public static int minCoinsDP(int coins[],  int V) { 
        // table[i] will be storing  
        // the minimum number of coins 
        // required for i value. So  
        // table[V] will have result 
        int memo[] = new int[V + 1]; 
  
        // Base case (If given value V is 0) 
        memo[0] = 0; 
  
        // Initialize all table values as Infinite 
        for (int i = 1; i <= V; i++) 
        memo[i] = Integer.MAX_VALUE; 
  
        // Compute minimum coins required for all 
        // values from 1 to V 
        for (int i = 1; i <= V; i++) { 
            // Go through all coins smaller than i 
            for (int j = 0; j < coins.length; j++) 
            if (coins[j] <= i) { 
//            	int sub_res = memo[i - coins[j]]; 
//                if (sub_res != Integer.MAX_VALUE  
//                       && sub_res + 1 < memo[i]) 
//                       memo[i] = sub_res + 1; 
               memo[i] = Math.min(memo[i - coins[j]]+1, memo[i]);         
                  
            } 
              
        } 
        return memo[V]; 
          
    } 

}
