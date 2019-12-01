package sequential;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.*;

public class WordCount {
	public static void main(String[] args) throws IOException {

		File f1 = new File("C:\\Users\\sabee\\eclipse-workspace\\Assignment2\\src\\input"); // Creation of File Descriptor for input file
		String[] words = null; // Intialize the word Array
		int wc = 0; // Intialize word count to zero
		List<String> arrayList = new ArrayList<String>();
		FileReader fr = new FileReader(f1); // Creation of File Reader object
		BufferedReader br = new BufferedReader(fr); // Creation of BufferedReader object
		String s;
		
		Instant start = Instant.now();
		while ((s = br.readLine()) != null) // Reading Content from the file
		{
			words = s.split(","); // Split the word using space
			wc = wc + words.length; // increase the word count for each word
			for(int i = 0; i < words.length;i++) {
				arrayList.add(words[i]);
			}
			
			
		}
		fr.close();
		
		
		
		
		Map<String, Long> collect = 
		        arrayList
		        .stream()
		        .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		Instant finish = Instant.now();
		
		
		long timeElapsed = Duration.between(start, finish).toMillis();
		
		System.out.println("Time Elapsed: " + timeElapsed);
		System.out.println(collect);
	}

}
