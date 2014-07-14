// Klasa CommandCT

package jlogo;

import java.util.*;

public class CommandCT implements Command {
	public CommandCT() {}

	public void runCommand(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		logoInterpreter.consoleClear();
	}
}
