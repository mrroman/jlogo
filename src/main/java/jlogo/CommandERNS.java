// klasa CommandERNS
//

package jlogo;

import java.util.*;

public class CommandERNS implements Command 
{
	public void runCommand(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		logoInterpreter.eraseAllVariables();
	}
}

