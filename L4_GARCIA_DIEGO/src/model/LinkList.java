package model;

public class LinkList {

	    private LinkList prev;
	    private LinkList next ;
	    private long number;

	    public LinkList(long n) {
	        number = n;
	        prev=null;
	        next=null;
	    }

	    public Long getNumber() {
	        return number;
	    }

	    public LinkList getPrev() {
	        return prev;
	    }

	    public LinkList getNext() {
	        return next;
	    }

	    public void setPrev(LinkList p) {
	        prev = p;
	    }

	    public void setNext(LinkList n) {
	        next = n;
	    }

	}
		/*private long number;
		private LinkList next;
		private LinkList prev;
		public LinkList(long number) {
			this.number = number;
			next=null;
			prev=null;
		}
		public LinkList getNext() {
			return next;
		}
		public void setNext(LinkList next) {
			this.next = next;
		}
		public LinkList getPrev() {
			return prev;
		}
		public void setPrev(LinkList prev) {
			this.prev = prev;
		}
		public long getNumber() {
			return number;
		}*/
		
		

