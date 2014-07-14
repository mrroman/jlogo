// klasa CommandERALL
//

package jlogo;

import java.util.*;

public class CommandERALL implements Command 
{
	public void runCommand(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		logoInterpreter.eraseAll();
	}
}

