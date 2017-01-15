
public class Vehicle {

	private String manufacturerName;
	private double engineLiterSize;
	private double maxSpeed;
	private int numWheels;
	private int seatingCapacity;

	
	public Vehicle(){//default constructor
		manufacturerName = "Honda";
		engineLiterSize = 2.4;
		maxSpeed = 80;
		numWheels = 4;
		seatingCapacity = 5;
		
	}
	
	public Vehicle(String manufacturerName){//overloaded constructor
		this.manufacturerName = manufacturerName;
		engineLiterSize = 2.4;
		maxSpeed = 80;
		numWheels = 4;
		seatingCapacity = 5;
	}
	
	public Vehicle(String manufacturerName,double engineLiterSize,double maxSpeed,int numWheels,int seatingCapacity){//overloaded constructor
		this.manufacturerName = manufacturerName;
		this.engineLiterSize = engineLiterSize;
		this.maxSpeed = maxSpeed;
		this.numWheels = numWheels;
		this.seatingCapacity = seatingCapacity;
	}
	
	//getters
	public String getManufacturerName(){
		return manufacturerName;
	}
	public double getEngineLiterSize(){
		return engineLiterSize;
	}
	public double getMaxSpeed(){
		return maxSpeed;
	}
	public int getNumWheels(){
		return numWheels;
	}
	
	public int getSeatingCapacity(){
		return seatingCapacity;
	}

	//setter
	public void setManufacturerName(String manufacturerName){
		this.manufacturerName = manufacturerName;
	}
	public void setEngineLiterSize(double engineLiterSize){
		this.engineLiterSize = engineLiterSize;
	}
	public void setMaxSpeed(double maxSpeed){
		this.maxSpeed = maxSpeed;
	}
	public void setNumWheels(int numWheels){
		this.numWheels = numWheels;
	}
	public void setSeatingCapacity(int seatingCapacity){
		this.seatingCapacity = seatingCapacity;
	}
	
	public String toString(){
		return "Manufacturer Name: " +this.manufacturerName +"//"+ " Engine Liter Size: "+ this.engineLiterSize +"//"+ " Max Speed: "+ this.maxSpeed +"//"+ " Number of Wheels: " + this.numWheels +"//"+ " Seating Capacity: "  +this.seatingCapacity +"//"+ zoom()+"//" ; 
		
	}
	public boolean equals(Object obj){
		if(obj instanceof Vehicle){
			Vehicle otherP = (Vehicle)obj;
				if((this.engineLiterSize == otherP.engineLiterSize) && (this.maxSpeed == otherP.maxSpeed)){
					if(this.manufacturerName.equalsIgnoreCase(otherP.manufacturerName) ){
						return true;
					}
				}
			}
			return false;
	
	}
	
	public String zoom(){
		
		return " Zoooom! I top out at "+maxSpeed + " mph";
		
	}

	

}

	