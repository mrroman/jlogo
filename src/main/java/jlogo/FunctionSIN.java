// Interfejs Function

package jlogo;

import java.util.*;

public class FunctionSIN implements Function { 
	public Object run(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		Object o = logoInterpreter.evaluate(it);
		if (o instanceof Double)
			return (Object)new Double(Math.sin(((Double)o).doubleValue()*Math.PI/180.0));
		else 
			throw new InterpreterError("SIN: Wrong parameter type");
	}
}
