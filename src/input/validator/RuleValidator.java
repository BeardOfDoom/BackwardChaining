package input.validator;

import java.util.regex.Pattern;

public class RuleValidator {

	public final String RULE_PATTERN = "[A-Z](&[A-Z])*>[A-Z]";

	private Pattern rulePattern;
	
	public RuleValidator() {
		rulePattern = Pattern.compile(RULE_PATTERN);
	}
	
	public boolean isValid(String knowledge) {
		return rulePattern.matcher(knowledge).matches();
	}
	
}
