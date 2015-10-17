package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

    // Test 1 - Is this an empty string
    @Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	// Test 2 - Check if string contains one number
	@Test 
	public void testOneNumber(){
		assertEquals(1, Calculator.add("1"));
	}

	// Test 3 - Sum of two numbers
	@Test
	public void testTwoNumbers(){
		assertEquals(3, Calculator.add("1,2"));
	}

	// Test 4 - Sum of multiple numbers
	@Test
	public void testMultNumbers(){
		assertEquals(15, Calculator.add("1,2,3,4,5"));
	}

	// Test 5 - Allow new lines and commas between numbers
	@Test
	public void newLine(){
		assertEquals(6, Calculator.add("1\n2,3"));
	}

	// Test 6 - Handle a different delimiter
	@Test
	public void differentDelimeter(){
		assertEquals(3, Calculator.add("//;\n1;2"));
	}

	// Test 7 - Negative number will throw an exception
	@Test
	public void negativeNumber(){
		try {
			Calculator.add("-1,1,-2");	
		} catch (RuntimeException ex) {
			assertEquals("Negatives not allowed: -1,-2", ex.getMessage());
		}		
	}

	//Test 8 - Numbers bigger than 1000 should be ignored
	@Test
	public void ignoreBiggerThousand(){
		assertEquals(2, Calculator.add("1001,2"));
	}

	// Test 9 - Delimeters can be of any length
	@Test
	public void delimeterOfAntLength(){		
		assertEquals(6, Calculator.add("//[***]\n1***2***3"));
	}

	// Test 10 - Allow multiple delimiters
	@Test
	public void multipleDelimeter(){
		assertEquals(6, Calculator.add("//[*][%]\n1*2%3"));
	}

}