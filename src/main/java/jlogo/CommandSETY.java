// Klasa CommandSETY

package jlogo;

import java.awt.*;
import java.util.*;

public class CommandSETY implements Command {
	public CommandSETY() {}

	public void runCommand(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		Object obj = logoInterpreter.evaluate(it);
		
		if (obj instanceof Double)
			logoScreen.turtleSetPos(logoScreen.turtleGetX(),((Double)obj).doubleValue());
		else 
			throw new InterpreterError("SETY: Wrong parameter");
	}
}
