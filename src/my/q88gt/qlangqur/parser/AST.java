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
		nodes.forEach(out::append);
		return out.toString();
	}
	
	@Override public String toString()
	{
		return asString();
	}
}
