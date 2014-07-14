// Klasa CommandWAIT

package jlogo.command;

import jlogo.InterpreterError;
import jlogo.LogoInterpreter;
import jlogo.LogoScreen;

import java.util.*;

public class CommandWAIT implements Command {
	public CommandWAIT() {}

	public void runCommand(LogoScreen logoScreen, LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException, InterpreterError {
		Object o = logoInterpreter.evaluate(it);
		
		if (o instanceof Double) {
			try {
				Thread.sleep((long)((Double)o).doubleValue()*1000);
			} catch (InterruptedException e) {}
		} else 
			throw new InterpreterError("WAIT: Wrong parameter");
	}
}
