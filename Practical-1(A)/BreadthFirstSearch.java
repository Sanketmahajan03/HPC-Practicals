import java.util.LinkedList;
import java.util.Queue;

class Node {
    Node left, right;
    int data;

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class BreadthFirstSearch {
    Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if (temp.left == null) {
                temp.left = new Node(data);
                return root;
            } else {
                queue.add(temp.left);
            }

            if (temp.right == null) {
                temp.right = new Node(data);
                return root;
            } else {
                queue.add(temp.right);
            }
        }

        return root;
    }

    void bfs(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int qSize = queue.size();

            for (int i = 0; i < qSize; i++) {
                Node currNode = queue.poll();
                System.out.print(currNode.data + " ");

                if (currNode.left != null)
                    queue.add(currNode.left);
                if (currNode.right != null)
                    queue.add(currNode.right);
            }
        }
    }

    public static void main(String[] args) {
        BreadthFirstSearch bfsObj = new BreadthFirstSearch();
        Node root = null;
        char ans;
        
        do {
            System.out.print("\nEnter data => ");
            int data = Integer.parseInt(System.console().readLine());
            
            root = bfsObj.insert(root, data);

            System.out.print("Do you want to insert one more node? (y/n): ");
            ans = System.console().readLine().charAt(0);
        } while (ans == 'y' || ans == 'Y');
        
        System.out.println("\nBFS traversal:");
        bfsObj.bfs(root);
    }
}
