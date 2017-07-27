package com.test.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GroupAnagrams {
	
	public static void main(String[] args){
		String[] test = new String[]{"cat", "act", "tac", "dog", "god"};
		groupAnagrams(test);
	}

	// time complexity : 
	// if length of each very is m and length of array is n then time complexity is O(m*n)
	public static void groupAnagrams(String[] args){
		Map<String, ArrayList<String>> mapOfAnagrams = new HashMap<String, ArrayList<String>>();
		for(String str : args){
			char[] temp = new char[26];
			for(int i=0; i<str.length();i++){
				//temp[i] = str.charAt(i);
				temp[str.charAt(i) - 'a'] = str.charAt(i);
			}
			String test = new String(temp);
			System.out.println(test);

			if(mapOfAnagrams.containsKey(test)){
				ArrayList<String> list = mapOfAnagrams.get(test);
				list.add(str);
				mapOfAnagrams.put(test, list);
			}else{
				ArrayList<String> listOfAnagrams = new ArrayList<String>();
				listOfAnagrams.add(str);
				mapOfAnagrams.put(test, listOfAnagrams);
			}
		}

		//List<String> listsOfAnagrams = mapOfAnagrams.values();
		for(ArrayList<String> list : mapOfAnagrams.values()){
			for(String str : list){
				System.out.println(str);
				System.out.println("/n");
			}
		}

	}
}
