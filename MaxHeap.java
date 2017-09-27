import java.util.Arrays;
/**
 * Class to create a MaxHeap Data Structure for T objects
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
	 * Constructor for an empty MaxHeap. Uses default capacity of 50.
	 */
	@SuppressWarnings("unchecked")
	public MaxHeap() {
		setCapacity(DEFAULT_CAPACITY);
		setHeapSize(0);
		heap = new HeapNode[capacity + 1]; 
	}
	/**
	 * Constructor to create a new maxheap based on the parameter arrays.
	 * @param dataArray - array of T objects .
	 * @param keyArray - array of corresponding keys for the data array.
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
	 * Get the maximum from the heap. No change to heap.
	 * @return T object from maximum of heap
	 */
	public T heapMax() {
		return (T) heap[1].getObject();
	}
	/**
	 * Get and remove maximum from the heap
	 * @return T object from maximum of heap
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
	 * Method to replace the key of a specific node at location
	 * @param location - location to change
	 * @param key - new key
	 */
	public void increaseHeapKey(int location, int key) { 
		if (key > heap[location].getKey()) { // Only need to change if newKey is larger
			heap[location].setKey(key);
			moveUp(location);
		}
	}
	/**
	 * Method to insert a new node to max heap
	 * @param data - T Object
	 * @param key - key for object
	 */
	public void maxHeapInsert(T data, int key) {
		if (heapSize == capacity) {
			expandCapacity();
		}
		heapSize++;
		heap[heapSize] = new HeapNode<T>(data, key);
		moveUp(heapSize);
	}
	/**
	 * Method to check max heap properties starting at location
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
	 * Returns the size of heap
	 * @return Size of Heap 
	 */
	public int getHeapSize() {
		return heapSize;
	}
	/**
	 * Returns boolean if heap is empty
	 * @return boolean
	 */
	public boolean isEmpty() {
		return (heapSize == 0);
	}
	/**
	 * Private method to expand heap array
	 */
	private void expandCapacity() {
		setCapacity(heapSize * 2);
		heap = Arrays.copyOf(heap, capacity);		
	}
	/**
	 * Private method to move a node up the heap if necessary
	 * @param location
	 */
	private void moveUp(int location) {
		int i = location;
		while (i >= 2 && (heap[parent(i)].getKey() < heap[i].getKey())) {
			exchange(i, parent(i));
			i = parent(i);
		}
	}
	/**
	 * Private method to change the node at two locations 
	 * @param locationA
	 * @param locationB
	 */
	private void exchange(int locationA, int locationB) {
		HeapNode<T> priorA = (HeapNode<T>) heap[locationA];
		heap[locationA] = heap[locationB];
		heap[locationB] = priorA;
		priorA = null;
	}
	/**
	 * Private method to return the location of the left node
	 * @param location
	 * @return
	 */
	private int left(int location) {
		return (location * 2);
	}
	/**
	 * Private method to return the location of the right node
	 * @param location
	 * @return
	 */
	private int right(int location) {
		return (location * 2 + 1);
	}
	/**
	 * Private method to return the location of the parent node
	 * @param location
	 * @return
	 */
	private int parent(int location) {
		return (location / 2);
	}
	/**
	 * Private method to set heap size
	 * @param size
	 */
	private void setHeapSize(int size) {
		heapSize = size;
	}
	/**
	 * Private method to set a new capacity if greater than DEFAULT_CAPACITY
	 * @param newCapacity
	 */
	private void setCapacity(int newCapacity) {
		if (newCapacity < DEFAULT_CAPACITY) { // Check to make sure that the new capacity is greater than the default
			capacity = 50;
		} else {
			capacity = newCapacity;
		}
	}
}
