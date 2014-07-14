// Klasa CommandBG

package jlogo.command;

import jlogo.InterpreterError;
import jlogo.LogoInterpreter;
import jlogo.LogoScreen;

import java.util.*;

public class CommandSETBG implements Command {
	public CommandSETBG() {}

	public void runCommand(LogoScreen logoScreen, LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException, InterpreterError {
		Object r = logoInterpreter.evaluate(it);
		Object g = logoInterpreter.evaluate(it);
		Object b = logoInterpreter.evaluate(it);
		
		if ((r instanceof Double) && (r instanceof Double) && (r instanceof Double))
			logoScreen.setBgColor(((Double)r).intValue(),((Double)g).intValue(),((Double)b).intValue());
		else 
			throw new InterpreterError("SETBG: Wrong parameter");
	}
}
