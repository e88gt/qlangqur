package my.q88gt.qlangqur.parser;

import java.util.*;

public class AST
{
	private final int size;
	private final List<Node> nodes;
	
	public AST(List<Node> nodes)
	{
		this.nodes = nodes;
		this.size = nodes.size();
	}
	
	public String asString()
	{
		StringBuilder out = new StringBuilder();
		
		for (int i = 0; i < size; i++)
		{
			if (i + 1 < size)
			{
				out.append("- ");
			}
			
			out.append(nodes.get(i).toString());
		}
		
		return out.toString();
	}
	
	@Override public String toString()
	{
		return asString();
	}
}
