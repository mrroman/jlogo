// Klasa CommandFD

package jlogo.command;

import jlogo.InterpreterError;
import jlogo.LogoInterpreter;
import jlogo.LogoScreen;

import java.util.*;

public class CommandFD implements Command {
	public CommandFD() {}

	public void runCommand(LogoScreen logoScreen, LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException, InterpreterError {
		Object o = logoInterpreter.evaluate(it);
		
		if (o instanceof Double) 
			logoScreen.turtleForward(((Double)o).intValue());
		else 
			throw new InterpreterError("FD: Wrong parameter");
	}
}
