import com.jidayu.datastructure.ArrayStack;

public class MatchParentheses {

    public boolean isValid(String s) {
        ArrayStack S = new ArrayStack();
        for (char c : s.toCharArray()) {
            if (c == '(')
                S.push(')');
            else if (c == '{')
                S.push('}');
            else if (c == '[')
                S.push(']');
            else if (S.isEmpty() || (Character) S.pop() != c)
                return false;
        }
        return S.isEmpty();
    }
}
