// Klasa CommandCS

package jlogo;

import java.util.*;

public class CommandCS implements Command {
	public CommandCS() {}

	public void runCommand(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		logoScreen.clearScreen();
		logoScreen.turtleSetPos(0,0,false);
	}
}
