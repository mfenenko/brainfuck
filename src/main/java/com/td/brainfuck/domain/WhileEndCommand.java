package com.td.brainfuck.domain;

public class WhileEndCommand extends AbstractCommand {

	public WhileEndCommand(int index) {
		super(index);
	}

	@Override
	public void execute(CommandContext context) {
		
		if (!isInProgress(context)) {
			context.addLoopEndIndex(getIndex());
		}
		
		context.setNextCommand(
			context.getLoopStartIndex()
		);
	}
	
	protected boolean isInProgress(CommandContext context) {
		return context.getLoopEndIndex() == getIndex();
	}
}
