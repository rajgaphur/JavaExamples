package com.corejava.enumurations;

public enum Apple {
	
	Jonathan("1","One"),
	GoldenDel("2","Two"),
	RedDel("3","Three"),
	Cortland("4","Four");

	public String price, Name;
	
	Apple(String string, String string2) {
		price = string;
		Name = string2;
	}

	void display() {
		System.out.println(price +" "+ Name);
	}
	
	
}
