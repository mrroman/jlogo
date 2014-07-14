// Klasa CommandASK

package jlogo;

import java.util.*;

public class CommandASK implements Command {
	public CommandASK() {}

	public void runCommand(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		Object obj=logoInterpreter.evaluate(it);
		Object obj2 = logoInterpreter.evaluate(it);
		
		if (!(obj instanceof LogoList) && !(obj2 instanceof LogoList)) 
			throw new InterpreterError("ASK doesn't like input");
		
		LogoList l1 = (LogoList)obj;
		LogoList l2 = (LogoList)obj2;
		
		int tmp = logoScreen.getCurrentTurtle();

		for (int i=0;i<l1.length();i++) {
			if (!(l1.get(i) instanceof Double)) 
				throw new InterpreterError("ASK don't know that turtle");
			
			int n = ((Double)l1.get(i)).intValue();
			if (n>=logoScreen.turtlesNumber())
				throw new InterpreterError("ASK don't know that turtle");
			
			logoScreen.chooseTurtle(n);
			logoInterpreter.interpret(l2.arrayList());
		}

		logoScreen.chooseTurtle(tmp);
	}
}
