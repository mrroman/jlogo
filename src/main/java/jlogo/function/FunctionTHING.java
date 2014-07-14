// Interfejs Function

package jlogo.function;

import jlogo.InterpreterError;
import jlogo.LogoInterpreter;
import jlogo.LogoScreen;

import java.util.*;

public class FunctionTHING implements Function { 
	public Object run(LogoScreen logoScreen, LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException, InterpreterError {
		Object o = logoInterpreter.evaluate(it);
		if (o instanceof String) {
			Object v = logoInterpreter.getVariable((String)o);
			
			if (v!=null) return v;
			else 
				throw new InterpreterError("THING: Unknown variable");
		} else 
			throw new InterpreterError("THING: Wrong parameter type");
	}
}
