// Klasa CommandPU

package jlogo;

import java.util.*;

public class CommandPU implements Command {
	public CommandPU() {}

	public void runCommand(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		logoScreen.penUp();				
	}
}
