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
	/**
	 * Constructor for a new process
	 * @param arriveTime - int representing the arrival time
	 * @param startPriorityLevel - int of the start priority level of process
	 * @param startTimeToFinish - int of the start time to finish process
	 * @param startMaxPriorityLevel - int of the maximum the priority can receive
	 */
	public Process(int arriveTime, int startPriorityLevel, int startTimeToFinish, int startMaxPriorityLevel) {
		setArrivalTime(arriveTime);
		setPriorityLevel(startPriorityLevel);
		setTimeToFinish(startTimeToFinish);
		setMaxPriorityLevel(startMaxPriorityLevel);
		setTimeNotProcessed(0);
	}
	/**
	 * Method to decrement the Time Remaining of Process by one
	 */
	public void reduceTimeRemaining() {
		timeToFinish--;
	}
	/**
	 * Method to increment the Time Not Processed of Process by one
	 */
	public void incrementTimeNotProcessed() {
		timeNotProcessed++;
	}
	/**
	 * Method to get the Time Not Processed
	 * @return
	 */
	public int getTimeNotProcessed() {
		return timeNotProcessed;
	}
	/**
	 * Method to get the time to finish or time remaining of process
	 * @return
	 */
	public int getTimeRemaining() { 
		return timeToFinish;
	}
	/**
	 * Method to check if process is completed
	 * @return
	 */
	public boolean done() {
		return (timeToFinish <= 0);
	}
	/**
	 * Method to get the arrival time of process
	 * @return
	 */
	public int getArrivalTime() {
		return arrivalTime;
	}
	/**
	 * Method to get the priority of process
	 * @return
	 */
	public int getPriority() {
		return priorityLevel;
	}
	/**
	 * Method to increment the priority of process by one
	 */
	public void incrementPriority() {
		if (priorityLevel < maxPriorityLevel) {
			priorityLevel++;
		}
	}
	/**
	 * Method to set the time not process to zero
	 */
	public void resetTimeNotProcessed() {
		timeNotProcessed = 0;
	}
	/**
	 * Method to return the time to finish of process
	 * @return
	 */
	public int getTimeToFinish() {
		return timeToFinish;
	}
	/**
	 * Method to return the maximum the priority of the process can be
	 * @return
	 */
	public int getMaxPriorityLevel() {
		return maxPriorityLevel;
	}
	/**
	 * Method to set a new maximum priority level
	 * @param newMaxPriorityLevel
	 */
	public void setMaxPriorityLevel(int newMaxPriorityLevel) {
		maxPriorityLevel = newMaxPriorityLevel;
	}
	/**
	 * Private method to set priority level
	 * @param newPriorityLevel
	 */
	private void setPriorityLevel(int newPriorityLevel) {
		priorityLevel = newPriorityLevel;
	}
	/**
	 * Private method to set time to finish
	 * @param newTimeToFinish
	 */
	private void setTimeToFinish(int newTimeToFinish) {
		timeToFinish = newTimeToFinish;
	}
	/**
	 * Private method to set time not processed
	 * @param newTimeNotProcessed
	 */
	private void setTimeNotProcessed(int newTimeNotProcessed) {
		timeNotProcessed = newTimeNotProcessed;
	}
	/**
	 * Private method to set arrival time
	 * @param newArrivalTime
	 */
	private void setArrivalTime(int newArrivalTime) {
		arrivalTime = newArrivalTime;
	}
}
