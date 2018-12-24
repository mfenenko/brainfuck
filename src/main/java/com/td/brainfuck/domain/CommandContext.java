package com.td.brainfuck.domain;

import java.util.LinkedList;
import java.util.List;

public class CommandContext {

    public static final int LENGTH = 65535;
    
    private byte[] values = new byte[LENGTH];
    
    /*
     * Index in the array of values
     */
    private int index = 0;
    
    /*
     * Next command index in the list of commands
     */
    private int nextCommand = 0;
    
    private List<Integer> loopStartIndexes = new LinkedList<>();
    
    private List<Integer> loopEndIndexes = new LinkedList<>();
    
    public int getIndex() {
    	return index;
    }
    
    public void setIndex(int index) {
    	this.index = index;
    }
    
    public byte getValueAtIndex() {
    	return values[index];
    }
    
    public byte getValueAtIndex(int index) {
    	return values[index];
    }
    
    public void setValueAtIndex(byte value) {
    	this.values[index] = value;
    }
    
    public void setValueAtIndex(byte value, int index) {
    	this.values[index] = value;
    }

	public int getNextCommand() {
		return nextCommand;
	}

	public void setNextCommand(int nextCommand) {
		this.nextCommand = nextCommand;
	}
    
	public void addLoopStartIndex(int index) {
		this.loopStartIndexes.add(index);
	}
	
	public int getLoopStartIndex() {
		return loopStartIndexes.size() > 0 ? loopStartIndexes.get(loopStartIndexes.size() - 1) : -1;
	}
	
	public void removeLoopStartIndex() {
		if (loopStartIndexes.size() > 0) loopStartIndexes.remove(loopStartIndexes.size() - 1);
	}
    
	public void addLoopEndIndex(int index) {
		this.loopEndIndexes.add(index);
	}
	
	public int getLoopEndIndex() {
		return loopEndIndexes.size() > 0 ? loopEndIndexes.get(loopEndIndexes.size() - 1) : -1;
	}
	
	public void removeLoopEndIndex() {
		if (loopEndIndexes.size() > 0) loopEndIndexes.remove(loopEndIndexes.size() - 1);
	}
	
}
