// Klasa FunctionPOS

package jlogo;

import java.util.*;

public class FunctionPOS implements Function { 
	public Object run(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		LogoList ll = new LogoList(new ArrayList());
		
		ll.add(new Double(logoScreen.turtleGetX()));
		ll.add(new Double(logoScreen.turtleGetY()));
	
		return ll;
	}
}
