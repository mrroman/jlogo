// Interfejs Function

package jlogo;

import java.util.*;

public class FunctionGETL implements Function { 
	public Object run(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		Object o = logoInterpreter.evaluate(it);
		Object o2 = logoInterpreter.evaluate(it);
		
		if (!(o2 instanceof Double)) 
			throw new InterpreterError("GETL: Wrong parameter type");
		
		int no = ((Double)o2).intValue();		
		
		if (o instanceof String) {
			if (no>=((String)o).length()) 
				throw new InterpreterError("GETL: Index out of bounds");
			
			return (Object)((String)o).substring(no,no+1);
		} else if (o instanceof LogoList) {
			if (no>=((LogoList)o).length()) 
				throw new InterpreterError("GETL: Index out of bounds");
					
			return (Object)((LogoList)o).get(no);
		} else
			throw new InterpreterError("GETL: Wrong parameter type");
	}
}
