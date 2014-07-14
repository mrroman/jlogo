// Interfejs Function

package jlogo;

import java.util.*;

public class FunctionSQRT implements Function { 
	public Object run(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		Object o = logoInterpreter.evaluate(it);
		if (o instanceof Double)
			return (Object)new Double(Math.sqrt(((Double)o).intValue()));
		else 
			throw new InterpreterError("SQRT: Wrong parameter type");
	}
}
