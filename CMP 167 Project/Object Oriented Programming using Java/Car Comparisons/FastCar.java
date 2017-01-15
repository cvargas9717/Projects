
public class FastCar extends Car {
	
	private boolean hasSpoiler;
	private int numDoors;
	private String manufacturerName;
	
	public FastCar(){ //default constructor
		super(); //calls from parent class
		hasSpoiler = true;
		numDoors = 2;
		
	}
	public FastCar(boolean hasSpoiler,int numDoors,String manufacturerName){ //overloaded constructor
		super(hasSpoiler,numDoors,manufacturerName); //calls from parent class
		this.hasSpoiler = true;
		this.numDoors = 2;
		this.manufacturerName = "Lamborghini";
	}
	//getters
	public boolean getHasSpoiler() {
		return hasSpoiler;
	}
	public int getNumDoors() {
		return numDoors;
	}
	public String getManufacturerName(){
		return manufacturerName;
	}
	//setters
	public void setHasSpoiler(boolean hasSpoiler) {
		this.hasSpoiler = hasSpoiler;
	}
	
	public void setNumDoors(int numDoors) {
		this.numDoors = numDoors;
	}
	public void setManufacturerName(String manufacturerName){
		this.manufacturerName = manufacturerName;
	}
	public String toString(){
		String a = super.toString(); //uses the toString from parent class
		if(this.hasSpoiler){
			a += " Has a Spoiler";
		}
		else{//false
			a += " Does NOT have a spoiler";
		}
		//a += " Number of doors: " +this.numDoors;
		return a;
	}
	public boolean equals(Object o){
		if(o instanceof FastCar){
			if(super.equals(o)){//use the parent class equals.. Person equals to check before doing more work
				FastCar otherH = (FastCar)o;
				if(this.hasSpoiler == otherH.hasSpoiler){
					if(this.manufacturerName.equalsIgnoreCase(otherH.manufacturerName)){
						return true;
					}
					
				}
			}
				
		}
	
	return false;//not an instance

	}
	@Override
	public String zoom(){
		return " I'm a Fast Car";
	}




}
