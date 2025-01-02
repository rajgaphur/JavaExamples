package com.corejava.strings;
	
import java.nio.charset.Charset;
import java.util.Scanner;

public class StringEx2 {

	public static void main(String[] args) {

		StringEx2 ex = new StringEx2();

		ex.revString();
		System.out.println("============================================================================");
		ex.booleanArr();
		System.out.println("============================================================================");
		ex.upperCaseFirstLetter();
		System.out.println("============================================================================");
		ex.ASCHII();
		System.out.println("============================================================================");
		ex.charSetList();
		System.out.println("============================================================================");
		//combination of 3 unique digits from (1, 2, 3, 4)
		ex.combination();
		System.out.println("============================================================================");
		//counting numbers, spaces, letters others
		ex.countChars();
		System.out.println("============================================================================");
		//System properties related to java installation
		ex.javaProperties();
		System.out.println("============================================================================");
		ex.image1();
		System.out.println("============================================================================");
		ex.americanFlag();
		System.out.println("============================================================================");
		ex.displayJava();
		System.out.println("============================================================================");
		ex.displayJava2();
		System.out.println("============================================================================");
		ex.uniqueCharsInStr();		
	}
	

	public void revString() {
		String str = "This is first level of radar testing";
		int palindroeCount = 0;
		String[] inpArr = str.split(" ");

		/*
		for (String string : inpArr) {
			if(string.equalsIgnoreCase(reverse(string))) {
				palindroeCount++;
			}
		}*/
		
		for(int i =0; i< inpArr.length; i++){
			if(inpArr[i].equalsIgnoreCase(reverse(inpArr[i]))){
				
				palindroeCount++;
			}
			
		}

		System.out.println("Total number of Palindrome : "+ palindroeCount);
	
	}
	
	public String reverse(String word) {
		
		
		String revWord = "";
		/*
		System.out.println(word);
	//	for(int i=0; i< word.length();i++) {
	//		revWord = word.charAt(i) + revWord;
	//	}
		for(int i=word.length()-1; i>= 0 ;i--) {
			revWord += word.charAt(i);
		}
		System.out.println(revWord);
		
		*/
		
		StringBuffer sb = new StringBuffer();
		sb.append(word);
		
		revWord = sb.reverse().toString();
		System.out.println(revWord);
		
		return revWord;	
	}
	



	
	public void displayArr(int[] ar){
		
		System.out.println("Array contents");
		for(int i =0;i <ar.length;i++) {
			System.out.print(ar[i]+" ");
		}
		System.out.println();
	}
	
