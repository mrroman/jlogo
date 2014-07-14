// Interfejs Function

package jlogo.function;

import jlogo.InterpreterError;
import jlogo.LogoInterpreter;
import jlogo.LogoList;
import jlogo.LogoScreen;

import java.util.*;

public class FunctionBF implements Function { 
	public Object run(LogoScreen logoScreen, LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException, InterpreterError {
		Object o = logoInterpreter.evaluate(it);
		
		if (o instanceof String) {
			return (Object)((String)o).substring(1);
		} else if (o instanceof LogoList) {
			try {
				return (Object)((LogoList)o).withoutFirst();
			} catch(IndexOutOfBoundsException e) {
				throw new InterpreterError("BF doesn't like [] input");
			}
		}
			throw new InterpreterError("BF: Wrong parameter type");
	}
}
