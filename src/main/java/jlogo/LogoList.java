// klasa LogoList
// 

package jlogo;

import java.util.*;

public class LogoList {
	private ArrayList list;

	public LogoList(ArrayList list) {
		this.list=list;
	}

	public String toString() {
		ListIterator li=list.listIterator();
		String s = new String();
		
		while (li.hasNext()) {
			Token token = (Token)li.next();

			if (token.isNumber()) s=s+token.number()+" ";
			else if (token.isList()) s=s+"[ "+token.list()+" ] ";
			else if (token.isString()) s=s+'"'+token.string()+" ";
			else if (token.isVariable()) s=s+':'+token.string()+" ";
			else if (token.isSeparator()) continue;
			else
				s=s+token.string()+" ";
		}

		return s.trim();
	}

	public ArrayList arrayList()
	{
		return list;
	}
	
	public boolean equals(Object var2) {
		
		if (!(var2 instanceof LogoList)) return false;
		
		int var1Size=list.size();
		int var2Size=((LogoList)var2).arrayList().size();

		if (var1Size!=var2Size) return false;			
		
		for (int i=0;i<var1Size;i++) {
			Token v1 = (Token)list.get(i);
			Token v2 = (Token)((LogoList)var2).arrayList().get(i);
		
			if ((v1.isNumber() && !v2.isNumber()) ||
			    (!v1.isNumber() && v2.isNumber())) 
				return false;
					
			if (v1.isNumber() && (v1.number()!=v2.number()))
				return false;
						
			if (v1.isList() && !(v1.list().equals(v2.list())))
				return false;

			if (!v1.isNumber() && !v1.isList() && !(v1.string().equals(v2.string())))
				return false;	
		} 
		return true;
	}
	
	public LogoList withoutFirst() throws IndexOutOfBoundsException {
		LogoList l = new LogoList(new ArrayList(list));

		l.arrayList().remove(0);
		return l;
	}

	public LogoList withoutLast() throws IndexOutOfBoundsException {
		LogoList l = new LogoList(new ArrayList(list));

		l.arrayList().remove(list.size()-1);
		return l;
	}

	public void add(Object obj) {
		if (obj instanceof String) 
			list.add(new Token(Token.STRING,obj.toString()));
		if (obj instanceof Double)
			list.add(new Token(Token.NUMBER,obj.toString()));
		if (obj instanceof Boolean)
			list.add(new Token(Token.STATEMENT,obj.toString()));
	}
	
	public void addAll(LogoList l) {
		for (int i=0;i<l.arrayList().size();i++) {
			Token token = (Token)l.arrayList().get(i);
			if (token.isList()) 
				addAll(token.list());
			else
				list.add(token);
		}
	}
	
	public LogoList firstPut(Object obj) {
		LogoList l = new LogoList(new ArrayList());

		l.add(obj);
		l.addAll(this);
		return l;
	}
	
	public LogoList lastPut(Object obj) {
		LogoList l = new LogoList(new ArrayList(list));

		l.add(obj);
		return l;
	}

	public Object get(int l) {
		int i,k=0;
		
		for (i=0;i<list.size();i++) {
			if (!getToken(i).isSeparator()) {
				if (l==k) break;
				else k++;
			}
		}
		
		Token token=(Token)list.get(i);
		
		if (token.isList()) return token.list();
		else if (token.isNumber()) return new Double(token.number());
		else if (token.isString()) return '"'+token.string();
		else
			return token.string();
	}
		
	public Token getToken(int i) {
		return (Token)list.get(i);
	}
	
	public Object first() throws IndexOutOfBoundsException {
		return get(0);
	}
	
	public Object last() throws IndexOutOfBoundsException {
		return get(length()-1);
	}
		
	public int length()
	{
		int len=0;

		for (int i=0;i<list.size();i++)
			if (!getToken(i).isSeparator()) len++;
		
		return len;
	}
}

