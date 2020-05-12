package model;

public class Timer {
	private Integer min = 0, seg = 0, mseg = 0;
	private String minutos = "", segundos = "", milesimas = "";
	private boolean runTime;
	public Timer() {
	}
	public String advanceTime() {
		mseg += 4;
		if (mseg == 1000) {
			mseg = 0;
			seg += 1;
			if (seg == 60) {
				seg = 0;
				min++;
			}
		}
		if (min < 10) {
			minutos = "0" + min;
		} else {
			minutos = min.toString();
		}
		if (seg < 10) {
			segundos = "0" + seg;
		} else {
			segundos = seg.toString();
		}
		if (mseg < 10) {
			milesimas = "00" + mseg;
		} else if (mseg < 100) {
			milesimas = "0" + mseg;
		} else {
			milesimas = mseg.toString();
		}
		return minutos+":"+segundos+":"+milesimas;
	}
	public String getMinutos() {
		return minutos;
	}
	public String getSegundos() {
		return segundos;
	}
	public String getMilesimas() {
		return milesimas;
	}
	public String getTime() {
		return minutos+":"+segundos+""+milesimas;
		
	}
	public boolean isRunTime() {
		return runTime;
	}
	public void setRunTime(boolean runTime) {
		this.runTime = runTime;
	}
	
	
	
	
}
