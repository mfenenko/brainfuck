package com.td.brainfuck.domain;

public abstract class AbstractCommand {

	private final int index;
	
	public AbstractCommand(int index) {
		this.index = index;
	}
	
	public int getIndex() {
		return index;
	}

	/**
	 * Executes current command.
	 * Place super method call in the end of overriding method
	 * to move to the next command
	 * @param context
	 */
	public void execute(CommandContext context) {
		context.setNextCommand(getIndex() + 1);
	};
	
}
