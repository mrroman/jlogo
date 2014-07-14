// Klasa CommandRT

package jlogo.command;

import jlogo.InterpreterError;
import jlogo.LogoInterpreter;
import jlogo.LogoScreen;

import java.util.*;

public class CommandRT implements Command {
	public CommandRT() {}

	public void runCommand(LogoScreen logoScreen, LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException, InterpreterError {
		Object o = logoInterpreter.evaluate(it);
		
		if (o instanceof Double) 
			logoScreen.turtleRight(((Double)o).intValue());
		else 
			throw new InterpreterError("RT: Wrong parameter");
	}
}
