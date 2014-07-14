// Klasa Tokenizer

package jlogo;

import java.util.*;

public class Tokenizer {
	final static int T_START=0;
	final static int T_WORD=1;
	final static int T_NUMBER=2;
	final static int T_OPERATOR=3;
	final static int T_LIST = 4;
	final static int T_SEPARATOR = 5;
	
	public static ArrayList tokenize(String line) throws InterpreterError {
		ArrayList tokens=new ArrayList();
		int t=T_START;
		int last_pos=0;
		
		int listSt=0;
		
		boolean isVariable=false;
		boolean isString=false;
		String s=line+" "; // zeby nie trzeba bylo na koncu sprawdzac
		
		for (int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			
			if (t==T_NUMBER) {
				if (!Character.isDigit(c) && (c!='.')) {
					try {
						tokens.add(new Token(Token.NUMBER,s.substring(last_pos,i)));
						t=T_START;
					} catch (NumberFormatException e) {
						throw new InterpreterError("Wrong number format");
					}	
				}
			}
			
			if (t==T_WORD) {
				if (Character.isWhitespace(c) || ("<>=+-*/()[]".indexOf(c)!=-1)) {
					if (isVariable) {
						tokens.add(new Token(Token.VARIABLE,s.substring(last_pos,i)));
						isVariable=false;
					} else if (isString) {
						tokens.add(new Token(Token.STRING,s.substring(last_pos,i)));
						isString=false;
					} else
						tokens.add(new Token(Token.STATEMENT,s.substring(last_pos,i)));
					t=T_START;
				}
			}
		
			if (t==T_OPERATOR) {
				if ("<>=".indexOf(c)==-1) {
					String ts = s.substring(last_pos,i);
					tokens.add(new Token(Token.OPERATOR,ts));
					t=T_START;
					continue;
				}
			}
		
			if (t==T_LIST) {
				if (c=='[') listSt++;
				if (c==']') listSt--;
					
				if (listSt==0) {
					tokens.add(new Token(new LogoList(tokenize(s.substring(last_pos,i)))));
					t=T_START;
					continue;
				}
			}

			if (t==T_SEPARATOR) {
				if (!Character.isWhitespace(c)) {
					tokens.add(new Token());
					// cofam o jeden znak zeby odczytal poprawnie nastepny token
					t=T_START;
				}
			}
			
			if (t==T_START) {
				if (Character.isDigit(c)) {
					last_pos=i;
					t=T_NUMBER;
				} else if (Character.isLetter(c)) {
					last_pos=i;
					t=T_WORD;
				} else if (Character.isWhitespace(c)) {
					t=T_SEPARATOR;
				} else { 
				        switch(c) {
						case '[':
							listSt=1;
							last_pos=i+1;
							t=T_LIST;
							break;
						case '(':
						case ')':
						case '+':
						case '-':
						case '*':
						case '/':
							tokens.add(new Token(Token.OPERATOR,""+c));
							break;
						case ':':
							last_pos=i+1;
							t=T_WORD;
							isVariable=true;
							break;
						case '"':
							last_pos=i+1;
							t=T_WORD;
							isString=true;
							break;
						case '%':
							return tokens; // komentarz
						default:
							last_pos=i;
							t=T_OPERATOR;
							break;
					}
				}
			} 
		}
		
		return tokens;
	}

}
