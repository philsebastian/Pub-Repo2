
public class TestingClass {

	private PQueue<Process> theQueue;
	
	public TestingClass() {
		theQueue = new PQueue<Process>();
	}
	
	public void createQueue(boolean large) {
		Process tmpProcess = new Process(1, 1, 10, 99);		
		theQueue.insert(tmpProcess, tmpProcess.getPriority());
		System.out.println(theQueue.maximum());
		tmpProcess = new Process(2, 2, 10, 99);		
		theQueue.insert(tmpProcess, tmpProcess.getPriority());
		System.out.println(theQueue.maximum());
		tmpProcess = new Process(3, 3, 10, 99);		
		theQueue.insert(tmpProcess, tmpProcess.getPriority());
		if (large) {
			System.out.println(theQueue.maximum());
			tmpProcess = new Process(4, 4, 10, 99);		
			theQueue.insert(tmpProcess, tmpProcess.getPriority());
			System.out.println(theQueue.maximum());
			tmpProcess = new Process(5, 5, 10, 99);
			theQueue.insert(tmpProcess, tmpProcess.getPriority());
			System.out.println(theQueue.maximum());
			tmpProcess = new Process(6, 1, 10, 99);		
			theQueue.insert(tmpProcess, tmpProcess.getPriority());
			System.out.println(theQueue.maximum());
			tmpProcess = new Process(7, 2, 10, 99);		
			theQueue.insert(tmpProcess, tmpProcess.getPriority());
			System.out.println(theQueue.maximum());
			tmpProcess = new Process(8, 3, 10, 99);		
			theQueue.insert(tmpProcess, tmpProcess.getPriority());
			System.out.println(theQueue.maximum());
			tmpProcess = new Process(9, 4, 10, 99);		
			theQueue.insert(tmpProcess, tmpProcess.getPriority());
			System.out.println(theQueue.maximum());
			tmpProcess = new Process(10, 5, 10, 99);	
			theQueue.insert(tmpProcess, tmpProcess.getPriority());
			System.out.println(theQueue.maximum());
		}

	}
	
	public void firstUnitTest() {
		// Tests insertion
		System.out.println("---------First Unit Test Start-------------");
		createQueue(false);
		endQueue();
	}
	
	public void secondUnitTest() {
		System.out.println("---------Second Unit Test Start-------------");
		createQueue(true);
		System.out.println("---------Move end up-------------");
		theQueue.increaseKey(theQueue.size(), 6);
		System.out.println(theQueue.maximum());	
		endQueue();
	}
	
	
	public void thirdUnitTest() {
		System.out.println("---------Third Unit Test Start-------------");
		System.out.println("---------Make Queue-------------");
		createQueue(true);		
		System.out.println("---------Pull Queue and Increment-------------");
		incrementList(1);
		endQueue();
	}
	
	public void incrementList(int timeToIncrementPriority) {
		int count = theQueue.size(); 
		int keys[] = new int[count]; 
		int timeNP;
		Process processes[] = new Process[count]; 
		Process p;
		
		System.out.println("Creating arrays of size " + count);

		// extract processes in priority queue and update time not processed
		for(int i = 0; i < count; i++)
		{
			p = theQueue.extractMax();
			p.incrementTimeNotProcessed();
			timeNP = p.getTimeNotProcessed();
			if(timeNP >= timeToIncrementPriority)
			{
				p.incrementPriority();
				p.resetTimeNotProcessed();
			}					
			System.out.println("Found process (" + p + ")");
			keys[i] = p.getPriority();
			processes[i] = p; 
		}
		// rebuild priority queue 
		theQueue = new PQueue<Process>(processes, keys); 
	}
	
	public void fourthUnitTest() {
		System.out.println("---------Fourth Unit Test Start-------------");
		System.out.println("---------Make Queue-------------");
		createQueue(true);
		System.out.println("---------Selectitve Pull and Increment to end-------------");		
		Process next;
		while (!theQueue.isEmpty()) {
			System.out.println("---------Check Max-------------");
			next = theQueue.extractMax();		
			System.out.println("Current Max: (" + next + ")");		
			next.reduceTimeRemaining();
			System.out.println("---------Pull All Queue and Increment-------------");		
			incrementList(5);	
			if (next.done())
		    {
					System.out.println("Process finished (" + next + ")");
		    }
			else
		    {
				System.out.println("Re-inserting Max");
				next.resetTimeNotProcessed();
				theQueue.insert(next, next.getPriority());
		    }
		}

	}
	
	public void endQueue() {
		System.out.println("----------------EMPTYING QUEUE-------------------");

		while (!theQueue.isEmpty()) {
			System.out.println(theQueue.maximum());	
			theQueue.extractMax();
		}
		System.out.println("----------------END-------------------");

	}

	
	public static void main(String[] args) {
		TestingClass thisTest = new TestingClass();
		//thisTest.firstUnitTest();
		//thisTest.secondUnitTest();
		//thisTest.thirdUnitTest();
		thisTest.fourthUnitTest();
	}

}
