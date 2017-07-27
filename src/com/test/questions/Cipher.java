package com.test.questions;

import java.util.Scanner;

public class Cipher {

	    public static void main(String[] args) {
	        //Scanner in = new Scanner(System.in);
	        //int n = in.nextInt();
	        //String s = in.next();
	        //int k = in.nextInt();
	    	String s = "zzzz";
	        //int newCharPosition = 0;
	    	int k = 100;

	        
	        char[] result = new char[11];
	        char[] test = s.toCharArray();
	        for(int i=0; i< s.length(); i++){
		    	char value = Character.MIN_VALUE;
	            char c = s.charAt(i);
	            if(Character.isLetter(c)){
	                int ascii = c;
	                int charPosition = ascii + k;
	                value = (char) charPosition;
	                if(charPosition > 90 && charPosition < 97){
	                    int diff = charPosition - 90;
	                    int asciiOfC = 64 + diff;
	                    value = (char) asciiOfC;
	                    //System.out.print(resetValue);
	                } else if(charPosition > 122){
	                    int diff = charPosition - 122;
	                    int asciiOfC = 96 + diff;
	                    value = (char) asciiOfC;
	                    //System.out.print(resetValue);
	                } 
	            }
	            else{
	                System.out.print(c);
	            }
	            System.out.print(value);
	        }
	    }
	}

