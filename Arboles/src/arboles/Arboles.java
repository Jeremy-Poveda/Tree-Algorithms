
package arboles;

import java.util.LinkedList;

public class Arboles {

    public static void main(String[] args) {
        BinaryTree<String> a = new BinaryTree<>("A");
        BinaryTree<String> b = new BinaryTree<>("B");
        BinaryTree<String> c = new BinaryTree<>("C");
        a.setLeft(b);
        a.setRigth(c);
        BinaryTree<String> d = new BinaryTree<>("D");
        BinaryTree<String> e = new BinaryTree<>("E");
        b.setLeft(d);
        b.setRigth(e);
        BinaryTree<String> f = new BinaryTree<>("F");
        BinaryTree<String> g = new BinaryTree<>("G");
        d.setLeft(f);
        d.setRigth(g);
        System.out.println("PreOrder (Resursivo): "+a.returnPreOrderListRecursive());
        System.out.println("InOrder (Resursivo): "+a.returnInOrderListRecursive());
        System.out.println("PostOrder (Resursivo): "+a.returnPostOrderListRecursive());
        
        System.out.println("PreOrder (Iterativo): "+a.returnPreOrderListIterative());
        System.out.println("InOrder: (Iterativo): "+a.returnInOrderListIterative());
        System.out.println("PostOrder: (Iterativo): "+a.returnPostOrderListIterative());
        
        System.out.println("Numero de hojas del arbol (Recursiva): "+ a.countLeavesRecursive());
        System.out.println("Numero de hojas del arbol (Iterativa): "+ a.countLeavesIterative());
        
        System.out.println("Buscando elemento de manera iterativa: "+a.iterativeSearch("D").returnPreOrderListRecursive());
    }
}