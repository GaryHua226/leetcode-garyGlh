import java.util.Stack;

public class Prob20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if (stack.empty())
                    return false;
                if (Math.abs(stack.pop() - s.charAt(i)) > 2)
                    return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        Prob20 prob20 = new Prob20();
        System.out.println(prob20.isValid("(){}[]"));
    }
}
