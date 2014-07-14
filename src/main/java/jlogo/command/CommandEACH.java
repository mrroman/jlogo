// Klasa CommandEACH

package jlogo.command;

import jlogo.InterpreterError;
import jlogo.LogoInterpreter;
import jlogo.LogoList;
import jlogo.LogoScreen;

import java.util.*;

public class CommandEACH implements Command {
	public CommandEACH() {}

	public void runCommand(LogoScreen logoScreen, LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException, InterpreterError {
		Object obj=logoInterpreter.evaluate(it);
		
		if (!(obj instanceof LogoList))
			throw new InterpreterError("EACH doesn't like input");
		
		int tmp = logoScreen.getCurrentTurtle();

		for (int i=0;i<logoScreen.turtlesNumber();i++) {
			logoScreen.chooseTurtle(i);
			logoInterpreter.interpret(((LogoList)obj).arrayList());
		}

		logoScreen.chooseTurtle(tmp);
	}
}
