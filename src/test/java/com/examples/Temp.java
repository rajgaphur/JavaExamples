package com.examples;

import java.util.concurrent.ThreadLocalRandom;

public class Temp {

	public static void main(String[] args) {
		
		//String digit =   randomDecimal(4);
	    //System.out.println(digit);
	    System.out.println("-122.161240");
		//System.out.println(removeTrailingZerosAfterDecimal("-97.708900"));
		//System.out.println(removeLeadingTrailingZeros("-97.708900"));
		//System.out.println(setLatLongWithoutDecimals("-97.708900"));
		//System.out.println(replaceSplCharacters("-97.708900"));
		System.out.println(remTrailingZerosAfterDecimal("-122.161240"));
		
		String lpFileName = "locationProfile_20220228_132053361-0800.xml";
		String searchText = lpFileName.split("[.]")[0];
		System.out.println(searchText);
		System.out.println("<tt>locationProfile_20220228_132053361-0800_28022022132053.log".substring(4));
	}
	
	public static String replaceSplCharacters(String str) {
		String splCharacters = "[`*!_@]";
		str = str.replaceAll(splCharacters, " ");
		str = str.replace("\\", " ");
		str = str.replace("[", "(");
		str = str.replace("]", ")");
		str = str.replace("&", "+");
		str = str.replace(".", "");
		return str;
	}
	
	public static String randomDecimal(int numDigits) {
		String result = String.valueOf(ThreadLocalRandom.current().nextInt(1,10));
		
		for(int x = 1; x < numDigits; x++) {
			result += String.valueOf(ThreadLocalRandom.current().nextInt(0,10));
		}
		
		return result;
	}
	
	
	// Removes  trailing zeros after decimal from a String
		public static String remTrailingZerosAfterDecimal(String str) {
			if(str != null) {
				String[] strArr = str.split("[.]");
				String trimmedStr = strArr[1];
				int decimal_index = 0;
				//"-090.16012400"
				for(int index = trimmedStr.length()-1 ; index >= 0 ; index--) {
					char indexedChar = trimmedStr.charAt(index);
					if(indexedChar == '0'){
						decimal_index++;
					}
					else
						break;
				}
				if(decimal_index > 0)
					return strArr[0]+ "." +trimmedStr.substring(0, trimmedStr.length()-decimal_index);
			}
			
			return str;
		}
	// Removes  trailing zeros after decimal from a String
	public static String removeTrailingZerosAfterDecimal(String str) {
		if(str != null) {
			StringBuilder result = new StringBuilder();
			String trimmedStr = str.trim();
			int decimal_index =0;
			for(int index = 0; index < trimmedStr.length(); index++) {
				char indexedChar = trimmedStr.charAt(index);
				if (indexedChar == '.' ){
					decimal_index = index;
				}
				if(!((indexedChar == '0') && (index > decimal_index) && ((index + 1) == trimmedStr.length()))){
					result.append(indexedChar);
				}
			}
			
			return result.toString();
		}
		
		return str;
	}
	
	// Removes leading and trailing zeros and whitespace from a String
	public static String removeLeadingTrailingZeros(String str) {
		if(str != null) {
			StringBuilder result = new StringBuilder();
			String trimmedStr = str.trim();
			
			for(int index = 0; index < trimmedStr.length(); index++) {
				char indexedChar = trimmedStr.charAt(index);
				
				if(indexedChar != '0') {
					result.append(indexedChar);
				}
			}
			
			return result.toString();
		}
		
		return str;
	}
	
	public static String setLatLongWithoutDecimals(String latlong) {
		String value = "";
		
		try {
			Double valueAsDouble = Double.valueOf(latlong) * 1000000;
			value = ((Integer)valueAsDouble.intValue()).toString();
		} catch(NumberFormatException e) {
		}
		
		//this.replaceParameterValue("LatitudeWithoutDecimals",value);
	return value;
	}
}
