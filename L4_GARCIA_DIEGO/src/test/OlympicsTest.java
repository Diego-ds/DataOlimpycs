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
	
	@Test
	public void addLinkedListRecursiveTest () {
		LinkList l1 = new LinkList(5);
		LinkList l2 = new LinkList(7);
		LinkList l3 = new LinkList(9);
		LinkList l4 = new LinkList(11);
		control.addLinkedListRecursive(control.getFirst(), l1);
		control.addLinkedListRecursive(control.getFirst(), l2);
		control.addLinkedListRecursive(control.getFirst(), l3);
		control.addLinkedListRecursive(control.getFirst(), l4);
		control.addLinkedListRecursive(control.getFirst(), l1);
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
	}

}
