
public class tenant {
	/*
	 * bool screeDiscount
	 * bool dreeDiscount
	 * double preferentialDiscount
	 * bool sectionEightDiscount
	 * String name
	 * int/string telephone
	 * int/string alternateNumber
	 * String email
	 * int roommates
	 * String[] roommate
	 * double security
	 * double fee
	 * function pay(money)
	 */
	public String name;
	public unit apartment;
	public lease myLease;
	
	public tenant(String name, unit apartment){
		this.apartment = apartment;
		this.name = name;
	}
	
	public tenant(String name, unit apartment, String start, String end){
		this.apartment = apartment;
		this.name = name;
		this.myLease = new lease(start, end);
	}
}
