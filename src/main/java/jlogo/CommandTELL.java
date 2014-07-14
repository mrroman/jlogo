// Klasa CommandTELL

package jlogo;

import java.util.*;

public class CommandTELL implements Command {
	public CommandTELL() {}

	public void runCommand(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		Object o = logoInterpreter.evaluate(it);
		
		if (o instanceof Double) 
			logoScreen.chooseTurtle(((Double)o).intValue());
		else 
			throw new InterpreterError("TELL: Wrong parameter");
	}
}
