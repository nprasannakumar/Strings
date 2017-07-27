package com.test.questions;

import java.util.Stack;

public class StringCompression {
	
	public static void main(String[] args){
		String test = "abcddd";
		//String result = stringCompression(test);
		//System.out.println("compressed string is : " +result);
		
		String x = anotherApproachStringCompression(test);
		System.out.println(x);
	}

	private static String stringCompression(String test) {
		StringBuffer sb = new StringBuffer();
		Stack<Character> stack = new Stack<Character>();
		char[] temp = test.toCharArray();
		int count = 0;
		for(int i=0; i<temp.length;i++){
			if(stack.isEmpty()){
				stack.add(temp[i]);
				count += 1;
			}else{
				Character e = stack.peek();
				if(e == temp[i]){
					count +=1;
				}else{
					Character poppedElement = stack.pop();
					sb.append(poppedElement);
					if(count != 1){
						sb.append(count);
					}
					count = 1;
					stack.add(temp[i]);
				}
			}
		}
		sb.append(stack.pop());
		if(count != 1){
			sb.append(count);
		}
		return sb.toString();
	}
	
	private static String anotherApproachStringCompression(String str){
		String test = "";
		int count = 0;
		for(int i=0; i<str.length();i++){
			count+=1;
			
			if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)){
				test += "" +str.charAt(i)+count;
				count = 0;
			}
		}
		System.out.println(test.length());
		System.out.println(str.length());
		return test;
	}

}
