
public class City {
	private double x;
	private double y;
	private int id;
	
	public City(int id, double x, double y) {
		this.id = id;
		this.x = x;
		this.y = y;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public double distanceTo(City city) {
		double xDistance = Math.abs(getX() - city.getX());
		double yDistance = Math.abs(getY() - city.getY());
		
		double distance = Math.sqrt(Math.abs((xDistance * xDistance) + (yDistance * yDistance)));
		return distance;
	}
	
	public String toString() {
		return this.x + "-" + this.y; 
	}
	
	
	
}
