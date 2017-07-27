package com.test.questions;

import java.util.Scanner;

public class CamelCase {
	
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        String s = "saveChangesInTheEditor";
	        if(s==null || s.isEmpty()){
	            System.out.println(0);
	        }
	        
	        if(Character.isUpperCase(s.charAt(0))){
	            System.out.println(0);
	        }
	        
	        int countOfWords = 1;
	        for(Character c : s.toCharArray()){
	            if(Character.isUpperCase(c)){
	                countOfWords++;
	            }
	        }
	        System.out.println(countOfWords);
	    }

}
