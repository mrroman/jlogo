// Interfejs Function

package jlogo;

import java.util.*;

public class FunctionLAST implements Function { 
	public Object run(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		Object o = logoInterpreter.evaluate(it);
		
		if (o instanceof String) {
			return (Object)((String)o).substring(((String)o).length()-1);
		} else if (o instanceof LogoList) {
			try {
				return (Object)((LogoList)o).last();
			} catch(IndexOutOfBoundsException e) {
				throw new InterpreterError("LAST doesn't like [] input");
			}
		}
			throw new InterpreterError("LAST: Wrong parameter type");
	}
}
