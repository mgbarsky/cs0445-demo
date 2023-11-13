package pattern_matching;

/******************************************************************************
 *  Compilation:  javac Brute.java
 *  Execution:    java Brute pattern text
 *  Dependencies: StdOut.java
 *
 *  Reads in two strings, the pattern and the input text, and
 *  searches for the pattern in the input text using brute force.
 *
 *  % java Brute abracadabra abacadabrabracabracadabrabrabracad
 *  text:    abacadabrabracabracadabrabrabracad
 *  pattern:               abracadabra
 *
 *  % java Brute rab abacadabrabracabracadabrabrabracad
 *  text:    abacadabrabracabracadabrabrabracad
 *  pattern:         rab
 *
 *  % java Brute rabrabracad abacadabrabracabracadabrabrabracad
 *  text:    abacadabrabracabracadabrabrabracad
 *  pattern:                        rabrabracad
 *
 *  % java Brute bcara abacadabrabracabracadabrabrabracad
 *  text:    abacadabrabracabracadabrabrabracad
 *  pattern:                                   bcara
 *
 *  % java Brute abacad abacadabrabracabracadabrabrabracad
 *  text:    abacadabrabracabracadabrabrabracad
 *  pattern: abacad
 *
 ******************************************************************************/

public class Brute {

   /***************************************************************************
    *  String versions.
    ***************************************************************************/

    // return index of first match or -1 if no match
    public static int search(String pat, String txt) {
        int m = pat.length();
        int n = txt.length();

        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (txt.charAt(i+j) != pat.charAt(j))
                    break;
            }
            if (j == m) return i;            // found at offset i
        }
        return -1;                            // not found
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

        int firstIndex = search(P, T);       

        // print results
        System.out.println("text:       " + T);

        // from brute force search method 
        System.out.print("pattern:    ");
        for (int i = 0; i < firstIndex; i++)
        	System.out.print(" ");
        System.out.println(P);
    }
}


//Copyright © 2000–2019, Robert Sedgewick and Kevin Wayne.
//Last updated: Thu Aug 11 09:35:01 EDT 2022.
