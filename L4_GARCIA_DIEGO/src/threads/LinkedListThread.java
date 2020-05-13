package threads;


import java.util.Random;

import javafx.application.Platform;
import model.LinkList;
import model.Olympics;
import ui.RaceScreenGUI;

public class LinkedListThread extends Thread {
	private RaceScreenGUI gui;
	private Olympics olympics;
	private Random generator;
	private int method;
	private int type;
	private int num;
	public LinkedListThread(Olympics olympics,long seed,int method,int type,int num,RaceScreenGUI gui) {
		generator=new Random(seed);
		this.olympics=olympics;
		this.method=method;
		this.type=type;
		this.num=num;
		this.gui=gui;
	}
	public void run() {
			int i=0;
			switch(method) {
			case 0:
				if(type==0) {
					while(i<num) {
						LinkList toAdd = new LinkList(generator.nextLong());
						olympics.addLinkedListIterative(toAdd);
						i++;
					}	
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							gui.setLinkListTime();	
							//gui.setListFinish(true);
						}
						
					});
				}else if(type==1) {
					while(i<num) {
						LinkList toAdd = new LinkList(generator.nextLong());
						olympics.addLinkedListRecursive(olympics.getFirst(), toAdd);
						i++;
					}
					
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							gui.setLinkListTime();	
							//gui.setListFinish(true);
						}
						
					});
				}
				break;
			case 1:
				if(type==0) {
					while(i<num) {
						olympics.deleteLinkedListIterative(generator.nextLong());
						i++;
					}
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							gui.setLinkListTime();	
							//gui.setListFinish(true);
						}
						
					});
				}else if(type==1) {
					while(i<num) {
						
						olympics.deleteLinkedListRecursive(olympics.getFirst(), generator.nextLong());
						i++;
					}
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							gui.setLinkListTime();
							//gui.setListFinish(true);
						}
						
					});
				}
				break;
			case 2:
				if(type==0) {
					while(i<num) {
						
						olympics.searchLinkedListIterative(generator.nextLong());
						i++;
					}
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							gui.setLinkListTime();	
							//gui.setListFinish(true);
						}
						
					});
				}else if(type==1) {
					while(i<num) {
						olympics.searchLinkedListRecursive(olympics.getFirst(), generator.nextLong());
						i++;
					}
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							gui.setLinkListTime();	
							//gui.setListFinish(true);
						}
						
					});
				}
			}
	}
}

