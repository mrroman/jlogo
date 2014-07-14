// klasa FunctionSE
//

package jlogo.function;

import jlogo.*;

import java.util.*;

public class FunctionSE implements Function
{
	public Object run(LogoScreen logoScreen, LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException, InterpreterError {
		LogoList li = new LogoList(new ArrayList());
		Object obj = logoInterpreter.evaluate(it);
		
		if (obj instanceof LogoList) 
			li.addAll((LogoList)obj);
		else
			li.add(obj);
		
		obj = logoInterpreter.evaluate(it);
	
		if (obj instanceof LogoList) 
			li.addAll((LogoList)obj);
		else
			li.add(obj);
		
		if (logoInterpreter.isInParenthesis()) {
			while (it.hasNext()) {
				Token token=Token.next(it);
				
				if (token.isOperator() && token.string().equals(")")) {
//					logoInterpreter.outOfParenthesis();
					it.previous(); // bo funkcja
					break;
				} else {
					it.previous();
					obj = logoInterpreter.evaluate(it);
						
					if (obj instanceof LogoList) 
						li.addAll((LogoList)obj);
					else
						li.add(obj);
				}
			}
		}		
		
		return (Object)li;			
	}
}
