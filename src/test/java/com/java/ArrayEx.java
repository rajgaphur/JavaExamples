package com.java;

import java.util.Arrays;

public class ArrayEx {

	public static void main(String[] args) {
		
		ArrayEx ae = new ArrayEx();

		ae.reverseInArr();
	}

	public void reverseInArr() {
		int[] intArr = {12,34,54,31,61,26,15};
		
		System.out.println(Arrays.toString(intArr));
		for(int i=0;i<intArr.length/2;i++) {
			int temp = intArr[i];
			intArr[i] = intArr[intArr.length - 1 - i];
			intArr[intArr.length - 1 - i] = temp;
			
		}
		System.out.println(Arrays.toString(intArr));
	}
}
