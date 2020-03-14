package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFind {
    public static double[] getMedians(int[] arrayNums){
        PriorityQueue<Integer> lowers = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b){
                return -1*a.compareTo(b); //put the biggest value on the top
            }
        });
        PriorityQueue<Integer> highers = new PriorityQueue<Integer>();
        
        double[] medians = new double[arrayNums.length];
        for(int i=0; i<arrayNums.length; i++){
            int number = arrayNums[i];
            addNumber(number, lowers, highers);
            rebalance(lowers, highers);
            medians[i]  = getMedian(lowers, highers);
        }
        return medians;
    }

    private static void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        if(lowers.size()==0 || number<lowers.peek()){
            lowers.add(number);
        }else{
            highers.add(number);
        }
    }

    private static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) { //compare the size of the two heaps
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers; // biggerHeap: with more elements
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers; // smallerHeap: with less elements
        if(biggerHeap.size()-smallerHeap.size() >= 2){
            smallerHeap.add(biggerHeap.poll());
        }
    }

    private static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers; // biggerHeap: with more elements
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers; // smallerHeap: with less elements
        if(biggerHeap.size() ==  smallerHeap.size()){
            return ((double) biggerHeap.peek() + smallerHeap.peek()/2);
        }else{
            return biggerHeap.peek();
        }
    }
}



















