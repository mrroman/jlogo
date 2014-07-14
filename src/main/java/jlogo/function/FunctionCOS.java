// Interfejs Function

package jlogo.function;

import jlogo.InterpreterError;
import jlogo.LogoInterpreter;
import jlogo.LogoScreen;

import java.util.*;

public class FunctionCOS implements Function { 
	public Object run(LogoScreen logoScreen, LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException, InterpreterError {
		Object o = logoInterpreter.evaluate(it);
		if (o instanceof Double)
			return (Object)new Double(Math.cos(((Double)o).doubleValue()*Math.PI/180.0));
		else 
			throw new InterpreterError("COS: Wrong parameter type");
	}
}
