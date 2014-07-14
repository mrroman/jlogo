// Klasa CommandRECYCLE

package jlogo;

import java.util.*;

public class CommandRECYCLE implements Command {
	public CommandRECYCLE() {}

	public void runCommand(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		System.gc();
	}
}
