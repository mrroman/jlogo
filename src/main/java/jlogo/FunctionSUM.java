// Interfejs Function

package jlogo;

import java.util.*;

public class FunctionSUM implements Function { 
	public Object run(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		Object o1 = logoInterpreter.evaluate(it);
		Object o2 = logoInterpreter.evaluate(it);
		
		if ((o1 instanceof Double) && (o2 instanceof Double))
			return (Object)new Double(((Double)o1).doubleValue()+((Double)o2).doubleValue());
		else 
			throw new InterpreterError("SUM: Wrong parameter type");
	}
}
