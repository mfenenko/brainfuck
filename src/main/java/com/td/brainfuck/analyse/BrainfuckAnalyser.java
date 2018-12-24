package com.td.brainfuck.analyse;

import java.util.ArrayList;
import java.util.List;

public class BrainfuckAnalyser implements IAnalyser<BrainfuckOperator> {

	@Override
	public List<BrainfuckOperator> map(String input) {
		List<BrainfuckOperator> commands = new ArrayList<>(input.length());
		
		for(int i = 0; i < input.length(); i++) {
			char bfCommand = input.charAt(i);
			
			BrainfuckOperator operator = BrainfuckOperator.of(bfCommand);
			
			if (operator != null) {
				commands.add(operator);
			}
		}
		
		return commands;
	}

}
