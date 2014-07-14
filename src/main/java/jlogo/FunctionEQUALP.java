// Interfejs Function

package jlogo;

import java.util.*;

public class FunctionEQUALP implements Function { 
	public Object run(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		Object o1 = logoInterpreter.evaluate(it);
		Object o2 = logoInterpreter.evaluate(it);
		
		if (((o1 instanceof Double) && (o2 instanceof Double)) ||
		    ((o1 instanceof String) && (o2 instanceof String)) ||
		    ((o1 instanceof LogoList) && (o2 instanceof LogoList)))
			return (Object)new Boolean(o1.equals(o2));
		else 
			return (Object)Boolean.FALSE;
	}
}
