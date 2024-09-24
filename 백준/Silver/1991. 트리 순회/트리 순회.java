import java.util.*;
import java.io.*;

public class Main {
    public static class Node {
        char data;
        Node left;
        Node right;

        Node(char data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Node[] tree = new Node[N + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if (tree[parent - 'A'] == null) {
                tree[parent - 'A'] = new Node(parent);
            }

            if (left != '.') {
                tree[left - 'A'] = new Node(left);
                tree[parent - 'A'].left = tree[left - 'A'];
            }
            if (right != '.') {
                tree[right - 'A'] = new Node(right);
                tree[parent - 'A'].right = tree[right - 'A'];
            }
        }

        preOrder(tree[0]);
        System.out.println();

        inOrder(tree[0]);
        System.out.println();

        postOrder(tree[0]);
        System.out.println();
    }

    public static void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data);
        inOrder(node.right);
    }

    public static void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data);
    }
}
