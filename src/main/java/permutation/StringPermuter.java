package permutation;

import java.util.Set;
import java.util.HashSet;

public class StringPermuter {

	public static void main(String[] args) {

		StringPermuter permuter = new StringPermuter();
		//String[] perms = permuter.permute("ab");
		String[] perms = permuter.permute("abcdefghij");
		if (perms != null) {
			System.out.println("Totalutaions : " + perms.length);
			if (perms.length > 0) {
				for (String s : perms)
					System.out.println(s);
			}
		}

	}

	public String[] permute(String string) {
		if (string != null) {
			char[] chars = string.toCharArray();
			if (chars.length == 0)
				return null;
			else if (chars.length == 1) {
				// Permutation for one char
				String[] strs = new String[1];
				strs[0] = new StringBuilder().append(chars[0]).toString();
				return strs;
			} else if (chars.length == 2) {
				// Permutation for two chars
				String[] strings = new String[2];
				strings[0] = new StringBuilder().append(chars[0]).append(chars[1]).toString();
				strings[1] = new StringBuilder().append(chars[1]).append(chars[0]).toString();
				return strings;
			} else {
				Set<String> set = new HashSet<>();
				// Find permuation of n-1 chars
				String[] permutations = permute(string.substring(0, chars.length - 1));
				// nth char
				char ch = chars[chars.length - 1];
				// Place nth char in all places in Permutation(n-1)
				for (String str : permutations) {
					char[] chrs = str.toCharArray();
					int x = 0, y = 0;
					StringBuilder newString = null;
					while (x <= chrs.length) {
						newString = new StringBuilder();
						y = 0;
						while (y < x) {
							newString.append(chrs[y]);
							y++;
						}
						newString.append(ch);
						while (y < chars.length - 1) {
							newString.append(chrs[y]);
							y++;
						}
						set.add(newString.toString());
						x++;
					}
				}

				return set.toArray(new String[0]);
			}
		}
		return null;
	}

}
