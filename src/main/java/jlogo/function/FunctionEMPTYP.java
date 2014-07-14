// Interfejs Function

package jlogo.function;

import jlogo.InterpreterError;
import jlogo.LogoInterpreter;
import jlogo.LogoList;
import jlogo.LogoScreen;

import java.util.*;

public class FunctionEMPTYP implements Function { 
	public Object run(LogoScreen logoScreen, LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException, InterpreterError {
		Object o = logoInterpreter.evaluate(it);
		
		if (o instanceof String) {
			return (Object)new Boolean(((String)o).length()==0);
		} else if (o instanceof LogoList) {
			return (Object)new Boolean(((LogoList)o).length()==0);
		}
			throw new InterpreterError("EMPTYP: Wrong parameter type");
	}
}
