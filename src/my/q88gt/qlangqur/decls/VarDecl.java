package my.q88gt.qlangqur.decls;

import my.q88gt.qlangqur.parser.*;

public record VarDecl(String name, String value) implements Node
{
	@Override public String toString()
	{
		StringBuilder out = new StringBuilder();
		String nameNoSpace = name.trim();
		String valueNoSpace = value.trim();
		
		out.append("Varable [");
		out.append(nameNoSpace);
		out.append(", ");
		out.append(valueNoSpace);
		out.append("]");
		
		return out.toString();
	}
}
