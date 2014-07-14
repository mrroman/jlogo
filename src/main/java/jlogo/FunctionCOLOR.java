// Klasa FunctionCOLOR

package jlogo;

import java.util.*;
import java.awt.*;

public class FunctionCOLOR implements Function { 
	public Object run(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		Color c = logoScreen.getColor();
		LogoList ll = new LogoList(new ArrayList());
		
		ll.add(new Double((double)c.getRed()));
		ll.add(new Double((double)c.getGreen()));
		ll.add(new Double((double)c.getBlue()));
		
		return ll;
	}
}
