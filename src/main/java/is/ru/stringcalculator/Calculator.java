package is.ru.stringcalculator;

public class Calculator {
	
	public static int add(String text) {

		if (text.equals("")) {
			return 0;
		}

		else if (text.contains("-")) {
			return sum(splitNumbers(text));
		}

		else if (text.contains("][")) {
			return sum(multipleDel(text));
		}

		else if (text.contains("//[")) {
			return sum(delOfAnyLength(text));
		}

		else if (text.startsWith("//")) {
			return sum(diffDelimeter(text));
		}

		else if (text.contains(",") || text.contains("\n")) {
			return sum(splitNumbers(text));
		}
		else
			return toInt(text);
	}

//--------------------------- Constructors ------------------------------------//	

	private static int toInt(String number) {
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers) {
		String delimeter = "[,|\\\n]";
		return numbers.split(delimeter);
	}

	
	// Test 6
	private static String[] diffDelimeter(String numbers) {
		int newLine = numbers.indexOf('\n');
		String delimeter = "[\\D|\\" + numbers.substring(2, newLine);
		numbers = numbers.substring(newLine + 1);
		return numbers.split(delimeter + "]");
	}

	// Test 9
	private static String[] delOfAnyLength(String numbers) {
		int newLine = numbers.indexOf('\n');
		String delimeter = "[\\D|\\" +  numbers.substring(3, newLine);
		numbers = numbers.substring(newLine + 1);
		return numbers.split(delimeter);
	}

	// Test 10 - Allow multiple delimiters
	private static String[] multipleDel(String numbers) {
		int newLine = numbers.indexOf('\n');
		int firstDelEnd = numbers.indexOf(']');
		String delimeter = numbers.substring(3, firstDelEnd);
		for (int i = firstDelEnd; i < newLine; i++) {
			if (numbers.charAt(i) == '[') {
				delimeter += "|\\" + numbers.substring(i + 1, numbers.indexOf(']', i));
			}
		}		
		numbers = numbers.substring(newLine + 1);
		return numbers.split("[\\D|\\" + delimeter + "]");
	}

//--------------------------- Sum method ------------------------------------//	
	private static int sum(String[] numbers) {
		int result = 0;
		String negative = "";
		for (String s : numbers) {
			if (s.equals("") || s == null) continue;
			if (toInt(s) > 1000) continue;
			if (toInt(s) < 0) negative += s + ",";
			result += toInt(s);
		}
		if (!negative.isEmpty()) throw new RuntimeException("Negatives not allowed: " + negative.substring(0, negative.length() -1));
		return result;
    }
//---------------------------------------------------------------------------//

}