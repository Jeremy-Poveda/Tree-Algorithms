package arboles;

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

    public BinaryTree getLeft() {
        return this.left;
    }

    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    public BinaryTree getRight() {
        return this.right;
    }

    public void setRight(BinaryTree right) {
        this.right = right;
    }
}