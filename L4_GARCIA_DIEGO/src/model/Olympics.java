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
	
	public void addBinaryTreeIterative(BinaryTree toAdd) {
		if(p==null) {
			p=toAdd;
		}else {
			BinaryTree current = p;
			boolean val = false;
			while(current!=null & !val) {
				if(toAdd.getNumber()>current.getNumber()) {
					if(current.getRight()==null) {
						current.setRight(toAdd);
						toAdd.setP(current);
						val=true;
					}else {
						current=current.getRight();
					}
				}else if(toAdd.getNumber()<=current.getNumber()) {
					if(current.getLeft()==null) {
						current.setLeft(toAdd);
						toAdd.setP(current);
						val=true;
					}else {
						current=current.getLeft();
					}
				}
			}
		}
	}
	
	public void addBinaryTreeRecursive(BinaryTree current,BinaryTree toAdd) {
		if(toAdd.getNumber()>current.getNumber()) {
			if(current.getRight()==null) {
				current.setRight(toAdd);
				toAdd.setP(current);
			}else {
				addBinaryTreeRecursive(current.getRight(),toAdd);
			}
		
		}else if(toAdd.getNumber()<=current.getNumber()) {
			if(current.getLeft()==null) {
				current.setLeft(toAdd);
				toAdd.setP(current);
			}else {
				addBinaryTreeRecursive(current.getLeft(),toAdd);
			}
		}
	}
	
	public void deleteLinkedListIterative(long num) {
		if(first!=null) {
			LinkList current = first;
			boolean val = false;
			while(current!=null && !val) {
				if(current.getNumber()==num) {
					if(current == first) {
						LinkList next = current.getNext();
						next.setPrev(null);
						first=next;
						val=true;
					}else if(current.getNext()==null) {
						LinkList prev = current.getPrev();
						prev.setNext(null);
						val=true;
					}else {
						LinkList prev = current.getPrev();
						LinkList next = current.getNext();
						prev.setNext(next);
						next.setPrev(prev);
						val=true;
					}
				}else {
					current=current.getNext();
				}
			}
		}
	}
	
	public void deleteLinkedListRecursive(LinkList current,long num) {
		
		if(current.getNumber()==num) {
			if(current == first) {
				LinkList next = current.getNext();
				next.setPrev(null);
				first=next;
			}else if(current.getNext()==null) {
				LinkList prev = current.getPrev();
				prev.setNext(null);
			}else {
				LinkList prev = current.getPrev();
				LinkList next = current.getNext();
				prev.setNext(next);
				next.setPrev(prev);
			}
		}else {
			deleteLinkedListRecursive(current.getNext(),num);
		}
	}
	
	public boolean searchLinkedListIterative(long num){
		boolean val = false;
		if(first!=null) {
			LinkList current =first;
			boolean flag = false;
			while(current!=null && !flag) {
				if(current.getNumber()==num) {
					//System.out.println("3rfew");
					flag=true;
					val=flag;
				}
					current=current.getNext();
					System.out.println(current.getNumber());
		
			}
		}
		return val;
		
	}
	
	public boolean searchLinkedListRecursive(LinkList current,long num) {
		boolean val = false;
		if(current!=null) {
			System.out.println("primer if");
			if(current.getNumber()==num) {
				System.out.println("segundo");

				val=true;
			}else {
				searchLinkedListRecursive(current.getNext(),num);
			}
		}
		return val;
	}
}
