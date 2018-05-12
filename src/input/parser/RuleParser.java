package input.parser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import input.model.Rule;
import input.validator.RuleValidator;

public class RuleParser {

	RuleValidator validator;
	
	public RuleParser() {
		validator = new RuleValidator();
	}
	
	public Rule tryParse(String rawKnowledge) {

		if(validator.isValid(rawKnowledge)) {
			String[] parts = rawKnowledge.split(">");

			Set<String> premises = new HashSet<>(Arrays.asList(parts[0].split("&")));
			String head = parts[1];

			return new Rule(premises, head);
		} else {
			return null;
		}
		
	}
	
}
