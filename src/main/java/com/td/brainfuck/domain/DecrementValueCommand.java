package com.td.brainfuck.domain;

public class DecrementValueCommand extends AbstractCommand {

	public DecrementValueCommand(int index) {
		super(index);
	}

	@Override
	public void execute(CommandContext context) {
		
		context.setValueAtIndex(
		
			(byte)(context.getValueAtIndex() - 1)
			
		);

		super.execute(context);
	}
}
