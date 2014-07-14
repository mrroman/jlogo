// Klasa CommandLOAD

package jlogo.command;

import jlogo.*;

import java.util.*;
import java.io.*;

public class CommandLOAD implements Command {
	public CommandLOAD() {}

	public void runCommand(LogoScreen logoScreen, LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException, InterpreterError {
		Object o = logoInterpreter.evaluate(it);
		
		if (!(o instanceof String) && !(o instanceof LogoList))
			throw new InterpreterError("LOAD: Wrong parameter");
		
		try {
			String fileName = o.toString();
			BufferedReader in = new BufferedReader(new FileReader(fileName));
		
			String s;
			int lineNo=1;
			while ((s=in.readLine())!=null) {
				try {
					logoInterpreter.interpret(Tokenizer.tokenize(s));
				} catch (InterpreterError e) {
					logoInterpreter.println("LOAD:"+lineNo+": "+e.getMessage());
					break;
				}
				lineNo++;
			}
		
			in.close();

		} catch (IOException e) {
			throw new InterpreterError("LOAD: "+e.getMessage());
		}

	}
}
