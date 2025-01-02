package com.corejava.lambdaexp;

import java.util.function.Predicate;


public class PredicateEx {

	public static void main(String[] args) {

		Predicate<Integer> p = (i)->(i>=10);
		//Even Object of class can be passed as parameter
		System.out.println(p.test(7));
		System.out.println(p.test(13));
		
		Predicate<String> p1 = string->(string.length()>10);
		System.out.println(p1.test("Welcome"));
		System.out.println(p1.test("Welcome to home"));
		
		
		int[] arr = {5,10,15,20,25,30,35,40,45,50};
		
		Predicate<Integer> pd1 = (i)->(i%2==0);
		
		Predicate<Integer> pd2 = (i)->(i>=35);
		
		for (int j : arr) {
			System.out.print(j+ " ");			
		}
		System.out.println();
		//if(pd1.test(j) && pd2.test(j))
		for (int j : arr) {
			if(pd1.test(j) && pd2.test(j)) {
				System.out.print(j+ " ");
			}
		}
		System.out.println();
	
		//if(pd1.and(pd2).test(j))
		for (int j : arr) {
			if(pd1.and(pd2).test(j)) {
				System.out.print(j+ " ");
			}
		}
		System.out.println();
		
		//if(pd1.or(pd2).test(j))
		for (int j : arr) {
			if(pd1.or(pd2).test(j)) {
				System.out.print(j+ " ");
			}
		}
		System.out.println();
		
		Predicate<Integer> pd3 = a-> a<Math.PI;
		System.out.println("Is true? - "+pd3.test(4));
		
		
	}

}
