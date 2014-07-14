// Klasa CommandHOME

package jlogo;

import java.util.*;

public class CommandHOME implements Command {
	public CommandHOME() {}

	public void runCommand(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		logoScreen.turtleSetPos(0,0,false);
	}
}
