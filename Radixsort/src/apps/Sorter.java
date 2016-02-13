package apps;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import structures.Node;

public class Sorter {

	public static void main(String[] args) 
	throws IOException {
		String inFile = "radixin1.txt";
		//String inFile = "radixin2.txt";
				
		// create new Radixsort object, using default constructor
		Radixsort rs = new Radixsort();
		
		// sort the items in the input file
		Scanner sc = new Scanner(new File(inFile));
		Node<String> output = rs.sort(sc);
		
		// print output
		System.out.println("Sorted Result:");
		printCLL(output);
		
	}

	/**
	 * Prints the items in a CLL
	 */
	public static<T> void printCLL(Node<T> rear) {
		if (rear == null) {
			return;
		}
		Node<T> ptr = rear;
		do {
			ptr = ptr.getNext();
			System.out.println(ptr.getData());
		} while (ptr != rear);
		System.out.println();
	}
}
