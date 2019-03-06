import com.jidayu.datastructure.*;

import java.util.ArrayList;

public class MainClass {
    public static void main (String[] args) {
        // KMP
        String txt = "AAAA";
        String pat = "A";
        ArrayList<Integer> indexOf = new KMP(pat,txt).getRet();
        System.out.println(indexOf.toString());

        // MatchParentheses
        boolean ret = new MatchParentheses().isValid("{[]}()");
        boolean ret2 = new MatchParentheses().isValid("{[]}({[])}");
        System.out.println(ret + " " + ret2);

        ArrayStack as = new ArrayStack();
        NodeStack as2 = new NodeStack();
        ArrayQueue aq = new ArrayQueue();
        NodeQueue aq2 = new NodeQueue();
        for(int i = 0; i < 202; i++) {
            as.push(i);
            System.out.println(as.top());
            as2.push(i);
            System.out.println(as2.top());
            aq.enqueue(i);
            System.out.println(aq.front());
            aq2.enqueue(i);
            System.out.println(aq2.front());
        }

    }
}
