package us.model;

public class Mine implements Comparable<Mine> {
	private int x;
	private int y;
	private int blastRadius;
	private boolean isExploted;
	private int power;

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getBlastRadius() {
		return blastRadius;
	}

	public void setBlastRadius(int blastRadius) {
		this.blastRadius = blastRadius;
	}

	public boolean isExploted() {
		return isExploted;
	}

	public void setExploted(boolean isExploted) {
		this.isExploted = isExploted;
	}

	/*
	 * Overriding this method to order and Arraylist<Mine> by BlastRadius value
	 */
	@Override
	public int compareTo(Mine m) {
		return Integer.compare(m.blastRadius, getBlastRadius());
	}

}
