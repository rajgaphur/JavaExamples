package com.corejava.strings;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringEx1 {

	public static void main(String[] args) {

		StringEx1 ex = new StringEx1();
		ex.evenLenWords();
		System.out.println("============================================================================");
		ex.insertWord();
		System.out.println("============================================================================");
		ex.isPalindrome();
		System.out.println("============================================================================");
		ex.isAnagram();
		System.out.println("============================================================================");
		ex.printNewLine();
		System.out.println("============================================================================");
		ex.isPangrams();
		System.out.println("============================================================================");
		ex.firstLtrWord();
		System.out.println("============================================================================");
		ex.printUncodeAlpha();
		System.out.println("============================================================================");
		ex.stringCompare();
		System.out.println("============================================================================");
		ex.swapCharsInStr();
		System.out.println("============================================================================");
		ex.possibleSubStr();
		System.out.println("============================================================================");
		ex.removeTrailPrecdZero();
		System.out.println("============================================================================");
		ex.sortStrChars();
		System.out.println("============================================================================");
		ex.reverseWordsInStr();
		System.out.println("============================================================================");
		ex.convertRomanToNum();
		System.out.println("============================================================================");
		ex.stringEx();
		System.out.println("============================================================================");
	}

	public void evenLenWords() {
		/*
		 * Input: s = "Hi! This is a, java language."
	Output: This
        	is
        	java
        	language 
		 */
		String str = "Hi! This is a, java language.";
		str = str.replaceAll("[$&+,:;=?@#|'<>.^*()%!-]", "");
		System.out.println(str);
		String[] words = str.split(" ");
		
		for (String string : words) {
			if(string.length()%2 == 0) {
				System.out.println(string + " --> "+string.length());
			}
		}

	}

	public void insertWord() {
	
		/*
		 * Input: originalString = "GeeksGeeks", 
              stringToBeInserted = "For", 
              index = 4
			Output: "GeeksForGeeks"
		 */
		
		String originalString = "GeeksGeeks";
		String stringToBeInserted = "For";
		int index = 4;
		String strFirst = "", strLast = "", finalStirng = "";
		
		strFirst = originalString.substring(0, index+1);
		strLast = originalString.substring(index+1, originalString.length());
		finalStirng = strFirst + stringToBeInserted + strLast;
		System.out.println(finalStirng);
		
		System.out.println("------Another Way-------");
		String newStr = "";
		for (int i = 0; i < originalString.length(); i++) {
			
			newStr += originalString.charAt(i);
			if(i == index) {
				newStr += stringToBeInserted;
			}
		}
		
		System.out.println(newStr);
	}
	
	public void isPalindrome() {
		/*
		 * Input : str = “abba” 

			Output: Yes
		 */
		String str = "abba";
		String palindromeStr = "";
		for (int i = str.length()-1; i >=0 ; i--) {
			palindromeStr += str.charAt(i);
		}
		
		if(str.equals(palindromeStr)) {
			System.out.println(str+ " is Palindrome");
		}else {
			System.out.println(str+ " is Not Palindrome");
		}
	}
	
	public void isAnagram() {
		//Program to Check Two Strings Are Anagram Of Each Other in Java
		/*
		 * String str1 = "SILENT";
		 * String str2 = "LISTEN";
		 */
		
		//String str1 = "SILENT";
		//String str2 = "LISTEN";
		
		
		String str1 = "anaGramm";
		String str2 = "marganaa";
		
		// Get lengths of both strings
        int n1 = str1.length();
        int n2 = str2.length();
        
        Boolean isAnagram1 = true;
        // If length of both strings is not
        // same, then they cannot be anagram
        if (n1 == n2){
        
        //converting to lower case for correct validation
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        // Sort both strings
        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str2.toCharArray(); 
        
        Arrays.sort(charArr1);
        Arrays.sort(charArr2);
 
        System.out.println(charArr1);
        System.out.println(charArr2);
        // Compare sorted strings
        	for (int i = 0; i < n1; i++) {
        		if (charArr1[i] != charArr2[i]) {
        			isAnagram1 = false;
        			break;
        		}
        	}
        }else {
        	isAnagram1 = false;
        }
        
        if(isAnagram1) {
			System.out.println(str1 +" and "+ str2 +" are Anagrams");
		}else {
			System.out.println(str1 +" and "+ str2 +" are NOT Anagrams");
		}
        
	}
	
	public void printNewLine() {
		/*
		 * Methods: 

		There are many ways to print new line in string been illustrated as below:

		Using System.lineSeparator() method
		Using platform-dependent newline character
		Using System.getProperty() method
 		Using %n newline character
		Using System.out.println() method 
		 */
		
		String newLine = System.lineSeparator();
		
		System.out.println("Raj"+newLine+"Ilkal");
		
		System.out.println("------Another Way-------");
		//Method 2: Here the new line character is “\n” for Unix and “\r\n” for Windows OS.
		System.out.println("Raj\rIlkal");
		
		System.out.println("------Another Way-------");
		System.out.println("Raj\nIlkal");
		
		System.out.println("------Another Way-------");
		System.out.println("Raj\r\nIlkal");
		
		System.out.println("------Another Way-------");
		//Method 3: Using System.getProperty() method. Here this function uses the value of the 
		//system property “line.separator”, which returns the system-dependent line separator string. 
		String newLine1 = System.getProperty("line.separator");
		System.out.println("Raj"+newLine1+"Ilkal");
		
		System.out.println("------Another Way-------");
		/*
		 * Method 4: Using %n newline character
			Note: Here this newline character is used along with the printf() function.
		 */
		System.out.printf("Raj%nIlkal");
		System.out.println();
		
		System.out.println("------Another Way-------");
		//Method-5: Using System.out.println() method.
		System.out.println("Raj");
		System.out.println("Ilkal");
	}
	
	public void isPangrams() {
		//A string is a pangram string if it contains 
		//all the character of the alphabets ignoring the case of the alphabets.
		
		/*
		 * Input: str = “Abcdefghijklmnopqrstuvwxyz”
			Output: Yes
			Explanation: The given string contains all the letters from a to z (ignoring case).
		 */
		String strInput = "Waltz, bad nymph, for quick jigs vex.";
		String strInputLower = strInput.toLowerCase();
		//String alphbets = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String alphbets = "abcdefghijklmnopqrstuvwxyz";
		char[] inpChars = strInput.toCharArray();
		boolean ispangram = false;
		int len1 = strInput.length();
		int len2 = alphbets.length();
		
		if(len1 < len2) {
			ispangram = false;
		}else{
			
			for (int i = 0; i < alphbets.length(); i++) {
				char c = alphbets.charAt(i);
			
				if(strInputLower.contains(c+"")) {
					System.out.print(c +" ");
					ispangram = true;
				}else {
					ispangram = false;
					break;
				}
			}
		}
		System.out.println();
		if(ispangram) {
			System.out.println("Pangram");
		}else {
			System.out.println("Not Pangram");
		}
		
		System.out.println("------Another Way-------");
		String str = strInputLower;
		 
        boolean allLetterPresent = true;
		// Loop over each character itself
        for (char ch = 'a'; ch <= 'z'; ch++) {
 
            // Check if the string does not
            // contains all the letters
        	int c = ch;
        	System.out.print(ch+"="+c+"="+String.valueOf(ch)+", ");
            if (!str.contains(String.valueOf(ch))) {
                allLetterPresent = false;
                break;
            }
        }
        System.out.println();
        if(allLetterPresent) {
			System.out.println("Pangram");
		}else {
			System.out.println("Not Pangram");
		}
	}
	
	public void firstLtrWord() {
		String s1 = "Geeks for 1Geeks";
        String s2 = "A Computer Science Portal for Geeks";
         
        Pattern p = Pattern.compile("\\b[a-zA-Z0-9]");
        Matcher m1 = p.matcher(s1);
        Matcher m2 = p.matcher(s2);
         
        System.out.println("First letter of each word from string \"" + s1 + "\" : ");
        while (m1.find())
            System.out.print(m1.group());
         
        System.out.println();
         
        System.out.println("First letter of each word from string \"" + s2 + "\" : ");
         
        while (m2.find()) 
            System.out.print(m2.group());

        System.out.println();
        
	}
	
	public void printUncodeAlpha() {
		
		String str = "JAVA";
		System.out.println("Unicodes/ASCHII values of characters in "+str);
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i); 
			int j = ch;
			System.out.print(ch+"-->"+j+" "+str.codePointAt(i)+", ");
		}
		
		System.out.println();
	}
	
	public void stringCompare() {
		String string1 = new String("Geeks");  
        String string2 = new String("Geeks");          
		for (int i = 0; i < string1.length() && i < string2.length(); i++) {
			if ((int) string1.charAt(i) == (int) string2.charAt(i)) {
				continue;
			} else {
				System.out.println((int) string1.charAt(i) - (int) string2.charAt(i)+" 1st");
			}
		}
		
		if (string1.length() < string2.length()) {
			System.out.println(string2.length() - string1.length()+" <");
		} else if (string1.length() > string2.length()) {
			System.out.println(string1.length() - string2.length()+" >");
		}		// 	If none of the above conditions is true,  // it implies both the strings are equal  
		else {
			System.out.println("0");
		}
		
	}
	
	public void swapCharsInStr() {
		
		String str = "StringSwapE";
		
		char[] ch = str.toCharArray();
		char c = 0;
		System.out.println("Default value of chars :"+c);
		for (int i = 0; i < ch.length-1; i++) {
			if(i%2==0) {
				c= ch[i];
				ch[i] = ch[i+1];
				ch[i+1] = c;
			}
		}
		
		System.out.println("Swapped characters :"+ new String(ch));
	}
	
	public void possibleSubStr() {
		String str = "The Cat";
		for(int i=0;i<str.length();i++) {
			String temp = "";
			for(int j=i;j<str.length();j++) {
				temp+=str.charAt(j);
				System.out.println("\""+temp+"\"");
			}
		}
		
		System.out.println("\"\"");
		
	}
	
	public void removeTrailPrecdZero() {
		
		String strNum = "00000120100";
		System.out.println("Actual Number: "+ strNum);
		int i = 0;
		while(strNum.charAt(i) == '0' && i<strNum.length()) {
			i++;
		}
		System.out.println("Removed Preceding Zeros from string: "+ strNum.substring(i));
		
		System.out.println("Replaced zero with empty "+strNum.replaceAll("0", ""));
		System.out.println("Convert the output to integer num "+strNum);
		int num = Integer.parseInt(strNum);
		System.out.println("Converted the integer num to String "+String.valueOf(num));
		int temp = num;
		while(temp%10==0) {
			
			temp /= 10;
			
		}
		num = temp;
		System.out.println("Removed Trailied Zeros : "+num);
		

	}
		
	public void sortStrChars() {
		
		String str = "HIWORLD";
		char[] sortedArr = str.toCharArray();
		char[] chArr = str.toCharArray();
		System.out.println("Using Arrays.sort method");
		Arrays.sort(sortedArr);
		System.out.println(sortedArr);
		int ch1, ch2;		char tempChar;
		for (int i = 0; i < chArr.length; i++) {
			for (int j = 0; j < chArr.length; j++) {
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
	
	
	public void reverseWordsInStr() {
		//Reverse words in a given string
		/*
		 * Input: s = “i love programming very much” 
		 * Output: s = “much very programming love i” 
		 * 
		 *
		 */
		String input = "i love programming very much";
		System.out.println("Input :"+input);
		String[] inputArr = input.split(" ");
		String output = "";
		for (String string : inputArr) {
			output = " "+string + output;
		}
		
		System.out.println("Output :"+output.trim());
	}

	public void convertRomanToNum() {
		
		//Converting Roman Numerals to Integer
		/*
		 * I

I 1
V 5
X 10
L 50
C 100
D 500
M 1000

Input: XL
Output: 40
Explanation: XL is a Roman symbol which represents 40

Input: MCMIV
Output: 1904
Explanation: M is a thousand, CM is nine hundred and IV is four
		 */
		String input = "XD";
		
		int res = 0;
		for (int i = 0; i < input.length()-1; i++) {
			int v1 = romanValue(input.charAt(i));
			int v2 = romanValue(input.charAt(i+1));
			
			if(v1 >= v2) {
				res = res + v1;
			}else {
				res = res + v2 - v1;
				i++;
			}
			
		}
		
		System.out.println("Output for Roman value '"+input+"' is "+res);
		
	}
	int romanValue(char r){
		int value = 0;
		switch(r) {
			case 'I': value = 1;
			break;
			case 'V': value = 5;
			break;
			case 'X': value = 10;
			break;
			case 'L': value = 50;
			break;
			case 'C': value = 100;
			break;
			case 'D': value = 500;
			break;
			case 'M': value = 1000;
			break;
			default: value = 0;
				break;
		}
		return value;
	}
	
	public void stringEx() {
		String x = "abc";
		String z = "abc";
		System.out.println("Entered String as 'abc'");
		
		x.concat(z);
		
		System.out.println("String value "+x);
		String s = "He is a very very good boy, isn't he?";
		String[] strArr = s.split("[ ,!,?._'@]+");
		System.out.println(strArr.length);
		for (String string : strArr) {
			System.out.println(string);
		}
		
		int y= 10;
		System.out.println("x value :" +y++);
		System.out.println("x value :" +y);
		System.out.println("x value :" + ++y+y++);
		
	}
}
