// Klasa LogoInterpreter

package jlogo;

import jlogo.command.*;
import jlogo.function.*;

import javax.swing.*;
import java.util.*;
import java.io.*;

public class LogoInterpreter extends Thread {
	LogoScreen logoScreen;
	Map<String, Command> cmdMap;
	Map<String, Function> funcMap;
	HashMap varMap;
	Random rnd;
	Stack cmdStack;
	
	DefaultListModel outList;
	int outCnt=1;

	UserCommand userCmd=null;
	
	int inParenthesis=0;
	
	public LogoInterpreter(LogoScreen logoScreen,DefaultListModel outList) {
		this.logoScreen=logoScreen;
		installCommands();
		this.outList=outList;
	}

	public LogoInterpreter(LogoScreen logoScreen) {
		this.logoScreen=logoScreen;
		installCommands();
		this.outList=null;
	}
	
	public void installCommands() {
		cmdMap=new HashMap<String, Command>(); // mapa procedur
		funcMap=new HashMap<String, Function>(); // mapa funkcji
		varMap=new HashMap(); // mapa zmiennych
		rnd=new Random();
		cmdStack=new Stack();
		
// implementuje wbudowane komendy Logo
//
		cmdMap.put("bk",new CommandBK());
		cmdMap.put("clean",new CommandCLEAN());
		cmdMap.put("cs",new CommandCS());
		cmdMap.put("fd",new CommandFD());
		cmdMap.put("lt",new CommandLT());
		cmdMap.put("rt",new CommandRT());
		cmdMap.put("pu",new CommandPU());
		cmdMap.put("pd",new CommandPD());
		cmdMap.put("tell",new CommandTELL());
		cmdMap.put("setbg",new CommandSETBG());
		cmdMap.put("setc",new CommandSETC());
		cmdMap.put("setx",new CommandSETX());
		cmdMap.put("sety",new CommandSETY());
		cmdMap.put("seth",new CommandSETH());
		cmdMap.put("setpos",new CommandSETPOS());
		cmdMap.put("home",new CommandHOME());

		cmdMap.put("pr",new CommandPR());
		cmdMap.put("make",new CommandMAKE());
		cmdMap.put("rerandom",new CommandRERANDOM());
		cmdMap.put("repeat",new CommandREPEAT());
		cmdMap.put("run",new CommandRUN());
		cmdMap.put("wait",new CommandWAIT());
		cmdMap.put("if",new CommandIF());
		cmdMap.put("each",new CommandEACH());
		cmdMap.put("ask",new CommandASK());
		
		cmdMap.put("catalog",new CommandCATALOG());
		cmdMap.put("load",new CommandLOAD());
		cmdMap.put("erall",new CommandERALL());
		cmdMap.put("erps",new CommandERPS());
		cmdMap.put("erns",new CommandERNS());
		cmdMap.put("er",new CommandER());
		cmdMap.put("ern",new CommandERN());
		cmdMap.put("pots",new CommandPOTS());
		cmdMap.put("pons",new CommandPONS());
		cmdMap.put("save",new CommandSAVE());
		
		cmdMap.put("ct",new CommandCT());
		cmdMap.put("recycle",new CommandRECYCLE());
		cmdMap.put("quit",new CommandQUIT());
		
		
// implementuje wbudowane funkcje Logo
//

		funcMap.put("cos",new FunctionCOS());
		funcMap.put("product",new FunctionPRODUCT());
		funcMap.put("int",new FunctionINT());
		funcMap.put("sin",new FunctionSIN());
		funcMap.put("random",new FunctionRANDOM());
		funcMap.put("remainder",new FunctionREMAINDER());
		funcMap.put("round",new FunctionROUND());
		funcMap.put("sqrt",new FunctionSQRT());
		funcMap.put("sum",new FunctionSUM());
		
		funcMap.put("and",new FunctionAND());
		funcMap.put("or",new FunctionOR());
		funcMap.put("not",new FunctionNOT());

		funcMap.put("namep",new FunctionNAMEP());
		funcMap.put("thing",new FunctionTHING());

		funcMap.put("ascii",new FunctionASCII());
		funcMap.put("word",new FunctionWORD());
		funcMap.put("wordp",new FunctionWORDP());
		funcMap.put("numberp",new FunctionNUMBERP());			
	
		funcMap.put("bf",new FunctionBF());
		funcMap.put("bl",new FunctionBL());
		funcMap.put("count",new FunctionCOUNT());
		funcMap.put("emptyp",new FunctionEMPTYP());
		funcMap.put("equalp",new FunctionEQUALP());
		funcMap.put("first",new FunctionFIRST());
		funcMap.put("fput",new FunctionFPUT());
		funcMap.put("last",new FunctionLAST());
		funcMap.put("list",new FunctionLIST());
		funcMap.put("listp",new FunctionLISTP());
		funcMap.put("lput",new FunctionLPUT());
		funcMap.put("memberp",new FunctionMEMBERP());
		funcMap.put("se",new FunctionSE());

		funcMap.put("getl",new FunctionGETL());
		
		funcMap.put("bg",new FunctionBG());
		funcMap.put("color",new FunctionCOLOR());
		funcMap.put("xcor",new FunctionXCOR());
		funcMap.put("ycor",new FunctionYCOR());
		funcMap.put("who",new FunctionYCOR());
		funcMap.put("pos",new FunctionPOS());
		funcMap.put("heading",new FunctionHEADING());
		
	}
	
