// Interfejs Function

package jlogo;

import java.util.*;

public class FunctionNOT implements Function { 
	public Object run(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		Object o = logoInterpreter.evaluate(it);
		if (o instanceof Boolean) {
			boolean a = ((Boolean)o).booleanValue();
			return (Object)(a ? Boolean.FALSE : Boolean.TRUE);
		} else 
			throw new InterpreterError("NOT: Wrong parameter type");
	}
}
