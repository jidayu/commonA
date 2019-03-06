import java.util.ArrayList;

public class KMP {
    /**
     * Knuth–Morris–Pratt algorithm for String-matching.
     */
    private ArrayList<Integer> ret;
    KMP(String word, String textString) {
        this.ret = new ArrayList<>();
        kmpSearch(word, textString, this.ret);
    }

    /**
     *
     * @param word word as pattern.
     * @param textString text string as the string to be worked on.
     * @param ret return all first index of every pattern found.
     */
    private void kmpSearch(String word, String textString, ArrayList<Integer> ret){
        char[] w = word.toCharArray();
        char[] s = textString.toCharArray();
        int wl = word.length();
        int[] lps = new int[wl];
        int sl = textString.length();

        lpsFind(w,wl,lps);

        int i = 0;
        int j = 0;
        while (i < sl) {
            if (w[j] == s[i]) {
                i++;
                j++;
            }
            if (j == wl) {
                int index = i - j;
                ret.add(index);
                j = lps[j - 1];
            } else if (i < sl && w[j] != s[i]) {
                if (j != 0) j = lps[j - 1];
                else i++;
            }
        }
    }

    // parameter: the pattern
    // return: lps array
    // For each substring (1 to length), length of the longest proper prefix which is also suffix
    private void lpsFind(char[] w, int wl, int[] lps) {
        int len = 0;
        lps[0] = 0;
        int i = 1;

        while(i < wl) {
            if(w[i] == w[len]) lps[i++] = ++len;
            else {
                if (len != 0) len = lps[len - 1];
                else lps[i++] = len;
            }
        }
    }

    /**
     *
     * @return array list of first index of pattern found in string
     */
    public ArrayList<Integer> getRet() {
        return this.ret;
    }
}