	public void run()
	{
		while (true) {
		
			if (cmdStack.empty()) {
				try {
					sleep(10);
				} catch (Exception e) {}
				continue;
			}
				
			String s = (String)cmdStack.pop();
			
			try {
				interpret(Tokenizer.tokenize(s));
			} catch(InterpreterError e) {
				println(e.getMessage());
			}
		}
	}
			
	public synchronized void addCmd(String s)
	{
		cmdStack.push(s);
	}
	
	public void interpret(ArrayList tokens) throws InterpreterError {
		ListIterator it = tokens.listIterator();
		boolean moreParams=false;

		try {
			while (it.hasNext()) {
				Token token = (Token)it.next();

				if (userCmd!=null) {
					if (token.isStatement() && token.string().toLowerCase().equals("end")) {
						if (userCmd.isFunction()) 
							funcMap.put(userCmd.name(),userCmd);
						else 
							cmdMap.put(userCmd.name(),userCmd);

						userCmd=null;
						break;
					} else {
						userCmd.add(token);
						continue;
					}
				}

				if (token.isOperator() && token.string().equals("(")) {
					inParenthesis++;
					continue;
				} else if (token.isOperator() && token.string().equals(")")) {
					inParenthesis--;
					continue;
				} else if (token.isSeparator())
					continue;
				else if (!token.isStatement()) {
					if (token.isList()) 
						throw new InterpreterError("I don't know how to "+token.list());
					else if (token.isNumber())
						throw new InterpreterError("I don't know how to "+token.number());
					else 
						throw new InterpreterError("I don't know how to "+token.string());
				} else {
					String cmdName=token.string().toLowerCase();
					
					if (cmdName.equals("to")) {
						
						userCmd=addUserCmd(it);
						return;
					}
					
					Command cmd=getCommand(cmdName);
					
					if (cmd!=null) cmd.runCommand(logoScreen,this,it);
					else {
						if (cmdName.equals("stop"))
							throw new InterpreterError("Stop!");
						else
							throw new InterpreterError("I don't know how to "+cmdName);
					}
				}	
			}
		} catch(NoSuchElementException e) {
			throw new InterpreterError("Wrong number of parameters");
		}
	}

	public Object interpretFunction(ArrayList tokens) throws InterpreterError {
		ListIterator it = tokens.listIterator();
		boolean moreParams=false;

		while (it.hasNext()) {
			Token token = (Token)it.next();
			
			if (token.isOperator() && token.string().equals("(")) {
				inParenthesis++;
				continue;
			} else if (token.isOperator() && token.string().equals(")")) {
				inParenthesis--;
				continue;
			} else if (!token.isStatement())
				throw new InterpreterError("Syntax error");
			else {
				String cmdName=token.string().toLowerCase();
				
				if (cmdName.equals("op"))
					return evaluate(it);
				
				Command cmd=getCommand(cmdName);
				
				if (cmd!=null) cmd.runCommand(logoScreen,this,it);
				if (cmdName.equals("quit")) {
					System.exit(0);
				}
			}	
		}
		throw new InterpreterError("Function must return something");
	}

	public Object evaluate(ListIterator it) throws InterpreterError,NoSuchElementException {
		Token token = Token.next(it);

		return evalExp1(it,token);
	}
	
