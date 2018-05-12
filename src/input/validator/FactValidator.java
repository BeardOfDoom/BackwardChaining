package input.validator;

import java.util.regex.Pattern;

public class FactValidator {

	public final String FACT_PATTERN = "[A-Z]";
	
	private Pattern factPattern;
	
	public FactValidator() {
		factPattern = Pattern.compile(FACT_PATTERN);
	}
	
	public boolean isValid(String knowledge) {
		return factPattern.matcher(knowledge).matches();
	}
	
}
