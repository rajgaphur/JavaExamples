package com.corejava.sorting;

import java.util.Arrays;

import com.corejava.strings.StringEx1;

public class SortingEx {

	public static void main(String[] args) {

		SortingEx ex = new SortingEx();
		ex.searchKeyPos();
		System.out.println("============================================================================");
		ex.leftAndRightMostIndex();
		System.out.println("============================================================================");
		ex.bitonicPoint();
		System.out.println("============================================================================");
		ex.sortStrChars();
		System.out.println("============================================================================");
		ex.bubbleSort();
		System.out.println("============================================================================");
		ex.linearSort();
		System.out.println("============================================================================");

	}
	
	public void searchKeyPos() {
		/*
		 * Input: arr[] = {1, 3, 5, 6}, K = 5
		Output: 2
		Explanation: Since 5 is found at index 2 as arr[2] = 5, the output is 2.

		Input: arr[] = {1, 3, 5, 6}, K = 2
		Output: 1
		Explanation: Since 2 is not present in the array but can be inserted at index 1 to make the array sorted.
		 */
		
		int arr[] = {1, 3, 5, 6};
		int key = 5;
		int insert = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==key) {
				System.out.println("Key found at position "+ i);
				break;
			}else if(arr[i]>key) {
				insert = i;
				System.out.println("Can be inserted at index "+ i);
				break;
			}
		}
	}
	
	public void leftAndRightMostIndex() {
		//Left most and right most index
		/*
		 * 
		 * Input : arr[] = {1, 3, 5, 5, 5, 5, 67, 123, 125}, x = 5
Output : First Occurrence = 2
              Last Occurrence = 5

Input : arr[] = {1, 3, 5, 5, 5, 5, 7, 123, 125 }, x = 7

Output : First Occurrence = 6
              Last Occurrence = 6

Recommended Problem
		 */
		int arr[] = {1, 3, 5, 5, 5, 5, 67, 123, 125};
		int x = 5, first = -1, last = -1;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] != x)
				continue;
			if(first == -1)
				first = i;
			last = i;
		}
		
		if(first != -1) {
			System.out.println("First occurence : "+first);
			System.out.println("Last occurence : "+last);
		}
		else
			System.out.println("Not found");
	}

	public void bitonicPoint() {
		/*
		 * 
		 * A Bitonic Sequence is a sequence of numbers which is first strictly increasing then after a point strictly decreasing.
		 * Input : arr[] = {6, 7, 8, 11, 9, 5, 2, 1}
			Output: 11
		 */
		int arr[] = {6, 7, 8, 11, 12, 5, 2, 1};
		int bitonicPointVal = 0;
		for (int i = 0; i < arr.length-1; i++) {
			
			if(arr[i]<arr[i+1]) 
				continue;
			else {
				bitonicPointVal = arr[i];
				break;
			}
		}
		
		System.out.println("Bitonic Point : "+ bitonicPointVal);
	}
	
	public void sortStrChars() {
		
		String str = "HIWORLD";
		
		char[] chArr = str.toCharArray();
		
		System.out.println("Using Arrays.sort method");
		char[] sortedArr = str.toCharArray();
		Arrays.sort(sortedArr);
		System.out.println(sortedArr);
		
		System.out.println("Using Normal method");
		int ch1, ch2;		char tempChar;
		for (int i = 0; i < chArr.length; i++) {
			for (int j = 0; j < chArr.length-1; j++) {
				ch1 = chArr[i];
				ch2 = chArr[j];
				if(ch1 < ch2) {
					tempChar = chArr[j];
					
					chArr[j] = chArr[i];
					
					chArr[i] = tempChar;
				}
			}
			
		}
		
		System.out.println("SortedStrChars");
		System.out.println(chArr);
	}
	
	public void bubbleSort() {
		int arr[] = {6, 7, 8, 11, 12, 5, 2, 1};
		int temp = 0;
		for (int i = 0; i < arr.length-1; i++) {
			
			for (int j = i; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}	
		}
		displayArr(arr);
	}
	
	public void linearSort() {
		int arr[] = {6, 7, 26, 11, 12, 5, 7, 1, 3};
		int n = arr.length;
		for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
		displayArr(arr);
	}
	
	public void displayArr(int[] ar){
		
		System.out.println("Array contents");
		for(int i =0;i <ar.length;i++) {
			System.out.print(ar[i]+" ");
		}
		System.out.println();
	}
}
