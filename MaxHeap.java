
public class MaxHeap<T>{
	
	private HeapNode<T>[] heap;
	private int heapSize;
	private int capacity;
	private int DEFAULT_CAPACITY = 11;
	
	public MaxHeap() {
		this.capacity = 11;
		this.heapSize = 0;
		this.heap = new HeapNode[12];
	}
	
	public MaxHeap(T[] dataArray, int[] keyArray) {
		
	}
	
	public T heapMax() {
		// TODO 
		return null;
	}

	public T extractHeapMax() {
		// TODO 
		return null;
	}

	public void increaseHeapKey(int location, int key) {
		// TODO 
		
	}

	public void maxHeapInsert(T data, int key) {
		// TODO 
		
	}

	public void maxHeapify(int location) {
		// TODO 
		
	}

	public int getHeapSize() {
		return this.heapSize;
	}

	public boolean isEmpty() {
		return (this.heapSize == 0);
	}
	
	private void expandCapacity() {
		// TODO
	}
	
	private void moveUp(int location) {
		// TODO
	}
	
	private void exchange(int locationA, int locationB) {
		// TODO
	}
	
	private int left(int location) {
		// TODO
		return 0;
	}
	
	private int right(int location) {
		// TODO
		return 0;
	}
	
	private int parent(int location) {
		// TODO
		return 0;
	}
	
	private void setHeapSize(int size) {
		this.heapSize = size;
	}
	
	private void setCapacity(int newCapacity) {
		this.capacity = newCapacity;
	}
}
