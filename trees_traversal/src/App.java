import java.util.LinkedList;
import java.util.Queue;

public class App {

    public Node root;
 
    /*
        ejemplo : https://i.ytimg.com/vi/H9ObBBoGS9E/maxresdefault.jpg
            llamado recursivo # 0
            node = 45
            llamado recursivo # 1
            node.left = 23
            llamado recursivo # 2
            node.left.left = 2
            llamdo recurisvo # 3
            node.left.left.left = null
            nos regresamos a 
            node.left.left = 2
            llamado recursivo # 4
            node.left.left.rigth = 7*/

    public void printInorden(Node node){
        // Base case for recursivity 
        if (node == null){
            return;
        }
        // Dirigirse al subarbol IZQ
        printInorden(node.left);
        // Escribir la raiz del subarbol actual
        System.out.print(node.data + " ");
        // Dirigirse al subarbol DER
        printInorden(node.right);
    }

    public void printPreorden(Node node){
        // Base case for recursivity 
        if (node == null){
            return;
        }
        // Escribir la raiz del subarbol actual
        System.out.print(node.data + " ");
         // Dirigirse al subarbol IZQ
        printPreorden(node.left);
        // Dirigirse al subarbol DER
        printPreorden(node.right);
    }

    public void printPostorden(Node node){
        // Base case for recursivity 
        if (node == null){
            return;
        }
        // Dirigirse al subarbol IZQ
        printPostorden(node.left);
        // Dirigirse al subarbol DER
        printPostorden(node.right);
        // Escribir la raiz del subarbol actual
        System.out.print(node.data + " ");
    }

    /*
     * Por nivel
     * 
     * Necesitamos pre: Arbol, root , cola (Queue)
     * 
     * Pseudo-logica
     * 1. Crear una cola
     * 2. Guardar en la cola el nodo actual
     * 2.1 Se saca de la cola y escribimos la informacion del nodo
     * 3. Nos movemos al hijo IZQ y si es distinto de nulo guardamos el nodo
     *    en la cola
     * 4. Nos movemos al hijo DER y si es distinto de nulo guardamos el nodo
     *    en la cola
     * 5. Repetimos el proceso desde el paso 2.1 hasta que la cola este vacia
     */
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
       App tree = new App();
       tree.root = new Node("45");
       tree.root.left = new Node("23");
       tree.root.right = new Node("65");
       tree.root.left.left = new Node("2");
       tree.root.left.right = new Node("38");
       tree.root.left.left.right = new Node("7");
       tree.root.right.left = new Node("52");
       tree.root.right.left.left = new Node("48");
       tree.root.right.right = new Node("96");
       System.out.println("Inorden es: \n");
       tree.printInorden(tree.root);
       System.out.println("\nPreorden es: \n");
       tree.printPreorden(tree.root);
       System.out.println("\nPostorden es: \n");
       tree.printPostorden(tree.root);
       System.out.println("\nLevel es: \n");
       tree.level_traversal(tree.root);
    }      

}
