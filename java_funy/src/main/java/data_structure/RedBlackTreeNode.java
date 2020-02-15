package data_structure;

public class RedBlackTreeNode<T extends Comparable<T>> {
    private T value;//node value
    private RedBlackTreeNode<T> left;//left child pointer
    private RedBlackTreeNode<T> right;//right child pointer
    private RedBlackTreeNode<T> parent;//parent pointer
    private boolean red;//color is red or not red

    public RedBlackTreeNode(){}
    public RedBlackTreeNode(T value){this.value=value;}
    public RedBlackTreeNode(T value, boolean isRed){this.value=value;this.red = isRed;}

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public RedBlackTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(RedBlackTreeNode<T> left) {
        this.left = left;
    }

    public RedBlackTreeNode<T> getRight() {
        return right;
    }

    public void setRight(RedBlackTreeNode<T> right) {
        this.right = right;
    }

    public RedBlackTreeNode<T> getParent() {
        return parent;
    }

    public void setParent(RedBlackTreeNode<T> parent) {
        this.parent = parent;
    }

    public boolean isRed() {
        return red;
    }

    public void setRed(boolean red) {
        this.red = red;
    }

    //居然还有判断black，好像使用时更符合直觉
    public boolean isBlack(){
        return !red;
    }

    /**
     * is leaf node
     **/
    boolean isLeaf(){
        return left==null && right==null;
    }

    //和直接用set有什么区别，起别名？
    void makeRed(){
        red=true;
    }
    void makeBlack(){
        red=false;
    }

    @Override
    public String toString(){
        return value.toString();
    }
}
