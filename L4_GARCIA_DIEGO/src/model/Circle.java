package model;

public class Circle {
	public static final double RADIUS_INCREASE= 1;
	public static final double MAX_RADIUS= 40;
	public static final double MIN_RADIUS= 10;
	private double radius;
	private boolean increase;
	public Circle(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}
	
	
	public boolean getIncrease() {
		return increase;
	}

	public void setIncrease(boolean increase) {
		this.increase = increase;
	}
	
	public void increaseRadius() {
		if(increase) {
			radius=radius+Circle.RADIUS_INCREASE;
		}else {
			radius=radius-Circle.RADIUS_INCREASE;
		}
	}
}
