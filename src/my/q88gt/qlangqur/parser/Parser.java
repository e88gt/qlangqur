package my.q88gt.qlangqur.parser;

import java.util.*;

import my.q88gt.qlangqur.decls.*;
import my.q88gt.qlangqur.token.*;

public class Parser
{
	private int index;
	private final int length;
	private final List<Token> tokens;
	
	public Parser(List<Token> tokens)
	{
		this.tokens = tokens;
		this.length = tokens.size();
	}
	
	public AST parse()
	{
		List<Node> nodes = new ArrayList<>();
		
		while (!isEof())
		{
			nodes.add(parseVarDecl());
		}
		
		return new AST(nodes);
	}
	
	private VarDecl parseVarDecl()
	{
		Token nameToken = advance();
		advance();
		Token valueToken = advance();
		advance();
		
		String name = nameToken.value().get();
		String value = valueToken.value().get();
		
		return new VarDecl(name, value);
	}
	
	private boolean expect(TokenType type)
	{
		return peek().get().type() == type;
	}
	
	private boolean isEof()
	{
		return isEofBy(0);
	}
	
	private Optional<Token> peek()
	{
		return peekBy(0);
	}
	
	private Optional<Token> peekNext()
	{
		return peekBy(1);
	}
	
	private Token advance()
	{
		return advanceBy(1);
	}
	
	private boolean isEofBy(int by)
	{
		return ((index + by) >= length() || (tokens().get(index + by).type() == TokenType.EOF));
	}
	
	private Optional<Token> peekBy(int by)
	{
		if (isEofBy(by))
		{
			return Optional.empty();
		}
		return Optional.ofNullable(tokens().get(index + by));
	}
	
	private Token advanceBy(int by)
	{
		try
		{
			return tokens().get(index);
		}
		finally
		{
			index += by;
		}
	}
	
	private int length()
	{
		return length;
	}
	
	private List<Token> tokens()
	{
		return tokens;
	}
}
