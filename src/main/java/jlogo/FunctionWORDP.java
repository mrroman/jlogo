// Interfejs Function

package jlogo;

import java.util.*;

public class FunctionWORDP implements Function { 
	public Object run(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		Object o = logoInterpreter.evaluate(it);
		
		if (o instanceof String) {
			Object v = logoInterpreter.getVariable((String)o);
			
			if (v instanceof String) return Boolean.TRUE;
			else return Boolean.FALSE;
		} else 
			throw new InterpreterError("WORDP: Wrong parameter type");
	}
}
