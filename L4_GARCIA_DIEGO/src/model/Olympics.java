package model;

import java.util.ArrayList;

public class Olympics {
	private LinkList first;
	private BinaryTree p;
	private ArrayList <Long> aList;
	private boolean runTime;
	public Olympics() {
		this.first = null;
		this.p = null;
		this.aList = new ArrayList <Long>();
	}
	//getters setters
	public LinkList getFirst() {
		return first;
	}

	public BinaryTree getP() {
		return p;
	}
	
	public boolean isRunTime() {
		return runTime;
	}
	public void setRunTime(boolean runTime) {
		this.runTime = runTime;
	}
	
	
	//methods
	public void addArrayList(long n) {
		aList.add(n);
	}
	public void searchArrayList(long n) {
		boolean val=false;
		for(int i =0;i<aList.size() && !val;i++) {
			if(aList.get(i)!=null) {
				if(aList.get(i)==n) {
					val=true;
				}
			}			
		}
	}
	
	public boolean searchArrayListRecursive(long n,int index) {
		if(index>=aList.size()) {
			return false;
		}else if(aList.get(index)==n) {
			return true;
		}else {
			return searchArrayListRecursive(n,index+1);
		}
	}
	
	public boolean deleteArrayListRecursive(long n,int index) {
		if(index>=aList.size()) {
			return false;
		}else if(aList.get(index)==n) {
			aList.remove(index);
			return true;
		}else {
			try{
				return deleteArrayListRecursive(n,index+1);
			}catch(StackOverflowError e) {
				
			}
		}
		return false;
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
			try{
				addLinkedListRecursive(cur.getNext(),toAdd);
			}catch(StackOverflowError e) {
				
			}
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
		if(current==null && current==p) {
			p=toAdd;
		}else {
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
		
	}
	
	public void deleteLinkedListIterative(long num) {
		if(first!=null) {
			LinkList current = first;
			boolean val = false;
			while(current!=null && !val) {
				if(current.getNumber()==num) {
					if(current == first) {
						if(current.getNext()!=null) {
							LinkList next = current.getNext();
							next.setPrev(null);
							first=next;
							val=true;
						}else {
							first=null;
							val=true;
						}
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
				if(current.getNext()!=null) {
					LinkList next = current.getNext();
					next.setPrev(null);
					first=next;
				}else {
					first=null;
				}	
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
			try {
				deleteLinkedListRecursive(current.getNext(),num);
			}catch(StackOverflowError e) {
				
			}
			
		}
	}
	
	public boolean searchLinkedListIterative(long num){
		boolean val = false;
		if(first!=null) {
			LinkList current =first;
			boolean flag = false;
			while(current!=null && !flag) {
				if(current.getNumber()==num) {
					
					flag=true;
					val=flag;
				}
				current=current.getNext();
			}
		}
		return val;
		
	}
	
	public boolean searchLinkedListRecursive(LinkList current,long num) {
		if(current!=null) {
			if(current.getNumber()==num) {
				return true;
			}else {
				try {
					return searchLinkedListRecursive(current.getNext(),num);
				}catch(StackOverflowError e) {
					
				}
				
			}
		}
		return false;
	}
	
	public boolean searchBinaryTreeIterative(long num) {
		BinaryTree current =p;
		boolean val=false;
		while(current!=null && !val) {
			if(current.getNumber()==num) {
				val=true;
			}else if(current.getNumber()<num) {
				current=current.getRight();
			}else if(current.getNumber()>num) {
				current=current.getLeft();
			}
		}
		return val;
	}
	
	public boolean searchBinaryTreeRecursive(BinaryTree current,long num) {
		if(current!=null) {
			if(current.getNumber()==num) {
				return true;
			}else if(current.getNumber()<num) {
				return searchBinaryTreeRecursive(current.getRight(),num);
			}else if(current.getNumber()>num) {
				return searchBinaryTreeRecursive(current.getLeft(),num);
			}
		}
		return false;
	}
	
	public BinaryTree minimunValue(BinaryTree root) {
		if(root.getLeft()==null) {
			return root;
		}else {
			try{
				return minimunValue(root.getLeft());
			}catch(StackOverflowError e) {
				
			}
		}
		return root;
	}
	
	public boolean deleteBinaryTreeRecursive(BinaryTree root,long num) {
		if(root==null) {
			return false;
		}
		if(root.getNumber()<num) {
			try{
				return deleteBinaryTreeRecursive(root.getRight(),num);
			}catch(StackOverflowError e) {
				
			}
		}else if(root.getNumber()>num) {
			try{
				return deleteBinaryTreeRecursive(root.getLeft(),num);
			}catch(StackOverflowError e) {
				
			}
		}else {
			if(root.getLeft()!=null && root.getRight()!=null) {
				return deleteTreeTwoSons(root);	
			}else if(root.getLeft()!=null) {
				return deleteTreeOneSon(root);
			}else if(root.getRight()!=null) {
				return deleteTreeOneSon(root);
			}else {
				return deleteTreeNoSons(root);
			}
		}
		return false;
		
	}
	
	public boolean deleteTreeOneSon(BinaryTree root) {
		if(root.getLeft()!=null) {
			root=root.getLeft();
			root.setLeft(null);
			return true;
		}else if(root.getRight()!=null) {
			root=root.getRight();
			root.setRight(null);
			return true;
		}
		return false;
	}
	public boolean deleteTreeTwoSons(BinaryTree root) {
		BinaryTree minRightValue = minimunValue(root.getRight());
		if(minRightValue.getRight()!=null) {
			BinaryTree temp =minRightValue;
			deleteTreeOneSon(minRightValue);
			if(root==p) {
				temp.setRight(root.getRight());
				temp.setLeft(root.getLeft());
				root.getLeft().setP(temp);
				root.getRight().setP(temp);
				p=temp;
				return true;
			}else {
				temp.setRight(root.getRight());
				temp.setLeft(root.getLeft());
				BinaryTree pop = root.getP();
				if(pop.getLeft()==root) {
					pop.setLeft(temp);
				}else if(pop.getRight()==root) {
					pop.setRight(temp);
				}
				if(root.getLeft()!=null ) {
					root.getLeft().setP(temp);
				}
				if(root.getRight()!=null) {
					root.getRight().setP(temp);
				}
				root=temp;
				return true;
			}
		}else {
			BinaryTree temp =minRightValue;
			deleteTreeNoSons(minRightValue);
			if(root==p) {
				temp.setRight(root.getRight());
				temp.setLeft(root.getLeft());
				root.getLeft().setP(temp);
				root.getRight().setP(temp);
				p=temp;
				return true;
			}else {
				temp.setRight(root.getRight());
				temp.setLeft(root.getLeft());
				BinaryTree pop = root.getP();
				if(pop.getLeft()==root) {
					pop.setLeft(temp);
				}else if(pop.getRight()==root) {
					pop.setRight(temp);
				}
				root.getLeft().setP(temp);
				root.getRight().setP(temp);
				root=temp;
				return true;
			}
		}
	}
	
	public boolean deleteTreeNoSons(BinaryTree root) {
		root=null;
		return true;
	}
	public boolean deleteBinaryTreeIterative(long num) {
		BinaryTree current=p;
		while(current!=null) {
			if(num>current.getNumber()) {
				current=current.getRight();
			}else if(num<current.getNumber()) {
				current=current.getLeft();
			}else {
				if(current.getLeft()!=null && current.getRight()!=null) {
					return deleteTreeTwoSons(current);	
				}else if(current.getLeft()!=null) {
					return deleteTreeOneSon(current);
				}else if(current.getRight()!=null) {
					return  deleteTreeOneSon(current);
				}else {
					return deleteTreeNoSons(current);
				}
			}
		}
		return false;	
	}
	public void restartStructures() {
		this.p=null;
		this.first=null;
		this.aList.clear();
	}
	
	
	
	
}
