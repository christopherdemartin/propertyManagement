public class unit {
	/*
	 * maintenance[]
	 * tenant[]
	 * size: studio, 1br, 2br...
	 * bool rentStabilized
	 * if legalRent < 2700 its rent stabilized
	 * appliance[]
	 * double legalRent
	 * complaints[]
	 */
	public String size;
	public double rent;
	public String id;
	
	public unit(String size, double rent, String id){
		this.size = size;
		this.rent = rent;
		this.id = id;
	}
}
