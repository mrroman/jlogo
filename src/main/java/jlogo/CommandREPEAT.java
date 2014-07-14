// Klasa CommandREPEAT

package jlogo;

import java.util.*;

public class CommandREPEAT implements Command {
	public CommandREPEAT() {}

	public void runCommand(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		Object obj = logoInterpreter.evaluate(it);

		if (!(obj instanceof Double))
			throw new InterpreterError("REPEAT doesn't like input");

		int len = ((Double)obj).intValue();
		obj=logoInterpreter.evaluate(it);
		
		if (!(obj instanceof LogoList)) 
			throw new InterpreterError("REPEAT doesn't like input");
		
		for (;len>0;len--) 
			logoInterpreter.interpret(((LogoList)obj).arrayList());
	}
}
