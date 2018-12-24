package com.td.brainfuck;

import java.util.Collection;

import org.junit.Test;

import com.td.brainfuck.analyse.BrainfuckAnalyser;
import com.td.brainfuck.analyse.BrainfuckOperator;

import junit.framework.TestCase;

public class BrainfuckAnalyserTest extends TestCase {

	@Test
	public void testSimpleAnalyzerTest() {
		
		String input = "+-<>[].";
		
		// analyse input and make collection of operators
		Collection<BrainfuckOperator> bfOperators = new BrainfuckAnalyser().map(input);
		
		assertNotNull(bfOperators);
		assertEquals(input.length(), bfOperators.size());
		
	}
	
	@Test
	public void testFakeAnalyzerTest() {
		
		String input = "+-{}##.";
		
		// analyse input and make collection of operators
		Collection<BrainfuckOperator> bfOperators = new BrainfuckAnalyser().map(input);
		
		assertNotNull(bfOperators);
		assertEquals(3, bfOperators.size());
		
	}
	
}
