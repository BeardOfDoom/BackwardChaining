package input.model;

public class Fact extends Knowledge {

	private String fact;
	
	public Fact(String fact) {
		this.fact = fact;
	}

	public String getFact() {
		return fact;
	}

	public void setFact(String fact) {
		this.fact = fact;
	}
}
