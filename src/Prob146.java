import java.util.*;

public class Prob146 {
    class LRUCache {

        // 考虑用一个最小堆来实现？
        private int[][] heap;
        private int num;  // 记录有几个key
        private int time; // 记录当前的时间节点
        private Map<Integer, Integer> map;

        public LRUCache(int capacity) {
            heap = new int[capacity][3];
            num = 0;
            time = 0;
            map = new HashMap<>();
        }

        public int get(int key) {
            return map.getOrDefault(key, -1);
        }

        public void put(int key, int value) {

        }
    }
}
