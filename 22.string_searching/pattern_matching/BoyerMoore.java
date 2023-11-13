package pattern_matching;

import java.util.*;

/******************************************************************************
 *  Compilation:  javac BoyerMoore.java
 *  Execution:    java BoyerMoore pattern text
 *  Reads in two strings, the pattern and the input text, and
 *  searches for the pattern in the input text using the
 *  bad-character rule part of the Boyer-Moore algorithm.
 *  (does not implement the strong good suffix rule)
 *
 *  % java BoyerMoore abracadabra abacadabrabracabracadabrabrabracad
 *  text:    abacadabrabracabracadabrabrabracad
 *  pattern:               abracadabra
 *
 *  % java BoyerMoore rab abacadabrabracabracadabrabrabracad
 *  text:    abacadabrabracabracadabrabrabracad
 *  pattern:         rab
 *
 *  % java BoyerMoore bcara abacadabrabracabracadabrabrabracad
 *  text:    abacadabrabracabracadabrabrabracad
 *  pattern:                                   bcara
 *
 *  % java BoyerMoore rabrabracad abacadabrabracabracadabrabrabracad
 *  text:    abacadabrabracabracadabrabrabracad
 *  pattern:                        rabrabracad
 *
 *  % java BoyerMoore abacad abacadabrabracabracadabrabrabracad
 *  text:    abacadabrabracabracadabrabrabracad
 *  pattern: abacad
 *
 ******************************************************************************/

/**
 *  The {@code BoyerMoore} class finds the first occurrence of a pattern string
 *  in a text string.
 *  <p>
 *  This implementation uses only one heuristic of the Boyer-Moore algorithm (the bad-character
 *  rule, but not the strong good suffix rule).
 * 
 */
public class BoyerMoore {
    Map <Character, Integer> right = new HashMap<Character, Integer>(); // the bad-character skip values     

   
    private String P;      // store the pattern as a string

    /**
     * Preprocesses the pattern string.
     *
     * @param pat the pattern string
     */
    public BoyerMoore(String pat) {        
        this.P = pat;

        // position of rightmost occurrence of c in the pattern
        right = new HashMap<Character, Integer>(); 
        for (int i=P.length()-1; i>=0; i--) {
        	if (right.get(P.charAt(i))==null)
        		right.put(P.charAt(i), i);
        }        
    }    

    /**
     * Returns the index of the first occurrence of the pattern string
     * in the text string.
     *
     * @param  T the text string
     * @return the index of the first occurrence of the pattern string
     *         in the text string; -1 if no such match
     */
    public int search(String T) {
        int M = P.length();
        int N = T.length();
        int skip;
        for (int i = 0; i <= N - M; i += skip) {
            skip = 0;
            for (int j = M-1; j >= 0; j--) {
                if (P.charAt(j) != T.charAt(i+j)) {
                	if (right.get(T.charAt(i))==null)  // bad character rule - no such character in the pattern
                		skip = j -  (-1);
                	else
                		skip = Math.max(1, j - right.get(T.charAt(i)));                	
                    break;
                }
            }
            if (skip == 0) return i;    // found
        }
        return -1;                       // not found
    }

    /**
     * Takes a pattern string and an input string as command-line arguments;
     * searches for the pattern string in the text string; and prints
     * the first occurrence of the pattern string in the text string.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
    	String P = "THEM";
        String T = "THETHEYTHYTHEMEM";
    	
        if (args.length >= 2) {
        	P = args[0];
            T = args[1];
        }  	  

        BoyerMoore bm = new BoyerMoore(P);
        int firstIndex = bm.search(T);       

        // print results
        System.out.println("text:       " + T);

        // from brute force search method 
        System.out.print("pattern:    ");
        for (int i = 0; i < firstIndex; i++)
        	System.out.print(" ");
        System.out.println(P);
    
    }
}
