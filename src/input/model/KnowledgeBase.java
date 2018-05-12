package input.model;

import java.util.ArrayList;
import java.util.List;

public class KnowledgeBase {

	private List<Rule> rules;
	private List<Fact> facts;
	private Query query;
	
	public KnowledgeBase() {
		rules = new ArrayList<>();
		facts = new ArrayList<>();
	}

	public List<Rule> getRules() {
		return rules;
	}

	public void setRules(List<Rule> rules) {
		this.rules = rules;
	}

	public List<Fact> getFacts() {
		return facts;
	}

	public void setFacts(List<Fact> facts) {
		this.facts = facts;
	}

	public Query getQuery() {
		return query;
	}

	public void setQuery(Query query) {
		this.query = query;
	}
}