	Object evalExp1(ListIterator it,Token token) throws InterpreterError,NoSuchElementException {
		Object result = evalExp2(it,token);

		if (!it.hasNext()) 
			return result;

		token = (Token)it.next();
		
		if (!token.isOperator()) 
			it.previous();
		else if ("< > <> <= >= =".indexOf(token.string())!=-1) {
			Object var2=evalExp1(it,(Token)it.next());

			if (((result instanceof String) && (var2 instanceof String)) || 
			    ((result instanceof Double) && (var2 instanceof Double))) {
				if (token.string().equals("=")) 
					result=(Object)new Boolean(((Comparable)result).compareTo(var2)==0);
				
				if (token.string().equals("<"))
					result=(Object)new Boolean(((Comparable)result).compareTo(var2)==-1);
				
				if (token.string().equals(">"))
					result=(Object)new Boolean(((Comparable)result).compareTo(var2)==1);
				
				if (token.string().equals("<="))
					result=(Object)new Boolean(((Comparable)result).compareTo(var2)<=0);
				
				if (token.string().equals(">="))
					result=(Object)new Boolean(((Comparable)result).compareTo(var2)>=0);
				
			} else if ((result instanceof LogoList) && (var2 instanceof LogoList)) {
				if (token.string().equals("=")) 
					result=(Object)new Boolean(result.equals(var2));
				else
					throw new InterpreterError(token.string()+" doesn't like input");
			} else if (token.string().equals("="))
				result=(Object)Boolean.FALSE;
			else 
				throw new InterpreterError(token.string()+" doesn't like input");
		} else 
			it.previous();
			
		return result;
	}	

	Object evalExp2(ListIterator it,Token token) throws InterpreterError,NoSuchElementException {
		Object result = evalExp3(it,token);
		
		while (it.hasNext()) {

			token = (Token)it.next();
			if (!token.isOperator()) {
				it.previous();
				break;
			} else if ("+ -".indexOf(token.string())!=-1) {
				Object var2=evalExp3(it,(Token)it.next());
			
				if ((result instanceof Double) && (var2 instanceof Double)) {
					if (token.string().equals("+"))
						result=new Double(((Double)result).doubleValue()+((Double)var2).doubleValue());
					else if (token.string().equals("-"))
						result=new Double(((Double)result).doubleValue()-((Double)var2).doubleValue());				
				} else 
					throw new InterpreterError(token.string()+" doesn't like input");
			} else {
				it.previous();
				break;
			}
		}
		
		return result;
	}
	
	Object evalExp3(ListIterator it,Token token) throws InterpreterError,NoSuchElementException {
		Object result = evalExp4(it,token);
		
		while (it.hasNext()) {
			token = (Token)it.next();
			if (!token.isOperator()) {
				it.previous();
				break;
			}
			else if ("* /".indexOf(token.string())!=-1) {
				Object var2=evalExp4(it,(Token)it.next());
			
				if ((result instanceof Double) && (var2 instanceof Double)) {
					if (token.string().equals("*"))
						result=new Double(((Double)result).doubleValue()*((Double)var2).doubleValue());
					else if (token.string().equals("/")) {
						if (((Double)var2).doubleValue()==0) throw new InterpreterError("DIVISION BY ZERO");
					
						result=new Double(((Double)result).doubleValue()/((Double)var2).doubleValue()); 
					}
				} else 
					throw new InterpreterError(token.string()+" doesn't like input");
			} else {
				it.previous();
				break;
			}
		}
		
		return result;
	}

	Object evalExp4(ListIterator it,Token token) throws InterpreterError,NoSuchElementException {
		double result=1;
		
		if (token.isOperator() && (token.string().equals("-"))) {
			result=-1;
			if (!it.hasNext()) 
				throw new InterpreterError("Syntax error: - left alone.");
			token=(Token)it.next();
			
		}

		Object var2=evalExp5(it,token);
		
		if (var2 instanceof Double)
			return new Double(result*((Double)var2).doubleValue());
		else {
			if (result==1)
				return var2;
			else
				throw new InterpreterError("- doesn't like "+var2);
		}
	}
		
	Object evalExp5(ListIterator it,Token token) throws InterpreterError,NoSuchElementException {
		Object result;

		if (token.isOperator() && (token.string().equals("("))) {
			if (!it.hasNext()) 
				throw new InterpreterError("Syntax error: ( left alone.");
			token=(Token)it.next();
			inParenthesis++;
			result=evalExp1(it,token);
			if (!it.hasNext())
				throw new InterpreterError("Syntax error: Missing ')'. End of line. ");
			token=(Token)it.next();
			if (token.isSeparator()) token=(Token)it.next();
			if (!token.string().equals(")")) 
				throw new InterpreterError("Syntax error: Missing ')'.");
			inParenthesis--;
		} else
			result=atom(it,token);

		return result;
	}

	public boolean isInParenthesis() {
		return (inParenthesis>0);
	}

	public void outOfParenthesis() {
		inParenthesis--;
	}
	
