package com.td.brainfuck;

import java.util.List;

import com.td.brainfuck.analyse.BrainfuckAnalyser;
import com.td.brainfuck.analyse.BrainfuckOperator;
import com.td.brainfuck.executor.BrainfuckProgram;

public class BrainfuckMainClass {

	public static void main(String[] args) {

		String input = "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";
		
		// analyse input and make collection of operators
		List<BrainfuckOperator> bfOperators = new BrainfuckAnalyser().map(input);
		
		// execute them 
		new BrainfuckProgram(bfOperators).run();
		
		// notify we are done
		System.out.println();
		System.out.println("Done!");
	}

}
