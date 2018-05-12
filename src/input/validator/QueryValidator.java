package input.validator;

import java.util.regex.Pattern;

public class QueryValidator {

	public final String QUERY_PATTERN = "[A-Z]";
	
	private Pattern queryPattern;
	
	public QueryValidator() {
		queryPattern = Pattern.compile(QUERY_PATTERN);
	}
	
	public boolean isValid(String query) {
		return queryPattern.matcher(query).matches();
	}
	
}
