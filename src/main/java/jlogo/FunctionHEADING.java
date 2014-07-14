// Klasa FunctionHEADING

package jlogo;

import java.util.*;

public class FunctionHEADING implements Function { 
	public Object run(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		return new Double(logoScreen.turtleGetHeading());
	}
}
