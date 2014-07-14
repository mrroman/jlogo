// Klasa FunctionXCOR

package jlogo.function;

import jlogo.InterpreterError;
import jlogo.LogoInterpreter;
import jlogo.LogoScreen;

import java.util.*;

public class FunctionXCOR implements Function { 
	public Object run(LogoScreen logoScreen, LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException, InterpreterError {
		return new Double(logoScreen.turtleGetX());
	}
}
