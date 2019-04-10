package permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation {

	private static void getPermutation(String str, int length)
    {
        if(str==null)
            return;
        Set<String> StrList = new HashSet<String>();
        StringBuilder strB= new StringBuilder();
        for(int i = 0;i < (1 << str.length()); ++i)
        {
            strB.setLength(0); //clear the StringBuilder
            if(getNumberOfOnes(i)==length){
              for(int j = 0;j < str.length() ;++j){
                if((i & (1 << j))>0){  // to check whether jth bit is set (is 1 or not)
                    strB.append(str.charAt(j));
                }
            }
            StrList.add(strB.toString());
            }
        }
        System.out.println(Arrays.toString(StrList.toArray()));
    }

private static  int getNumberOfOnes (int n) // to count how many numbers of 1 in binary representation of n
{
    int count=0;
    while( n>0 ){
       n = n&(n-1);
       count++;
    }
    return count;
}

public static List<String> getPerms(String input, int k){
	int len = input.length();
	List<String> perm = new ArrayList<>();
	if(k == 0) {
		perm.add("");
		return perm;
	}
	char first = input.charAt(0);
	String remainder = input.substring(1);
	List<String> words = getPerms(remainder, k-1);
	
	for (String word : words) {
		for(int j =0; j<= word.length();j++ ) {
			String s = insertCharAt(word, first, j);
			perm.add(s);
		}
	}
	return perm;
}

private static String insertCharAt(String word, char first , int i) {
	String start = word.substring(0, i);
	String end = word.substring(i);
	return start + first + end;
}
public static void main(String[] args) {
//	getPermutation("abcd", 2);
//	String str = "abcd";
//	System.out.println((1 << str.length()));
//	System.out.println(getNumberOfOnes(3));
//	int n = 3 & 2;
//	System.out.println(n);
	
	System.out.println(getPerms("abc", 2));
}
}
