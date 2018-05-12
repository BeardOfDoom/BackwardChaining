package input.parser;

import java.util.List;

import exception.InvalidKnowledgeException;
import exception.InvalidQueryException;
import input.model.Fact;
import input.model.Knowledge;
import input.model.KnowledgeBase;
import input.model.Query;
import input.model.Rule;

public class KnowledgeBaseParser {

	public KnowledgeBase tryParse(List<String> rawKnowledgeList) throws InvalidKnowledgeException, InvalidQueryException {
		
		KnowledgeParser knowledgeParser = new KnowledgeParser();
		
		KnowledgeBase knowledgeBase = new KnowledgeBase();
		QueryParser queryParser = new QueryParser();
		
		Query query = queryParser.tryParse(rawKnowledgeList.get(rawKnowledgeList.size() - 1));
		
		if(query == null) {
			throw new InvalidQueryException();
		} else {
			knowledgeBase.setQuery(query);
			rawKnowledgeList.remove(rawKnowledgeList.size() - 1);
		}
		
		for(String rawKnowledge : rawKnowledgeList) {
			
			Knowledge knowledge = knowledgeParser.tryParse(rawKnowledge);
			
			if(knowledge instanceof Rule) {
				knowledgeBase.getRules().add((Rule) knowledge);
				
			} else if(knowledge instanceof Fact) {
				knowledgeBase.getFacts().add((Fact) knowledge);
			}
			
		}
		
		return knowledgeBase;
	}
}
