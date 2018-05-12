package backwardchaining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import input.model.Fact;
import input.model.KnowledgeBase;
import input.model.Rule;

public class BackwardChaining {

	KnowledgeBase knowledgeBase;
	List<String> openQueries;
	Map<String, List<Set<String>>> unprovedQueries;
	List<String> provedQueries;
	String query;
	
	public BackwardChaining(KnowledgeBase knowledgeBase) {
		this.knowledgeBase = knowledgeBase;
		query = knowledgeBase.getQuery().getQuery();
		
		openQueries = new ArrayList<>();
		unprovedQueries = new HashMap<String, List<Set<String>>>();
		provedQueries = new ArrayList<>();
		
		openQueries.add(query);
	}
	
	public boolean proveQuery() {
		
		List<Fact> facts = knowledgeBase.getFacts();
		List<Rule> rules = knowledgeBase.getRules();
		Set<String> newlyProvedQueries = new HashSet<>();
		boolean isProved = false;
		
		while(!openQueries.isEmpty() || !newlyProvedQueries.isEmpty()) {
			String chosenQuery = null;
			if(!openQueries.isEmpty()) {
				chosenQuery = openQueries.get(openQueries.size() - 1);
				openQueries.remove(openQueries.size() - 1);
				
				if(provedQueries.contains(chosenQuery) || unprovedQueries.containsKey(chosenQuery))
					continue;
				
				for(Fact fact : facts) {
					if(chosenQuery.equals(fact.getFact())) {
						provedQueries.add(chosenQuery);
						newlyProvedQueries.add(chosenQuery);
						isProved = true;
						break;
					}
				}
			}
			
			if(isProved) {
				while(!newlyProvedQueries.isEmpty()) {
					String newlyProvedQuery = newlyProvedQueries.iterator().next();
					newlyProvedQueries.remove(newlyProvedQuery);
					Map<String, List<Set<String>>> unprovedQueriesCopy = new HashMap<String, List<Set<String>>>();
					
					for(String key : unprovedQueries.keySet()) {
						List<Set<String>> premissesListCopy = new ArrayList<>();
						
						for(Set<String> premisses : unprovedQueries.get(key)) {
							Set<String> premissesCopy = new HashSet<>(premisses);
							premissesListCopy.add(premissesCopy);
						}
						
						unprovedQueriesCopy.put(key, premissesListCopy);
					}
					
					for(String unprovedQuery : unprovedQueries.keySet()) {
						List<Set<String>> premissesList = unprovedQueries.get(unprovedQuery);
						for(int i = 0; i < premissesList.size(); i++) {
							Set<String> premisses = premissesList.get(i);
							if(premisses.contains(newlyProvedQuery)) {
								Set<String> premissesCopy = unprovedQueriesCopy.get(unprovedQuery).get(i);
								premissesCopy.remove(newlyProvedQuery);
								
								if(premissesCopy.isEmpty()) {
									if(unprovedQuery == query)
										return true;
									provedQueries.add(unprovedQuery);
									unprovedQueriesCopy.remove(unprovedQuery);
									newlyProvedQueries.add(unprovedQuery);
									break;
								}
							}
						}
					}
					unprovedQueries = unprovedQueriesCopy;
				}
				isProved = false;
				continue;
			}
			
			for(Rule rule : rules) {
				if(chosenQuery.equals(rule.getHead())) {
					Set<String> premisses = new HashSet<>(rule.getPremises());
					for(String provedQuery : provedQueries) {
						if(premisses.contains(provedQuery))
							premisses.remove(provedQuery);
					}
					if(premisses.isEmpty()) {
						provedQueries.add(chosenQuery);
						newlyProvedQueries.add(chosenQuery);
						isProved = true;
						break;
					}
					if(unprovedQueries.containsKey(chosenQuery)) {
						List<Set<String>> premissesList = unprovedQueries.get(chosenQuery);
						premissesList.add(premisses);
					} else {
						unprovedQueries.put(chosenQuery, new ArrayList<>(Arrays.asList(premisses)));
					}
					openQueries.addAll(rule.getPremises());
				}
			}
		}
		return false;
	}
	
}
