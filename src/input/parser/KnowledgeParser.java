package input.parser;

import exception.InvalidKnowledgeException;
import input.model.Knowledge;

public class KnowledgeParser {

	private RuleParser ruleParser;
	private FactParser factParser;
	
	public KnowledgeParser() {
		ruleParser = new RuleParser();
		factParser = new FactParser();
	}

	public Knowledge tryParse(String input) throws InvalidKnowledgeException {

		Knowledge knowledge;
		
		knowledge = ruleParser.tryParse(input);
		
		if(knowledge == null)
			knowledge = factParser.tryParse(input);
		
		if(knowledge == null)
			throw new InvalidKnowledgeException();
		
		return knowledge;
		
	}
	
}
