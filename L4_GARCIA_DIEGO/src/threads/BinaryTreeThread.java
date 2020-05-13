package threads;


import java.util.Random;

import javafx.application.Platform;
import model.BinaryTree;
import model.Olympics;
import ui.RaceScreenGUI;

public class BinaryTreeThread extends Thread {
	private Olympics olympics;
	private Random generator;
	private int method;
	private int type;
	private int num;
	private RaceScreenGUI gui;
	public BinaryTreeThread(Olympics olympics,long seed,int method,int type,int num,RaceScreenGUI gui) {
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
					BinaryTree toAdd = new BinaryTree(generator.nextLong());
					olympics.addBinaryTreeIterative(toAdd);
					i++;
				}
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						gui.setBinaryTreeTime();
						//gui.setTreeFinish(true);
					}
					
				});
			}else if(type==1) {
				while(i<num) {
					BinaryTree toAdd = new BinaryTree(generator.nextLong());
					olympics.addBinaryTreeRecursive(olympics.getP(), toAdd);
					i++;
				}
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						gui.setBinaryTreeTime();
						//gui.setTreeFinish(true);
					}
					
				});
			}
			break;
		case 1:
			if(type==0) {
				while(i<num) {
					
					olympics.deleteBinaryTreeIterative(generator.nextLong());
					i++;
				}
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						gui.setBinaryTreeTime();
						//gui.setTreeFinish(true);
					}
					
				});
			}else if(type==1) {
				while(i<num) {
					
					olympics.deleteBinaryTreeRecursive(olympics.getP(), generator.nextLong());
					i++;
				}
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						gui.setBinaryTreeTime();
						//gui.setTreeFinish(true);
					}
					
				});
			}
			break;
		case 2:
			if(type==0) {
				while(i<num) {
					
					olympics.searchBinaryTreeIterative(generator.nextLong());
					i++;
				}
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						gui.setBinaryTreeTime();
						//gui.setTreeFinish(true);
					}
					
				});
			}else if(type==1) {
				while(i<num) {
					olympics.searchBinaryTreeRecursive(olympics.getP(), generator.nextLong());
					i++;
				}
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						gui.setBinaryTreeTime();
						//gui.setTreeFinish(true);
					}
					
				});
			}
		}

	}
}
