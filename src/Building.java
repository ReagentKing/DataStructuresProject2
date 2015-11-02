/*
 * @author = Michael Kinealy
 * @date = 11/1/15
 */

public class Building {
	
	//instantiate variables for the building class
	//start is the left coordinate of the building
	private int start;
	//height is the height of the building
	private int height;
	//end is the right coordinate of the building
	private int end;
	
	//constructor for the building class
	public Building(int strt, int hght, int ed){
		start = strt;
		height = hght;
		end = ed;
	}
	
	//getter for the start coordinate
	public int getStart(){
		return start;
	}
	
	//getter for the height of the building
	public int getHeight(){
		return height;
	}
	
	//getter for the end coordinate
	public int getEnd(){
		return end;
	}
	
	//setter for the start coordinate
	public void setStart(int newstrt){
		start = newstrt;
	}
	
	//setter for the height
	public void setHeight(int newhght){
		height = newhght;
	}
	
	//setter for the ending coordinate
	public void setEnd(int newed){
		end = newed;
	}
	
	
}
