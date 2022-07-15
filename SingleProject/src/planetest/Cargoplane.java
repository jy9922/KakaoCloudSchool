package planetest;

public class Cargoplane extends Plane{
	public Cargoplane() {
		
	}
	public Cargoplane(String planeName, int fuelSize) {
		super(planeName, fuelSize);
	}
	
	public void flight(int distance) {
		System.out.println(super.getFuelSize() - (distance/10) * 50);
		super.setFuelSize(super.getFuelSize() - (distance/10) * 50);

	}
}
