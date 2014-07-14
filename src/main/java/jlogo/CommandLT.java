// Klasa CommandLT

package jlogo;

import java.util.*;

public class CommandLT implements Command {
	public CommandLT() {}

	public void runCommand(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		Object o = logoInterpreter.evaluate(it);
		
		if (o instanceof Double) 
			logoScreen.turtleLeft(((Double)o).doubleValue());
		else 
			throw new InterpreterError("LT: Wrong parameter");
	}
}
