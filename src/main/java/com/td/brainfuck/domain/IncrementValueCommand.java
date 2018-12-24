package com.td.brainfuck.domain;

public class IncrementValueCommand extends AbstractCommand {

	public IncrementValueCommand(int index) {
		super(index);
	}

	@Override
	public void execute(CommandContext context) {
		
		context.setValueAtIndex(
		
			(byte)(context.getValueAtIndex() + 1)
				
		);
		
		super.execute(context);
	}
}
