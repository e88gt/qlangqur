package my.q88gt.qlangqur.token;

import java.util.*;

public record Token(TokenType type, Optional<String> value)
{
	@Override public String toString()
	{
		StringBuilder out = new StringBuilder();
		
		out.append("Token [").append(type);
		
		if (value.isPresent() && !value.get().isBlank())
		{
			out.append(", ").append(value.get());
		}
		
		out.append("]");
		
		return out.toString();
	}
}
