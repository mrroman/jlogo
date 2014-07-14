// klasa UserCommand
//

package jlogo;

import java.util.*;

public class UserCommand implements Command,Function
{
	String cmdName;
	boolean is_function;
	ArrayList cmdList;
	LinkedHashMap params;
	int paramsNo=0;
	
	public UserCommand(String name) {
		this.cmdName=name;
		cmdList=new ArrayList();
		params=new LinkedHashMap();
	}

	public void runCommand(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		Iterator iter = params.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry=(Map.Entry)iter.next();

			entry.setValue(logoInterpreter.getVariable((String)entry.getKey()));
			logoInterpreter.setVariable((String)entry.getKey(),logoInterpreter.evaluate(it));
		}
		
		logoInterpreter.interpret(cmdList);
		
		iter = params.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry=(Map.Entry)iter.next();

			logoInterpreter.setVariable((String)entry.getKey(),entry.getValue());
		}
	}

	public Object run(LogoScreen logoScreen,LogoInterpreter logoInterpreter,ListIterator it) throws NoSuchElementException,InterpreterError {
		Iterator iter = params.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry=(Map.Entry)iter.next();

			entry.setValue(logoInterpreter.getVariable((String)entry.getKey()));
			logoInterpreter.setVariable((String)entry.getKey(),logoInterpreter.evaluate(it));
		}
		
		Object result=logoInterpreter.interpretFunction(cmdList);
		
		iter = params.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry=(Map.Entry)iter.next();

			logoInterpreter.setVariable((String)entry.getKey(),entry.getValue());
		}

		return result;
	}

	public boolean isFunction()
	{
		return is_function;
	}

	public String name()
	{
		return cmdName;
	}

	public void add(Token token)
	{
		if (token.isStatement() && token.string().toLowerCase().equals("op"))
			is_function=true;

		cmdList.add(token);
	}

	public void addParameter(Token token)
	{
		params.put(token.string(),null);
		paramsNo++;
	}

	public String getHeader() {
		String s=new String("to "+cmdName+" ");
		
		Iterator iter = params.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry=(Map.Entry)iter.next();
			
			s+=":"+(String)entry.getKey()+" ";
		}
	
		return s;
	}
	
	public String toString() {
		String s=new String("to "+cmdName+" ");
		
		Iterator iter = params.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry=(Map.Entry)iter.next();
			
			s+=":"+(String)entry.getKey()+" ";
		}
		
		ListIterator li = cmdList.listIterator();
		int parenth=0;

		while (li.hasNext()) {
			Token token = (Token)li.next();
			if (token.isStatement() && (parenth==0)) s+="\n";
			if (token.isOperator()){
				if ("( [".indexOf(token.string())!=-1)
					parenth++;
				if (") ]".indexOf(token.string())!=-1)
					parenth++;
			}
			if (token.isList()) 
				s+="[ "+token.list()+" ]";
			else if (token.isNumber()) 
				s+=token.number();
			else if (token.isVariable()) 
				s+=":"+token.string();
			else if (token.isString())
				s+='"'+token.string();
			else if (token.isStatement())
				s+=token.string();
			else if (token.isOperator())
				s+=token.string();
			else if (token.isSeparator())
				s+=" ";
		}
			
		s+="\nend\n";

		return s;
	}
}

