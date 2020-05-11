package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.BinaryTree;
import model.LinkList;
import model.Olympics;

public class OlympicsTest {
	private Olympics control;
	
	public  OlympicsTest() {
		control = new Olympics();
	}
	
	public void setup1() {
		LinkList l1 = new LinkList(5);
		LinkList l2 = new LinkList(7);
		LinkList l3 = new LinkList(9);
		LinkList l4 = new LinkList(11);
		control.addLinkedListRecursive(control.getFirst(), l1);
		control.addLinkedListRecursive(control.getFirst(), l2);
		control.addLinkedListRecursive(control.getFirst(), l3);
		control.addLinkedListRecursive(control.getFirst(), l4);
		/*control.addLinkedListIterative(l1);
		control.addLinkedListIterative(l2);
		control.addLinkedListIterative(l3);
		control.addLinkedListIterative(l4);*/
		

	}
	
	public void setup2() {
		BinaryTree t1 = new BinaryTree(10);
		BinaryTree t2 = new BinaryTree(6);
		BinaryTree t3 = new BinaryTree(13);
		BinaryTree t4 = new BinaryTree(11);
		BinaryTree t5 = new BinaryTree(14);
		BinaryTree t6 = new BinaryTree(4);
		BinaryTree t7 = new BinaryTree(8);
		/*control.addBinaryTreeRecursive(control.getP(), t1);
		control.addBinaryTreeRecursive(control.getP(), t2);
		control.addBinaryTreeRecursive(control.getP(), t3);
		control.addBinaryTreeRecursive(control.getP(), t4);
		control.addBinaryTreeRecursive(control.getP(), t5);*/
		control.addBinaryTreeIterative(t1);
		control.addBinaryTreeIterative(t2);
		control.addBinaryTreeIterative(t3);
		control.addBinaryTreeIterative(t4);
		control.addBinaryTreeIterative(t5);
		control.addBinaryTreeIterative(t6);
		control.addBinaryTreeIterative(t7);
		
	}
	
	@Test
	public void addLinkedListRecursiveTest () {
		setup1();
		LinkList current = control.getFirst();
		assertTrue(current.getNumber()==5);
		current=current.getNext();
		assertTrue(current.getNumber()==7);
		current=current.getNext();
		assertTrue(current.getNumber()==9);
		current=current.getNext();
		assertTrue(current.getNumber()==11);
		current=current.getNext();
		
	}
	
	@Test
	public void deleteLinkedListIterativeTest() {
		setup1();
		control.deleteLinkedListIterative(5);
		assertTrue(control.getFirst().getNumber()==7);
		control.deleteLinkedListIterative(11);
		LinkList cur = control.getFirst();
		cur=cur.getNext().getNext();
		//assertTrue(cur.getNumber()==5);
		//control.deleteLinkedListIterative(5);
		//LinkList cur2 = control.getFirst();
		//cur2=cur2.getNext();
		//assertTrue(cur2.getNumber()==9);
		
	}
	
	@Test
	public void deleteLinkedListRecursiveTest() {
		setup1();
		control.deleteLinkedListRecursive(control.getFirst(),5 );
		assertTrue(control.getFirst().getNumber()==7);
		control.deleteLinkedListRecursive(control.getFirst(), 11);
		LinkList cur = control.getFirst();
		cur=cur.getNext().getNext();
		/*assertTrue(cur.getNumber()==5);
		control.deleteLinkedListRecursive(control.getFirst(), 5);
		LinkList cur2 = control.getFirst();
		cur2=cur2.getNext();
		assertTrue(cur2.getNumber()==9);*/
		
	}
	
	@Test
	public void searchLinkedListIterativeTest() {
		setup1();
		assertTrue(control.searchLinkedListIterative(34)==false);
		assertTrue(control.searchLinkedListIterative(5)==true);
		assertTrue(control.searchLinkedListIterative(11)==true);
		assertTrue(control.searchLinkedListIterative(67)==false);
	}
	
	@Test
	public void searchLinkedListRecursiveTest() {
		setup1();
		assertTrue(control.searchLinkedListRecursive(control.getFirst(), 43)==false);
		assertTrue(control.searchLinkedListRecursive(control.getFirst(), 5)==true);
		assertTrue(control.searchLinkedListRecursive(control.getFirst(), 11)==true);
		assertTrue(control.searchLinkedListRecursive(control.getFirst(), 67)==false);
		
	}
	
	@Test
	public void addBinaryTreeTest() {
		setup2();
		BinaryTree current = control.getP();
		BinaryTree currentLeft=current.getLeft();
		BinaryTree currentRight =current.getRight();
		assertTrue(current.getNumber()==10);
		assertTrue(currentLeft.getNumber()==6);
		assertTrue(currentRight.getNumber()==13);
		BinaryTree currentLeftL = currentLeft.getLeft();
		assertTrue(currentLeftL.getNumber()==4);
		currentLeft = currentLeft.getRight();
		assertTrue(currentLeft.getNumber()==8);
		BinaryTree currentRightR = currentRight.getRight();
		assertTrue(currentRightR.getNumber()==14);
		currentRight=currentRight.getLeft();
		assertTrue(currentRight.getNumber()==11);
		currentRight=currentRight.getLeft();
		assertTrue(currentRight==null);
		currentRightR=currentRightR.getLeft();
		assertTrue(currentRightR==null);
		currentLeft = currentLeft.getRight();
		assertTrue(currentLeft==null);
		currentLeftL = currentLeftL.getLeft();
		assertTrue(currentLeftL==null);
		

	}
	
	@Test
	public void searchBinaryTreeIterativeTest() {
		setup2();
		assertTrue(control.searchBinaryTreeIterative(11)==true);
		assertTrue(control.searchBinaryTreeIterative(2)==false);
		assertTrue(control.searchBinaryTreeIterative(6)==true);
		assertTrue(control.searchBinaryTreeIterative(38)==false);
		

	}
	
	@Test
	public void searchBinaryTreeRecursiveTest() {
		setup2();
		assertTrue(control.searchBinaryTreeRecursive(control.getP(), 4)==true);
		assertTrue(control.searchBinaryTreeRecursive(control.getP(), 20)==false);
		assertTrue(control.searchBinaryTreeRecursive(control.getP(), 8)==true);
		assertTrue(control.searchBinaryTreeRecursive(control.getP(), 38)==false);
		

	}
	
	@Test
	public void deleteBinaryTreeRecursiveTest() {
		setup2();
		assertTrue(control.deleteBinaryTreeRecursive(control.getP(),10)==true);
		assertTrue(control.deleteBinaryTreeRecursive(control.getP(),14)==true);
		assertTrue(control.deleteBinaryTreeRecursive(control.getP(),34)==false);
		assertTrue(control.deleteBinaryTreeRecursive(control.getP(),13)==true);
		assertTrue(control.deleteBinaryTreeRecursive(control.getP(),4)==true);
	}
	
	@Test
	public void deleteBinaryTreeIterativeTest() {
		setup2();
		assertTrue(control.deleteBinaryTreeIterative(10)==true);
		assertTrue(control.deleteBinaryTreeIterative(14)==true);
		assertTrue(control.deleteBinaryTreeIterative(34)==false);
		assertTrue(control.deleteBinaryTreeIterative(6)==true);
		
		
		
	}
}
