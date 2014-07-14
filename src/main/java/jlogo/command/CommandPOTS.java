// klasa CommandPOTS
//

package jlogo.command;

import jlogo.InterpreterError;
import jlogo.LogoInterpreter;
import jlogo.LogoScreen;

import java.util.*;

public class CommandPOTS implements Command 
{
	public void runCommand(LogoScreen logoScreen, LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException, InterpreterError {
		logoInterpreter.printAllUserCmds();
	}
}

