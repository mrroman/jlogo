// Interfejs Function

package jlogo.function;

import jlogo.InterpreterError;
import jlogo.LogoInterpreter;
import jlogo.LogoList;
import jlogo.LogoScreen;

import java.util.*;

public class FunctionBL implements Function { 
	public Object run(LogoScreen logoScreen, LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException, InterpreterError {
		Object o = logoInterpreter.evaluate(it);
		
		if (o instanceof String) {
			return (Object)((String)o).substring(0,((String)o).length()-1);
		} else if (o instanceof LogoList) {
			try {
				return (Object)((LogoList)o).withoutLast();
			} catch(IndexOutOfBoundsException e) {
				throw new InterpreterError("BL doesn't like [] input");
			}
		}
			throw new InterpreterError("BL: Wrong parameter type");
	}
}
