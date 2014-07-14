// Interfejs Function

package jlogo;

import java.util.*;

public class FunctionMEMBERP implements Function { 
	public Object run(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		Object o1 = logoInterpreter.evaluate(it);
		Object o2 = logoInterpreter.evaluate(it);
		
		if (o2 instanceof LogoList) 
			return (Object)new Boolean(((LogoList)o2).arrayList().indexOf(o1)!=-1);
		else
			throw new InterpreterError("MEMBERP: Wrong parameter type");
	}
}
