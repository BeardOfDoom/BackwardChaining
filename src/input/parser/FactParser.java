package input.parser;

import input.model.Fact;
import input.validator.FactValidator;

public class FactParser {
	
	FactValidator validator;
	
	public FactParser() {
		validator = new FactValidator();
	}

	public Fact tryParse(String rawKnowledge) {
		if(validator.isValid(rawKnowledge)) {
			return new Fact(rawKnowledge);
		} else {
			return null;
		}
	}
}
