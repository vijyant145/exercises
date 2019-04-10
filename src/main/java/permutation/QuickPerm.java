package permutation;

import java.util.ArrayList;
import java.util.Arrays;
public class QuickPerm {

    public static void main (String args[]) {
      String s = "abcdefghij";
      
      long before = System.currentTimeMillis();
      ArrayList<String> perms = perm(s, 3);
      perms.forEach(System.out::println);
      long after = System.currentTimeMillis();
      double time = (after - before)/1000.0;
      System.out.println("\n\nTook " + time + " seconds to calculate " + perms.size() + " permutations of " + numOfPermutations(new String(s)));
    }
   
   /**
    * Returns an arraylist of unique permutations.
    *
    *@author Tyler Hoover
    */
    public static ArrayList<String> perm(String word, int len) {
      ArrayList<String> permutations = new ArrayList<String>();
      
      char[] originalSorted = word.toCharArray();
      Arrays.sort(originalSorted);
      char[] value = originalSorted;
      
      int k = word.length();
      
      boolean allWordsDone = false;
      //Start off by storing the original word.
      permutations.add(new String(value));
      //Loop until all words are added. The logic here is that its sorted, so loop while switching characters until its reverse sorted,
      //Store each switch as a new word unless it is a duplicate.
      while (!allWordsDone) {
         //Remember the words are in abc order before coming to me. 
         int i = k - 1;
         while (i > 0 && value[i-1] >= value[i]) {
            i--;
         }
      
         if (i < 1) {
            allWordsDone = true;
            return permutations;
         }
      
         int j = k;
         while (value[j-1] <= value[i-1]) {
            j--;
         }
         
         //Swap around letters
         char swap1 = value[i-1];
         value[i-1] = value[j-1];
         value[j-1] = swap1;
         
      
         i++;
         j = k;
      
         while (i < j) {
            //Perform a swap
            char swap2 = value[i-1];
            value[i-1] = value[j-1];
            value[j-1] = swap2;
            i++;
            j--;
         }
         
         permutations.add(new String(value));
      }
      return null;
   }
   
   
   /**
    * Returns the number of unique permutations for a word.
    *
    *@author Tyler Hoover
    */
   public static int numOfPermutations(String word) {
      char[] toSort = word.toCharArray();
      Arrays.sort(toSort);
      String sortedWord = new String(toSort);
      
      int count = 1;
      
      for (int n = sortedWord.length(); n > 0; n--) {
         count = count*n;
      }
      
      int dupes = 1;
      for (int i = 1; i < sortedWord.length(); i++) {
         if (sortedWord.charAt(i) == sortedWord.charAt(i-1)) {
            dupes = dupes + 1;
         } else {
            dupes = 1;
         }
         
         //Idea is divide by 2 whenever there is a duplicate.
         count = count / dupes;
      }
      
      return count;
   }
}