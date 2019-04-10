package permutation;

import java.util.ArrayList;
import java.util.List;

public class PermutationIterative {
	
	public static void printAllKLengthIterative(String input,  int k) {
		
		List<String> perms2 = new ArrayList<>();
		Long total = countPermutations(input.length(), k);
		char[][] perms = new char[total.intValue()][k];
		
		List<char[]> perms3 = new ArrayList<>();
		char[] inpArr = input.toCharArray();
		
		
		for (int i = 0; i < input.length(); ++i) {			
			String prefix  = ""+ input.charAt(i);
			String remainder = input.substring(0, i)+ input.substring(i+1); 
			for (int j = 0; j < remainder.length(); j++) {
				 prefix  += input.charAt(j);
				 String remainder2 = input.substring(0, j)+ input.substring(j+1); 
				
			}
		}
		
		
		
		
		
	}
	
	public static long countPermutations(int n, int k) {
		long fact=1l;
		for(int i =n; i > n-k; i--) {
			fact *=i;
		}
		return fact;
	}
	
	
	
	
	public static void main(String[] args) {
		String a = "abcdefghijkl";
		String input = "abc";
		String prefix = "";
		List<String> perms = new ArrayList<>();
		//printAllKLengthIterative(a, "",  3);
		System.out.println(perms);
		
		System.out.println(countPermutations(3, 2));
		
	}

}
