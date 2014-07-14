// klasa Token
//

package jlogo;

import java.util.*;

public class Token {
	public final static int NUMBER = 1;
	public final static int STRING = 2; // wszystko :)
	public final static int VARIABLE = 3;
	public final static int OPERATOR = 4;
	public final static int STATEMENT = 5;
	public final static int LIST = 6;
	public final static int SEPARATOR = 7;
	
	private int type; // typ tokenu

// dla typu NUMBER
// 
	private double number_val;

// dla typu STRING,VARIABLE,OPERATOR,STATEMENT
//
	private String string_val;

// dla typu LIST
// 

	private LogoList list_val;
	
	public Token() {
		type=SEPARATOR;
		string_val="";
	}

	public Token(int type,String val) {
		this.type=type;
		if (type==NUMBER) number_val=Double.valueOf(val).doubleValue();
		else string_val=new String(val);
	}

	public Token(LogoList l) {
		this.type=LIST;
		list_val=l;
	}
	
	public boolean isNumber() {
		return (type==NUMBER);
	}

	public boolean isString() {
		return (type==STRING);
	}
	
	public boolean isVariable() {
		return (type==VARIABLE);
	}

	public boolean isOperator() {
		return (type==OPERATOR);
	}

	public boolean isStatement() {
		return (type==STATEMENT);
	}

	public boolean isList() {
		return (type==LIST);
	}

	public boolean isSeparator() {
		return (type==SEPARATOR);
	}

	public double number() {
		return number_val;
	}

	public String string() {
		return string_val;
	}

	public LogoList list() {
		return list_val;
	}

	public void setToken(Object obj) {
		if (obj instanceof String) {
			type=STRING;
			string_val=(String)obj;
		}
		if (obj instanceof LogoList) {
			type=LIST;
			list_val=(LogoList)obj;
		}
		if (obj instanceof Double) {
			type=NUMBER;
			number_val=((Double)obj).doubleValue();
		}
	}

	public static Token next(ListIterator it) throws NoSuchElementException {
		Token token = (Token)it.next();

		if (token.isSeparator()) token=(Token)it.next();
		return token;
	}
	
	public String toString() {
		if ((type!=NUMBER) && (type!=LIST) && (type!=SEPARATOR)) 
			return "Token: type: "+type+" value: "+string_val;
		else if (type==NUMBER) 
			return "Token: type: "+type+" value: "+number_val;
		else if (type==LIST)
			return "Token: type: "+type+" value: "+list_val;		
		else 
			return "Token: separator";
	}
}	
	
