// Interfejs Function

package jlogo.function;

import jlogo.InterpreterError;
import jlogo.LogoInterpreter;
import jlogo.LogoScreen;

import java.util.*;

public class FunctionRANDOM implements Function { 
	public Object run(LogoScreen logoScreen, LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException, InterpreterError {
		Object o = logoInterpreter.evaluate(it);
		if (o instanceof Double)
			return (Object)new Double(logoInterpreter.getRandom(((Double)o).doubleValue()));
		else 
			throw new InterpreterError("RANDOM: Wrong parameter type");
	}
}
