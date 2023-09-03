/*
 * MaxFrequency.java
 * Author: CS 151 staff
 * Fall 2022
 * Finds the word with max frequency by using sophisticated data structures and a single scan
 */

import java.util.*;

public class MaxFrequencySmart {

    public static void count (List <String> words){
        Map<String, Integer> dict = new HashMap<String, Integer>();
        
        
       
        
        int maxCount = 0;
        String maxWord = null;
        
        for(int i=0; i < words.size(); i++) {
            String w = words.get(i);
            if (!dict.containsKey(w))
                dict.put(w, 0);
            int count = dict.get(w)+1;
            dict.put(w, count);
            if (count > maxCount) {
                maxCount = count;
                maxWord = w;
            }    
        }
        
        System.out.println("The most frequent word is '"+maxWord+"' which occurs "+maxCount+" times.");
       
    }

}
