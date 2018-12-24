package com.td.brainfuck.analyse;

import com.td.brainfuck.domain.DecrementIndexCommand;
import com.td.brainfuck.domain.DecrementValueCommand;
import com.td.brainfuck.domain.AbstractCommand;
import com.td.brainfuck.domain.IncrementIndexCommand;
import com.td.brainfuck.domain.IncrementValueCommand;
import com.td.brainfuck.domain.PrintValueCommand;
import com.td.brainfuck.domain.WhileEndCommand;
import com.td.brainfuck.domain.WhileStartCommand;

public enum BrainfuckOperator {

	INDEX_INC('>', IncrementIndexCommand.class),
	INDEX_DEC('<', DecrementIndexCommand.class),
	VALUE_INC('+', IncrementValueCommand.class),
	VALUE_DEC('-', DecrementValueCommand.class),
	VALUE_PRINT('.', PrintValueCommand.class),
	VALUE_WHILE_START('[', WhileStartCommand.class),
	VALUE_WHILE_END(']'  , WhileEndCommand.class);
	
	
	private final char operator;
	
	private final Class commandClass;
 	
	private BrainfuckOperator(char operator, Class commandClass) {
		this.operator = operator;
		this.commandClass = commandClass;
	}
	
	public char getOperator() {
		return operator;
	}
	
	public AbstractCommand newCommand(int index) {
		try {
			return (AbstractCommand) commandClass.getConstructor(int.class).newInstance(index);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static BrainfuckOperator of(char operator) {
		for (BrainfuckOperator oper : values()) {
			if (oper.operator == operator) {
				return oper;
			}
		}
		return null;
	}
	
}
