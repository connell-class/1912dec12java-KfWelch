package com.revature.eval.java.core;

import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
		
		String acronym = new String();
		
		acronym += phrase.charAt(0);
		
		int i = 0;
		while( phrase.indexOf(' ', i) > 0 )
		{
			i = phrase.indexOf(' ', i) + 1;  // We find the position of the next space in the phrase, then add one to the index to get the next letter
			acronym += phrase.charAt(i);
		}
		
		//System.out.println(acronym);
		return acronym;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			// TODO Write an implementation for this method declaration
			if ( this.sideOne == this.sideTwo && this.sideTwo == this.sideThree )
				return true;
			else
				return false;
		}

		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration
			if ( this.sideOne == this.sideTwo && this.sideTwo == this.sideThree )  //Or if (this.isEquilateral())
				return false;
			else if ( this.sideOne != this.sideTwo && this.sideTwo != this.sideThree && this.sideThree != this.sideOne )	//Or if (this.isScalene())
				return false;
			else
				return true;
		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration
			if ( this.sideOne != this.sideTwo && this.sideTwo != this.sideThree && this.sideThree != this.sideOne )
				return true;
			else
				return false;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration
		int scoreTotal = 0;
		
		char [] alphaKey = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		int [] scoreKey = { 1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10 };
		
		int i = 0;
		while ( i < string.length() )
		{
			int j = 0;
			while ( alphaKey[j] != string.charAt(i) && j < 26 )		//Find the index of the letter on the alphabet so we can find its respective score
				j++;
			scoreTotal += scoreKey[j];								//Add the score of the letter to the word's total score
			i++;
		}
		
		return scoreTotal;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		// TODO Write an implementation for this method declaration
		
		String number = new String();
		
		int i = 0;
		
		string.replace("+1", " ");
		string.replace('(', ' ');
		string.replace(')', ' ');
		string.replace('-', ' ');
		string.replace('.', ' ');						//These lines take all non number characters expected and turns them into spaces
		string.trim();									//Trims off any fore/after spaces
		
		if ( string.charAt(0) == '1')					//Turns a leading one into a space if it exists
			i++;
		
		while ( number.length() < 10 )
		{
			while ( string.charAt(i) == ' ' )			//Follows the spaces leading up to the next set of numbers, starting at i
				i++;
			
			int j = string.indexOf(' ', i);				//Gets the location of the next space in the sequence
			
			if ( j > 0 )
				number += string.substring(i, j-1);		//Gets the substring of numbers, case first two sets, and adds it to the number
			else
				number += string.substring(i);			//Gets the substring of numbers, case last set, and adds it to the number
			
			i = j;
			
		}
		
		return number;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public String punctuationToWhiteSpace(String string)
	{
		char [] punctuationHandled = { ',', ';', '.', ':', '\n', '!', '?' };
		
		for (char ch : punctuationHandled)
			string = string.replace(ch, ' ');
		
		string = string.replace("  ", " ");
		
		return string;
	}
	
	public Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration
		int i = 0, j = 0;
		
		string = punctuationToWhiteSpace(string);
		
		String temp;
		Map<String, Integer> wordCount = new HashMap<>();
		while ( j != -1 )
		{
			j = string.indexOf(' ', i + 1);
			
			if ( j == -1 )
			{
				temp = string.substring(i);
			}
			else
			{
				temp = string.substring(i, j);
				i = j + 1;
			}
			
			if ( wordCount.containsKey(temp) )
				wordCount.replace(temp, wordCount.get(temp) + 1);
			else
				wordCount.put(temp, 1);
			
		}
		return wordCount;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			
			//An actual binary search algorithm, won't work because comparator operators not present for the template variable
