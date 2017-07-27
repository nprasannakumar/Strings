package com.test.questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
// checking for special characters : s.matches("[^A-Za-z0-9 ]");
public class ScratchPad {
	

	public static void main(String[] args){
		//twoSumProblem();
		
		//reverseAString();
		
		// need to change a bit of the implementation
		//checkIfStringIsPalindrome();
		
		
		//boolean isAnagram = checkIfTwoStringsAreAnagrams();
		//System.out.println("are these 2 strings anagrams : " +isAnagram);
		
		//boolean hasAllUnique = removeDuplicatesInAString();
		//System.out.println("string has duplicates? " +hasAllUnique);
		
		// return the first duplicate character in a string
		//char firstDuplicate = firstDuplicateCharacterInString();
		//System.out.println("first duplicate character is : " +firstDuplicate);
		
		//removeDuplicatesFromSortedIntegerArray();
		
		// TODO: code the remove duplicates from sorted integer array using 2 arrays/modifying existing one
		// TODO : palindrome
		// TODO : tree problem
		//reverseWordsInSentence();
		
		// is palidrome easier solution
		//boolean palindrome = isPalindrome();
		//System.out.println(palindrome);
		
		//int[] A = new int[]{10,20,20,30};
		//int[] B = removeDuplicates(A);
		//System.out.println(B);
		
		//char[] test = {'a'};
		//char charWithMaxCount = getMaxCountCharacter(test);
		//System.out.println(charWithMaxCount);
		
		permutation("abc");
		
		//char dup = firstDuplicateCharacterInString();
		//System.out.println("the first duplicate character is : " +dup);
		testSubstring();
	}
	
	public static int[] removeDuplicates(int[] A) {
		if (A.length < 2)
			return A;
	 
		int j = 0;
		int i = 1;
	 
		while (i < A.length) {
			if (A[i] == A[j]) {
				i++;
			} else {
				j++;
				A[j] = A[i];
				i++;
			}
		}
	 
		int[] B = Arrays.copyOf(A, j + 1);
	 
		return B;
	}

	private static boolean isPalindrome() {
		String str="nayana";
		char[] word = str.toCharArray();
		int i=0;
		int j = word.length - 1;
		while(j > i){
			if(word[i] != word[j]){
				return false;
			}
			++i;
			--j;
		}
		return true;
	}

	private static void reverseWordsInSentence() {
		// reverse order of the words in a string : expected output is "world Hello"
		String str = "Hello world";
		String[] words = str.split("\\s+");
		for(int i=words.length-1; i>=0; i--){
			System.out.print(words[i] + " ");
		}
	}

	private static void removeDuplicatesFromSortedIntegerArray() {
		// given a sorted array of integers, remove all duplicates
		// ask interviewer what should be returned?  : 
		int[] sortedNumbers = new int[]{2,3,4,5};
		HashSet<Integer> setOfUniqueIntegers = new HashSet<>();
		for(int i=0; i<sortedNumbers.length;i++){
			if(setOfUniqueIntegers.contains(sortedNumbers[i])){
				setOfUniqueIntegers.remove(sortedNumbers[i]);
			}
			else{
				setOfUniqueIntegers.add(sortedNumbers[i]);
			}
		}
		setOfUniqueIntegers.stream().forEach(i -> System.out.println(i));
	}

	// bug in this code : nayana // this will return a.. output is n 
	// ask the interviewer what to return if string length is greater than 128
	private static char firstDuplicateCharacterInString() {
		String str = "nna";
		if(str.length() > 128 || str.isEmpty() || str == null){
			return Character.MIN_VALUE;
		}
		boolean[] charset = new boolean[128];
		for(int i=0; i<str.length();i++){
			char val = str.charAt(i);
			if(charset[val]){
				//charset[val] = false;
				return val;
			}
			charset[val] = true;
		}
		return Character.MIN_VALUE;
	}

	// time complexity : O(n)
	// space complexity : O(1)
	// determine if a string has all unique characters
	private static boolean checkIfDuplicatesInAString() {
		// determine if a string has duplicates or not
		String str = "abcd";
		// if ever the string length is greater than 128, then it means that its not a unique 
		// string and return false. After all we cant form a string of 280 unique characters 
		// out of a 128 character alphabet.
		if(str.length() > 128){
			return false;
		}
		boolean[] charset = new boolean[128];
		for(int i=0; i<str.length();i++){
			int val = str.charAt(i);
			if(charset[val]){
				return false;
			}
			charset[val] = true;
		}
		return true;
	}
	
