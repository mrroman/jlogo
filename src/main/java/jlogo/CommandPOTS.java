// klasa CommandPOTS
//

package jlogo;

import java.util.*;

public class CommandPOTS implements Command 
{
	public void runCommand(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		logoInterpreter.printAllUserCmds();
	}
}

