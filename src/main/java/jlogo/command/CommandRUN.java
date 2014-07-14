// Klasa CommandRUN

package jlogo.command;

import jlogo.InterpreterError;
import jlogo.LogoInterpreter;
import jlogo.LogoList;
import jlogo.LogoScreen;

import java.util.*;

public class CommandRUN implements Command {
	public CommandRUN() {}

	public void runCommand(LogoScreen logoScreen, LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException, InterpreterError {
		Object obj=logoInterpreter.evaluate(it);
		
		if (!(obj instanceof LogoList))
			throw new InterpreterError("RUN doesn't like input");
		
		logoInterpreter.interpret(((LogoList)obj).arrayList());
	}
}
