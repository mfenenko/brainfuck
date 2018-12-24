package com.td.brainfuck;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import com.td.brainfuck.domain.CommandContext;
import com.td.brainfuck.domain.DecrementIndexCommand;
import com.td.brainfuck.analyse.BrainfuckAnalyser;
import com.td.brainfuck.analyse.BrainfuckOperator;
import com.td.brainfuck.domain.AbstractCommand;
import com.td.brainfuck.domain.IncrementIndexCommand;
import com.td.brainfuck.domain.IncrementValueCommand;
import com.td.brainfuck.executor.BrainfuckProgram;

import junit.framework.TestCase;

public class BrainfuckExecutorTest extends TestCase {

	@Test
	public void testIncrementIndexCommand() {

		CommandContext context = new CommandContext();
			context.setIndex(3);
			context.setValueAtIndex((byte)4);
		
		Collection<AbstractCommand> commands = new ArrayList<>();	
			commands.add(new IncrementValueCommand(0));
			commands.add(new IncrementIndexCommand(1));
			commands.add(new IncrementIndexCommand(2));
			commands.add(new DecrementIndexCommand(3));
		
		for (AbstractCommand iCommand : commands) {
			iCommand.execute(context);
		}
			
		assertEquals(5, context.getValueAtIndex(3));
		assertEquals(4, context.getIndex());
		
	}
	
	@Test
	public void testAddTwoDigits() {
	
		String input = "++>+++++[<+>-]";
		
		// analyse input and make collection of operators
		List<BrainfuckOperator> bfOperators = new BrainfuckAnalyser().map(input);
		
		// execute them 
		BrainfuckProgram program = new BrainfuckProgram(bfOperators);
			program.run();
			
		assertEquals(7, program.getContext().getValueAtIndex(0));
		
	}	
	
}
