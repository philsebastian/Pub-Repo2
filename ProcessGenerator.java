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
	 * 
	 * @param probability
	 */
	public ProcessGenerator(double probability) {
		setProbability(probability);
		random = new Random(111);
	}
	
	/**
	 * 
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
	 * 
	 * @param currentTime
	 * @param maximumProcessTime
	 * @param maximumPriorityLevel
	 * @return
	 */
	public Process getNewProcess(int currentTime, int maximumProcessTime, int maximumPriorityLevel) {
		return new Process(currentTime, random.nextInt(maximumPriorityLevel) + 1, random.nextInt(maximumProcessTime) + 1, maximumPriorityLevel);
	}
	
	private void setProbability(double newProbability) {
		probability = newProbability;
	}
}
