import java.util.Arrays;
import java.util.NoSuchElementException;

public class BinaryHeap {
     

    private final int[] heap;
    private int heapSize;
     
    /**
     * This will initialize our heap with default size. 
     */
    public BinaryHeap(int capacity){
        heapSize = 0;
        heap = new int[capacity+1];
        Arrays.fill(heap, -1);
         
    }

    private void rightChildren(int i){

        int children = i * 2 + 2;
        System.out.println("The right children of "+ heap[i] + " is: " + heap[children]);
    }

    private void leftChildren(int i){

        int children = i * 2 + 1;
        System.out.println("The left children of "+ heap[i] + " is: " + heap[children]);
    }

    /**
     *  This will check if the heap is empty or not
     */
    public boolean isEmpty(){
        return heapSize==0;
    }
     
    /**
     *  This will check if the heap is full or not
     */
    public boolean isFull(){
        return heapSize == heap.length;
    }
     
    private int parent(int i){
        return (i-1)/2;
    }
     
    private int kthChild(int i,int k){
        return 2*i  +k;
    }
     
    /**
     *  This will insert new element in to heap
     *  As worst case scenario, we need to traverse till the root
     */
    public void insert(int x){
        if(isFull())
            System.out.println(">>>THE TREE IS FULL<<<");
        heap[heapSize++] = x;
        heapifyUp(heapSize-1);
    }
    /**
     *  This will delete element at index x
     */
    public void delete(int x){
        if(isEmpty())
            throw new NoSuchElementException("Heap is empty, No element to delete");
        int key = heap[x];
        heap[x] = heap[heapSize -1];
        heapSize--;
        heapifyDown(x);
    }

    /**
     *  This method used to maintain the heap property while inserting an element.
     */
    private void heapifyUp(int i) {
        int temp = heap[i];
        while(i>0 && temp > heap[parent(i)]){
            heap[i] = heap[parent(i)];
            i = parent(i);
        }
        heap[i] = temp;
    }
     
    /**
     *  This method used to maintain the heap property while deleting an element.
     */
    private void heapifyDown(int i){
        int child;
        int temp = heap[i];
        while(kthChild(i, 1) < heapSize){
            child = maxChild(i);
            if(temp < heap[child]){ heap[i] = heap[child]; }else break; i = child; } heap[i] = temp; } private int maxChild(int i) { int leftChild = kthChild(i, 1); int rightChild = kthChild(i, 2); return heap[leftChild]>heap[rightChild]?leftChild:rightChild;
    }
     
    /**
     *  This method used to print all element of the heap
     *  
     */
    public void printHeap()
        {
            System.out.print("nHeap = ");
            for (int i = 0; i < heapSize; i++)
                System.out.print(heap[i] +" ");
            System.out.println();
        }
    /**
     *  This method returns the max element of the heap.
     *  complexity: O(1)
     */
     public void findMax(){
         if(isEmpty())
             throw new NoSuchElementException("Heap is empty.");
         System.out.println("Max value: " + heap[0]);
     }
      
     public static void main(String[] args){
         BinaryHeap maxHeap = new BinaryHeap(6);

         maxHeap.insert(10);
         maxHeap.insert(4);
         maxHeap.insert(9);
         maxHeap.insert(1);
         maxHeap.insert(7);
         maxHeap.insert(5);
         maxHeap.insert(3);
         maxHeap.printHeap();

         maxHeap.rightChildren(0);
         maxHeap.leftChildren(0);

         maxHeap.delete(5);
         maxHeap.printHeap();

         maxHeap.findMax();
          
     }
}