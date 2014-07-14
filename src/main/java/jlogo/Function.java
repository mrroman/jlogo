// Interfejs Function

package jlogo;

import java.util.*;

public interface Function { 
	public abstract Object run(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError;
}
