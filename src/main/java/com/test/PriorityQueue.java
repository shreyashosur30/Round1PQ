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
        boolean whileloop = true;

        Scanner scanner = new Scanner(System.in);
        while (whileloop){
            System.out.println("Please Enter the Option");
            System.out.println("Option 1 : Insert element with Priority");
            System.out.println("Option 2 : Insert element without Priority");
            System.out.println("Option 3 : Remove element  Highest Priority");
            System.out.println("Option 4 : Remove element  Given Priority");
            System.out.println("Option 5 : Break the Loop");
            int option;
            try {
                option = Integer.parseInt(scanner.nextLine());
            }
            catch (NumberFormatException e){
                System.out.println("Please give appropriate Number");
                continue;
            }
            switch (option){
                case 1 :
                    try {
                        System.out.println("Number and Priority");
                        int number = Integer.parseInt(scanner.nextLine());
                        int priority = Integer.parseInt(scanner.nextLine());
                        priorityQueue.insertwithPriority(4,5);
                    }
                    catch (NumberFormatException e){
                        System.out.println("Please give appropriate Number");
                    }
                    break;
                case 2 :
                    try {
                        int number = Integer.parseInt(scanner.nextLine());
                        priorityQueue.insert(number);
                    }
                    catch (NumberFormatException e){
                        System.out.println("Please give appropriate Number");
                    }
                    break;
                case 3 :
                    priorityQueue.deleteElementwithHighestPriority();
                    break;
                case 4 :
                    try {
                        int priority = Integer.parseInt(scanner.nextLine());
                        priorityQueue.deleteElementwithPriority(priority);
                    }
                    catch (NumberFormatException e){
                        System.out.println("Please give appropriate Number");
                    }
                    break;
                default:
                    whileloop = false;

            }
        }
    }
}
