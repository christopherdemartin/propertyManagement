import javax.swing.plaf.synth.SynthSpinnerUI;
import java.util.*;
import org.joda.time.*;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.*;

public class lease {
	/*
	 * start date
	 * end date
	 * isleaseUp
	 */
	DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
	DateTime startDate;
	DateTime endDate;
	
	
	DateTime findToday = new DateTime();
	LocalDate todayDate = findToday.toLocalDate();
	DateTime today = stringToDate(todayDate.toString("MM/dd/yyyy"));

	//System.out.println(today.plusDays(150));
	
	boolean isLeaseUp;
	
	@Override
	public String toString(){
	String leaseString = 	"Lease started on: " + this.startDate + 
							"\n Lease will end on " + this.endDate + 
							"\n Days left of lease: " + (Days.daysBetween(startDate.toLocalDate(), endDate.toLocalDate()).getDays());
		return leaseString;
	}
	
	public boolean isLeaseUp(){
		int daysLeft = Days.daysBetween(startDate.toLocalDate(), endDate.toLocalDate()).getDays();
		if (daysLeft <= 150){
			return true;
		}
		else
			return false;
	}
	
	//UTILITY FUNCTION TO CONVERT STRINGS INTO DATES
	public DateTime stringToDate(String dateString){
		//System.out.println("Please enter a date: mm/dd/yyyy");
		DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yyyy");
		DateTime dt = formatter.parseDateTime(dateString);
		return dt;
	}
	
	//CONSTRUCTOR
	public lease() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the lease starting date as MM/dd/yyyy:");
		this.startDate = stringToDate(scanner.next());
		System.out.println("Please enter the lease ending date as MM/dd/yyyy:");
		this.endDate = stringToDate(scanner.next());
		scanner.close();
	}
	
	public lease(String start, String end){
		this.startDate = stringToDate(start);
		this.endDate = stringToDate(end);
	}
	
	
}

