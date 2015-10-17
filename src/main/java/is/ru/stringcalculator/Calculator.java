package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text) {
		if (text.equals("")) {
	    	return 0;
		}
		else if(text.contains(",") || text.contains("\n")) {
			return sum(splitNumbers(text));
		}
		else return 1;
	
	}

	//Refactor
	private static int toInt(String number){
	    return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
		return numbers.split("\\D");
	}

	private static int sum(String[] numbers){
		int result = 0;
		for (String number : numbers){
			result += toInt(number);
		}
		return result;
	}
}