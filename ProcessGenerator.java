import java.util.Random;

/**
 * 
 * @author Phillip Sebastian
 *
 */
public class ProcessGenerator {

	private double probability;
	private Random random;
	
	/**
	 * Constructor for process generator 
	 * @param probability - double between 0.0 and 1.0
	 */
	public ProcessGenerator(double probability) {
		setProbability(probability);
		random = new Random();
	}
	
	/**
	 * Method generates new random double between 0.0 and 1.0. If less than probability returns true
	 * @return
	 */
	public boolean query() {
		double newProb = random.nextDouble();
		if (newProb  < probability) {
			return true;
		}
		return false;
	}
	
	/**
	 * Method to generate a new random process based on parameters
	 * @param currentTime - current time
	 * @param maximumProcessTime - Maximum for random number generation
	 * @param maximumPriorityLevel - Maximum for random number generation
	 * @return
	 */
	public Process getNewProcess(int currentTime, int maximumProcessTime, int maximumPriorityLevel) {
		return new Process(currentTime, random.nextInt(maximumPriorityLevel) + 1, random.nextInt(maximumProcessTime) + 1, maximumPriorityLevel);
	}
	/**
	 * Private method to set probability
	 * @param newProbability
	 */
	private void setProbability(double newProbability) {
		probability = newProbability;
	}
}
