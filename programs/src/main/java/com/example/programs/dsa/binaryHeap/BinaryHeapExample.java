package com.example.programs.dsa.binaryHeap;
import java.util.Arrays;

public class BinaryHeapExample {
    public static void main(String[] arr) {
        MinHeap minHeap = new MinHeap(6);
        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.insert(15);
        minHeap.insert(5);
        minHeap.insert(4);
        minHeap.insert(45);
        System.out.println(Arrays.toString(minHeap.heap));
        System.out.println(minHeap.extractMin());
        System.out.println(Arrays.toString(minHeap.heap));

        MaxHeap maxHeap = new MaxHeap(6);
        maxHeap.insert(3);
        maxHeap.insert(2);
        maxHeap.insert(15);
        maxHeap.insert(5);
        maxHeap.insert(4);
        maxHeap.insert(45);
        System.out.println(Arrays.toString(maxHeap.heap));
        System.out.println(maxHeap.extractMax());
        System.out.println(Arrays.toString(maxHeap.heap));


    }
}

class MinHeap {
    int[] heap;
    int size;
    int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    public int parent(int index) {
        return (index - 1) / 2;
    }

    public int left(int index) {
        return 2 * index + 1;
    }

    public int right(int index) {
        return 2 * index + 2;
    }

    void swap(int i, int j) {
        int temp = heap[j];
        heap[j] = heap[i];
        heap[i] = temp;
    }

    public void insert(int key) {
        if (size == capacity) {
            return;
        }
        size++;
        int i = size - 1;
        heap[i] = key;

        // Heapify up
        while (i != 0 && heap[parent(i)] > heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }

    }

    public void minHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < size && heap[l] < heap[smallest]) {
            smallest = l;
        }
        if (r < size && heap[r] < heap[smallest]) {
            smallest = r;
        }
        if (smallest != i) {
            swap(i, smallest);
            minHeapify(smallest);
        }

    }
    public int extractMin(){
        if(size==1){
            size--;
            return heap[0];
        }
        int min=heap[0];
        heap[0]=heap[size-1];
        size--;
        minHeapify(0);
        return min;

    }


}


class MaxHeap {
    int[] heap;
    int size;
    int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    public int parent(int index) {
        return (index - 1) / 2;
    }

    public int left(int index) {
        return (2 * index + 1);
    }

    public int right(int index) {
        return (2 * index + 2);
    }

    void swap(int i, int j) {
        int temp = heap[j];
        heap[j] = heap[i];
        heap[i] = temp;
    }

    public void insert(int key) {
        if (size == capacity) {
            return;
        }
        size++;
        int i = size - 1;
        heap[i] = key;
        while (i != 0 && heap[parent(i)] < heap[i]) {
            swap(parent(i), i);
            i = parent(i);
        }

    }

    public void maxHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < size && heap[l] > heap[smallest]) {
            smallest = l;
        }
        if (r < size && heap[r] > heap[smallest]) {
            smallest = r;
        }
        if (smallest != i) {
            swap(i, smallest);
            maxHeapify(smallest);
        }

    }
    public int extractMax(){
        if(size==1){
            size--;
            return heap[0];
        }
        int min=heap[0];
        heap[0]=heap[size-1];
        size--;
        maxHeapify(0);
        return min;

    }


}
