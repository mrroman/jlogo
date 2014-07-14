// Klasa CommandSAVE

package jlogo.command;

import jlogo.InterpreterError;
import jlogo.LogoInterpreter;
import jlogo.LogoList;
import jlogo.LogoScreen;

import java.util.*;

public class CommandSAVE implements Command {
	public CommandSAVE() {}

	public void runCommand(LogoScreen logoScreen, LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException, InterpreterError {
		Object o = logoInterpreter.evaluate(it);
		
		if (!(o instanceof String) && !(o instanceof LogoList))
			throw new InterpreterError("SAVE: Wrong parameter");
		
		try {
			String fileName = o.toString();
			
			logoInterpreter.saveAllUserCmds(fileName);
		} catch (InterpreterError e) {
			throw new InterpreterError("SAVE: "+e.getMessage());
		}

	}
}
