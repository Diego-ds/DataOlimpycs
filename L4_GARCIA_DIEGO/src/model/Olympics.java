package model;

import java.util.ArrayList;

public class Olympics {
	private LinkList first;
	private BinaryTree p;
	private ArrayList <Long> aList;
	public Olympics() {
		this.first = null;
		this.p = null;
		this.aList = new ArrayList <Long>();
	}
	//getters
	public LinkList getFirst() {
		return first;
	}

	public BinaryTree getP() {
		return p;
	}

	//methods
	public void addArrayList(long n) {
		aList.add(n);
	}
	public void searchArrayList(long n) {
		boolean val=false;
		for(int i =0;i<aList.size() && !val;i++) {
			if(aList.get(i)==n) {
				val=true;
			}
		}
	}
	
	public void deleteArrayList(long n) {
		boolean val=false;
		for(int i =0;i<aList.size() && !val;i++) {
			if(aList.get(i)==n) {
				aList.remove(i);
				val=true;
			}
		}
	}
	
	public void addLinkedListIterative(LinkList toAdd) {
		if(first==null) {
			first=toAdd;
		}else if(first.getNext()==null) {
			first.setNext(toAdd);
			toAdd.setPrev(first);
		}else {
			LinkList current = first;
			while(current.getNext()!=null) {
				current=current.getNext();
			}
			current.setNext(toAdd);
			toAdd.setPrev(current);
		}
	}
	
	public void addLinkedListRecursive(LinkList cur,LinkList toAdd) {
		if(cur==null) {
			first=toAdd;
		}else if(cur.getNext()==null) {
			cur.setNext(toAdd);
			toAdd.setPrev(cur);
		}else {
			addLinkedListRecursive(cur.getNext(),toAdd);
		}
	}
}
