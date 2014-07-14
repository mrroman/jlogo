// Klasa CommandSETPOS

package jlogo.command;

import jlogo.InterpreterError;
import jlogo.LogoInterpreter;
import jlogo.LogoScreen;

import java.util.*;

public class CommandSETPOS implements Command {
	public CommandSETPOS() {}

	public void runCommand(LogoScreen logoScreen, LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException, InterpreterError {
		Object obj1 = logoInterpreter.evaluate(it);
		Object obj2 = logoInterpreter.evaluate(it);
		
		if ((obj1 instanceof Double) && (obj1 instanceof Double)) {
			Double num1=(Double)obj1;
			Double num2=(Double)obj2;
			
			logoScreen.turtleSetPos(num1.doubleValue(),num2.doubleValue());
		} else 
			throw new InterpreterError("SETPOS: Don't like the input.");
	}
}
