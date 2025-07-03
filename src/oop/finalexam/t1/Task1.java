package oop.finalexam.t1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This program demonstrates a two-phase list processing operation that combines and filters elements
 * from two input lists (list1 and list2) to produce a third output list (list3).
 *
 * Key Operations:
 * 1. Combination Phase:
 *    - For each numeric value in list1, uses it as an offset (+1) to index into list2
 *    - Combines matching elements in the format "[list2Element][list1Value]"
 *    - Handles out-of-bounds indices gracefully by skipping invalid entries
 *
 * 2. Filtering Phase:
 *    - Removes elements from the combined list where:
 *      a) The original list1 value corresponds to a valid index in list3
 *      b) Removal is performed from highest to lowest index to prevent position shifting
 *
 * Sample Workflow:
 * - list1 contains integers [3, 6, 9, ...]
 * - list2 contains strings ["ygg", "gfg", "kor", ...]
 * - Program creates combinations like "coq3" (when list1 value is 3)
 * - Final output excludes elements at positions specified by list1 values
 *
 * Error Handling:
 * - Logs skipped elements when list1 values would cause out-of-bounds access in list2
 * - Safely handles cases where list1 values might be invalid indices for list3
 */
public class Task1 {
    /**
     * Main method that executes the list processing pipeline.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Initialize list1 with integer values
        List<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(6);
        list1.add(9);
        list1.add(1);
        list1.add(8);
        list1.add(10);
        list1.add(4);
        list1.add(5);
        list1.add(7);
        list1.add(2);

        System.out.println("List1: " + list1);
         
        // Initialize list2 with string values
        List<String> list2 = new ArrayList<>();
        list2.add("ygg");
        list2.add("gfg");
        list2.add("kor");
        list2.add("coq");
        list2.add("mjx");
        list2.add("qws");
        list2.add("wra");
        list2.add("pkp");
        list2.add("mmv");
        list2.add("vhp");
        list2.add("nxi");
        list2.add("psd");
        System.out.println("List2: " + list2);

        // Phase 1: Create list3 by combining elements from list1 and list2
        List<String> list3 = new ArrayList<>();
        
        for (int i = 0; i < list1.size(); i++) {
            int indexFromList1 = list1.get(i);
            int list2Index = indexFromList1 + 1;  // Apply +1 offset
            
            try {
                String list2Element = list2.get(list2Index);
                String combined = list2Element + indexFromList1;
                list3.add(combined);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Skipping element " + indexFromList1 + 
                                 " at position " + i + 
                                 ": index " + list2Index + 
                                 " is out of bounds for list2");
            }
        }
        
        System.out.println("List3 after combination phase: " + list3);
        
        // Phase 2: Filter list3 by removing elements at indexes specified by list1 values
        Set<Integer> indexesToRemove = new HashSet<>();
        for (int value : list1) {
            if (value >= 0 && value < list3.size()) {
                indexesToRemove.add(value);
            }
        }

        // Sort in descending order for safe removal
        List<Integer> sortedIndexes = new ArrayList<>(indexesToRemove);
        sortedIndexes.sort(Collections.reverseOrder());

        for (int index : sortedIndexes) {
            list3.remove(index);
        }
        
       //final list3
        System.out.println("Final list3 after filtering: " + list3);
    }
}