package planetest;

public class PlaneTest {
	public static void main(String[] args) {
		Airplane air = new Airplane("L747",1000);
		Cargoplane car = new Cargoplane("C40",1000);
		
		System.out.println("plane          fuelSize");
		System.out.println("=======================");
		System.out.println(air.getPlaneName() + "           " + air.getFuelSize());
		System.out.println(car.getPlaneName() + "            " + car.getFuelSize());
		System.out.println();
		System.out.println("100운항");
		System.out.println("plane          fuelSize");
		System.out.println("=======================");
		System.out.print(air.getPlaneName() + "            ");
		air.flight(100);
		System.out.print(car.getPlaneName() + "             ");
		car.flight(100);
		System.out.println();
		System.out.println("200주유");
		System.out.println("plane          fuelSize");
		System.out.println("=======================");
		System.out.print(air.getPlaneName() + "            ");
		air.refuel(200);
		System.out.print(car.getPlaneName() + "             ");
		car.refuel(200); 
		
	}
}
