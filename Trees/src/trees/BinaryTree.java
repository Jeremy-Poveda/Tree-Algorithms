package trees;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
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

    public void setRoot(E content) {
        BinaryTreeNode<E> root = new BinaryTreeNode<>(content);
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
   
    public boolean isLeaf(){
        return ((this.root.getLeft() == null) && (this.root.getRight() == null));
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
    public boolean hasOnlyOneChild(){
        return (((this.root.getLeft() == null) && (this.root.getRight() != null))||((this.root.getLeft() != null) && (this.root.getRight() == null)));
    }
    
    public int countNodesWithOnlyChildRecursive(){
        int nodesWithOnlyOneChild = 0;
        
        if(!this.isEmpty()){
            if(this.hasOnlyOneChild()){
                nodesWithOnlyOneChild++;
            }
            if(this.root.getLeft() != null){
                nodesWithOnlyOneChild += this.root.getLeft().countNodesWithOnlyChildRecursive();
            }
            if(this.root.getRight() != null){
                nodesWithOnlyOneChild += this.root.getRight().countNodesWithOnlyChildRecursive();
            }
        }
        return nodesWithOnlyOneChild;
    }
    public int countNodesWithOnlyChildIterative(){
        int nodesWithOnlyOneChild = 0;
        Stack<BinaryTree<E>> s = new Stack<>();
        if(!this.isEmpty()){
            s.push(this);
            while(!s.isEmpty()){
                BinaryTree<E> actualBinaryTree = s.pop();
                if(actualBinaryTree.hasOnlyOneChild()){
                    nodesWithOnlyOneChild++;
                }
                if(actualBinaryTree.root.getLeft() != null){
                    s.push(actualBinaryTree.root.getLeft());
                }
                if(actualBinaryTree.root.getRight() != null){
                    s.push(actualBinaryTree.root.getRight());
                }
            }
        }
        return nodesWithOnlyOneChild;
    }
    
    private void updateLevels(int level, LinkedList<LinkedList<E>> niveles){
        if(!this.isEmpty()){
           if(niveles.size()<=level){
               niveles.add(new LinkedList<>());
           }
           niveles.get(level).add(this.getRoot());
           if(this.root.getLeft()!= null){
               this.root.getLeft().updateLevels(level+1, niveles);
           }
           if(this.root.getRight()!= null){
               this.root.getRight().updateLevels(level+1, niveles);
           }
        }
    }
    
    public  LinkedList<E> largestValueInEachLevelRecursive(){
        LinkedList<E> maxValores = new LinkedList<>();
        LinkedList<LinkedList<E>> niveles = new LinkedList<>();
        this.updateLevels(0, niveles);
        for(LinkedList<E> nivel : niveles){
            PriorityQueue<E> pq = new PriorityQueue<>();
            for(E valor : nivel){
                pq.offer(valor);
            }
            maxValores.add(pq.poll());
        }
        return maxValores;
    }
    
    public  LinkedList<E> largestValueInEachLevelIterative(){
        LinkedList<E> maxValores = new LinkedList<>();
        
        if(!this.isEmpty()){
            Queue<BinaryTree<E>> q = new ArrayDeque<>();
            q.offer(this);
            while(!q.isEmpty()){
                PriorityQueue<E> pq = new PriorityQueue<>();
                int sizeLevel = q.size();// numero de elementos del nivel
                for(int i = 0; i < sizeLevel; i++){
                    
                    BinaryTree<E> actualBinaryTree = q.poll();
                    pq.offer(actualBinaryTree.getRoot());
                    if(actualBinaryTree.root.getLeft() != null){
                        q.offer(actualBinaryTree.root.getLeft());
                    }
                    if(actualBinaryTree.root.getRight() != null){
                        q.offer(actualBinaryTree.root.getRight());
                    }
                }
                maxValores.add(pq.poll());
            }
        }
        return maxValores;
    }
    
    public int getHeightRecursive(){
        int height = 0;
        if(!this.isEmpty()){
            int leftHeight = 0;
            int rightHeight = 0;
            if(this.root.getLeft() != null){
                leftHeight = this.root.getLeft().getHeightRecursive();
            }
            if(this.root.getRight() != null){
                rightHeight = this.root.getRight().getHeightRecursive();
            }
            height = Integer.max(leftHeight, rightHeight)+1;
        }
        return height;
    }
    
    //Aplicando busqueda a lo ancho.
    public int getHeightIterative(){
        int height = 0;
        if(!this.isEmpty()){
           Queue<BinaryTree<E>> q = new ArrayDeque<>();
           q.offer(this);
           while(!q.isEmpty()){
               int sizeLevel = q.size();
               for(int i = 0; i < sizeLevel; i++){
                   BinaryTree<E> actualBinaryTree = q.poll();
                   if(actualBinaryTree.root.getLeft() != null){
                       q.offer(actualBinaryTree.root.getLeft());
                   }
                   if(actualBinaryTree.root.getRight() != null){
                       q.offer(actualBinaryTree.root.getRight());
                   }
               }
               height++;
           }
        }
        return height;
    }
    
    public boolean isHeightBalancedRecursive(){
        if(this.isEmpty()){
            return true;
        }
        if(this.isLeaf()){
            return true;
        }
        int leftHeight = this.root.getLeft().getHeightRecursive();
        int rightHeight = this.root.getRight().getHeightRecursive();
        return (Math.abs(leftHeight - rightHeight) <= 1);
    }
    public boolean isHeightBalancedIterative(){
        if(this.isEmpty()){
            return true;
        }
        if(this.isLeaf()){
            return true;
        }
        int leftHeight = this.root.getLeft().getHeightIterative();
        int rightHeight = this.root.getRight().getHeightIterative();
        return (Math.abs(leftHeight - rightHeight) <= 1);
    }
    public BinaryTree<E> findInterceptionRecursive(BinaryTree<E> otherBinaryTree){
        BinaryTree<E> interceptionTree = new BinaryTree<>();
        if(!this.isEmpty() && !otherBinaryTree.isEmpty()){
            try{
                int result = (int) this.getRoot() + (int) otherBinaryTree.getRoot();
                BinaryTreeNode<E> resultBinaryTreeNode = new BinaryTreeNode(result);
                interceptionTree.root = resultBinaryTreeNode;
                
            } catch (ClassCastException e){
                System.out.println("Esta operacion solo es valida para arboles binarios de tipo numerico.");
            }
            if(this.root.getLeft()!= null && otherBinaryTree.root.getLeft()!= null){
                interceptionTree.setLeft(this.root.getLeft().findInterceptionRecursive(otherBinaryTree.root.getLeft()));
            }
            
            if(this.root.getRight()!= null && otherBinaryTree.root.getRight()!= null){
                interceptionTree.setRigth(this.root.getRight().findInterceptionRecursive(otherBinaryTree.root.getRight()));
            }
        }
        return interceptionTree;
    }
    
      public BinaryTree<E> findInterceptionIterative(BinaryTree<E> otherBinaryTree){
        BinaryTree<E> interceptionTree = new BinaryTree<>();
        if(!this.isEmpty() && !otherBinaryTree.isEmpty()){
            Stack<BinaryTree<E>> s1 = new Stack<>();
            Stack<BinaryTree<E>> s2 = new Stack<>();
            try{
                int result = (int) this.getRoot() + (int) otherBinaryTree.getRoot();
                BinaryTreeNode<E> resultBinaryTreeNode = new BinaryTreeNode(result);
                interceptionTree.root = resultBinaryTreeNode;
                
            } catch (ClassCastException e){
                System.out.println("Esta operacion solo es valida para arboles binarios de tipo numerico.");
            }
            s1.push(this);
            s2.push(otherBinaryTree);
            while(!s1.isEmpty() && !s2.isEmpty()){
                BinaryTree<E> actualBinaryTree = s1.pop();
                BinaryTree<E> actualOtherBinaryTree = s2.pop();
                if(actualBinaryTree.root.getLeft() != null && actualOtherBinaryTree.root.getLeft() != null){
                    try{
                        int result = (int) actualBinaryTree.root.getLeft().getRoot() + (int) actualOtherBinaryTree.root.getLeft().getRoot();
                        BinaryTree<E> resultBinaryTreeNode = new BinaryTree(result);
                        interceptionTree.setLeft(resultBinaryTreeNode);

                    } catch (ClassCastException e){
                        System.out.println("Esta operacion solo es valida para arboles binarios de tipo numerico.");
                    }
                    s1.push(actualBinaryTree.root.getLeft());
                    s2.push(actualOtherBinaryTree.root.getLeft());
                }
                if(actualBinaryTree.root.getRight() != null && actualOtherBinaryTree.root.getRight() != null){
                    try{
                        int result = (int) actualBinaryTree.root.getRight().getRoot() + (int) actualOtherBinaryTree.root.getRight().getRoot();
                        BinaryTree<E> resultBinaryTreeNode = new BinaryTree(result);
                        interceptionTree.setRigth(resultBinaryTreeNode);

                    } catch (NumberFormatException e){
                        System.out.println("Esta operacion solo es valida para arboles binarios de tipo numerico.");
                    }
                    s1.push(actualBinaryTree.root.getRight());
                    s2.push(actualOtherBinaryTree.root.getRight());
                }
            }
        }
        return interceptionTree;
    }
      
    public int countDescendantsRecursive(){
        int countDescendents = 0;
        if(!this.isEmpty()){
            if(this.root.getLeft() != null){
                countDescendents++;
                countDescendents += this.root.getLeft().countDescendantsRecursive();
            }
            if(this.root.getRight() != null){
                countDescendents++;
                countDescendents += this.root.getRight().countDescendantsRecursive();
            }
        }
        return countDescendents;
    }
    
    public int countDescendantsIterative(){
        int countDescendents = 0;
        if(!this.isEmpty()){
            Stack<BinaryTree<E>> s = new Stack<>();
            s.push(this);
            while(!s.isEmpty()){
                BinaryTree<E> actualBinaryTree = s.pop();
                if(actualBinaryTree.root.getLeft() != null){
                    countDescendents++;
                    s.push(actualBinaryTree.root.getLeft());
                }
                if(actualBinaryTree.root.getRight() != null){
                    countDescendents++;
                    s.push(actualBinaryTree.root.getRight());
                }
            }
        }
        return countDescendents;
    }
    
    public boolean isIdenticalRecursive(BinaryTree<E> otherBinaryTree){
        boolean isIdentical = false;
        if(otherBinaryTree == null){
            return false;
        }
        if(!this.isEmpty() && !otherBinaryTree.isEmpty()){ 
            if(this.getRoot().equals(otherBinaryTree.getRoot())){
                isIdentical = true;
                if((this.root.getLeft() == null && otherBinaryTree.root.getLeft() != null) || (this.root.getLeft() != null && otherBinaryTree.root.getLeft() == null)){
                    isIdentical = false; // Si uno de los dos no existe
                } else {
                    if(this.root.getLeft() != null && otherBinaryTree.root.getLeft() != null){
                        return isIdentical && this.root.getLeft().isIdenticalRecursive(otherBinaryTree.root.getLeft());
                    }
                }
                if((this.root.getRight() == null && otherBinaryTree.root.getRight() != null) || (this.root.getRight() != null && otherBinaryTree.root.getRight() == null)){
                    isIdentical = false; // Si uno de los dos no existe
                } else {
                    if(this.root.getRight() != null && otherBinaryTree.root.getRight() != null){
                        return isIdentical && this.root.getRight().isIdenticalRecursive(otherBinaryTree.root.getRight());
                    }
                }
            } else {
                return false;
            }
        } else if(this.isEmpty() && otherBinaryTree.isEmpty()){
            return true; // Dos arboles vacios seran identicos.
        }
        return isIdentical;
    }
    
    public boolean isIdenticalIterative(BinaryTree<E> otherBinaryTree){
        boolean isIdentical = false;
        if(otherBinaryTree == null){
            return false;
        }
        if(this.isEmpty() && otherBinaryTree.isEmpty()){
            return true; // Dos arboles vacios seran identicos.
        }
        if(!this.isEmpty() && !otherBinaryTree.isEmpty()){
            Stack<BinaryTree<E>> s1 = new Stack<>();
            Stack<BinaryTree<E>> s2 = new Stack<>();
            s1.push(this);
            s2.push(otherBinaryTree);
            while(!s1.isEmpty() && !s2.isEmpty()){
                BinaryTree<E> actualBinaryTree = s1.pop();
                BinaryTree<E> actualOtherBinaryTree = s2.pop();
                if(actualBinaryTree.getRoot().equals(actualOtherBinaryTree.getRoot())){
                    
                }
            }
        }
            
        
        return isIdentical;
    }
}