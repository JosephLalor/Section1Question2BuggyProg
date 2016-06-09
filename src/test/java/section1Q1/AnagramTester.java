/*
 * Program to test if string pairs are anagrams of each other.
 * For each string pair the strings are stripped of spaces and punctuation,
 * then their letters are put in alphabetical order, as many times as they
 * occur.  The sorted strings are compared, and if equal the original strings
 * form an anagram pair.
 */

package section1Q1;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Arrays;

public class AnagramTester 
{
	public static void main(String[] args) 
	{
		System.out.println("AnagramTester starting");
		
		Hashtable<Object,String> wordPairs = new Hashtable<Object,String>();
		Enumeration<Object> firstWords;
		
		wordPairs.put("Punishment","Nine Thumps");
		wordPairs.put("The Morse Code","Here come dots");
		wordPairs.put("Snooze alarms", "Alas, no more Zs");
		wordPairs.put("Supermarine", "Weston-super-Mare"); // Letters in common, different lengths
		wordPairs.put("Halley's Comet","Shall yet come");
		wordPairs.put("One good turn deserves another.","Do rogues endorse that? No, never!");
		wordPairs.put("Tennis","Dennis"); // Same lengths, one letter different
		
		firstWords = wordPairs.keys();
		
		while(firstWords.hasMoreElements())
		{
			Object firstWord = firstWords.nextElement();
			System.out.println(areAnagrams(firstWord,wordPairs.get((String)firstWord)));
		}
	}
		
	public static String areAnagrams(Object first, String second) 
	{
		System.out.println("Method 'areAnagrams' running");
		
		String message = "'"+ (String)first + "' and '" + second + "' are not anagrams";
		String regex = "[\\s,'!?.-]+"; // Regular expression for stripping spaces and punctuation
		// Character arrays to contain letters
		char[] array1;
		char[] array2;
		// Make all letters lower case, then strip out punctuation and spaces
		String s1 =  ((String)first).toLowerCase().replaceAll(regex,"");
		String s2 = second.toLowerCase().replaceAll(regex,"");
		System.out.println(s1+","+s2);
		
		if(s1.length() == s2.length()) // Strings cannot be anagrams if of different lengths
		{
			array1 = s1.toCharArray();
			array2 = s2.toCharArray();
			Arrays.sort(array1);
			Arrays.sort(array2);
			s1 = new String(array1);
			s2 = new String(array2);
			System.out.println(s1+","+s2);
			if(s1.equals(s2))
			{
				message = "'"+(String)first + "' and '" + second + "' are anagrams"; 
			}
		}
		else
		{
			message = "'"+(String)first + "' and '" + second + "' cannot be anagrams as they are different lengths";
		}
		return message;
	} // Method areAnagrams
}
