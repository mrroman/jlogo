// Interfejs Function

package jlogo;

import java.util.*;

public class FunctionWORD implements Function { 
	public Object run(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		Object o1 = logoInterpreter.evaluate(it);
		Object o2 = logoInterpreter.evaluate(it);
		
		if ((o1 instanceof String) && (o2 instanceof String))
			return (Object)((String)o1+(String)o2);
		else 
			throw new InterpreterError("WORD: Wrong parameter type");
	}
}
