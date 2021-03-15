import java.util.LinkedList;
import java.util.Queue;

public class Prob331 {
    public boolean isValidSerialization(String preorder) {
        if (preorder.equals(""))
            return true;
        String[] nodes = preorder.split(",");
        Queue<String> queue = new LinkedList<>();
        for (String s : nodes)
            queue.offer(s);
        if (queue.peek().equals("#")) {
            return queue.size() == 1;
        }
        queue.poll();
        return findValidTree(queue) && findValidTree(queue) && queue.isEmpty();
    }

    public boolean findValidTree(Queue<String> nodes) {
        if (nodes.isEmpty())
            return false;
        if (nodes.peek().equals("#")){
            nodes.poll();
            return true;
        }
        nodes.poll();
        return findValidTree(nodes) && findValidTree(nodes);
    }

    public static void main(String[] args) {
        Prob331 prob331 = new Prob331();
        System.out.println(prob331.isValidSerialization("9,#,#,1"));
    }
}
