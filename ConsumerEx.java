package com.corejava.lambdaexp;

import java.util.function.Consumer;

public class ConsumerEx {

	public static void main(String[] args) {

		Consumer<Integer> con1 = (n)->System.out.println(" "+n*n);
		Consumer<Integer> con2 = (n)->System.out.println(" "+(n+n));
		Consumer<Integer> con3 = (n)->System.out.println(" "+n*3);
		
		con1.accept(5);
		con2.accept(5);
		con3.accept(5);
		
		System.out.println("----------------------------");
		con1.andThen(con2).andThen(con3).accept(5);
		
		Consumer<Integer> con4 = con1.andThen(con2).andThen(con3);
		
		System.out.println("----------------------------");
		con4.accept(5);

	}

}
