/*
 * @author = Michael Kinealy
 * @date = 11/1/15
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Project2 {
	public static void main(String[] args){
		// set up scanner to read in input
		Scanner scanner = new Scanner(System.in);
		
		// ask what file to use
		System.out.println("What file would you like to run the skyline algorithms on?");
		
		// read in answer
		String inpt = scanner.next();
		
		//set up arraylist to store the buildings in
		ArrayList <Building> bldarr = new ArrayList<Building>();
		
		//instantiate counter to know how big to make the array for the skyline
		int maxLength = 0;
		
		try{
			//attempt to open the file using string provided
			File fle = new File(inpt);
			
			//create scanner to read that file
			Scanner input = new Scanner(fle);
			
			//loop to read in each building
			while(input.hasNextLine()){
				//get the left, height, and right data points for the building
				int strt = Integer.parseInt(input.next());
				int hgt = Integer.parseInt(input.next());
				int ed = Integer.parseInt(input.next());
				
				//check if the ending is farther out than the currently recorded max
				if(ed>maxLength){
					//if it is, set that as the new max
					maxLength = ed;
				}
				
				//instantiate the building
				Building bld = new Building(strt,hgt,ed);
				
				//add it to the arraylist
				bldarr.add(bld);
			}
			
			//close the scanner for the file
			input.close();
		}
		
		//catch any exceptions that occur attempting to open and read the file
		catch(IOException e){
			//print error message
			System.out.println("Error reading in file: " + e);
		}
		//close the scanner reading input
		scanner.close();
		
		//create the skyline
		Skyline skline = new Skyline(maxLength);
		
		//print out message saying which algorithm is which
		System.out.println("Induction algorithm");
		
		//run the induction algorithm
		skline.induction(bldarr, bldarr.size());
		
		//reset the skyline's array for the divide and conquer algorithm
		skline.resetSkyline(maxLength);
		
		//print out message saying which algorithm it is
		System.out.println("Divide and Conquer algorithm)");
		
		//run the divide and conquer algorithm
		skline.divideConquer(bldarr);
		
		//print the results of the divide and conquer algorithm
		skline.printReslts();
	}

}
