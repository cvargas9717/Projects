
public class Tester {
	
	public static void main(String[]args){
		
		
		Vehicle v = new Vehicle("AverageCar");
		Vehicle v2 = new Vehicle("AverageCar");
		Vehicle v3 = new Vehicle("AverageCar");		
		Vehicle v4 = new Vehicle("AverageCar");
		Vehicle v5 = new Vehicle("AverageCar");
		
		Car boring = new Car();
		Car boring2 = new Car(4,"Toyota");
		Car boring3 = new Car(4,"Subaru");
		Car boring4 = new Car(4,"Volkswagen");
		Car boring5 = new Car(4,"Volvo");
		
		Motorcycle Harley = new Motorcycle(true,true,"Harley");
		Motorcycle Kawasaki = new Motorcycle(false,true,"Kawasaki");
		Motorcycle Yamaha = new Motorcycle(false,true,"Yamaha");
		Motorcycle Ducati = new Motorcycle(false,true,"Ducati");
		Motorcycle Suzuki = new Motorcycle(false,true,"Suzuki");
		
		FastCar Lamborghini= new FastCar(true,2,"Lamborghini");
		FastCar Ferrari= new FastCar(false,2,"Ferrari");
		FastCar AstonMartin= new FastCar(false,2,"AstonMartin");
		FastCar Pagani = new FastCar(true,2,"Pagani");
		FastCar MclarenP1= new FastCar(true,2,"McLaren P1");
		
		Vehicle[]Vehicles = {v,v2,v3,v4,v5};
		Car [] Cars = {boring,boring2,boring3,boring4,boring5};
		Motorcycle[] Motorcycles = {Harley,Kawasaki,Yamaha,Ducati,Suzuki};
		FastCar[] FastCars = {Lamborghini,Ferrari,AstonMartin,Pagani,MclarenP1};
		
		//setting values for Motorcycles
		Harley.setNumWheels(2);
		Kawasaki.setNumWheels(2);
		Yamaha.setNumWheels(2);
		Ducati.setNumWheels(2);
		Suzuki.setNumWheels(2);
		
		Harley.setSeatingCapacity(2);
		Kawasaki.setSeatingCapacity(2);
		Yamaha.setSeatingCapacity(2);
		Ducati.setSeatingCapacity(2);
		Suzuki.setSeatingCapacity(2);
		
		Harley.setMaxSpeed(100);
		Kawasaki.setMaxSpeed(165);
		Yamaha.setMaxSpeed(186);
		Ducati.setMaxSpeed(169);
		Suzuki.setMaxSpeed(248);
		
		//setting values for FastCars
		Lamborghini.setEngineLiterSize(3.5);
		Ferrari.setEngineLiterSize(3.9);
		AstonMartin.setEngineLiterSize(6.0);
		Pagani.setEngineLiterSize(6.0);
		MclarenP1.setEngineLiterSize(3.8);
		
		Lamborghini.setSeatingCapacity(2);
		Ferrari.setSeatingCapacity(2);
		AstonMartin.setSeatingCapacity(4);
		Pagani.setSeatingCapacity(2);
		MclarenP1.setSeatingCapacity(2);
		
		Lamborghini.setMaxSpeed(211);
		Ferrari.setMaxSpeed(199);
		AstonMartin.setMaxSpeed(183);
		Pagani.setMaxSpeed(198);
		MclarenP1.setMaxSpeed(225);
		
		System.out.println("STANDARD VEHICLE: ");
		
		//iteration through all Vehicles
		for(int i = 0;i<Vehicles.length-1;i++){
				
			System.out.println(Vehicles[i].toString()+ "\n\t EQUALS \n" + Vehicles[i+1].toString()+ "\n\t: "+ Vehicles[i].equals(Vehicles[i+1]) );
			
		}
		//zoom2();
		
		System.out.println();
		System.out.println("COMMON CARS: ");
		
		//iteration through all Cars
		for(int i = 0;i<Cars.length-1;i++){
					
		System.out.println(Cars[i].toString()+ "\n\t EQUALS \n" + Cars[i+1].toString()+ "\n\t: "+ Cars[i].equals(Cars[i+1]) );
		}
		//zoom2();
		
		System.out.println();
		System.out.println("COMMON MOTORCYCLES: ");
		
		//iteration through all Motorcycles
		for(int i = 0;i<Motorcycles.length-1;i++){
						
		System.out.println(Motorcycles[i].toString()+ "\n\t EQUALS \n" + Motorcycles[i+1].toString()+ "\n\t: "+ Motorcycles[i].equals(Motorcycles[i+1]) );
					
		}
		//zoom3();
		
		System.out.println();
		System.out.println("COMMON SPORTS CARS: ");
		
		//iteration through all FastCars
		for(int i = 0;i<FastCars.length-1;i++){
								
		System.out.println(FastCars[i].toString()+ "\n\t EQUALS \n" + FastCars[i+1].toString()+ "\n\t: "+ FastCars[i].equals(FastCars[i+1]) );
							
		}
		//zoom();
	}
	/*public static void zoom2(){
		System.out.println("Zoooom! I top out at 80 mph. I am a boring car");
	}
	public static void zoom3(){
		System.out.println("Zoooom! I top out at ~200 mph. I can also pop a wheelie");
	}
	public static void zoom(){
		System.out.println("Zoooom! I top out at ~200 mph. I am a sporty car");
	}
	*/

	



}
