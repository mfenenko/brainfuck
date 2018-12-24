package com.td.brainfuck.executor;

import java.util.ArrayList;
import java.util.List;

import com.td.brainfuck.analyse.BrainfuckOperator;
import com.td.brainfuck.domain.AbstractCommand;
import com.td.brainfuck.domain.CommandContext;

/**
 * 
 * @author mfenenko
 *
 */
public class BrainfuckProgram {

	private List<AbstractCommand> commands;
	private CommandContext context;

	/**
	 * Constructor
	 * @param operators
	 */
	public BrainfuckProgram(List<BrainfuckOperator> operators) {
		this(operators, new CommandContext());
	}
	
	/**
	 * Constructor
	 * @param operators
	 * @param context
	 */
	public BrainfuckProgram(List<BrainfuckOperator> operators, CommandContext context) {
		this.context = context;
		
		this.commands = new ArrayList<>(operators.size());
		
		for(int i = 0; i < operators.size(); i++) {
			AbstractCommand command = operators.get(i).newCommand(i);
			
			commands.add(command);
		}
	}

	/**
	 * Run the program 
	 */
	public void run() {
		int nextCommand = context.getNextCommand();
		
		while (nextCommand < commands.size()) {
			
			commands.get(nextCommand).execute(context);
			
			nextCommand = context.getNextCommand();
		}
	}
	
	public CommandContext getContext() {
		return this.context;
	}
}
