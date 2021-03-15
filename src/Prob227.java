import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Prob227 {

    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        Stack<Character> op = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        Map<Character, Integer> prio = new HashMap<>();
        prio.put('+', 1);
        prio.put('-', 1);
        prio.put('*', 2);
        prio.put('/', 2);
        int tmp;
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                if (op.empty()) {
                    op.push(ch);
                } else {
                    // 优先级更高就push到栈里面
                    if (prio.get(ch) > prio.get(op.peek())) {
                        op.push(ch);
                    }
                    // 否则就将之前操作符出栈并做操作
                    else {
                        while (!op.empty() && prio.get(op.peek()) >= prio.get(ch)) {
                            switch (op.pop()) {
                                case '+':
                                    nums.push(nums.pop() + nums.pop());
                                    break;
                                case '-':
                                    nums.push(-(nums.pop() - nums.pop()));
                                    break;
                                case '*':
                                    nums.push(nums.pop() * nums.pop());
                                    break;
                                case '/':
                                    tmp = nums.pop();
                                    nums.push(nums.pop() / tmp);
                                    break;
                                default:
                                    break;
                            }
                        }
                        op.push(ch);
                    }
                }
            }
            // 遇到数字需要将其拼成一个整数
            else {
                tmp = 0;
                while ( i < s.length() && '0' <= s.charAt(i) && s.charAt(i) <= '9' ) {
                    tmp *= 10;
                    tmp += s.charAt(i) - '0';
                    i++;
                }
                nums.push(tmp);
                i--;
            }
        }

        while (!op.empty()) {
            switch (op.pop()) {
                case '+':
                    nums.push(nums.pop() + nums.pop());
                    break;
                case '-':
                    nums.push(-(nums.pop()-nums.pop()));
                    break;
                case '*':
                    nums.push(nums.pop()*nums.pop());
                    break;
                case '/':
                    tmp = nums.pop();
                    nums.push(nums.pop()/tmp);
                    break;
                default:
                    break;
            }
        }
        return nums.pop();
    }

    public static void main(String[] args) {
        Prob227 prob227 = new Prob227();
        System.out.println(prob227.calculate("1*2-3/4+5*6-7*8+9/10"));
    }
}
