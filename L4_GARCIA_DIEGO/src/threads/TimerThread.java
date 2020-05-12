package threads;

import model.Timer;
import ui.RaceScreenGUI;
import javafx.application.Platform;


public class TimerThread extends Thread {
	private RaceScreenGUI gui;
	private Timer timer;
	private String time;
	public TimerThread(RaceScreenGUI gui,Timer timer) {
		this.gui=gui;
		this.timer=timer;
	}
	
	@Override
	public void run() {
		while(timer.isRunTime()) {
			time=timer.advanceTime();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Platform.runLater(new Runnable() {
				@Override
				public void run() {	
					gui.setLabel(time);
				}
			});
		}
		
	}
	
}
