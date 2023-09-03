import java.util.*;
import java.io.*;

/*
 * MaxFrequency.java
 * Author: MBarsky
 * Fall 2022
 * Finds the word with max frequency by multiple scans of a file data
 */
public class MaxFrequency {
    public static void count(List<String> words) {           
        int maxCount = 0;
        String maxWord = null;
        
        for(int i=0; i < words.size(); i++) {
            String currentWord = words.get(i);
            int count = 1;
            
            for(int j=i+1; j < words.size(); j++) {
                String w = words.get(j);
                if (w.equals(currentWord)) {
                    count ++;
                }
            }
            
            if (count > maxCount) {
                maxCount = count;
                maxWord = currentWord;
            }    
        }
        
        System.out.println("The most frequent word is '"+maxWord+"' which occurs "+maxCount+" times.");      
       
    }
}
