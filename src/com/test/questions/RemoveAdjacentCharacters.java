package com.test.questions;

import java.util.ArrayList;
import java.util.List;

public class RemoveAdjacentCharacters {
	public static void main(String[] args){
		removeAdjacent("abbbcc");
	}
	
	
	public static void removeAdjacent(String s){
		char[] test = s.toCharArray();
		List<Character> listOfUniques = new ArrayList<Character>();
		for(int i=0; i<test.length; i++){
			if(!listOfUniques.contains(test[i])){
				listOfUniques.add(test[i]);
			} else if(listOfUniques.get(listOfUniques.size()-1) != test[i]){
					listOfUniques.add(test[i]);
				}
			else{
				System.out.println("what is the value of i" +i);
				Character temp = listOfUniques.get(listOfUniques.size()-1);
				if(temp == test[i]){
					listOfUniques.remove(listOfUniques.size()-1);
				}
			}
		}
		
		char[] result = new char[listOfUniques.size()];
		for(int i=0; i< result.length; i++){
			result[i] = listOfUniques.get(i);
		}
		System.out.println(String.valueOf(result));
	}

}
