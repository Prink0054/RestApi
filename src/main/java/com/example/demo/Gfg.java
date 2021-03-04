package com.example.demo;

import java.util.Arrays;
import java.util.List;

public class Gfg {

	static void getdata(int a[]) {
		
		int low = 0;
		int high = a.length-1;
    	while(low < high)
    	{
    		int temp = a[low];
    		a[low]	= a[high];
    		a[high] = temp;
    		low++;
    		high--;
    	}
    	
for (int i = 0; i < a.length; i++) {
	System.out.println(a[i]);
}
	}
	public static void main(String[] args) {
	
	
		int a[] =  {10,15,25,5,34,1,2};
		getdata(a);
		
		
	}
	
	
	
	
}
