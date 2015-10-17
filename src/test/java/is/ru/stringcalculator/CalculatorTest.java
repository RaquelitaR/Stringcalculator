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


}