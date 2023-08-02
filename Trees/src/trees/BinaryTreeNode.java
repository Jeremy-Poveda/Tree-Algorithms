package trees;

public class BinaryTreeNode<E> {
    private E content;
    private BinaryTree<E> left;
    private BinaryTree<E> right;
    
    public BinaryTreeNode(E content){
        this.content = content;
        this.left = null;
        this.right = null;
    }
    
    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public BinaryTree<E> getLeft() {
        return this.left;
    }

    public void setLeft(BinaryTree<E> left) {
        this.left = left;
    }

    public BinaryTree<E> getRight() {
        return this.right;
    }

    public void setRight(BinaryTree<E> right) {
        this.right = right;
    }
    @Override
    public String toString(){
        return "{Nodo Arbol Binario | Contenido "+this.content+"}";
    }
}