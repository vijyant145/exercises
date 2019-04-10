package permutation;

public class GenerateAllPermutationOfNBits {
	 
	 public static void main(String[] args) {
	  permutation("ABC", "", 2);
	  permutationOfBinaryNumbers("", 2);
	 }
	  
	 private static void permutation(String str, String prefix, int lengthOfPermutationString){
	  if(prefix.length()==lengthOfPermutationString){
	   System.out.println(prefix);
	  }else{
	   for (int i = 0; i < str.length(); i++) {
	    permutation(str, prefix + str.charAt(i), lengthOfPermutationString);
	   }
	  }
	 }
	  
	 private static void permutationOfBinaryNumbers(String prefix, int lengthOfPermutationString){
	  if(prefix.length()==lengthOfPermutationString){
	   System.out.println(prefix);
	  }else{
	   permutationOfBinaryNumbers(prefix + "1", lengthOfPermutationString);
	   permutationOfBinaryNumbers(prefix + "0", lengthOfPermutationString);
	  }
	 }
	  
	}