	public void booleanArr() {
		
		boolean[][] booArr = {
				{true,false,true},
				{false,false,true}
		};
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(" "+(booArr[i][j] ? "t":"f"));
			}
			System.out.println();
		}
		System.out.println("------------------Another Way-----------------");
		//printing row <--> columns
		System.out.println("printing row <--> columns");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(" "+(booArr[j][i] ? "t":"f"));
			}
			System.out.println();
		}
	}
	

	
	public void upperCaseFirstLetter() {
		
		Scanner in = new Scanner(System.in);
		
		//System.out.println("enter a line without uppercase");
		//String line = in.nextLine();
		String line = "enter a line without uppercase";
		String upper_case_line = "";
		//Scanner lineScan = new Scanner(line);
		String[] wordArr = line.split(" ");
		//while (lineScan.hasNext()) {
		for (String word : wordArr) {
			//String word = lineScan.next();
			
			upper_case_line += Character.toUpperCase(word.charAt(0)) + word.substring(1)+" ";
			
		}
		
		System.out.println(line);
		System.out.println(upper_case_line);
	}
	
	public void ASCHII() {
		int ch = 'a';
		
		char c = 98;
		System.out.println("Aschii numbers :"+ch+" b value "+c);
		
		for (int i = 32; i < 127; i++) {
			char character = (char) i;
			System.out.println(i+" = "+character+ " is WhiteSpace character? --> "+ Character.isWhitespace(character));
		}
		
		System.out.format("\nCurrent Date time: %tc%n\n", System.currentTimeMillis());
	}
	
	public void charSetList() {
		
		System.out.println("List of available character sets: ");
        
        // Iterate through the available character sets and print their names
        for (String str : Charset.availableCharsets().keySet()) {
            System.out.println(str);
        }
	}
	
	public void combination() {
		int count = 0;
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				for (int k = 1; k <= 4; k++) {
					if(k!=j && j!=i && i!=k ) {
						System.out.println(i+""+j+""+k);
						count++;
					}
				}
			}
		}
		
		System.out.println("Total number of the three-digit-number is :"+count);
	}
	
	public void countChars() {
		String str = "Aa kiu, I swd skieo 236587. GH kiu: sieo?? 25.33";
		
		char[] ch = str.toCharArray();
		int letter = 0, numbers = 0, space = 0, other=0;
		for (int i = 0; i < ch.length; i++) {
			if(Character.isLetter(ch[i])) {
				letter++;
			}else if(Character.isDigit(ch[i])) {
				numbers++;
			}else if(Character.isSpaceChar(ch[i])) {
				space++;
			}else {
				other++;			
			}
		}
		
		System.out.println("Letters :"+letter +", numbers :"+numbers+", spaces :"+space+", Others :"+other);
	}
	
	public void javaProperties() {
		
		System.out.println("Java version :"+ System.getProperty("java.version"));
		
		System.out.println("Java Runtine :"+ System.getProperty("java.runtime.version"));
		
		System.out.println("Java Home :"+ System.getProperty("java.home"));
		
		System.out.println("Java Vendor :"+ System.getProperty("java.vendor"));
		
		System.out.println("Java vednor URL :"+ System.getProperty("java.vendor.url"));
		
		System.out.println("Java Class path :"+ System.getProperty("java.class.path"));
		
		System.out.println("All the System properties");
		System.out.println(System.getProperties());
		
	}

	
	public void image1() {
		
		System.out.println(" +\"\"\"\"\"+");
		System.out.println("[| o o |]");
		System.out.println(" |  ^  |");
		System.out.println(" | '-' |");
		System.out.println(" +-----+");
		System.out.println("");
	}


	
	public void americanFlag() {
		
		
		for(int i=0;i<15;i++) {
			
			for(int j=0;j<42;j++) {
				if(j<12 && i<9) {
				 if(i%2==0) {
					if(j%2==0) {						
						System.out.print("*");
					}else {
						System.out.print(" ");
					}
				 }else {
					 if((j+1)%2==0) {						
							System.out.print("*");
						}else {
							System.out.print(" ");
						}
					 }
				}else {
					System.out.print("=");
				}
				
			}
			System.out.println();
			
		}
	}
	

	public void displayJava() {
		//row lenght = 4, column lenght 25 
		//
		//int jArray[] = new int[] {3,3,3,};
		for(int i=0;i<4;i++) {
			for(int j=0;j<25;j++) {
				
			if(i==0) {	
				if(j==3) {
					System.out.print("J");
				}else if(j==7){
					System.out.print("a");
				}else if(j==11||j==17){
					System.out.print("v");
				}else if(j==21){
					System.out.print("a");
				}else {
					System.out.print(" ");
				}
			}
			if(i==1) {	
				if(j==3) {
					System.out.print("J");
				}else if(j==6||j==8){
					System.out.print("a");
				}else if(j==12||j==16){
					System.out.print("v");
				}else if(j==20||j==22){
					System.out.print("a");
				}else {
					System.out.print(" ");
				}
			}
			if(i==2) {	
				if(j==0||j==3) {
					System.out.print("J");
				}else if(j==5||j==6||j==7||j==8||j==9){
					System.out.print("a");
				}else if(j==13||j==15){
					System.out.print("v");
				}else if(j==19||j==20||j==21||j==22||j==23){
					System.out.print("a");
				}else {
					System.out.print(" ");
				}
			}
			if(i==3) {	
				if(j==1||j==2) {
					System.out.print("J");
				}else if(j==4||j==10){
					System.out.print("a");
				}else if(j==14){
					System.out.print("v");
				}else if(j==18||j==24){
					System.out.print("a");
				}else {
					System.out.print(" ");
				}
			}
			}
			System.out.println();
		}
	}
	
	public void displayJava2() {
		 int[] aRow = new int[]{1,1,9,6};
		 int[] bRow = new int[]{8,20,62,65};
		 int[] cRow = new int[]{65,34,20,8};
		 int[] dRow = bRow;

		
		for (int i = 0 ; i<4; i++) {

		prnMyText('J', aRow[i], 4);
		prnMyText('a', bRow[i], 7);
		prnMyText('v', cRow[i], 7);
		prnMyText('a', bRow[i], 7);
		System.out.print("\n");
		}
				
	}
	public static void prnMyText(char myChar, int myRow, int length){
		String myJ = "";
		for (int i=0; i< length ;i++) {

		myJ = (myRow % 2 == 0 ? " " : myChar) + myJ;
		myRow = myRow / 2;

		}
		System.out.print(myJ);
	}
	

	
	private void uniqueCharsInStr() {
	
		String inpStr = "Tabassum";
		
		String temp = "";
		for(int i=0;i<inpStr.length();i++) {
			if(temp.indexOf(inpStr.charAt(i))== -1) {
				temp += inpStr.charAt(i);
			}
		}
		System.out.println("Input : "+inpStr);
		System.out.println("Unique chars in string : "+temp);
	}
}
