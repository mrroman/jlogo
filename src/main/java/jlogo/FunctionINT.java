// Interfejs Function

package jlogo;

import java.util.*;

public class FunctionINT implements Function { 
	public Object run(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		Object o = logoInterpreter.evaluate(it);
		if (o instanceof Double)
			return (Object)new Double((double)((Double)o).intValue());
		else 
			throw new InterpreterError("INT: Wrong parameter type");
	}
}
