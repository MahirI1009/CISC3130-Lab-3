# CISC3130-Lab-3

This is my README file for Lab #3 which is due on October 5, 2020 for CISC3130 TY9. This will explain all the files within this repository. 
To begin I have multiple files, the one titled "regional-us-weekly-latest-2.csv" is the input file, it is a csv file downloaded from spotify which contains the Top 200 artists in the United States for the week of October 1, 2020.
I then have three java files, ArtistNode.java, LinkedListOfArtists.java and Lab3.java. 
ArtistNode.java is my custom Node for artists, and LinkedListOfArtists.java is my custom Simple LinkedList of ArtistNodes.
These two classes are just like normal Node and LinkedList classes but have an added custom method which prints the Node/List to an output file using a printwriter which is taken in as a parameter.
Finally, my Lab3.java class is what contains the main method, it reads in the data with a scanner, then adds all the names to an ArrayList.
Then I sort the ArrayList in descending alphabetical order and then remove the duplicates. I sorted it in descending order because I plan to add it to my custom LinkedList using the insertFirst method, since it adds each name to the beginning, by the time all the names are added, the order will be reversed and thus my LinkedList will contain all the names in ascending alphabetical order. 
After I filled up my LinkedList, I use my custom method to print all the artist names (in ascending alphabetical order) to an output file, the one that is titled "Artists-WeekOf10012020.txt".

If you want to run the code, keep all of the files in one package, including the input file, or in an online IDE, upload all the files to the online IDE (including the input file) and run it.
