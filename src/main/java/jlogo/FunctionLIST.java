// klasa FunctionLIST
//

package jlogo;

import java.util.*;

public class FunctionLIST implements Function
{
	public Object run(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		LogoList li = new LogoList(new ArrayList());
		
		li.arrayList().add(logoInterpreter.evaluate(it));
		li.arrayList().add(logoInterpreter.evaluate(it));
		if (logoInterpreter.isInParenthesis()) {
			while (it.hasNext()) {
				Token token=Token.next(it);
				
				if (token.isOperator() && token.string().equals(")")) {
					logoInterpreter.outOfParenthesis();
					break;
				} else {
					it.previous();
					li.arrayList().add(logoInterpreter.evaluate(it));
				}
			}
		}		
		
		return (Object)li;			
	}
}
