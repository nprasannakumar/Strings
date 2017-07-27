package com.test.questions;

import java.util.HashMap;
import java.util.Map;

public class FirstDuplicateCharacterInString {
	
	public static void main(String[] args){
		FirstDuplicateCharacterInString first = new FirstDuplicateCharacterInString();
		Character ch = first.firstDuplicateCharacter(null);
		System.out.println(ch);
	}

	public Character firstDuplicateCharacter(String str){
		if(str == null || str.isEmpty()){
			return Character.MIN_VALUE;
		}
		
	    char[] test = str.toCharArray();
	    Map<Character, Integer> mapOfCharToCount = new HashMap<Character, Integer>();
	    for(int i=0; i <test.length; i++){
	        if(mapOfCharToCount.containsKey(test[i])){
	            mapOfCharToCount.put(test[i], mapOfCharToCount.get(test[i]) + 1);
	        } else{
	            mapOfCharToCount.put(test[i], 1);
	        }
	    }

	    for(int i=0; i<test.length; i++){
	        if(mapOfCharToCount.get(test[i]) != 1){
	            return test[i];
	        }
	    }

	return Character.MIN_VALUE;
	}
}
