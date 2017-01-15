
public class Car extends Vehicle {
	
	private boolean hasSunRoof;
	private int numDoors;
	private String manufacturerName;
	
	public Car(){//default constructor
		super();//call the parent constructor
		this.hasSunRoof = true;
		this.numDoors = 4;
		this.manufacturerName = "Honda";
	}
	public Car(int doors,String manufacturerName){ //overloaded constructor
		super(manufacturerName);
		hasSunRoof = true;
		numDoors = doors;
		
	}
	public Car(boolean hasSunRoof,int doors,String manufacturerName){
		super(manufacturerName);
		this.hasSunRoof = hasSunRoof;
		this.numDoors = doors;
		this.manufacturerName = manufacturerName;
	}
	
	
	
	//getters
	public boolean getHasSunRoof(){
		return hasSunRoof;
	}
	public int getNumDoors(){
		return numDoors;
	}
	public String getManufacturerName() {
		return manufacturerName;
	}
	//setters
	public void setHasSunRoof(boolean hasSunRoof){
		this.hasSunRoof = hasSunRoof;
	}
	public void setNumDoors(int doors){
		this.numDoors = doors;
	}
	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}
	public String toString(){
		String s = super.toString();//uses the toString from the parent class
		if(this.hasSunRoof){//true
			s += " Has a Sun Roof //";
			
		}
		else{//false
			s += " Does NOT have Sun Roof"+"//";
		}
		
		s += " Number of doors: " + this.numDoors+"//";
		return s;
	}
	
	public boolean equals(Object o){
		if(o instanceof Car){
			if(super.equals(o)){ //use the parent class equals.. Vehicle equals to check before doing more work
				Car otherH = (Car)o;
				if(this.hasSunRoof == otherH.hasSunRoof){
					 if(this.manufacturerName.equalsIgnoreCase(otherH.manufacturerName)){
						return false ;
					 
					 }
				}
			}
		
		return true;
		}
		return hasSunRoof;
		
	}


	@Override
	public String zoom(){
		
		return " I'm a boring car";
	}


}
