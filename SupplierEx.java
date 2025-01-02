package com.corejava.lambdaexp;

import java.util.Date;
import java.util.function.Supplier;

public class SupplierEx {

	public static void main(String[] args) {
		
		Supplier<Double> sup1 = ()-> (Math.PI);
		System.out.println(sup1.get());

		Supplier<Date> sup2 = ()-> new Date();
		System.out.println(sup2.get());
	}

}
