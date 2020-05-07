package model;

public class LinkList {
		private long number;
		private LinkList next;
		private LinkList prev;
		public LinkList(long number) {
			this.number = number;
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
		}
		
		
}
