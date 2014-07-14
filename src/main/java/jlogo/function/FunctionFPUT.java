// Interfejs Function

package jlogo.function;

import jlogo.InterpreterError;
import jlogo.LogoInterpreter;
import jlogo.LogoList;
import jlogo.LogoScreen;

import java.util.*;

public class FunctionFPUT implements Function { 
	public Object run(LogoScreen logoScreen, LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException, InterpreterError {
		Object o1 = logoInterpreter.evaluate(it);
		Object o2 = logoInterpreter.evaluate(it);
		
		if (o2 instanceof LogoList)
			return (Object)((LogoList)o2).firstPut(o1);
		else
			throw new InterpreterError("FPUT: Wrong parameter type");
	}
}
