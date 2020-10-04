import java.io.PrintWriter;

/*This is my custom Node class for an individual artist, it is just like a regular node class, a field for the artist
 * and a field for a reference to the next node, the access modifiers are protected so that my custom LinkedList class
 * can have access to it. Then there's a constructor and a displayLink method called displayArtist
 * Lastly I have a method called PrintArtist, it takes a printwriter as a parameter and does the same as the displayArtist
 * method but instead prints the name to an output file, because the lab description asked that the report be printed to an
 * output file.*/

public class ArtistNode {

	protected String name; 
	protected ArtistNode next;
	
	public ArtistNode (String name) {
		this.name = name;
	}
	
	public void displayArtist () {
		System.out.println(name);
	}
	
	public void printArtist (PrintWriter report) {
		report.println(name);
	}
	
}
