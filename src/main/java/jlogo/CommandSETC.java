// Klasa CommandSETC

package jlogo;

import java.awt.*;
import java.util.*;

public class CommandSETC implements Command {
	public CommandSETC() {}

	public void runCommand(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		Object r = logoInterpreter.evaluate(it);
		Object g = logoInterpreter.evaluate(it);
		Object b = logoInterpreter.evaluate(it);
		
		if ((r instanceof Double) && (r instanceof Double) && (r instanceof Double))
			logoScreen.setColor(((Double)r).intValue(),((Double)g).intValue(),((Double)b).intValue());
		else 
			throw new InterpreterError("SETC: Wrong parameter");
	}
}
