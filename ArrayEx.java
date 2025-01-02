package com.corejava.Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ArrayEx {

	public static void main(String[] args) {

		ArrayEx arrEx = new ArrayEx();
		System.out.println("============================================================================");
		arrEx.rotateArr();
		System.out.println("============================================================================");
		arrEx.rotateArr1();
		System.out.println("============================================================================");
		arrEx.majorityInArr();
		System.out.println("============================================================================");
		arrEx.uniqueEleInBothArr();
	}



	public void rotateArr() {
		int[] arr = new int[] { 0, 1, 2, 3, 4, 5, 6, 7 };
		int d = 4, arrLen = arr.length;
		displayArr(arr);
		int[] temp = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };

		for (int i = 0; i < arr.length; i++) {
			if (i >= d) {
				temp[i - d] = arr[i];
			} else {
				int index = (arrLen - d) + i;
				temp[index] = arr[i];
			}
		}
		displayArr(temp);
	}

	public void rotateArr1() {
		int[] arr = new int[] { 0, 1, 2, 3, 4, 5, 6, 7 };
		displayArr(arr);
		System.out.println("----------------------");
		for (int i = 0; i < 4; i++) {
			rotateBy(arr);
		}
	}

	public static void rotateBy(int[] arr) {
		int tempH = arr[0];
		for (int i = 0; i < arr.length - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[arr.length - 1] = tempH;
		displayArr(arr);
	}

	public static void displayArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}

		System.out.println();
	}

	public void majorityInArr() {
		int arr[] = { 3, 3, 4, 2, 4, 4, 2, 4, 4, 1 };
		displayArr(arr);
		Map<Integer, Integer> mp = new LinkedHashMap<Integer, Integer>();
		// Map<Integer,Integer> mp = new TreeMap<Integer,Integer>();
		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					count++;
				}
			}
			mp.put(arr[i], count);
		}

		System.out.println(mp);
		Set<Integer> listMp = mp.keySet();

		System.out.println("Map content with occurences of Keys");
		for (Integer integer : listMp) {
			System.out.println(integer+"="+mp.get(integer));
			if (mp.get(integer) >= arr.length / 2) {
				System.out.println("Majority Value :" + integer);
			}
		}
		
		//---
		
		ArrayList<Integer> aa = new ArrayList<Integer>();
		for (Integer integer : arr) {
			aa.add(integer);
		}
		 
		LinkedHashMap<Integer, Integer> h = new LinkedHashMap<Integer, Integer>();

	        // counting occurrence of numbers
	        for (int i = 0; i < aa.size(); i++) {
	            h.put(aa.get(i), Collections.frequency(aa, aa.get(i)));
	        }
	        System.out.println(h);
	}
	
	public void uniqueEleInBothArr() {

		Integer[] arr1 = {2,4,1,5,6};
		Integer[] arr2 = {5,4,8,5,6,5,4,6};
		
		ArrayList<Integer> al1 = new ArrayList<Integer>();	
		ArrayList<Integer> al2 = new ArrayList<Integer>();
		
		Collections.addAll(al1, arr1);
		
		Collections.addAll(al2, arr2);
		
		for(int i=0;i<arr1.length;i++) {
			int freq = Collections.frequency(al2, arr1[i]);
			if( freq == 0) {
				System.out.println(arr1[i]+" doesn't find");
			}else {
				System.out.println(arr1[i]+" occurs "+freq +" times");
			}
		}
		
	}
	
}
