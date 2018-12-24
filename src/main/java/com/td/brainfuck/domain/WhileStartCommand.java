package com.td.brainfuck.domain;

public class WhileStartCommand extends AbstractCommand {

	public WhileStartCommand(int index) {
		super(index);
	}

	@Override
	public void execute(CommandContext context) {
		
		if (!isInProgress(context)) {
			context.addLoopStartIndex(getIndex());
		}
		
		if (context.getValueAtIndex() == 0) {

			context.removeLoopStartIndex();
			context.setNextCommand(
				context.getLoopEndIndex() + 1
			);
			context.removeLoopEndIndex();
			
		} else {
			
			super.execute(context);
			
		}
	}
	
	protected boolean isInProgress(CommandContext context) {
		return context.getLoopStartIndex() == getIndex();
	}

}
