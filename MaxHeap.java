import java.util.Arrays;
/**
 * 
 * @author Phillip Sebastian
 *
 * @param <T>
 */
public class MaxHeap<T>{
	
	private HeapNode<T>[] heap; 
	private int heapSize;
	private int capacity;
	private int DEFAULT_CAPACITY = 50;
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public MaxHeap() {
		setCapacity(DEFAULT_CAPACITY);
		setHeapSize(0);
		heap = new HeapNode[capacity + 1]; 
	}
	/**
	 * 
	 * @param dataArray
	 * @param keyArray
	 */
	@SuppressWarnings("unchecked")
	public MaxHeap(T[] dataArray, int[] keyArray) { 	
		setCapacity(dataArray.length);
		setHeapSize(dataArray.length);
		heap = new HeapNode[capacity + 1]; 
		
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
		heapSize--;
		if (heapSize > 0) {
			exchange(heapSize + 1, 1);
			heap[heapSize + 1] = null;			
			maxHeapify(1);
		}
		heap[heapSize + 1] = null;			
		return tmpT;
	}
	/**
	 * 
	 * @param location
	 * @param key
	 */
	public void increaseHeapKey(int location, int key) { 
		if (key < heap[location].getKey()) {
			throw new RuntimeException();
		} else {
			heap[location].setKey(key);
			moveUp(location);
		}
	}
	/**
	 * 
	 * @param data
	 * @param key
	 */
	public void maxHeapInsert(T data, int key) { // TODO - check this
		if (heapSize == capacity) {
			expandCapacity();
		}
		heapSize++;
		heap[heapSize] = new HeapNode<T>(data, key);
		moveUp(heapSize);
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
	
	private void moveUp(int location) {
		int i = location;
		while (i >= 2 && (heap[parent(i)].getKey() < heap[i].getKey())) {
			exchange(i, parent(i));
			i = parent(i);
		}
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
		if (newCapacity < DEFAULT_CAPACITY) {
			capacity = 50;
		} else {
			capacity = newCapacity;
		}
	}
}
