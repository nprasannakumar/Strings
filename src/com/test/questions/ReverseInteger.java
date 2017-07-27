package com.test.questions;

public class ReverseInteger {
	
	public static void main(String[] args){
		int x = reverse(123);
		System.out.println(x);
	}
	
	public static int reverseWorkingnot(int x) {
       String str = String.valueOf(x);
       char[] temp = str.toCharArray();
       char[] rev = new char[temp.length];
       int i=0;
       int j=temp.length-1;
       while(j > i){
    	   rev[i] = temp[i];
    	   temp[i] = temp[j];
    	   temp[j] = rev[i];
           i++;
           j--;
       }
       String result = String.valueOf(temp);
       int reversed = Integer.parseInt(result);
       return reversed;
    }
	
	public static int reverse(int x) {
        long rev= 0;
        while( x != 0){
        	long y = rev*10;
        	int z = x%10;
            rev= y + z;
            x= x/10;
            if( rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
                return 0;
        }
        return (int) rev;
    }
	
	public static int reverseOf(int x)
	{
	    int result = 0;

	    while (x != 0)
	    {
	        int tail = x % 10;
	        int newResult = result * 10 + tail;
	        if ((newResult - tail) / 10 != result)
	        { return 0; }
	        result = newResult;
	        x = x / 10;
	    }

	    return result;
	}
	
	

}
