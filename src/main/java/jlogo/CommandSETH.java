// Klasa CommandSETH

package jlogo;

import java.awt.*;
import java.util.*;

public class CommandSETH implements Command {
	public CommandSETH() {}

	public void runCommand(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		Object obj = logoInterpreter.evaluate(it);
		
		if (obj instanceof Double)
			logoScreen.turtleSetHeading(((Double)obj).doubleValue());
		else 
			throw new InterpreterError("SETH: Wrong parameter");
	}
}
