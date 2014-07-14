// klasa CommandER
//

package jlogo;

import java.util.*;

public class CommandER implements Command {
	public void runCommand(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		Token token = Token.next(it);	
	
		if (token.isString()) {
			String s = (String)token.string();

			if (logoInterpreter.isUserCmd(s))
				throw new InterpreterError("ER: I don't know "+s);
			else
				logoInterpreter.eraseUserCmd(s);
		} else if (token.isList()) {
			LogoList ll = (LogoList)token.list();
			
			for (int i=0;i<ll.arrayList().size();i++)
				if (!ll.getToken(i).isStatement())
					throw new InterpreterError("ER: Don't know how to "+ll.toString());
				else {
					String s = ll.getToken(i).string();

					if (logoInterpreter.isUserCmd(s)) 
						throw new InterpreterError("ER: Don't know "+s);
					else
						logoInterpreter.eraseUserCmd(s);
				}
		}
			
	}
}
