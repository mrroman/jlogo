// Interfejs Function

package jlogo;

import java.util.*;

public class FunctionROUND implements Function { 
	public Object run(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		Object o = logoInterpreter.evaluate(it);
		if (o instanceof Double)
			return (Object)new Double(Math.round(((Double)o).doubleValue()));
		else 
			throw new InterpreterError("ROUND: Wrong parameter type");
	}
}
