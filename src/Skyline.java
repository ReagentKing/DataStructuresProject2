/*
 * @author = Michael Kinealy
 * @date = 11/1/15
 */

// import necessary data structures
import java.util.ArrayList;
import java.util.List;

public class Skyline {
	//declare private variable to hold heights
	private int[] skline;
	
	//constructor
	public Skyline(int length){
		//set the array's size
		skline = new int[length+1];
	}
	
	//function used to take a building and add it's height to the array in the appropriate places
	public void addBuilding(Building bld){
		//loop to iterate through the spaces that the building takes up
		for (int i=bld.getStart();i<=bld.getEnd();i++){
			// check if the height of the building is greater than the height of whatever is there
			if (skline[i]<bld.getHeight()){
				//if it is, set the height to the height of the building
				skline[i] = bld.getHeight();
			}
		}
	}
	
	//induction algorithm for generating the skyline
	public void induction(ArrayList<Building> arr, int n){
		//check if we are done adding buildings
		if (n==0){
			//if we are, print skyline
			printReslts();
		}
		//if we aren't
		else{
			// add next building
			addBuilding(arr.get(n-1));
			// call the induction function on the array starting with one less
			induction(arr,n-1);
		}
	}
	
	// divide and conquer function for generating skyline
	public int [] divideConquer(List<Building> arr1){
		
		//check if there is just one building in the List
		if(arr1.size()==1){
			
			//if there is, create array to hold the results
			int[] reslt = new int[skline.length];
			
			//iterate through the spaces that the building occupies
			for(int i=arr1.get(arr1.size()-1).getStart();i<=arr1.get(arr1.size()-1).getEnd();i++){
				
				// set the height at that location of the result array to the height of the building
				reslt[i]=arr1.get(arr1.size()-1).getHeight();
			}
			
			//return the results of that building
			return reslt;
		}
		
		//it isn't 
		else{
			//create two smaller Lists of buildings
			List<Building> first = arr1.subList(0, arr1.size()/2);
			List<Building> second = arr1.subList(arr1.size()/2, arr1.size());
			
			//call and return combining function on the arrays returned by the two functions
			return combineLst(divideConquer(first), divideConquer(second));
		}
		
	}
	
	//function to combine two integer arrays into one
	public int[] combineLst(int[] arr1, int[] arr2){
		//instantiate the array to hold the result
		int[] reslt = new int[skline.length];
		
		//loop to iterate through the arrays
		for(int i=0;i<reslt.length;i++){
			
			//check if the value in the second array is larger than in the first
			if(arr1[i]>arr2[i]){
				
				//if it is, set the result array to the value of the first
				reslt[i]=arr1[i];
			}
			
			//else set it equal to the value from the second
			else{
				reslt[i]=arr2[i];
			}
		}
		
		//set skline variable to result to make printing easier
		skline=reslt;
		
		//return the result array
		return reslt;
	}
	
	//function to zero out the skline variable to use it for the next algorithm
	public void resetSkyline(int n){
		
		//reinstantiate the skline variable 
		skline = new int[n+1];
	}
	
	// function to print the contents of the skline variable in (p,h,p,h...) format
	public void printReslts(){
		
		//create variable to hold the current height 
		int currhgt = 0;
		
		//print '(' to indicate show start of data set
		System.out.print("(");
		
		//iterate through skline variable through second to last variable
		for(int i=0;i<skline.length-1;i++){
			//check if height at point in skyline is different from current height
			if(skline[i]!=currhgt){
				
				//if it is, print it
				System.out.print(i + "," + skline[i] + ", ");
				
				//set current height to new value
				currhgt = skline[i];
			}
		}
		
		//check if the last value in the skyline should be printed 
		if(skline[skline.length-1]!=currhgt){
			
			//if it should, print it without a ', ' to make things look nicer
			System.out.print(skline.length-1 + "," + skline[skline.length-1]+")\n");
		}
		
		//else it shouldn't be printed, and we just print a ')' to finish the data set
		else{
			System.out.print(")\n");
		}
	}
}
