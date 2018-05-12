package input.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InputReader {

	private BufferedReader reader;
	
	public InputReader() {
		reader = new BufferedReader(new InputStreamReader(System.in));
	}
	
	
	public List<String> startReading() throws IOException {
		
		
		List<String> rawKnowledgeList = new ArrayList<>();
		
		String inputLine;
		while(!(inputLine = reader.readLine()).isEmpty()) {
			rawKnowledgeList.add(inputLine);
		}
		
		return rawKnowledgeList;
	}
}
