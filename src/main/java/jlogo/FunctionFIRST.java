// Interfejs Function

package jlogo;

import java.util.*;

public class FunctionFIRST implements Function { 
	public Object run(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		Object o = logoInterpreter.evaluate(it);
		
		if (o instanceof String) {
			return (Object)((String)o).substring(0,1);
		} else if (o instanceof LogoList) {
			try {
				return (Object)((LogoList)o).first();
			} catch(IndexOutOfBoundsException e) {
				throw new InterpreterError("FIRST doesn't like [] input");
			}
		}
			throw new InterpreterError("FIRST: Wrong parameter type");
	}
}
