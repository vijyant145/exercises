/**
 * 
 */
package ccom.vijyant.exercise.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.vijyant.exercise.calculator.Calculator;

/**
 * @author vijyant
 *
 * @since Mar 10, 2019
 *
 */
@RunWith(SpringRunner.class)
public class CalculatorTest {

	private Calculator calc = new Calculator();
	
	@Test
	public void testSimpleAddition() {
		
		String expected = "12.0";
		String input = "3 + 4 + 5";
		String actual = calc.eval(input);
		Assert.assertTrue(expected.equals(actual));	
	}
	
	@Test
	public void testSimpleSubstraction() {
		
		String expected = "12.0";
		String input = "24 -12";
		String actual = calc.eval(input);
		Assert.assertTrue(expected.equals(actual));	
	}
	
	@Test
	public void testSimpleMultiplication() {
		
		String expected = "10.0";
		String input = "5*2";
		String actual = calc.eval(input);
		Assert.assertTrue(expected.equals(actual));	
	}
	@Test
	public void testSimpleDivision() {
		
		String expected = "2.5";
		String input = "5/2";
		String actual = calc.eval(input);
		Assert.assertTrue(expected.equals(actual));	
	}
	
	@Test
	public void testMixedWithMaxTwoMultiple() {
		
		String expected = "112.0";
		String input = "2 * 10 -10+100 + 5 * 2 + 5/5 - 3*3";
		String actual = calc.eval(input);
		Assert.assertTrue(expected.equals(actual));	
	}
	
	// this case doesnt work with v1 implementation
	@Test
	public void testMixedWithMaxThreeMultiple() {
		
		String expected = "94.0";
		String input = "2 * 10 -10+100 + 5 * 2 + 5/5 - 3*3*3";
		String actual = calc.eval(input);
		Assert.assertTrue(expected.equals(actual));	
	}
	
	// this case doesnt work with v1 implementation
	@Test
	public void testMixedWithMultipleWithDivision() {
		
		String expected = "96.0";
		String input = "2 * 10 -10+100 + 5 * 2 + 3*5/5 - 3*3*3";
		String actual = calc.eval(input);
		
		Assert.assertTrue(expected.equals(actual));	
	}
}
