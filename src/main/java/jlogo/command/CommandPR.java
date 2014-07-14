// klasa CommandPR
//

package jlogo.command;

import jlogo.InterpreterError;
import jlogo.LogoInterpreter;
import jlogo.LogoScreen;
import jlogo.Token;

import java.util.*;

public class CommandPR implements Command 
{
	public void runCommand(LogoScreen logoScreen, LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException, InterpreterError {
		String out;
	
		out=logoInterpreter.evaluate(it).toString();
		if (logoInterpreter.isInParenthesis()) {
			while (it.hasNext()) {
				Token token=Token.next(it);
				
				if (token.isOperator() && token.string().equals(")")) {
					logoInterpreter.outOfParenthesis();
					break;
				} else {
					it.previous();
					out+=" "+logoInterpreter.evaluate(it).toString();
				}
			}
		}		
		//System.out.println();
		logoInterpreter.println(out);			
	}
}
