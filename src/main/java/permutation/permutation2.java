package permutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class permutation2 {

	public static void printAllKLengthRec(String input, String prefix, List<String> perms, int k) {

		
		// Base case: k is 0, 
		// print prefix 
		if (k == 0) {
			perms.add(prefix);
			//System.out.println(prefix);
			return ;
		}

		// One by one add all characters  
		// from set and recursively  
		// call for k equals to k-1 
		for (int i = 0; i < input.length(); ++i) {

			// Next character of input added 
			String newPrefix = prefix + input.charAt(i);			
			// k is decreased, because  
			// we have added a new character 
			String remainder = input.substring(0, i)+ input.substring(i+1);
			
			printAllKLengthRec(remainder, newPrefix, perms, k - 1);
		}
		
	}
	
	public static void main(String[] args) {
		String a = "abcd";
		String input = "abcd";
		String prefix = "";
		List<String> perms = new ArrayList<>();
		printAllKLengthRec(a, "",perms,  3);
		System.out.println(perms);
		
	}

}
