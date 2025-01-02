package com.corejava.lambdaexp;

import java.util.function.Predicate;

@FunctionalInterface
interface Cab {
	public void display(int a, int b);
	//public void display1(int a, int b);
	static void m1() {
		
	}
	static void m2() {
		
	}
}

interface Car {
	public void disp(int a); 
	public void disp1(int b);
}

public class LambdaExp1 {

	public static void main(String[] args) {
	
		Cab cab = (a,b)-> System.out.println(a*b);
		cab.display(5, 10);

		Predicate<Integer> p = (i)->(i>=10);
		System.out.println(p.test(7));
		System.out.println(p.test(13));
		
		Predicate<String> p1 = string->(string.length()>10);
		System.out.println(p1.test("Welcome"));
		System.out.println(p1.test("Welcome to home"));
		
		//Car car = (a) -> System.out.println(a);
		//car.disp(5);
	}

}
