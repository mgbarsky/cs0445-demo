package pattern_matching;

/******************************************************************************
 *  Demo of a simplified version of Rabin-Karp algorithm - with no modulo
 *  @author M. Barsky
 *  Will only work for short patterns
 *
 ******************************************************************************/

public class RabinKarp {
    private String P;      				// the pattern  // needed only for Las Vegas
    private long patHash;    			// pattern hash value
    private int M;           			// pattern length
    private long polBase = 31;          // basis of a polynomial (for hashing)  
    private long firstCoef;             // will be precomputed as polBase ^(M-1) for speed

    /**
     * Preprocesses (hashes) the pattern string.
     *
     * @param pat the pattern string
     */
    public RabinKarp(String pat) {
        this.P = pat;      // save pattern (needed only for Las Vegas)
        M = P.length();
        firstCoef = (long) Math.pow(polBase, M-1);

        // hash pattern      
        patHash = hash(P, M);
    }

    // Compute polynomial hash for key[0..m-1].
    private long hash(String key, int m) {
        long h = 0;
        for (int j = 0; j < m; j++)
            h = (polBase * h + key.charAt(j)) ;
        return h;
    }

    // Las Vegas version: checks that P actually matches T starting at pos i ?
    private boolean check(String T, int i) {
        for (int j = 0; j < M; j++)
            if (P.charAt(j) != T.charAt(i + j))
                return false;
        return true;
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
        int N = T.length();
        if (N < M) return -1;
        
        long txtHash = hash(T, M);  // hash first M characters of text

        // check for match at offset 0
        if ((patHash == txtHash) && check(T, 0))
            return 0;

        // check for hash match; if hash match, check for exact match
        for (int i = M; i < N; i++) {
            // Remove leading digit, add trailing digit, check for match.
            txtHash = txtHash - firstCoef*T.charAt(i-M);
            txtHash = txtHash*polBase;
            txtHash = txtHash + T.charAt(i);

            // match
            int startInd = i - M + 1;
            if ((patHash == txtHash) && check(T, startInd))
                return startInd;
        }

        // no match
        return -1;
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

        RabinKarp rk = new RabinKarp(P);
        int firstIndex = rk.search(T);       

        // print results
        System.out.println("text:       " + T);

        // from brute force search method 
        System.out.print("pattern:    ");
        for (int i = 0; i < firstIndex; i++)
        	System.out.print(" ");
        System.out.println(P);
    }
}
