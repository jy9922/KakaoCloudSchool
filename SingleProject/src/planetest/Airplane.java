package planetest;

public class Airplane extends Plane {
	
	public Airplane() {
		
	}
	public Airplane(String planeName, int fuelSize) {
		super(planeName, fuelSize);	
	}
	public void flight(int distance) {
		System.out.println(super.getFuelSize() - (distance/10) * 30);
		super.setFuelSize(super.getFuelSize() - (distance/10) * 30);
	}
	
}
