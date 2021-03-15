import java.util.Arrays;

public class Prob705 {
    class MyHashSet {

        private boolean[] flag;

        /** Initialize your data structure here. */
        public MyHashSet() {
            flag = new boolean[(int)1e6+1];
            Arrays.fill(flag, false);
        }

        public void add(int key) {
            flag[key] = true;
        }

        public void remove(int key) {
            flag[key] = false;
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            return flag[key];
        }
    }
}
