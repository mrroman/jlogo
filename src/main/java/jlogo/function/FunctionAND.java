// Interfejs Function

package jlogo.function;

import jlogo.InterpreterError;
import jlogo.LogoInterpreter;
import jlogo.LogoScreen;

import java.util.*;

public class FunctionAND implements Function { 
	public Object run(LogoScreen logoScreen, LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException, InterpreterError {
		Object o1 = logoInterpreter.evaluate(it);
		Object o2 = logoInterpreter.evaluate(it);
		
		if ((o1 instanceof Boolean) && (o2 instanceof Boolean)) {
			boolean a = ((Boolean)o1).booleanValue();
			boolean b = ((Boolean)o2).booleanValue();
			
			return (Object)new Boolean(a && b);
		} else 
			throw new InterpreterError("AND: Wrong parameter type");
	}
}
