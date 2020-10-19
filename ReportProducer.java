import java.util.*;
import java.io.*;

/* In this class is the main method, it reads in a CSV file from Spotify's website, if you want to test this code you can use any CSV file from Spotify for their top 200
 * artists. In this class I am using the CSV class for the top 200 in the US for the week of October 1, 2020. In the main method a Scanner object reads in the file and only
 * takes the third value per line as that is the value that contains the artist's name. It adds all the names to an ArrayList, then a for loop goes through the ArrayList and
 * sorts the ArrayList in alphabetical order, then another for loop removes all duplicate names in the ArrayList. Finally, it creates an instance of my custom LinkedList class 
 * for artists and adds in all artists and then uses my custom printArtists method which uses a PrintWriter object to print the list of artists to an output file, however there
 * is a method called displayArtists that one can use if they prefer the list be printed to the console. In my program this output file is called "reportOfTop200Artists.txt" */

public class ReportProducer {

public static void main(String[] args) throws Exception {
		
	String csv = "regional-us-weekly-latest.csv";
	//String to hold file name
	Scanner sc = new Scanner(new File(csv));
	//Scanner object to read the csv file
	PrintWriter outputFile = new PrintWriter("reportOfTop200Artists.txt");
	//printwriter object to print the report to an output file
		
	String header = sc.nextLine(); 
	//gets header
	String artistName = ""; 
	//string for holding artist name
	ArrayList<String> top200 = new ArrayList<>(); 
	//arraylist for all the top 200 names, in the order they're in from the csv file
		
	String line = sc.nextLine(); 
	//gets the first line after header before the while loop starts since it is irrelevant data
		
	/*this while loop gets all the names from the csv file and ignores the rest of the data as it is unneeded for the report
	 *it adds all the names to the top200 arraylist in the order that they were in in the csv file (including duplicates)*/
        while(sc.hasNext()) { //loop continues to the end of the file
        	line = sc.nextLine(); //reads in an entire line
            String [] name = line.split(","); //splits lines by commas as the data values are separated by commas
            String remove = name[name.length-3];
            if (remove.charAt(0) == '"')
            	artistName = remove.substring(1, remove.length()-1);
            else artistName = name[name.length-3];
            /* some of the artist names in the file were surrounded with quotation marks while some didnt, which caused a problem 
             * for sorting the list in alphabetical order, so I made sure to check if a name starts with a quotation mark, if it
             * does then the quotation marks are removed from the String, this what the String remove is being used for
             * Secondly, I made sure artistName is assigned the 2nd to last value of every row because some values have commas 
             * within them, this assures I get the artist's name every time and not some other value*/
            
            top200.add(artistName); //adds artist name to the top200 arraylist
        } //end of while loop
        
        
        /*this loop sorts the top200 names in alphabetical order, the first character of an element is compared to the first character 
        of the next element, then it swaps the two names if the name after it starts with a letter that comes before it in the alphabet*/
        for (int i = 1; i < top200.size(); i++) {
        	String temp = "";
        	for (int j = 0; j < top200.size()-1; j++) {
        		/*I'm using the toLowerCase method, because some artist names start with lowercase letters, and unfortunately the comparison
        		 * operator is case sensitive, so this how I got around that issue*/
        		if(top200.get(i).toLowerCase().charAt(0) > top200.get(j).toLowerCase().charAt(0)) { //compares first letter of strings
        			temp = top200.get(i); 
        			top200.set(i, top200.get(j));
        			top200.set(j, temp);
        			/*The array is being sorted in descending order, (Z - A) because when I add it to my custom simple LinkedList
        			 * the order will be reversed as I will be inserting each name at the front of the arrayList, this assures that
        			 * when the data is printed from the LinkedList, it is printed in ascending order (A-Z)*/
        		}
        	} //end of second for loop
        } //end of for loop
        
          
        /*the job of this for loop is to go through the arraylist, and it looks through it for duplicates, it compares every single element 
         * with every element after it, once it finds a duplicate, it removes it from the arrayList*/
        for (int i = 0; i < top200.size(); i++) { // this loop goes through the arraylist 1 by 1
        	for (int j = i+1; j < top200.size(); j++) { //this loop will compare the current element with the rest of the array
        		if(top200.get(i).equals(top200.get(j))) { //this condition checks for duplicates
        			top200.remove(j); //when a duplicate is found it will be removed
        			j--; //j is decremented by 1, since an element was removed, the arraylist is shorter now, so the loop wont throw it out of bounds
        		}//end of if
        	}//end of second for loop
        } //end of for loop
        
        
        /* I made my own custom Artist node and LinkedList classes for this project, I am now instantiating my custom LinkedList below and I 
         * intend to add all the names from the top200 arrayList to my custom LinkedList*/
        
        LinkedListOfArtists listOfArtists = new LinkedListOfArtists();
       
        //prints report for header of the report to the output file
        outputFile.println("This is a report of the list of artists that appear on Spotify's");
        outputFile.println("Top 200 list in the United States for the week of October 1, 2020.");
        outputFile.println("The following names in the report are in alphabetical order.\n");
        
        //this for loop adds all the names to my LinkedList
        for (int i = 0; i < top200.size(); i++) {
        	listOfArtists.insertArtist(top200.get(i));
        } //end of for loop
        
        
        /*I initially made a displayList methodbut, instead of printing to the console, I made a custo, method in my custom LinkedList and Node classes that 
	 * would print the list to an output file, and it would take in the printwriter used to print to the output file as a parameter*/
        
        listOfArtists.printArtists(outputFile); 
        /*Here I called the method that prints the List to an output file, and Im sending the printwriter as a parameter so that the method
         * can print to the desired output file*/
        
        sc.close();
        outputFile.close();
        
	} //end of main method
} //end of class
