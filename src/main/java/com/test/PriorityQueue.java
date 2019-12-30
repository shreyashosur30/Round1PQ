package com.test;

import java.util.*;

public class PriorityQueue {

    List<Integer> priorities;
    HashMap<Integer, List<Integer>> priorityqueue;

    PriorityQueue(){
        this.priorities = new ArrayList<Integer>(){
            public boolean add(int data) {
                int index = Collections.binarySearch(this, data);
                if (index < 0) index = ~index;
                super.add(index, data);
                return true;
            }
        };
        this.priorityqueue = new HashMap<Integer, List<Integer>>();
    }

    void insertwithPriority(int element,int priority){
        priorities.add(priority);
        if(null == priorityqueue.get(priority)){
            List<Integer> elements = new LinkedList<Integer>();
            elements.add(element);
            priorityqueue.put(priority,elements);
        }
        else {
           priorityqueue.get(priority).add(element);
        }
    }

    void insert(int element){
        priorities.add(-1);
        if(null == priorityqueue.get(-1)){
            List<Integer> elements = new LinkedList<Integer>();
            elements.add(element);
            priorityqueue.put(-1,elements);
        }
        else {
            priorityqueue.get(-1).add(element);
        }
    }

    boolean deleteElementwithHighestPriority(){
        if(priorities != null) {
            int hightestPriority = priorities.remove(priorities.size() - 1);
            priorityqueue.get(hightestPriority).remove(0);
            if (priorityqueue.get(hightestPriority).size() == 0) {
                priorityqueue.remove(hightestPriority);
            }
            return true;
        }
        return false;
    }

    boolean deleteElementwithPriority(int priority){
        if(priorityqueue.get(priority) != null){
            priorityqueue.get(priority).remove(0);
            if (priorityqueue.get(priority).size() == 0) {
                priorityqueue.remove(priority);
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.insert(1);
        priorityQueue.insert(2);
        priorityQueue.insert(3);
        priorityQueue.insertwithPriority(4,5);
        priorityQueue.insertwithPriority(5,6);
        System.out.println(priorityQueue.deleteElementwithPriority(5));
    }
}
