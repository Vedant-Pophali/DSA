package DAA;
import java.util.*;

class Node {
    char ch;
    int freq;
    Node left, right;

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }

    Node(int freq) {
        this.ch = '\0';
        this.freq = freq;
    }
}

class FreqCompare implements Comparator<Node> {
    public int compare(Node a, Node b) {
        return a.freq - b.freq;
    }
}

public class HuffmanCoding {

    public static void buildHuffman(char[] chars, int[] freqs) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new FreqCompare());

        for (int i = 0; i < chars.length; i++) {
            pq.add(new Node(chars[i], freqs[i]));
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node parent = new Node(left.freq + right.freq);
            parent.left = left;
            parent.right = right;
            pq.add(parent);
        }

        Node root = pq.poll();
        printCodes(root, "");
    }

    private static void printCodes(Node root, String code) {
        if (root == null) return;

        if (root.ch != '\0') {
            System.out.println(root.ch + ": " + code);
        }

        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    public static void main(String[] args) {
        char[] chars = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] freqs = { 5, 9, 12, 13, 16, 45 };
        buildHuffman(chars, freqs);
    }
}