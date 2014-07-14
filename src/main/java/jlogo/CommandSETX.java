// Klasa CommandSETX

package jlogo;

import java.awt.*;
import java.util.*;

public class CommandSETX implements Command {
	public CommandSETX() {}

	public void runCommand(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		Object obj = logoInterpreter.evaluate(it);
		
		if (obj instanceof Double)
			logoScreen.turtleSetPos(((Double)obj).doubleValue(),logoScreen.turtleGetY());
		else 
			throw new InterpreterError("SETX: Wrong parameter");
	}
}
