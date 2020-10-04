import java.io.PrintWriter;

/*This is my custom LinkedList class, it is a LinkedList of my ArtistNode class
 *it is just like a normal Simple LinkedList, has a private first filed, constructor,
 *isEmpty, and insertFirst and DeleteFirst methods although they are called insertArtist
 *and deleteArtist
 *It also has a displayList method called displayArtists, it works like a displayList method
 *but it has a counter variable, so the position of the Artist on the list is printed alongside
 *their names.
 *I made my own method called printArtists, it does the same thing that the displayArtists method
 *does but instead it takes a printwriter object as a parameter and then instead of printing to 
 *the console, it will print to the desired output file*/

public class LinkedListOfArtists {

	private ArtistNode first;
	
	public LinkedListOfArtists() {
		first = null;
	}
	
	public boolean isEmpty() {
	     return (first == null);
	}
	
	//insertFirst method
	public void insertArtist (String artistName) {
		ArtistNode newArtist = new ArtistNode(artistName);
		newArtist.next = first;
		first = newArtist;
	}
	
	//deleteFirst method
	public ArtistNode deleteArtist () {
		ArtistNode deletedArtist = first;
		first = first.next;
		return deletedArtist;
	}
	
	//custom displayList method
	public void displayArtists () {
		ArtistNode current = first;
		int cnt = 1;
		while (current != null) {
			System.out.print(cnt + " ");
			current.displayArtist();
			current = current.next;
			cnt++;
		}
		
		cnt--;
		System.out.println("\nThere are " + cnt + " artists on the list.");
	}
	
	
	//this is the custom printArtists I mentioned, takes in a printwriter as a parameter and prints the List to an output file
	public void printArtists (PrintWriter report) {
		ArtistNode current = first;
		int cnt = 1;
		while (current != null) {
			report.print(cnt + " ");
			current.printArtist(report);
			/*it sends the printwriter to a custom printArtist method, it is the equivalent of a displayLink method except that it
			 *prints the Artist's name to the desired output file*/
			current = current.next;
			cnt++;
		}
		
		cnt--;
		report.println("\nThere are " + cnt + " artists on the list.");
	}
	
	
}
