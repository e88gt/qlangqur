package my.q88gt.qlangqur;

import java.util.*;

import my.q88gt.qlangqur.parser.*;
import my.q88gt.qlangqur.token.*;

public class Main
{
	public static void main(String... args)
	{
		String source = """
			name = 124;
			
			""";
		
		Tokenizer tokenizer = new Tokenizer(source);
		
		List<Token> tokens = tokenizer.tokenize();
		
		Parser parser = new Parser(tokens);
		
		AST ast = parser.parse();
		
		System.out.println(ast);
	}
}
