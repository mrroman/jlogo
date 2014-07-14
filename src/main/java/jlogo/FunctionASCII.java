// Interfejs Function

package jlogo;

import java.util.*;

public class FunctionASCII implements Function { 
	public Object run(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		Object o = logoInterpreter.evaluate(it);
		if (o instanceof String) {
			return (Object)new Double((int)((String)o).charAt(0));
		} else 
			throw new InterpreterError("ASCII: Wrong parameter type");
	}
}
