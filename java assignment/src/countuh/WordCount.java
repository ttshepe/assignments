package countuh;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Arrays;

public class WordCount {

		//count number of words in a file
	
	static String wordss = "C:\\MTEC\\Year1\\Semester2\\CP\\assignment/hunnid.txt";
	
	public static void main(String[] args) {
		int wordCount = 0;    
		Random rand = new Random();
		
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(wordss));
			String currLine = reader.readLine();
	        
			//timer start
			long start = System.nanoTime();  
	        
					//count words
					String Words[] = currLine.split(" ");
					wordCount = wordCount + Words.length;
					
					System.out.println("there are "+wordCount+" words in this file.");
				
			//timer end
			long finish = System.nanoTime();
			long timeElapsed = finish - start;
		 System.out.println(timeElapsed + " nanoseconds");
					
					//add all words to an array
				      for (int i = 0; i < Words.length; i++) {  
				         int randomIndexToSwap = rand.nextInt(Words.length);
				         String temps = Words[randomIndexToSwap];
				         Words[randomIndexToSwap] = Words[i];
				         Words[i] = temps; 
				      }
				      
				      			//convert array to array list
				      	List hundo = Arrays.asList(Words);
				      			//create sublist of array list
				      	List twenty = hundo.subList(0, 20);
				      			//sort alphabetical order
				      	Collections.sort(twenty);
				     

				      		//output sorted words to file
				        Path out = Paths.get("twenty.txt");
				        try {
				            Files.write(out,twenty,Charset.defaultCharset());
				        } catch (IOException e) {
				            System.out.println(e.getMessage());
				        }
    
				  
					
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

			//input and search for word
  class Search {
		
	public static void main(String[] args) throws IOException {
			//path to twenty random words
		Path path = Paths.get("twenty.txt").toAbsolutePath();
			//store words in array
		List<String> twentyy = Files.lines(path).collect(Collectors.toList());
		
		String searchWord = getInput();
		displayResults(searchWord, twentyy);
		
		
	}

		   //user input method
	public static String getInput() {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter Word: ");
			String oneWord = sc.nextLine();
			sc.close();
			
			return oneWord;

		}
		
	public static void displayResults(String searchWordy, List<String> twentyy) throws IOException {
		boolean inFile = twentyy.stream().anyMatch(p->p.equalsIgnoreCase(searchWordy));
		
		if (inFile) {
			System.out.println("\nYes, " + searchWordy + " is present" );
		} else {
			System.out.println("\nNo, " + searchWordy + " is not present" );
		}
		
		
	}
	
}
 
 
	
