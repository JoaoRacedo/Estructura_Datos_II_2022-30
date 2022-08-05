import java.util.LinkedList;
import java.util.Queue;

public class Insert_BT {
    public Node root;
    public Node temp = root;


    public void insert_node(Node temp, int value){
        if (temp == null){
            root = new Node(String.valueOf(value));
            return;
        }

        // Create an empty queue for level traversal
        Queue<Node> q = new LinkedList<Node>(); 
        q.add(temp);

        // Level order traversal until we find an empty space
        while(q.size() > 0){
            temp = q.peek(); // examine the node that is in head of queue 
                            // without removing it
            q.remove();     // remove node that is in head of queue

            if (temp.left == null){
                temp.left = new Node(String.valueOf(value));
                break;
            }else q.add(temp.left);

            if (temp.right == null){
                temp.right = new Node(String.valueOf(value));
                break;
            }else q.add(temp.right);
        }
    }

    public void level_traversal(Node root){
        if (root == null){
            return; // El arbol esta vacio
        }
        // Vamos a crear nuestra cola (Paso 1)
        Queue<Node> q = new LinkedList<Node>(); 
        // Agregamos el nodo actual (que para la primera vez es la raiz) (Paso 2)
        q.add(root);
        // Mientras que la cola sea distinto de vacio
        // es decir mientras tengamos objetos de tipo Nodo HAGA
        while(q.size() > 0){
            // Paso 2.1
            Node current = q.poll();
            System.out.print(current.data + " ");
            // Paso 3 Check if current.left is diff from null
            if (current.left != null) q.add(current.left);
            // Paso 4 Check if current.right is diff from null
            if (current.right != null) q.add(current.right);
        }
    }

    public static void main(String[] args) throws Exception {
        Insert_BT tree_insert = new Insert_BT();
        tree_insert.insert_node(tree_insert.root, 1);
        tree_insert.insert_node(tree_insert.root, 2);
        tree_insert.insert_node(tree_insert.root, 3);
        tree_insert.insert_node(tree_insert.root, 4);
        tree_insert.insert_node(tree_insert.root, 5);
        tree_insert.insert_node(tree_insert.root, 6);
        tree_insert.insert_node(tree_insert.root, 7);
        tree_insert.insert_node(tree_insert.root, 8);

        tree_insert.level_traversal(tree_insert.root);
        
     }     

}
