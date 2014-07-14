// Klasa CommandPD

package jlogo;

import java.util.*;

public class CommandPD implements Command {
	public CommandPD() {}

	public void runCommand(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		logoScreen.penDown();				
	}
}
