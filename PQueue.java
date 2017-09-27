/**
 * Class which implements a Priority Queue with a max heap
 * @author Phillip Sebastian
 *
 * @param <T>
 */
public class PQueue<T> {

	private MaxHeap<T> maxHeap;
	/**
	 * Constructor for a new empty queue
	 */
	public PQueue() {
		maxHeap = new MaxHeap<T>();
	}
	/**
	 * Constructor for a new queue based on a data array and key array
	 * @param dataArray
	 * @param keyArray
	 */
	public PQueue(T[] dataArray, int[] keyArray) {
		maxHeap = new MaxHeap<T>(dataArray, keyArray);
	}
	/**
	 * Method to return highest priority object T. Object stays in queue
	 * @return
	 */
	public T maximum() {
		return maxHeap.heapMax();
	}
	/**
	 * Method to return highest priority object T. Object is removed from queue
	 * @return
	 */
	public T extractMax() {
		return maxHeap.extractHeapMax();
	}
	/**
	 * Method to set the priority of an Object T at a location
	 * @param location
	 * @param newKey
	 */
	public void increaseKey(int location, int newKey) {
		maxHeap.increaseHeapKey(location, newKey);
	}
	/**
	 * Method to insert a new object T data with a priority of key
	 * @param data
	 * @param key
	 */
	public void insert(T data, int key) {
		maxHeap.maxHeapInsert(data, key);
	}
	/**
	 * Method to check if queue is empty
	 * @return
	 */
	public boolean isEmpty() {
		return maxHeap.isEmpty();
	}
	/**
	 * Method to return the queue size
	 * @return
	 */
	public int size() {
		return maxHeap.getHeapSize();
	}
}