	/**
	 * Another way of doing it is, sort both strings and check if equal
	 * OR
	 * 
	 * @return
	 */
	private static boolean checkIfTwoStringsAreAnagrams() {
		// given 2 strings, check if they are anagrams or not
		// need to make sure, 2 words given are of the same length, capitilization and punctuation
		// ask about spaces?

		String test1 = "Mother In Law";
		String test2 = "Hitler Woman";
		
		if(test1 == null || test2 == null || test1.isEmpty() || test2.isEmpty()){
			return false;
		}
		
		char[] anagram1 = test1.replaceAll("\\s", "").toLowerCase().toCharArray();
		char[] anagram2 = test2.replaceAll("\\s", "").toLowerCase().toCharArray();
		
		if(anagram1.length != anagram2.length){
			return false;
		}
		Map<Character, Integer> mapOfAnagrams = new HashMap<>();
		for(int i=0; i<anagram1.length; i++){
			if(!mapOfAnagrams.containsKey(anagram1[i])){
				mapOfAnagrams.put(anagram1[i], 1);
			} else{
				mapOfAnagrams.put(anagram1[i], mapOfAnagrams.get(anagram1[i]) + 1);
			}
		}
		
		for(int j=0; j<anagram2.length;j++){
			if(mapOfAnagrams.containsKey(anagram2[j])){
				mapOfAnagrams.put(anagram2[j], mapOfAnagrams.get(anagram2[j]) -1 );
			}
		}
		
		for(Integer countOfChar : mapOfAnagrams.values()){
			if(countOfChar != 0){
				return false;
			}
		}
		return true;
	}

	private static void checkIfStringIsPalindrome() {
		// check if a string is palindrome
		String test = "madame";
		char[] parlindrome = test.toCharArray();
		int j = parlindrome.length - 1;
		for(int i=0; i<parlindrome.length/2; i++){
			if(parlindrome[i] == parlindrome[j]){
				j = j - 1;
			} else{
				System.out.println("No string is not a palindrome" +String.valueOf(parlindrome));
				break;
			}
		}
	}

	private static void reverseAString() {
		// reverse a string
		String test = "prashanth";
		if(test == null || test.isEmpty()){
			// do something
		}
		// check if string contains special characters
		
		char[] rev = test.toCharArray();
		int j = rev.length - 1;
		char[] temp = new char[rev.length];
		for(int i=0; i<rev.length/2; i++){
			temp[i] = rev[j];
			rev[j] = rev[i];
			rev[i] = temp[i];
			j = j-1;
		}
		System.out.println("the reversed string is " +String.valueOf(rev));
	}

	private static void twoSumProblem() {
		// two sum problem
		// testing this 
		// how to handle negative integers, ??
		// if 2 numbers are not found, what should be done?
		// 20, 30, 10, 50 target = 80
		// 60 0
		// 50 1
		// 70 2
		// 
		// eg : given {2,7,9,11} target = 9
		// find the indices of 2 numbers which add up to the target
		// -2, -3, 4, 5 target = 1
		// 3 0
		// 4 1
		// 1, 2 
		int[] numbers={2,7,9,15};
		int target = 9;
		Map<Integer, Integer> mapOfDiff = new HashMap<>();
		int[] result = new int[2];
		for(int i=0; i<numbers.length; i++){
			if(mapOfDiff.containsKey(numbers[i])){
				result[0] = mapOfDiff.get(numbers[i]);
				result[1] = i;
				System.out.println("print the index1 : " +result[0]+ "index2 : " +result[1]);
				System.out.println("number 1 is : " +numbers[result[0]]);
				System.out.println("number 2 is : " +numbers[result[1]]);
				break;
			}
			else{
				mapOfDiff.put(target - numbers[i], i);
			}
		}
	}
	
	
	// return character with most repitions



	public static char getMaxCountCharacter(char[] arrayWithRepititedCharacters){
		int max = 0;
		// is this correct?
		char characterWithMaxCount = '\0';
		Map<Character, Integer> mapOfCharacterToCount = new HashMap<Character, Integer>();
		if(arrayWithRepititedCharacters.length == 1){
			return arrayWithRepititedCharacters[0];
		}

		for(int i=0; i < arrayWithRepititedCharacters.length; i++){
			if(!mapOfCharacterToCount.containsKey(arrayWithRepititedCharacters[i])){
				mapOfCharacterToCount.put(arrayWithRepititedCharacters[i], 1);
			} else{
				mapOfCharacterToCount.put(arrayWithRepititedCharacters[i], mapOfCharacterToCount.get(arrayWithRepititedCharacters[i]) + 1);
			}
		}


		for(Map.Entry<Character, Integer> entry : mapOfCharacterToCount.entrySet()){
			int value = entry.getValue();
			if (!(max > value)){
				max = value;
				characterWithMaxCount = entry.getKey();
			}
		}
		return characterWithMaxCount;

	}
	
	public static void permutation(String str) { 
	    permutation("", str); 
	}

	/**
	 * iterate through this in the end
	 * @param prefix
	 * @param str
	 */
	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
	
	public static void testSubstring(){
		String str="test";
		System.out.println(str.substring(0, 0));
	}
	

}
