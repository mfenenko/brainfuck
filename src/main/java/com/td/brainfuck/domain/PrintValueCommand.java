package com.td.brainfuck.domain;

public class PrintValueCommand extends AbstractCommand {

	public PrintValueCommand(int index) {
		super(index);
	}

	@Override
	public void execute(CommandContext context) {
			
		System.out.print((char) context.getValueAtIndex());

		super.execute(context);
	}

}
