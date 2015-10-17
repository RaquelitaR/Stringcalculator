package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text) {
		if (text.equals("")) return 0;
		
		else if (text.contains("-")) return sum(splitNumbers(text));
		
		else if (text.startsWith("//")) return sum(diffDelimeter(text));
				
		else if (text.contains("//[")) return sum(delOfAnyLength(text));

		else if(text.contains(",") || text.contains("\n")) return sum(splitNumbers(text));
		
		return toInt(text);	
	}

	//Refactor - Smiðir
	private static int toInt(String number){
	    return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
		String delimeter = "[,|\\\n]";
		return numbers.split(delimeter);
	}
	// Test 6
	private static String[] diffDelimeter(String numbers){
		int newLine = numbers.indexOf('\n');
		String delimeter = "[\\D|\\" + numbers.substring(2, newLine);
		numbers = numbers.substring(newLine + 1);
		return numbers.split(delimeter + "]");
	}

	// Test 9
	private static String[] delOfAnyLength(String numbers){
		int newLine = numbers.indexOf('\n');
		String del = "[\\D|\\" +  numbers.substring(3, newLine);
		numbers = numbers.substring(newLine + 1);
		return numbers.split(del);
	}
	
	//------------------------------------------------------//
	private static int sum(String[] numbers){
		int result = 0;
		String negative = "";

		for (String string : numbers){
			// Ignore emptry strings
			if(string.equals("") || string == null) continue;
			// Ignore number bigger than 1000
			if (toInt(string) > 1000) continue;
			// Ignore negative numbers			
			if (toInt(string) < 0) negative += string + ",";


			result += toInt(string);
		}
		// Negative number will throw an exception
		if (!negative.isEmpty()) throw new RuntimeException("Negatives not allowed: " + negative.substring(0, negative.length() -1));	
		return result;
	}
	//------------------------------------------------------//

}