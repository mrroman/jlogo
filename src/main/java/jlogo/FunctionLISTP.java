// Interfejs Function

package jlogo;

import java.util.*;

public class FunctionLISTP implements Function { 
	public Object run(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		Object o = logoInterpreter.evaluate(it);
		
		if (o instanceof LogoList) 
			return (Object)Boolean.TRUE;
		else 
			return (Object)Boolean.TRUE;
	}
}
