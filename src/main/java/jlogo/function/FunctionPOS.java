// Klasa FunctionPOS

package jlogo.function;

import jlogo.InterpreterError;
import jlogo.LogoInterpreter;
import jlogo.LogoList;
import jlogo.LogoScreen;

import java.util.*;

public class FunctionPOS implements Function { 
	public Object run(LogoScreen logoScreen, LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException, InterpreterError {
		LogoList ll = new LogoList(new ArrayList());
		
		ll.add(new Double(logoScreen.turtleGetX()));
		ll.add(new Double(logoScreen.turtleGetY()));
	
		return ll;
	}
}
