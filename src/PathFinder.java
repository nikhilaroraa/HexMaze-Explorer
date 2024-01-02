import java.io.FileNotFoundException;
import java.io.IOException;

public class PathFinder {

/*
 * Private variable created to reference object that represents the chambers of the pyramid
 */
	private Map pyramidMap;
	
/*
 * This method is used to input the file name which contains a description of the chambers of the pyramid 
 */
	public PathFinder(String fileName) throws InvalidMapCharacterException, FileNotFoundException, IOException {
		this.pyramidMap = new Map(fileName);
	}

/*
 * This method is used to find the path from the entrance to all the corresponding treasure chambers while following the constraints  
 */
	public DLStack<Chamber> path() {
		DLStack<Chamber> newPath = new DLStack<>();
		Chamber entranceValue = pyramidMap.getEntrance();
		int treasureValue = pyramidMap.getNumTreasures();
		int foundTreasureValues = 0;
		
		newPath.push(entranceValue);
		entranceValue.markPushed();
		
		while(!newPath.isEmpty()) {
		//while loop used to meet the following conditions while the stack is not empty
			Chamber currentChamber = newPath.peek();
			//peek method called at the top of the stack
			
			if (foundTreasureValues == treasureValue && currentChamber.isTreasure()) {
			//if statement used to end the loop if the current chamber is a treasure chamber and number of treasure chambers is equal to N
				break;
			}
			
			if (currentChamber.isTreasure() == true) {
			//if statement used to continue if a treasure value is found
				foundTreasureValues++;
			}
			
			Chamber adjacentChamber = this.bestChamber(currentChamber);
			
			if (adjacentChamber == null) {
			//if statement used to pop the top chamber and mark it as popped if the neighbouring chambers is equal to null
				newPath.pop().markPopped();
			}
			else {
			//else statement used to push neighbouring chambers into the stack and mark it as pushed if not equal to null
				newPath.push(adjacentChamber);
				adjacentChamber.markPushed();
			}
		}
		return newPath;
	}
	
/*
 * This method is used to return the value of the pyramidMap
 * @return this.pyramidMap returns the value of pyramidMap
 */
	public Map getMap() {
		return this.pyramidMap;
	}
/*
 * This method is used to check whether a chamber is dim or not dim based on the conditions assigned in the assignment outline 
 */
	public boolean isDim(Chamber currentChamber) {
		if (currentChamber == null) {
		//if statement used to return false if the currentChamber is equal to null
			return false;
		}
		if (currentChamber.isSealed() == true) {
		//if statement used to return false if the currentChamber is sealed
			return false;
		}
		if (currentChamber.isLighted() == true) {
		//if statement used to return false if the currentChamber is lighted
			return false;
		}
		for (int i = 0; i <= 5; i++) {
			if (currentChamber.getNeighbour(i) != null) {
			//if statement used to check if the neighbouring chamber is not equal to null	
				if(currentChamber.getNeighbour(i).isLighted()) {
				//if statement used to return true if the currentChamber is lighted
					return true;
				}
			}
		}
		return false;
	}

/*
 * This method is used to select the best chamber to move towards from the current chamber
 */
	public Chamber bestChamber (Chamber currentChamber) {
		for (int i = 0; i <= 5; i++) {
			if(currentChamber.getNeighbour(i) != null ) {
			//if statement used to check if the neighbouring chamber is not equal to null	
				if (currentChamber.getNeighbour(i).isTreasure() && currentChamber.getNeighbour(i).isMarked() == false) {
				//if statement used to return an unmarked treasure chamber
					return currentChamber.getNeighbour(i);	
				}
			}	
		}
		for (int i = 0; i <= 5; i++) {
			if(currentChamber.getNeighbour(i) != null) {
			//if statement used to check if the neighbouring chamber is not equal to null	

				if(currentChamber.getNeighbour(i).isLighted() && currentChamber.getNeighbour(i).isMarked() == false) {
				//if statement used to return a lighted marked neighbouring chamber
					return currentChamber.getNeighbour(i);					
				}
			}
		}
		for (int i = 0; i <= 5; i++) {
			if(currentChamber.getNeighbour(i) != null) {
			//if statement used to check if the neighbouring chamber is not equal to null	
	
				if (this.isDim(currentChamber.getNeighbour(i)) && currentChamber.getNeighbour(i).isMarked() == false) {
				//if statement used to return a neighbouring unmarked dim chamber
					return currentChamber.getNeighbour(i);
				}
			}
		}
		return null;
	}

}
