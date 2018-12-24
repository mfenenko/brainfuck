package com.td.brainfuck.analyse;

import java.util.Collection;

public interface IAnalyser<T> {

	Collection<T> map(String input);
	
}
