// Interfejs Function

package jlogo;

import java.util.*;

public class FunctionNAMEP implements Function { 
	public Object run(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		Object o = logoInterpreter.evaluate(it);
		if (o instanceof String) {
			Object v = logoInterpreter.getVariable((String)o);
			
			if (v==null) return (Object)Boolean.FALSE;
			else return (Object)Boolean.TRUE;
		} else 
			throw new InterpreterError("NAMEP: Wrong parameter type");
	}
}
