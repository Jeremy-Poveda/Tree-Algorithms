
package trees;

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
        
        System.out.println("Buscando elemento de manera iterativa: "+a.iterativeSearch("B").returnPreOrderListRecursive());
        
        System.out.println("Contando subarboles (nodos) con un solo hijo (Recursiva): "+a.countNodesWithOnlyChildRecursive());
        System.out.println("Contando subarboles (nodos) con un solo hijo (Iterativa): "+a.countNodesWithOnlyChildIterative());
        
        System.out.println("Valores maximos por nivel (Recursivo): "+ a.largestValueInEachLevelRecursive());
        System.out.println("Valores maximos por nivel (Iterativo): "+ a.largestValueInEachLevelIterative());
        
        System.out.println("Altura (Recursiva): "+ a.getHeightRecursive());
        System.out.println("Altura (Iterativa): "+ a.getHeightIterative());
        
        System.out.println("Si el arbol esta balanceado en altura (Recursivo): "+ a.isHeightBalancedRecursive());
        System.out.println("Si el arbol esta balanceado en altura (Iterativo): "+ a.isHeightBalancedIterative());
        
        BinaryTree<Integer> tree1 = new BinaryTree<>(1);
        tree1.setLeft(new BinaryTree<>(2));
        tree1.setRigth(new BinaryTree<>(3));
        
         BinaryTree<Integer> tree2 = new BinaryTree<>(1);
        tree2.setLeft(new BinaryTree<>(2));
        tree2.setRigth(new BinaryTree<>(3));
        
        System.out.println("Intercepcion arbol (Recursivo): "+tree1.findInterceptionRecursive(tree2).returnPreOrderListRecursive());
        System.out.println("Intercepcion arbol (Iterativo): "+tree1.findInterceptionIterative(tree2).returnPreOrderListRecursive());

    }
}