	Object atom(ListIterator it,Token token) throws InterpreterError,NoSuchElementException {
		if (token.isSeparator()) token=(Token)it.next();
		
		if (token.isNumber()) 
			return new Double(token.number());
		else if (token.isVariable()) {
			Object t = getVariable(token.string().toLowerCase());

			if (t==null) 
				throw new InterpreterError("Variable "+token.string()+" not declared");
			return t;
		} else if (token.isStatement()) {
			Function func = getFunction(token.string());
	
			if (func==null)
				throw new InterpreterError("Syntax error: I don't know how to "+token.string());
			
			Object retVal=func.run(logoScreen,this,it);
			return retVal;
		} else if (token.isString()) 
			return token.string();
		else if (token.isList())
			return token.list();
		else 
			throw new InterpreterError("Syntax error: I don't know what is this "+token);
	}

	synchronized Function getFunction(String name) {
		return (Function)funcMap.get(name);
	}

	synchronized Command getCommand(String name) {
		return (Command)cmdMap.get(name);
	}
	
	public synchronized Object getVariable(String name) {
		return varMap.get(name);
	}
	
	public synchronized void setVariable(String name,Object var) throws InterpreterError {
		varMap.put(name,var);
	}
	
	public double getRandom(double x)
	{
		return (double)rnd.nextInt((int)x);
	}
	
	public UserCommand addUserCmd(ListIterator it) throws InterpreterError,NoSuchElementException
	{
		Token token = Token.next(it);

		if (!token.isStatement()) 
			throw new InterpreterError("TO: Wrong routine name type (only strings)");
		
		UserCommand uCmd=new UserCommand(token.string());
		
		while (it.hasNext()) {
			token=Token.next(it);

			if (!token.isVariable()) 
				throw new InterpreterError("TO doesn't like input");
			else
				uCmd.addParameter(token);
		}

		return uCmd;
	}

	public boolean isUserCmd(String s)
	{
		return ((getCommand(s)!=null) || (getFunction(s)!=null));
	}

	public void consoleClear()
	{
		outCnt=1;
		if (outList!=null)
			outList.clear();
	}
	
	public void println(Object s)
	{	
		if (outList==null)
			System.out.println(outCnt+": "+s);
		else 
			outList.add(0,outCnt+": "+s.toString());
		outCnt++;
	}

	public void printAllVariables()
	{
		Iterator it = varMap.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();

			println(entry.getKey()+" = "+entry.getValue());
		}
	}

	public void printAllUserCmds()
	{
		Iterator it = funcMap.entrySet().iterator();
		ArrayList list=new ArrayList();
		
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();

			if (entry.getValue() instanceof UserCommand)
				println(((UserCommand)entry.getValue()).getHeader());
		
		}
	
		it = cmdMap.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();

			if (entry.getValue() instanceof UserCommand) 
				println(((UserCommand)entry.getValue()).getHeader());
		}
	}

	public void saveAllUserCmds(String fileName) throws InterpreterError
	{
		try {
			PrintWriter out = new PrintWriter(new FileWriter(fileName));

			Iterator it = funcMap.entrySet().iterator();
		
			while (it.hasNext()) {
				Map.Entry entry = (Map.Entry)it.next();

				if (entry.getValue() instanceof UserCommand)
					out.println((UserCommand)entry.getValue());
			
			}
	
			it = cmdMap.entrySet().iterator();

			while (it.hasNext()) {
				Map.Entry entry = (Map.Entry)it.next();

				if (entry.getValue() instanceof UserCommand) 
					out.println((UserCommand)entry.getValue());
			}

			out.close();
		} catch(IOException e) {
			throw new InterpreterError(e.getMessage());
		}
	}
	
	public void eraseAll()
	{
		eraseAllUserCmds();
		eraseAllVariables();
	}
	
	public void eraseAllUserCmds()
	{
		Iterator it = funcMap.entrySet().iterator();
		ArrayList list=new ArrayList();
		
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();

			if (entry.getValue() instanceof UserCommand) 
				list.add(entry.getKey());
		}
	
		for (int i=0;i<list.size();i++)
			funcMap.remove(list.get(i));
		
		it = cmdMap.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();

			if (entry.getValue() instanceof UserCommand) 
				list.add(entry.getKey());
		}

		for (int i=0;i<list.size();i++)
			cmdMap.remove(list.get(i));

	}

	public void eraseAllVariables() {
		varMap.clear();
	}
		
	
	public void eraseUserCmd(String name)
	{
		funcMap.remove(name);
		cmdMap.remove(name);
	}

	public void eraseVariable(String name)
	{
		varMap.remove((Object)name);
	}

}
