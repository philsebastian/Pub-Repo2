/**
 * 
 * @author Phillip Sebastian
 *
 */
public class Process {
	
	private int priorityLevel;
	private int timeToFinish;
	private int timeNotProcessed;
	private int arrivalTime;
	private int maxPriorityLevel;
	
	public Process(int arriveTime, int startPriorityLevel, int startTimeToFinish, int startMaxPriorityLevel) {
		setArrivalTime(arriveTime);
		setPriorityLevel(startPriorityLevel);
		setTimeToFinish(startTimeToFinish);
		setMaxPriorityLevel(startMaxPriorityLevel);
		setTimeNotProcessed(0);
	}
	
	public void reduceTimeRemaining() {
		timeToFinish--;
	}
	
	public void incrementTimeNotProcessed() {
		timeNotProcessed++;
	}
	
	public int getTimeNotProcessed() {
		return timeNotProcessed;
	}
	
	public int getTimeRemaining() { // TODO - How does this differ with getTimeToFinish?
		return timeToFinish;
	}
	
	public boolean done() {
		return (timeToFinish <= 0);
	}
	
	public int getArrivalTime() {
		return arrivalTime;
	}
	
	public int getPriority() {
		return priorityLevel;
	}
	
	public void incrementPriority() {
		if (priorityLevel < maxPriorityLevel) {
			priorityLevel++;
		}
	}
	
	public void resetTimeNotProcessed() {
		timeNotProcessed = 0;
	}
	
	public int getTimeToFinish() {
		return timeToFinish;
	}
	
	public int getMaxPriorityLevel() {
		return maxPriorityLevel;
	}
	
	public void setMaxPriorityLevel(int newMaxPriorityLevel) {
		maxPriorityLevel = newMaxPriorityLevel;
	}
	
	private void setPriorityLevel(int newPriorityLevel) {
		priorityLevel = newPriorityLevel;
	}
	
	private void setTimeToFinish(int newTimeToFinish) {
		timeToFinish = newTimeToFinish;
	}
	
	private void setTimeNotProcessed(int newTimeNotProcessed) {
		timeNotProcessed = newTimeNotProcessed;
	}
	
	private void setArrivalTime(int newArrivalTime) {
		arrivalTime = newArrivalTime;
	}
	
	public String toString() {
		return "Arrival Time: " + arrivalTime + "; TimeToFinish: " + timeToFinish + "; TimeNotProcessed: " + timeNotProcessed + "; Current Priority: " + priorityLevel;		
	}
	
	
}
