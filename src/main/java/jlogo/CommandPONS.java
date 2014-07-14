// klasa CommandPONS
//

package jlogo;

import java.util.*;

public class CommandPONS implements Command 
{
	public void runCommand(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		logoInterpreter.printAllVariables();
	}
}

