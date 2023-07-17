package arboles;

import java.util.LinkedList;
import java.util.Stack;

public class BinaryTree<E> {
    //Constructors
    BinaryTreeNode<E> root;
    public BinaryTree(E content){
        this.root = new BinaryTreeNode(content);
    }
    public BinaryTree(){
        this.root = null;
    }

    public E getRoot() {
        return root.getContent();
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }
   
    public boolean isEmpty(){
        return this.root == null;
    }
   
    public void setLeft(BinaryTree<E> leftBinaryTree){
        this.root.setLeft(leftBinaryTree);
    }
   
    public void setRigth(BinaryTree<E> rightBinaryTree){
        this.root.setRight(rightBinaryTree);
    }
   
    public LinkedList<E> returnPreOrderListRecursive(){
        LinkedList<E> result = new LinkedList<>();
        if(!this.isEmpty()){
            // Primero se añade el nodo raíz
            result.add(this.getRoot());
            if(this.root.getLeft() != null){ // Si existe un hijo izquierdo, aplicamos recursividad.
                result.addAll(this.root.getLeft().returnPreOrderListRecursive());
            }
            if(this.root.getRight() != null){ // Si existe un hijo derecho, aplicamos recursividad.
                result.addAll(this.root.getRight().returnPreOrderListRecursive());
            }
        }
    return result;
    }
   
    public LinkedList<E> returnPreOrderListIterative(){
    LinkedList<E> result = new LinkedList<>();
    Stack<BinaryTree> s = new Stack<>();
        if(!this.isEmpty()){
            s.push(this);
            while(!s.isEmpty()){
                BinaryTree<E> actualBinaryTree = s.pop();
                result.add(actualBinaryTree.getRoot());
                if(actualBinaryTree.root.getRight() != null){
                    s.push(actualBinaryTree.root.getRight());
                }
                if(actualBinaryTree.root.getLeft() != null){
                    s.push(actualBinaryTree.root.getLeft());
                }   
            }
        }
    return result;
   }
   
    public LinkedList<E> returnInOrderListRecursive(){
    LinkedList<E> result = new LinkedList<>();
        if(!this.isEmpty()){
            if(this.root.getLeft() != null){ // Si existe un hijo izquierdo, aplicamos recursividad.
                result.addAll(this.root.getLeft().returnInOrderListRecursive());
            }
            // Se agregar el root
            result.add(this.getRoot());
            if(this.root.getRight() != null){ // Si existe un hijo derecho, aplicamos recursividad.
                result.addAll(this.root.getRight().returnInOrderListRecursive());
            }
        }
    return result;
    }
   
    public LinkedList<E> returnInOrderListIterative(){
    LinkedList<E> result = new LinkedList<>();
    Stack<BinaryTree<E>> s = new Stack<>();
        if(!this.isEmpty()){
            BinaryTree<E> actualBinaryTree = this;
            while(true){
                if(actualBinaryTree != null){
                    s.push(actualBinaryTree);
                    actualBinaryTree = actualBinaryTree.root.getLeft();
                } else {
                    if(s.isEmpty()){
                        break;
                    }
                    actualBinaryTree = s.pop();
                    result.add(actualBinaryTree.getRoot());
                    actualBinaryTree = actualBinaryTree.root.getRight();
                }
            }
        }
    return result;
   }
   
    public LinkedList<E> returnPostOrderListRecursive(){
    LinkedList<E> result = new LinkedList<>();
        if(!this.isEmpty()){
            if(this.root.getLeft() != null){ // Si existe un hijo izquierdo, aplicamos recursividad.
                result.addAll(this.root.getLeft().returnPostOrderListRecursive());
            }
            if(this.root.getRight() != null){ // Si existe un hijo derecho, aplicamos recursividad.
                result.addAll(this.root.getRight().returnPostOrderListRecursive());
            }
            // Se agregar el root
            result.add(this.getRoot());
        }
    return result;
   }
   
    public LinkedList<E> returnPostOrderListIterative(){
    LinkedList<E> result = new LinkedList<>();
    Stack<BinaryTree<E>> s = new Stack<>();
    Stack<BinaryTree<E>> auxStack = new Stack<>();
        if(!this.isEmpty()){
            s.push(this);
            while(!s.isEmpty()){
                BinaryTree<E> actualBinaryTree = s.pop();
                auxStack.push(actualBinaryTree);
                if(actualBinaryTree.root.getLeft() != null){
                    s.push(actualBinaryTree.root.getLeft());  
                }
                if(actualBinaryTree.root.getRight() != null){
                    s.push(actualBinaryTree.root.getRight());
                }
            }
            while(!auxStack.isEmpty()){
                result.add(auxStack.pop().getRoot());
            }
        }
    return result;
   }
   
    public boolean isLeaf(){
       return ((this.root.getLeft() == null) && (this.root.getRight() == null));
   }
   
    public int countLeavesRecursive(){
       int leaves = 0;
       if(!this.isEmpty()){
           if(this.isLeaf()){
               leaves++;
           }
           if(this.root.getLeft() != null){ //Si existe el arbol hijo izquierdo
               leaves += this.root.getLeft().countLeavesRecursive();
           }
           if(this.root.getRight() != null){ //Si existe el arbol hijo izquierdo
               leaves += this.root.getRight().countLeavesRecursive();
           }
       }
       return leaves;
   }
   
    public int countLeavesIterative(){
       int leaves = 0;
       Stack<BinaryTree> s = new Stack<>();
       if(!this.isEmpty()){
            s.push(this);
            while(!s.isEmpty()){
                BinaryTree<E> actualBinaryTree = s.pop();
                if(actualBinaryTree.isLeaf()){
                    leaves++;
                }
                if(actualBinaryTree.root.getLeft() != null){ //Si existe el arbol hijo izquierdo
                    s.push(actualBinaryTree.root.getLeft());
                }
                if(actualBinaryTree.root.getRight() != null){ //Si existe el arbol hijo derecho
                    s.push(actualBinaryTree.root.getRight());
                }
            }
       }
       return leaves;
   }
   
    public BinaryTree<E> iterativeSearch(E content){
       BinaryTree<E> resultSubBinaryTree = new BinaryTree<>();
       Stack<BinaryTree<E>> s = new Stack<>();
       if(!this.isEmpty()){
            s.push(this);
            while(!s.isEmpty()){
                BinaryTree<E> actualBinaryTree = s.pop();
                if(actualBinaryTree.getRoot().equals(content)){
                    System.out.println("Node Finded");
                    resultSubBinaryTree = actualBinaryTree;
                }     
                if(actualBinaryTree.root.getLeft() != null){
                    s.push(actualBinaryTree.root.getLeft());
                }
                if(actualBinaryTree.root.getRight() != null){
                    s.push(actualBinaryTree.root.getRight());
                }
            }
        }
        return resultSubBinaryTree;
    } 
}