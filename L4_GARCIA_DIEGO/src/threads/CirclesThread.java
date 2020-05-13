package threads;

import javafx.application.Platform;
import model.CircleManage;
import ui.RaceScreenGUI;

public class CirclesThread extends Thread {
	private RaceScreenGUI gui;
	private CircleManage circleManage;
	
	public CirclesThread(RaceScreenGUI gui, CircleManage circleManage) {
		this.gui = gui;
		this.circleManage = circleManage;
	}

	public void run() {
		while(circleManage.getMovement()) {
			gui.moveCircles();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					gui.updateCircles();
					if(!gui.getArrayThread().isAlive() && !gui.getTreeThread().isAlive() && !gui.getListThread().isAlive()) {
						circleManage.setMovement(false);
					}
				}
				
			});
		}
	}
}
