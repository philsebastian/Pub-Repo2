import java.util.Arrays;
/**
 * 
 * @author Phillip Sebastian
 *
 * @param <T>
 */
public class MaxHeap<T>{
	
	private HeapNode<?>[] heap; // PHIL TODO - check this
	private int heapSize;
	private int capacity;
	private int DEFAULT_CAPACITY = 11;
	/**
	 * 
	 */
	public MaxHeap() {
		setCapacity(DEFAULT_CAPACITY);
		setHeapSize(0);
		heap = new HeapNode<?>[capacity + 1]; // PHIL TODO - check this
	}
	/**
	 * 
	 * @param dataArray
	 * @param keyArray
	 */
	public MaxHeap(T[] dataArray, int[] keyArray) { 	
		setCapacity(dataArray.length);
		setHeapSize(dataArray.length);
		heap = new HeapNode<?>[capacity + 1]; // PHIL TODO - check this
		
		// Below A.K.A. Build-Max-Heap
		// First build array
		for (int i = 0; i < dataArray.length; i++) {
			heap[i + 1] = new HeapNode<T>(dataArray[i], keyArray[i]);
		}
		// Max-Heapify the Array
		for (int i = heapSize / 2; i > 0; i--) {
			maxHeapify(i);
		}
	}
	/**
	 * 
	 * @return
	 */
	public T heapMax() {
		return (T) heap[1].getObject();
	}
	/**
	 * 
	 * @return
	 */
	public T extractHeapMax() {
		T tmpT = heapMax();
		heap[1] = heap[heapSize--];
		maxHeapify(1);
		return tmpT;
	}
	/**
	 * 
	 * @param location
	 * @param key
	 */
	public void increaseHeapKey(int location, int key) {
		heap[location].setKey(key);
		maxHeapify(parent(location));		
	}
	/**
	 * 
	 * @param data
	 * @param key
	 */
	public void maxHeapInsert(T data, int key) {
		if (heapSize == capacity) {
			expandCapacity();
		}
		heap[++heapSize] = new HeapNode<T>(data, key);
		if (heapSize > 1) {
			maxHeapify(parent(heapSize));		
		}
	}
	/**
	 * 
	 * @param location
	 */
	public void maxHeapify(int location) {
		int largest = 0;
		int left = left(location);
		int right = right(location);		
		if (left <= heapSize && heap[left].getKey() > heap[location].getKey()) {
			largest = left;
		} else {
			largest = location;
		}
		if (right <= heapSize && heap[right].getKey() > heap[largest].getKey()) {
			largest = right;
		}
		if (largest != location) {
			exchange(location, largest);
			maxHeapify(largest);
		}		
	}
	/**
	 * 
	 * @return
	 */
	public int getHeapSize() {
		return heapSize;
	}
	/**
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return (heapSize == 0);
	}
	
	private void expandCapacity() {
		setCapacity(heapSize * 2);
		heap = Arrays.copyOf(heap, capacity);		
	}
	
	// TODO - ask about this method - why and what it does?
	private void moveUp(int location) {
		// TODO
	}
	
	private void exchange(int locationA, int locationB) {
		HeapNode<T> priorA = (HeapNode<T>) heap[locationA];
		heap[locationA] = heap[locationB];
		heap[locationB] = priorA;
		priorA = null;
	}
	
	private int left(int location) {
		return (location * 2);
	}
	
	private int right(int location) {
		return (location * 2 + 1);
	}
	
	private int parent(int location) {
		return (location / 2);
	}
	
	private void setHeapSize(int size) {
		heapSize = size;
	}
	
	private void setCapacity(int newCapacity) {
		capacity = newCapacity;
	}
}
