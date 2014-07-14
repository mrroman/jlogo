// Interfejs Function

package jlogo;

import java.util.*;

public class FunctionNUMBERP implements Function { 
	public Object run(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		Object o = logoInterpreter.evaluate(it);
		if (o instanceof String) {
			Object v = logoInterpreter.getVariable((String)o);
			
			if (v instanceof Double) return (Object)Boolean.TRUE;
			else return (Object)Boolean.FALSE;
		} else 
			throw new InterpreterError("NUMBERP: Wrong parameter type");
	}
}
