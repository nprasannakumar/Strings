package com.test.questions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FirstUniqueCharacter {
	
	public static void main(String[] args){
		FirstUniqueCharacter fu = new FirstUniqueCharacter();
		//Character ch = fu.firstUniqueCharacter("aaabcd");
		//System.out.println(ch);
		
		Character ch = fu.firstUniqueCharacterAnotherWay("");
		System.out.println(ch);
	}
	
	public Character firstUniqueCharacter(String str){
		
		
		Map<Character, HashMap<Integer, Integer>> mapOfCharToIndexAndCount = new HashMap<Character,
				HashMap<Integer, Integer>>();
		char[] temp = str.toCharArray();
		
		for(int i=0; i<temp.length; i++){
			if(!mapOfCharToIndexAndCount.containsKey(temp[i])){
				HashMap<Integer, Integer> mapOfIndexToCount = new HashMap<Integer, Integer>();
				mapOfIndexToCount.put(i, 1);
				mapOfCharToIndexAndCount.put(temp[i], mapOfIndexToCount);
			}else{
				HashMap<Integer, Integer> map = mapOfCharToIndexAndCount.get(temp[i]);
				for(Integer index : map.keySet()){
					int count = map.get(index) + 1;
					map.put(index, count);
				}
				mapOfCharToIndexAndCount.put(temp[i], map);
			}
		}
		
		for(HashMap<Integer, Integer> map : mapOfCharToIndexAndCount.values()){
			for(Integer index : map.keySet()){
				if(map.get(index) == 1){
					return temp[index];
				}
			}
		}
//		for(Integer index : mapOfIndexToCount.keySet()){
//			if(mapOfIndexToCount.get(index) == 1){
//				return temp[index];
//			}
//		}
		
		return Character.MIN_VALUE;
	}
	
	// what I had thought of
	public Character firstUniqueCharacterAnotherWay(String str){
		
		if(str == null || str.isEmpty()){
			return Character.MIN_VALUE;
		}
		char[] temp = str.toLowerCase().toCharArray();
		Map<Character, Integer> mapOfCharacterToCount = new HashMap<Character, Integer>();
		for(int i=0; i<temp.length;i++){
			if(!mapOfCharacterToCount.containsKey(temp[i])){
				mapOfCharacterToCount.put(temp[i], 1);
			}else{
				mapOfCharacterToCount.put(temp[i], mapOfCharacterToCount.get(temp[i])+1);
			}
		}
		
		for(int i=0; i<temp.length;i++){
			int count = mapOfCharacterToCount.get(temp[i]);
			if(count == 1){
				return temp[i];
			}
		}
		return Character.MIN_VALUE;
		
		
	}

}
