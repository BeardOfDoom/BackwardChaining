package input.model;

import java.util.Set;

public class Rule extends Knowledge {

	private Set<String> premises;
	private String head;
	
	public Rule(Set<String> premises, String head) {
		this.premises = premises;
		this.head = head;
	}

	public Set<String> getPremises() {
		return premises;
	}

	public void setPremises(Set<String> premises) {
		this.premises = premises;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}
}
