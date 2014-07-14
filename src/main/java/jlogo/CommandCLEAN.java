// Klasa CommandCLEAN

package jlogo;

import java.util.*;

public class CommandCLEAN implements Command {
	public CommandCLEAN() {}

	public void runCommand(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		logoScreen.clearScreen();
	}
}
