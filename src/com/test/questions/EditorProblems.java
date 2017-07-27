package com.test.questions;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EditorProblems {
	
	public static void main(String[] args){
		String str = "test";
		//String reverse = reverseAString(str);
		//System.out.println("reversed string is : " +reverse);
		
		//String reverse = reverseAStringAnotherWay(null);
		//System.out.println("reversed string is : " +reverse);
		
		//boolean palindrome = isPalindrome(null);
		//System.out.println("is it a palindrome : " +palindrome);
		
		//boolean isAnagram = AreAnagrams("parrot,ed", "pred,ator");
		//System.out.println("are they anagrams? " +isAnagram);
		int[] numbers = new int[]{10, 20, 30, 40};
		int target = 50;
		int result[] = twoSumProblem(numbers, target);
		System.out.println("the result is : " +result[0]+ " "+result[1]);
	}
	
	public static String reverseAString(String str){
		char[] temp= new char[str.length()];
		if( str== null ){
			// ask the interviewer : or what if interviewer asks what would u do in this scenario
			return null;
		}
		char[] rev = str.toCharArray();
		int j = rev.length - 1;
		for(int i=0; i<rev.length/2; i++){
			temp[i] = rev[i];
			rev[i] = rev[j];
			rev[j] = temp[i];
			j = j-1;
		}
		return String.valueOf(rev);
	}
	
	public static String reverseAStringAnotherWay(String str){
		if(str == null){
			// ask the interviewer : or what if interviewer asks what would u do in this scenario
			return null;
		}
		if(str.isEmpty()){
			return "";
		}
		if(str.length() == 1){
			return str;
		}
		char[] temp = new char[str.length()];
		char[] rev = str.toCharArray();
		int i = 0;
		int j = rev.length - 1;
		while(j > i){
			temp[i] = rev[i];
			rev[i] = rev[j];
			rev[j] = temp[i];
			i++;
			j--;
		}
		return String.valueOf(rev);
	}
	
	// check if a string is a palindrome
	public static boolean isPalindrome(String str){
	  if(str == null || str.isEmpty()){
	  	return false;
	  }
	  if(str.length() == 1){
		return true;
	  }
	  char[] palindrome = str.toCharArray();
	  int i=0;
	  int j = palindrome.length - 1;
	  while(j > i){
	  	if(palindrome[i] != palindrome[j]){
	  		return false;

	  	}
  		i++;
  		j--;
	  	}
	  return true;
	}
	
	// check if 2 strings are anagrams
	//example :  The earthquakes, That queer shake
	// anagram is a word formed from another word by rearranging the letters of the original word
	// strings with same characters, length. ignore space, punctuation and capitilization
	// always ask about special characters
	public static boolean AreAnagrams(String str1, String str2){
		if(str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0){
			return false;
		}
		// replace all non word characters with ""
		char[] anagram1 = str1.replaceAll("[\\W]", "").toLowerCase().toCharArray();
		char[] anagram2 = str2.replaceAll("[\\W]", "").toLowerCase().toCharArray();
		if(anagram1.length != anagram2.length){
			return false;
		}

		Map<Character, Integer> mapOfCharacterToCount = new HashMap<Character, Integer>();
		for(int i=0; i<anagram1.length; i++){
			if(!mapOfCharacterToCount.containsKey(anagram1[i])){
				mapOfCharacterToCount.put(anagram1[i], 1);
			}
			else{
				mapOfCharacterToCount.put(anagram1[i], mapOfCharacterToCount.get(anagram1[i])+ 1);
			}
		}

		// iterate through the second string to reduce the count
		for(int i=0; i<anagram2.length; i++){
			if(mapOfCharacterToCount.containsKey(anagram2[i])){
				mapOfCharacterToCount.put(anagram2[i], mapOfCharacterToCount.get(anagram2[i]) - 1);
			}
		}

		Collection<Integer> anagramValues = mapOfCharacterToCount.values();
		for(Integer count : anagramValues){
			if(count != 0){
				return false;
			}
		}
		return true;

	}
	
	
	//int[] numbers = new int[]{10, 20, 30, 40};
	//int target = 50;
	public static int[] twoSumProblem(int[] numbers, int sum){
		Map<Integer, Integer> mapOfNumberToIndex = new HashMap<Integer, Integer>();
		int[] result = new int[2];
		int[] actual = new int[2];
		for(int i=0; i<numbers.length; i++){
			if(mapOfNumberToIndex.containsKey(numbers[i])){
				result[0] = mapOfNumberToIndex.get(numbers[i]);
				result[1] = i;
				actual[0]=numbers[result[0]];
				actual[1]=numbers[result[1]];
				return actual;
			}else{
				mapOfNumberToIndex.put(sum-numbers[i], i);
			}
		}
		return actual;
	}

}
