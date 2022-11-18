import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

//implement tests to test Sudokuverifier with boundary values.  Use templates from Task 1 to derive and document test cases.
	
// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891
String c = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
String i = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";

// Sudoku string contains a letter
String letter = "4a7369825632158947958724316825437169791586432346912758289643571573291684164875293";
// Sudoku string contains a special character
String character = "4!7369825632158947958724316825437169791586432346912758289643571573291684164875293";
// Sudoku string contains a space
String space = "4 7369825632158947958724316825437169791586432346912758289643571573291684164875293";
// Sudoku string contains a point
String point = "4.7369825632158947958724316825437169791586432346912758289643571573291684164875293";

// Sudoku string contains a negative number
String negative1 = "-417369825632158947958724316825437169791586432346912758289643571573291684164875293";
// Sudoku string contains a negative number and is 81 in length
String negative2 = "-17369825632158947958724316825437169791586432346912758289643571573291684164875293";
// Sudoku string contains a 0
String number0 = "017369825632158947958724316825437169791586432346912758289643571573291684164875293";
// Sudoku string contains 10
String number10 = "1017369825632158947958724316825437169791586432346912758289643571573291684164875293";

// Sudoku string is too short
String shortLength = "17369825632158947958724316825437169791586432346912758289643571573291684164875293";
// Blank Sudoku string
String blank = "";
// Sudoku string is too long
String longLength = "8417369825632158947958724316825437169791586432346912758289643571573291684164875293";

// Sudoku string with duplicate number in sub-grid
String sub = "417369825432158967958724316825437169791586432346912758289643571573291684164875293";
// Sudoku string with duplicate number in row
String row = "417369825632158947958724316825437169791586432346912758289643591573291684164875273";
// Sudoku string with duplicate number in column
String column = "417369825632158947958724316825437169791586432346912758289643571753291684164875293";


SudokuVerifier v = new SudokuVerifier();

	@Test
	public void testCorrectString() {
		int a = v.verify(c);
		assertEquals("correct string", a, 0);
	}

	@Test
	public void testIncorrectString() {
		int a = v.verify(i);
		assertEquals("incorrect string", a, -2);
		
	}
	
	@Test
	public void testNotNumber() {
		int a = v.verify(letter);
		assertEquals("incorrect string, contains a letter", a, 1);
		
		int b = v.verify(character);
		assertEquals("incorrect string, contains a special character", b, 1);
		
		int c = v.verify(space);
		assertEquals("incorrect string, contains a space", c, 1);
		
		int d = v.verify(point);
		assertEquals("incorrect string, contains a point", d, 1);
	}
	
	@Test
	public void testWrongNumber() {
		int a = v.verify(negative1);
		assertEquals("incorrect string, contains a negative number", a, -1);
		
		int b = v.verify(negative2);
		assertEquals("incorrect string, contains a negative number and is 81 in length", b, 1);
		
		int c = v.verify(number0);
		assertEquals("incorrect string, contains a 0", c, -1);
		
		int d = v.verify(number10);
		assertEquals("incorrect string, contains a 10", d, -1);
	}
	
	@Test
	public void testLength() {
		int a = v.verify(shortLength);
		assertEquals("incorrect string, the string is too short", a, -1);
		
		int b = v.verify(blank);
		assertEquals("incorrect string, the string is blank", b, -1);
		
		int c = v.verify(longLength);
		assertEquals("incorrect string, the string is too long", c, -1);
	}
	
	@Test
	public void testDuplicates() {
		int a = v.verify(sub);
		assertEquals("incorrect string, there is a duplicate number in sub-grid", a, -2);
		
		int b = v.verify(row);
		assertEquals("incorrect string, there is a duplicate number in row", b, -3);
		
		int c = v.verify(column);
		assertEquals("incorrect string, there is a duplicate number in column", c, -4);
	}
}
