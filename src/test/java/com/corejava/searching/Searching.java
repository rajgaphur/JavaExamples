package com.corejava.searching;

public class Searching {

	public static void main(String[] args) {

		Searching se = new Searching();
		se.binarySearch();
		System.out.println("============================================================================");
		se.linearSearch();
		System.out.println("============================================================================");
		se.ternarySearch();
	}
	
	public void binarySearch() {
		int arr[] = { 2, 3, 4, 10, 40 };
		int val = 10;
		int low = 0, high = arr.length;
		boolean found = false;
		while(low<=high) {
			int mid = (low+high)/2;
			if(val==arr[mid]) {
				found = true;
				break;
			}else if(val>arr[mid]) {
				low = mid+1;
			}else {
				high = mid-1;
			}
			
		}
		if(found) {
			System.out.println("Binary Search found");
		}else{
			System.out.println("Binary Search Not Found:");
		}
		
	}
	public void linearSearch() {
		int arr[] = { 15, 3, 2, 10, 40 };
		int val = 10;
		boolean found = false;
		for (int i = 0; i < arr.length; i++) {
			if(val == arr[i]) {
				found = true;
				break;
			}
		}
		if(found) {
			System.out.println("Linear Search found");
		}else{
			System.out.println("Linear Search Not Found:");
		}
		
	}

	public void ternarySearch() {
		int arr[] = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610};
		int val = 55, foundIndex = 0;
		int jumpVal = (int) Math.floor((int) Math.sqrt(arr.length));
		int low = 0, high = arr.length;
		boolean found = false;
		for (int i = 0; i < arr.length; i+=jumpVal) {
			if(arr[i]==val) {
				found  = true;
				foundIndex = i;
				break;
			}else if(arr[i]>val) {
				high = i;
				low = i - jumpVal;
			}
		}
		
		
		for (int j = low; j < high; j++) {
			if(val == arr[j]) {
				found = true;
				foundIndex = j;
				break;
			}
		}
		if(found) {
			System.out.println("Ternary Search found at position "+foundIndex);
		}else{
			System.out.println("Ternary Search Not Found:");
		}	
	}
}
