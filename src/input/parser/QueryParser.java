package input.parser;

import input.model.Query;
import input.validator.QueryValidator;

public class QueryParser {

	QueryValidator validator;
	
	public QueryParser() {
		validator = new QueryValidator();
	}
	
	public Query tryParse(String query) {
		if(validator.isValid(query)) {
			return new Query(query);
		} else {
			return null;
		}
	}
	
}
