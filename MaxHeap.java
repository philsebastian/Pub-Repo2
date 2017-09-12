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
		this.setCapacity(this.DEFAULT_CAPACITY);
		this.setHeapSize(0);
		this.heap = new HeapNode<?>[this.capacity + 1]; // PHIL TODO - check this
	}
	/**
	 * 
	 * @param dataArray
	 * @param keyArray
	 */
	public MaxHeap(T[] dataArray, int[] keyArray) { 	
		this.setCapacity(dataArray.length);
		this.setHeapSize(dataArray.length);
		this.heap = new HeapNode<?>[this.capacity + 1]; // PHIL TODO - check this
		
		// Below A.K.A. Build-Max-Heap
		// First build array
		for (int i = 0; i < dataArray.length; i++) {
			this.heap[i + 1] = new HeapNode<T>(dataArray[i], keyArray[i]);
		}
		// Max-Heapify the Array
		for (int i = this.heapSize / 2; i > 0; i--) {
			this.maxHeapify(i);
		}
	}
	/**
	 * 
	 * @return
	 */
	public T heapMax() {
		return (T) this.heap[1].getObject();
	}
	/**
	 * 
	 * @return
	 */
	public T extractHeapMax() {
		T tmpT = this.heapMax();
		this.heap[1] = this.heap[this.heapSize--];
		this.maxHeapify(1);
		return tmpT;
	}
	/**
	 * 
	 * @param location
	 * @param key
	 */
	public void increaseHeapKey(int location, int key) {
		this.heap[location].setKey(key);
		this.maxHeapify(this.parent(location));		
	}
	/**
	 * 
	 * @param data
	 * @param key
	 */
	public void maxHeapInsert(T data, int key) {
		if (this.heapSize == this.capacity) {
			this.expandCapacity();
		}
		this.heap[++this.heapSize] = new HeapNode<T>(data, key);
		if (this.heapSize > 1) {
			this.maxHeapify(this.parent(this.heapSize));		
		}
	}
	/**
	 * 
	 * @param location
	 */
	public void maxHeapify(int location) {
		int largest = 0;
		int left = this.left(location);
		int right = this.right(location);		
		if (left <= this.heapSize && this.heap[left].getKey() > this.heap[location].getKey()) {
			largest = left;
		} else {
			largest = location;
		}
		if (right <= this.heapSize && this.heap[right].getKey() > this.heap[largest].getKey()) {
			largest = right;
		}
		if (largest != location) {
			this.exchange(location, largest);
			this.maxHeapify(largest);
		}		
	}
	/**
	 * 
	 * @return
	 */
	public int getHeapSize() {
		return this.heapSize;
	}
	/**
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return (this.heapSize == 0);
	}
	
	private void expandCapacity() {
		this.setCapacity(this.heapSize * 2);
		this.heap = Arrays.copyOf(this.heap, this.capacity);		
	}
	
	// TODO - ask about this method - why and what it does?
	private void moveUp(int location) {
		// TODO
	}
	
	private void exchange(int locationA, int locationB) {
		HeapNode<T> priorA = (HeapNode<T>) this.heap[locationA];
		this.heap[locationA] = this.heap[locationB];
		this.heap[locationB] = priorA;
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
	
	// TODO - Ask why this method
	private void setHeapSize(int size) {
		this.heapSize = size;
	}
	
	// TODO - Ask why this method
	private void setCapacity(int newCapacity) {
		this.capacity = newCapacity;
	}
}
