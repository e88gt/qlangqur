package my.q88gt.qlangqur.token;

import java.util.*;

public class Tokenizer
{
	private int index, line, column;
	private final int length;
	private final String source;
	
	public Tokenizer(String source)
	{
		super();
		this.length = source.length();
		this.source = source;
	}
	
	public List<Token> tokenize()
	{
		List<Token> tokens = new ArrayList<>();
		
		while (!isEof())
		{
			if (Character.isWhitespace(peek().get()))
			{
				advance();
				continue;
			}
			
			if (Character.isLetter(peek().get()) || peek().get() == '_')
			{
				StringBuilder word = new StringBuilder();
				
				while (Character.isLetterOrDigit(peek().get()) || peek().get() == '_')
				{
					if (peekNext().isPresent())
					{
						word.append(advance());
					}
				}
				
				tokens.add(new Token(TokenType.IDENTIFIER, Optional.ofNullable(word.toString())));
				continue;
			}
			
			if (Character.isDigit(peek().get()))
			{
				StringBuilder number = new StringBuilder();
				
				while (Character.isLetterOrDigit(peek().get()) || peek().get() == '_')
				{
					if (peekNext().isPresent())
					{
						number.append(advance());
					}
				}
				
				tokens.add(new Token(TokenType.NUMBER, Optional.ofNullable(number.toString())));
				continue;
			}
			
			if (peek().get() == '=')
			{
				tokens.add(new Token(TokenType.ASSIGN, Optional.empty()));
				advance();
				continue;
			}
			
			if (peek().get() == ';')
			{
				tokens.add(new Token(TokenType.SEMI, Optional.empty()));
				advance();
				continue;
			}
		}
		
		tokens.add(new Token(TokenType.EOF, Optional.empty()));
		
		return tokens;
	}
	
	private boolean isEof()
	{
		return isEofBy(0);
	}
	
	private Optional<Character> peek()
	{
		return peekBy(0);
	}
	
	private Optional<Character> peekNext()
	{
		return peekBy(1);
	}
	
	private char advance()
	{
		return advanceBy(1);
	}
	
	private boolean isEofBy(int by)
	{
		return (index + by) >= length();
	}
	
	private Optional<Character> peekBy(int by)
	{
		if (isEofBy(by))
		{
			return Optional.empty();
		}
		return Optional.ofNullable(source().charAt(index + by));
	}
	
	private char advanceBy(int by)
	{
		try
		{
			return source().charAt(index);
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
	
	private String source()
	{
		return source;
	}
}
