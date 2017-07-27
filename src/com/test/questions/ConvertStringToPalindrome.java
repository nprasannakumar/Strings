package com.test.questions;

public class ConvertStringToPalindrome {
	// find the shortest palindrome that one can create from S by by adding 0 or more characters in front of it. 
	//For example the shortest palindrome can be constructed from 'baaa' is 'aaabaaa'. 
	public static void main(String[] args){
		String str = "pr";
		String palindrome = convertStringToPalindrome(str);
		System.out.println(palindrome);
		
		// another approach 
		//String palindrome = convertStrToPalindrome(str);
		//System.out.println(palindrome);
	}
	
	private static String convertStrToPalindrome(String str) {
		// need to see how to create an array of double the size of the string 
		// you cannot resize the array once created
		int length = str.length() * 2;
		char[] temp = new char[length-1];
		temp = str.toCharArray();
		int j=0;
		for(int i=temp.length; i>0; i--){
			temp[j] = temp[i];
			j++;
		}
		while(checkPalindrome(String.valueOf(temp))){
			return String.valueOf(temp);
		}
		return null;
	}

	// there is a reason why we check on every iteration if it is a palindrome as we
	// are trying to create the shortest palindrome here
	public static String convertStringToPalindrome(String str){
		if(str == null){
			return null;
		}
		
		if(str.length() == 1){
			return str;
		}
		
		String prefix = "";
		int i = str.length() - 1;
		while(!checkPalindrome(prefix + str)){
			prefix = prefix + str.charAt(i);
			i--;
		}
		return prefix + str;
	}
	
	public static boolean checkPalindrome(String str){
	  int i=0;
	  int j=str.length()-1;
	  while(j > i){
		  if(str.charAt(i) != str.charAt(j)){
			  return false;
		  }
	   i++;
	   j--;
	  }
	  return true;
	}
	
	public boolean isPrime(int n){
		if(n%2==0){
			return false;
		}
		
		for(int i=3; i*i<=n;i=i+2){
			if(n%i == 0){
				return false;
			}
		}
		return true;
	}

}
