package threads;

import java.util.Random;

import javafx.application.Platform;
import model.Olympics;
import ui.RaceScreenGUI;

public class ArrayListThread extends Thread {
	private Olympics olympics;
	private Random generator;
	private int method;
	private int type;
	private int num;
	private RaceScreenGUI gui;
	public ArrayListThread(Olympics oly,long seed,int method,int type,int num,RaceScreenGUI gui) {
		generator = new Random(seed);
		olympics=oly;
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
					olympics.addArrayList(generator.nextLong());
					i++;
				}
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						gui.setArrayListTime();	
						//gui.setArrayFinish(true);
					}
					
				});
			}else if(type==1) {
				while(i<num) {
					olympics.addArrayList(generator.nextLong());
					i++;
				}
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						gui.setArrayListTime();
						//gui.setArrayFinish(true);
					}
					
				});
			}
			break;
		case 1:
			if(type==0) {
				while(i<num) {
					
					olympics.deleteArrayList(generator.nextLong());
					i++;
				}
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						gui.setArrayListTime();
						//gui.setArrayFinish(true);
					}
					
				});
			}else if(type==1) {
				while(i<num) {
					
					olympics.deleteArrayListRecursive(generator.nextLong(), 0);
					i++;
				}
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						gui.setArrayListTime();
						//gui.setArrayFinish(true);
					}
					
				});
			}
			break;
		case 2:
			if(type==0) {
				while(i<num) {
					olympics.searchArrayList(generator.nextLong());
					i++;
				}
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						gui.setArrayListTime();
						//gui.setArrayFinish(true);
					}
					
				});
			}else if(type==1) {
				while(i<num) {
					olympics.searchArrayListRecursive(generator.nextLong(), 0);
					i++;
				}
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						gui.setArrayListTime();
						//gui.setArrayFinish(true);
					}
					
				});
			}
		}

	}
	
	
}
