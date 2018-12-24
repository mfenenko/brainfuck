package com.td.brainfuck.domain;

public class DecrementIndexCommand extends AbstractCommand {

	public DecrementIndexCommand(int index) {
		super(index);
	}

	@Override
	public void execute(CommandContext context) {

		context.setIndex(
		
			context.getIndex() - 1
			
		);
		
		super.execute(context);
	}
}
