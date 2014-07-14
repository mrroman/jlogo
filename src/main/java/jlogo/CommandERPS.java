// klasa CommandERPS
//

package jlogo;

import java.util.*;

public class CommandERPS implements Command 
{
	public void runCommand(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		logoInterpreter.eraseAllUserCmds();
	}
}

