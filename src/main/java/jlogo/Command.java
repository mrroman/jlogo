// Interfejs Command

package jlogo;

import java.util.*;

public interface Command { 
	public abstract void runCommand(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError;
}
