// klasa CommandERN
//

package jlogo.command;

import jlogo.*;

import java.util.*;

public class CommandERN implements Command {
	public void runCommand(LogoScreen logoScreen, LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException, InterpreterError {
		Token token=Token.next(it);

		if (token.isString()) {
			String s = (String)token.string();

			if (logoInterpreter.getVariable(s)==null)
				throw new InterpreterError("ERN: I don't know "+s);
			else
				logoInterpreter.eraseVariable(s);
		} else if (token.isList()) {
			LogoList ll = (LogoList)token.list();
			
			for (int i=0;i<ll.arrayList().size();i++) {
				if (ll.getToken(i).isSeparator()) continue;
				if (!ll.getToken(i).isStatement())
					throw new InterpreterError("ERN: Don't know how to "+ll.toString());
				else {
					String s = ll.getToken(i).string();

					if (logoInterpreter.getVariable(s)==null) 
						throw new InterpreterError("ERN: Don't know "+s);
					else
						logoInterpreter.eraseVariable(s);
				}
			}
		}
			
	}
}
