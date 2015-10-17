package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text) {
		if (text.equals("")) {
	    	return 0;
		}
		else if(text.startsWith("//")){
			return diffDelimeter(text);
		}
		else if(text.contains(",") || text.contains("\n")) {
			return sum(splitNumbers(text));
		}
		else return toInt(text);
	
	}

	//Refactor - Smiðir
	private static int toInt(String number){
	    return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
		return numbers.split("\\D");
	}

	private static int sum(String[] numbers){
		int result = 0;
		String negative = "";
		for (String string : numbers){
			// Ignore emptry strings
			if(string.equals("") || string == null) continue;
			// Ignore negative numbers
			if(toInt(string) < 0) negative = negative.concat(string + ",");
			// Ignore number bigger than 1000
			if (toInt(string) > 1000) continue;

			result += toInt(string);
		}
		// Negative number will throw an exception
		if(!negative.equals(""))
		throw new RuntimeException("Negative not allowd:" + negative.substring(0, negative.length() -1));	
		return result;
	}

	private static int diffDelimeter(String string){
		String numbS = string.substring(4, 7);
		String[] numbers = numbS.split(";");
		return sum(numbers);
	}
}