package model;

public class BinaryTree {
	private long number;
	private BinaryTree left;
	private BinaryTree right;
	private BinaryTree p;
	public BinaryTree(long number) {
		this.number = number;
	}
	public BinaryTree getLeft() {
		return left;
	}
	public void setLeft(BinaryTree left) {
		this.left = left;
	}
	public BinaryTree getRight() {
		return right;
	}
	public void setRight(BinaryTree right) {
		this.right = right;
	}
	public BinaryTree getP() {
		return p;
	}
	public void setP(BinaryTree p) {
		this.p = p;
	}
	public long getNumber() {
		return number;
	}
	
}
