import java.io.IOException;
import java.util.List;

import backwardchaining.BackwardChaining;
import exception.InvalidKnowledgeException;
import exception.InvalidQueryException;
import input.model.KnowledgeBase;
import input.parser.KnowledgeBaseParser;
import input.reader.InputReader;

public class Main {

	public static void main(String[] args) throws IOException, InvalidKnowledgeException, InvalidQueryException {
		InputReader inputReader = new InputReader();
		List<String> rawKnowledgeList = inputReader.startReading();
		
		KnowledgeBaseParser knwoledgeBaseParser = new KnowledgeBaseParser();
		KnowledgeBase knowledgeBase = knwoledgeBaseParser.tryParse(rawKnowledgeList);
		
		BackwardChaining backwardChaining = new BackwardChaining(knowledgeBase);
		if(backwardChaining.proveQuery()) {
			System.out.println("The query is proved.");
		} else {
			System.out.println("Couldn't prove the query.");
		}
	}
}
