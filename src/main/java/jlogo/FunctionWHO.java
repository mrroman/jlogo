// Klasa FunctionWHO

package jlogo;

import java.util.*;

public class FunctionWHO implements Function { 
	public Object run(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		return new Double((double)logoScreen.getCurrentTurtle());
	}
}
