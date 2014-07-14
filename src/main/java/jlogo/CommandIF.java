// klasa CommandIF
//

package jlogo;

import java.util.*;

public class CommandIF implements Command 
{
	public void runCommand(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		Object wyr = logoInterpreter.evaluate(it);
		
		if (!(wyr instanceof Boolean)) 
			throw new InterpreterError("IF: "+wyr+" . Is it true or false?");

		Token token = Token.next(it);
		Token token2;
		
		if (!token.isList()) 
			throw new InterpreterError("IF: I don't know how to do it.");
		
		try {
			token2 = Token.next(it);
		} catch (NoSuchElementException e) { 
			token2=null;
		}
		
		if (token2!=null)
			if (!token2.isList()) {
				token2=null;
				it.previous();
			}	
			
		if (((Boolean)wyr).booleanValue()) 
			logoInterpreter.interpret(token.list().arrayList());
		else if (token2!=null)
			logoInterpreter.interpret(token2.list().arrayList());

	}
}

