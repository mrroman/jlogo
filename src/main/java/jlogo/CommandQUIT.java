// Klasa CommandQUIT

package jlogo;

import java.util.*;

public class CommandQUIT implements Command {
	public CommandQUIT() {}

	public void runCommand(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		System.exit(0);
	}
}
