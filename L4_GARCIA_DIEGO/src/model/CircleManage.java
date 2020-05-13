package model;

import java.util.ArrayList;

public class CircleManage {
	private boolean movement;
	private ArrayList <Circle>circles;
	public CircleManage() {	
		circles = new ArrayList <Circle>();
	}
	public void addCircle(double  radius) {
		circles.add(new Circle(radius));
		
	}
	
	public void increaseCircle() {
		for(int i=0;i<circles.size();i++) {
			if(circles.get(i).getRadius()==Circle.MAX_RADIUS) {
				circles.get(i).setIncrease(false);
			}else if(circles.get(i).getRadius()==Circle.MIN_RADIUS) {
				circles.get(i).setIncrease(true);
				
			}
			circles.get(i).increaseRadius();
		}
	}
	public boolean getMovement() {
		return movement;
	}
	public void setMovement(boolean movement) {
		this.movement = movement;
	}
	public ArrayList<Circle> getCircles() {
		return circles;
	}
		
}