//			int i = sortedList.size() / 2;
//			int j = 0, k = sortedList.size() - 1;
//			
//			while (k - j > 0)
//			{
//				if (t < sortedList.get(i))
//					k = i - 1;
//				else if (t > sortedList.get(i))
//					j = i + 1;
//				else return i;
//				
//				i = (k - j) / 2 + j;
//			}
//			
//			return -1;
			
			//Not the right answer for a BSA
			return sortedList.indexOf(t);
			
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		// TODO Write an implementation for this method declaration
		
		int i = 0;
		String temp = new String();
		
		if (isVowel(string.charAt(i)))
		{
			string = string + "ay";
		}
		else
		{
			while (!isVowel(string.charAt(i)))
				i++;
			
			temp = string.substring(i);
			temp += string.substring(0, i) + "ay"; 
		}
		
		return temp;
	}
	
	public boolean isVowel(char ch)
	{
		char [] vowels = { 'a', 'e', 'i', 'o', 'u' };
		for (int i = 0; i < 5; i++)
		{
			if (ch == vowels[i])
				return true;
		}
		return false;
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// TODO Write an implementation for this method declaration
		int length = 0, temp = input;
		
		while (temp / 10 != 0)			//Gets the digital length of the number
		{
			temp = temp / 10;
			length++;
		}
		
		int sum = 0;
		temp = input;
		
		for (int i = 0; i < length; i++)
		{
			sum += Math.pow((temp % 10), length);
			temp = temp / 10;
		}
		
		if (sum == input)
			return true;
		else
			return false;
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		// TODO Write an implementation for this method declaration
		long n = 2;
		List<Long> factors = new ArrayList<>();
		
		while (n <= l)
		{
			if (l % n == 0)
			{
				factors.add(n);
				l = l / n;
			}
			else
				n++;
		}
		return factors;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}
		static char [] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
				'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		static char [] Alphabet = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
				'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		
		public char charSwitch(char ch)
		{
			for (int i = 0; i < 26; i++)
				if (alphabet[i] == ch)
					return alphabet[(i+key) % 26];
			for (int i = 0; i < 26; i++)
				if (Alphabet[i] == ch)
					return Alphabet[(i+key) % 26];
			return ch;
		}

		public String rotate(String string) {
			// TODO Write an implementation for this method declaration
			String temp = "";
			
			for ( int i = 0; i < string.length(); i++ )
			{
				temp += charSwitch(string.charAt(i));
			}
			
			return temp;
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		// TODO Write an implementation for this method declaration
		if (i == 0)
			throw new IllegalArgumentException();
			
		if ( i == 1 )
			return 2;
		
		int n = 3, j = 2;
		while ( j < i )
		{
			j++;
			while (true)
			{
				n += 2;
				List<Long> factors = calculatePrimeFactorsOf((long)n);
				if (factors.size() == 1)
					break;
			}
		}
		
		return n;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		static char [][] cipher = { { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' },
				{ 'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n', 'm', 'l', 'k', 'j', 'i', 'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a' } };
		public static char charSwitch(char ch)
		{
			for (int i = 0; i < 26; i++)
				if (cipher[0][i] == ch)
					return cipher[1][i];
			return ' ';
		}
		
		public static String encode(String string) {
			// TODO Write an implementation for this method declaration
			String temp = "", encoded = "";
			
			string = string.toLowerCase();
			
			int i = 0, j = i;
			while ( i < string.length())
			{
				for (j = i + 5; i < j && i < string.length(); i++)
					if (charSwitch(string.charAt(i)) != ' ')
						temp += charSwitch(string.charAt(i));		//If it's an actual character, add it to the temp string
					else
						j++;										//If its a space, ignore it and make sure we're still going to get our five characters
																	//We increment j here because i increases every time and we need 5 characters, not four with a random space
				encoded += temp;
				if (i < string.length() - 1)
				{
					encoded += " ";
					temp = "";
				}
			}
			return encoded;
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			// TODO Write an implementation for this method declaration
			String temp1, temp2 = "", decoded = "";
			
			int i = 0, nextSpace;
			while (i < string.length())
			{
				nextSpace = string.indexOf(' ', i);
				temp1 = string.substring(i, nextSpace);
				
				for (int j = i; j < nextSpace; j++)
					temp2 += charSwitch(temp1.charAt(j));
				
				decoded += temp2;
				
				i = nextSpace + 1;
			}
			return decoded;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		// TODO Write an implementation for this method declaration
		
		int i = 0;
		int nextHyph = string.indexOf('-');
		String temp = "";
		
		while (nextHyph >= 0)
		{
			temp += string.substring(i, nextHyph);		//This starts putting the numeric-only characters into a temporary string
			i = nextHyph + 1;
			nextHyph = string.indexOf('-', i);
		}
		temp += string.substring(i);					//We do this, and even if we don't go through the while loop at all, it will take in the entirety of the remaining part of the string
		
		Map<Character, Integer> key = new HashMap<>();	//Here's the key we'll use to solve our ISBN troubles
		key.put('0', 0);
		key.put('1', 1);
		key.put('2', 2);
		key.put('3', 3);
		key.put('4', 4);
		key.put('5', 5);
		key.put('6', 6);
		key.put('7', 7);
		key.put('8', 8);
		key.put('9', 9);
		key.put('X', 10);
		key.put('x', 10);
		
		int sum = 0, tempi;
		
		for (i = 0; i < temp.length(); i++)
		{
			if (key.get(temp.charAt(i)) == null)
				return false;
			tempi = key.get(temp.charAt(i));
			sum += (10 - i) * tempi;
		}
		
		if (sum % 11 == 0)
			return true;
		else
			return false;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		// TODO Write an implementation for this method declaration
		string = string.toLowerCase();
		
		Map<Character, Boolean> key = new HashMap<>();
		
		for (int i = 97; i < 123; i++)						//Generate a key for the alphabet preset to all false
			key.put((char)i, false);
		
		for (int i = 0; i < string.length(); i++)
			if (key.containsKey(string.charAt(i)))
				key.replace(string.charAt(i), true);
		
		if (key.containsValue(false))
			return false;
		else
			return true;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration
		given = given.plus(1000000000, ChronoUnit.SECONDS);
		return given;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		// TODO Write an implementation for this method declaration
		
		List<Integer> guys = new ArrayList<>();
		
		for (int j = 0; j < set.length; j++)
			for (int k = set[j]; k < i; k += set[j])
				if (!guys.contains(k))
					guys.add(k);
		
		int sum = 0;
		for (int j : guys)
			sum += guys.get(j);
		
		return sum;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		// TODO Write an implementation for this method declaration
		
		String temp = "";
		int i = 0, j = string.indexOf(' ');
		
		while (j >= 0)
		{
			temp += string.substring(i, j);
			i = j + 1;
			j = string.indexOf(' ', i);
		}
		temp += string.substring(i);					//Removes all instances of the space character from the string and puts it into temp
		
		Map<Character, Integer> key = new HashMap<>();	//Here's the key we'll use to solve our string to number troubles
		key.put('0', 0);
		key.put('1', 1);
		key.put('2', 2);
		key.put('3', 3);
		key.put('4', 4);
		key.put('5', 5);
		key.put('6', 6);
		key.put('7', 7);
		key.put('8', 8);
		key.put('9', 9);
		
		int sum = 0, tempInt = 0;
		
		for (int k = 0; k < temp.length(); k++)
		{
			if (k % 2 == 1)
			{
				tempInt = 2 * key.get(temp.charAt(i));
				if (tempInt > 9)
					tempInt -= 9;
			}
			
			sum += tempInt;
		}
		
		if (sum % 10 == 0)
			return true;
		else
			return false;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	
	public String getNthWord(String string, int n)
	{
		int i = 0, j = string.indexOf(' '), k = 0;
		
		while (j >= 0)
		{
			if (k == n)										//Return the nth word, starting at zero
			{
				return string.substring(i, j);
			}

			i = j + 1;
			j = string.indexOf(' ', i);
			k++;
		}
		
		return string.substring(i);
	}
	
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration
		
		String operator, a, b;
		
		if (string.endsWith("?"))
			string = string.substring(0, string.length() - 1);
		
		a = getNthWord(string, 2);						//We know that this one is going to be the first operand
		operator = getNthWord(string, 3);				//Likewise, we know that this one is going to be teh second operand 
		
		Map<Character, Integer> key = new HashMap<>();	//Here's the key we'll use to solve our string to number troubles
		key.put('0', 0);
		key.put('1', 1);
		key.put('2', 2);
		key.put('3', 3);
		key.put('4', 4);
		key.put('5', 5);
		key.put('6', 6);
		key.put('7', 7);
		key.put('8', 8);
		key.put('9', 9);
		key.put('-', -1);
		
		b = getNthWord(string, 4);
		if (!key.containsKey(b.charAt(0)))				//Checking to make sure that we have the second number and not a word
			b = getNthWord(string, 5);
		
		int result, ia = 0, ib = 0, temp;
		
		for (int i = a.length() - 1, j = 0; i >= 0; i--, j++)		//We need to turn the stringy number into an inty number, start from LSB and work your way up
		{
			temp = key.get(a.charAt(i));
			if (temp >= 0)
				ia += temp * Math.pow(10, j);
			else
				ia *= temp;
		}
		
		for (int i = b.length() - 1, j = 0; i >= 0; i--, j++)
		{
			temp = key.get(b.charAt(i));
			if (temp >= 0)
				ib += temp * Math.pow(10, j);
			else
				ib *= temp;
		}	
		
		switch (operator)
		{
		case "plus":
			result = ia + ib;
			break;
		case "minus":
			result = ia - ib;
			break;
		case "multiplied":
			result = ia * ib;
			break;
		case "divided":
			result = ia / ib;
			break;
		default:
			System.out.println("Invalid operand");
			return 0;
		}
		
		return result;
	}

}









