// Klasa CommandBK

package jlogo.command;

import jlogo.InterpreterError;
import jlogo.LogoInterpreter;
import jlogo.LogoScreen;

import java.util.*;

public class CommandBK implements Command {
	public CommandBK() {}

	public void runCommand(LogoScreen logoScreen, LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException, InterpreterError {
		Object o = logoInterpreter.evaluate(it);
		
		if (o instanceof Double) 
			logoScreen.turtleBackward(((Double)o).intValue());
		else 
			throw new InterpreterError("BK: Wrong parameter");

	}
}
