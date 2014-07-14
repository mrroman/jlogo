// klasa CommandMAKE
//

package jlogo.command;

import jlogo.InterpreterError;
import jlogo.LogoInterpreter;
import jlogo.LogoScreen;
import jlogo.Token;

import java.util.*;

public class CommandMAKE implements Command 
{
	public void runCommand(LogoScreen logoScreen, LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException, InterpreterError {
		Token token=Token.next(it);

		if (token.isString())
			logoInterpreter.setVariable(token.string(),logoInterpreter.evaluate(it));
		else 
			throw new InterpreterError("MAKE: Wrong parameter");
	}
}

