package com.corejava.lambdaexp;

import java.util.function.Function;

public class FunctionEx {

	public static void main(String[] args) {

		Function<Integer, Integer> fun1 = (n)->(n+n);
		
		//Even Object of class can be passed as parameter
		System.out.println(fun1.apply(5));
		System.out.println(fun1.apply(15));
		System.out.println(fun1.apply(20));
		
		Function<Double, Double> fun2 = (n)->(Math.sqrt(n));
		
		System.out.println(fun2.apply(5.0));
		System.out.println(fun2.apply(25.0));
		
		Function<Integer, Integer> fun3 = (n)->(n*n);
		System.out.println("fun1 andThen fun3 (i.e. fun1(n+n)-->fun3(n*n)) :"+fun1.andThen(fun3).apply(5));
		
		//---
		System.out.println("fun1 composeOf fun3 (i.e. fun3(n*n)-->fun1(n+n) :"+fun1.compose(fun3).apply(5));
	}

}
