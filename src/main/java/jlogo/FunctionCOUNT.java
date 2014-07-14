// Interfejs Function

package jlogo;

import java.util.*;

public class FunctionCOUNT implements Function { 
	public Object run(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		Object o = logoInterpreter.evaluate(it);
		
		if (o instanceof String) {
			return (Object)new Double(((String)o).length());
		} else if (o instanceof LogoList) {
			return (Object)new Double(((LogoList)o).length());
		}
			throw new InterpreterError("COUNT: Wrong parameter type");
	}
}
