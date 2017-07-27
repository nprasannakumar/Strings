package com.test.questions;

import java.util.HashSet;
import java.util.Set;

public class SubstringPalindrome {
	
	static String in = "aa";

	public static void main(String[] args){
		findSubstringOfString("abc");
		//substrings(0, 1);
	}

	// nsquare
	// substring is n2
	// add to set is 1
	// go over every string to find if palindrome is n
	// n3?
	private static void findSubstringOfString(String str) {
		int countOfPalindromes = 0;
		Set<String> uniqueSubstrings = new HashSet<String>();
		for(int i=0; i<str.length(); i++){
			for(int j=i+1; j<=str.length(); j++){
				System.out.println(str.substring(i, j));
				uniqueSubstrings.add(str.substring(i, j));
			}
		}
		
		for(String substring : uniqueSubstrings){
			boolean isPalindrome = isPalindrome(substring);
			if(isPalindrome){
				countOfPalindromes +=1;
			}
		}
		System.out.println("count of palindromes : " +countOfPalindromes);
	}
	
	private static boolean isPalindrome(String str) {
			System.out.println("str is : "+str);
			char[] temp = str.toCharArray();
			int i=0;
			int j = temp.length-1;
			
			if(str == null || str.isEmpty()){
				return false;
			}
			
			if(str.length() == 1){
				return true;
			}
			while(j > i){
				if(temp[i] != temp[j]){
					return false;
				}
			i++;
			j--;
			}
			return true;
		}

	// another approach
	private static void substrings(int start, int end){
        if(start == in.length() && end == in.length()){
            return;
        }else{
            if(end == in.length()+1){
                substrings(start+1,start+1);
            }else{
                System.out.println(in.substring(start, end));
                substrings(start, end+1);
            }
        }
    }
}
