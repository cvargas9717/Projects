
public class Motorcycle extends Vehicle {

	private boolean hasSaddleBags;
	private boolean hasWindshield;
	private String name;
	
	
	public Motorcycle(){ //default constructor
		super();//call the parent constructor
		this.hasSaddleBags = true;
		this.hasWindshield = true;
		this.name = "Harley";
		
	}
	
	
	public Motorcycle(boolean hasSaddleBags,boolean hasWindshield,String name){ //overloaded constructor
		super(name);
		this.hasSaddleBags = hasSaddleBags;
		this.hasWindshield = hasWindshield;
		this.name= name;
		
	}
	
	
	//getters
	public boolean getHasSaddleBags(){
		return hasSaddleBags; 
	}
	
	public String getName() {
		return name;
	}
	
	
	public boolean getHasWindshield(){
		return hasWindshield;
	}
	
	//setters
	public void setHasSaddleBags(boolean hasSaddleBags){
		this.hasSaddleBags = hasSaddleBags;
	}
	public void setHasWindshield(boolean hasWindshield){
		this.hasWindshield = hasWindshield;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString(){
		String r = super.toString();//uses the toString from the parent class
		if(this.hasSaddleBags){ //this.hasWindshield){//true
			r += " Has a Saddle Bag"+"//";
			
		}
		else{//false
			r += " Does NOT have a Saddle Bag"+"//";
		}
		if(this.hasWindshield){
			r += " Has Windshield";
		}
		else{
			r += " Does NOT have a Windshield";
		}
		return r;
	}
	
	
	
	public boolean equals(Object o){
		if(o instanceof Motorcycle){
			if(super.equals(o)){//use the parent class equals.. Person equals to check before doing more work
				Motorcycle otherH = (Motorcycle)o;
				Motorcycle otherF = (Motorcycle)o;
				if(this.hasSaddleBags== otherH.hasSaddleBags){
					if(this.name.equalsIgnoreCase(otherH.name)){
						return true;
					}
					
				}
				if(this.hasWindshield == otherF.hasWindshield){
					return true;
				}
			
			
			}
				
		}
	
	return false;//not an instance

	}
	@Override
	public String zoom(){
		return " I can pop a wheelie";
	}
	




}
