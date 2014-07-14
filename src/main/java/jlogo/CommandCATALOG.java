// Klasa CommandCATALOG

package jlogo;

import java.util.*;
import java.io.*;

public class CommandCATALOG implements Command {
	public CommandCATALOG() {}

	public void runCommand(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		File path=new File(".");
		
		String files[]=path.list();
		Arrays.sort(files);
			
		for (int i=0;i<files.length;i++)
			logoInterpreter.println(files[i]);

	}
}
