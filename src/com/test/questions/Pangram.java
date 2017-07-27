package com.test.questions;

public class Pangram {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution.
        */
        //Scanner scanner = new Scanner(System.in);
//        String str = "We promptly judged antique ivory buckles for the prize";
//        
//        if(str==null || str.isEmpty()){
//            System.out.println("not pangram");
//        }
//        
//        Map<Character, Boolean> mapOfCharIsVisited = new HashMap<Character, Boolean>();
//        char[] test = str.replaceAll("\\s", "").toCharArray();
//        for(int i=0; i<test.length; i++){
//        	System.out.println(test[i]);
//            if(!mapOfCharIsVisited.containsKey(test[i])){
//                mapOfCharIsVisited.put(test[i], true);
//            }
//        }
//        
//        Set<Character> keys = mapOfCharIsVisited.keySet();
//        System.out.println(keys.size());
//        if(keys.size() == 26){
//            System.out.println("pangram");
//        }
//        else{
//            System.out.println("not pangram");
//        }
		isPangram("We promptly judged antique ivory buckles for the next prize");
        
    }
	
	public static void isPangram(String str){
		int[] pangram = new int[26];
		char[] test = str.toLowerCase().replaceAll("\\s+", "").toCharArray();
		System.out.println(test.length);
		for(int i=0; i<test.length; i++){
			char val = test[i];
			int ascii = (int)val;
			int result = ascii - (int)'a';
			if(pangram[result] == 0){
				pangram[result] +=1;
			}
		}
		for(int i=0; i<pangram.length;i++){
			if(pangram[i] != 1){
				System.out.print("Not a Pangram");
				//System.exit(1);
				return;
			}
		}
		System.out.print("is pangram");
	}
}
