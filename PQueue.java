/**
 * 
 * @author Phillip Sebastian
 *
 * @param <T>
 */
public class PQueue<T> {

	private MaxHeap<T> maxHeap;
	
	public PQueue() {
		maxHeap = new MaxHeap<T>();
	}
	
	public PQueue(T[] dataArray, int[] keyArray) {
		maxHeap = new MaxHeap<T>(dataArray, keyArray);
	}
	
	public T maximum() {
		return maxHeap.heapMax();
	}
	
	public T extractMax() {
		return maxHeap.extractHeapMax();
	}
	
	public void increaseKey(int location, int newKey) {
		maxHeap.increaseHeapKey(location, newKey);
	}
	
	public void insert(T data, int key) {
		maxHeap.maxHeapInsert(data, key);
	}
	
	public boolean isEmpty() {
		return maxHeap.isEmpty();
	}
	
	public int size() {
		return maxHeap.getHeapSize();
	}
}
