package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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
		/*control.addLinkedListRecursive(control.getFirst(), l1);
		control.addLinkedListRecursive(control.getFirst(), l2);
		control.addLinkedListRecursive(control.getFirst(), l3);
		control.addLinkedListRecursive(control.getFirst(), l4);
		control.addLinkedListRecursive(control.getFirst(), l1);*/
		control.addLinkedListIterative(l1);
		control.addLinkedListIterative(l2);
		control.addLinkedListIterative(l3);
		control.addLinkedListIterative(l4);
		control.addLinkedListIterative(l1);

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
		assertTrue(current.getNumber()==5);
		current=current.getNext();
		System.out.println(control.searchLinkedListIterative(100));
	}
	
	@Test
	public void deleteLinkedListIterativeTest() {
		setup1();
		control.deleteLinkedListIterative(5);
		assertTrue(control.getFirst().getNumber()==7);
		control.deleteLinkedListIterative(11);
		LinkList cur = control.getFirst();
		cur=cur.getNext().getNext();
		assertTrue(cur.getNumber()==5);
		control.deleteLinkedListIterative(5);
		LinkList cur2 = control.getFirst();
		cur2=cur2.getNext();
		assertTrue(cur2.getNumber()==9);
		
	}
	
	@Test
	public void deleteLinkedListRecursiveTest() {
		setup1();
		control.deleteLinkedListRecursive(control.getFirst(),5 );
		assertTrue(control.getFirst().getNumber()==7);
		control.deleteLinkedListRecursive(control.getFirst(), 11);
		LinkList cur = control.getFirst();
		cur=cur.getNext().getNext();
		assertTrue(cur.getNumber()==5);
		control.deleteLinkedListRecursive(control.getFirst(), 5);
		LinkList cur2 = control.getFirst();
		cur2=cur2.getNext();
		assertTrue(cur2.getNumber()==9);
		
	}
	
	/*@Test
	public void searchLinkedListIterativeTest() {
		setup1();
		assertTrue(control.searchLinkedListIterative(34)==false);
		//assertTrue(control.searchLinkedListIterative(5)==true);
		//assertTrue(control.searchLinkedListIterative(11)==true);
		//assertTrue(control.searchLinkedListIterative(67)==false);
	}
	
	@Test
	public void searchLinkedListRecursiveTest() {
		setup1();
		assertTrue(control.searchLinkedListRecursive(control.getFirst(), 43)==false);
		assertTrue(control.searchLinkedListRecursive(control.getFirst(), 5)==true);
		assertTrue(control.searchLinkedListRecursive(control.getFirst(), 11)==true);
		assertTrue(control.searchLinkedListRecursive(control.getFirst(), 67)==false);
		
	}
	*/
	

}
