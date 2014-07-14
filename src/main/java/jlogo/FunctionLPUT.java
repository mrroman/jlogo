// Interfejs Function

package jlogo;

import java.util.*;

public class FunctionLPUT implements Function { 
	public Object run(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		Object o1 = logoInterpreter.evaluate(it);
		Object o2 = logoInterpreter.evaluate(it);
		
		if (o2 instanceof LogoList)
			return (Object)((LogoList)o2).lastPut(o1);
		else 
			throw new InterpreterError("LPUT: Wrong parameter type");
	}
}
