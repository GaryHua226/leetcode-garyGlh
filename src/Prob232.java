import java.util.Stack;
public class Prob232 {
    // 运用两个栈来实现先入先出的队列
    class MyQueue {
        Stack<Integer> in;
        Stack<Integer> out;
        /** Initialize your data structure here. */
        public MyQueue() {
            in = new Stack<>();
            out = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            in.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (!out.empty()) {
                return out.pop();
            } else {
                while (!in.empty()) {
                    out.push(in.pop());
                }
            }
            return out.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (!out.empty()) {
                return out.peek();
            } else {
                while (!in.empty()) {
                    out.push(in.pop());
                }
            }
            return out.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return in.empty() && out.empty();
        }
    }

}


