import org.joda.time.*;
import java.util.*;
public class test {

	public static void main(String[] args) {
		/*Get Today's Date
		DateTime now = new DateTime();
		LocalDate today = now.toLocalDate();
		*/		
		/*Send Email
		String emailTo = "tademartin@gmail.com";
		String body = "Today's date is: " + today;
		String subject = "Have a great day!";
		Email newEmail = new Email(emailTo, body, subject);
		newEmail.sendEmail();
		*/
		
		String emailTo = "vfihenderson@gmail.com";
		String body = "";
		String subject = "Information for an apartment building!";
		
		
		//first construct units, then construct a tenant with a unit
		ArrayList<unit> thirtyFourthStreet = new ArrayList<unit>();
		ArrayList<tenant> thirtyFourthStreetTenants = new ArrayList<tenant>();
		
		unit oneA = new unit("1 Bedroom", 1400, "1a");
		unit oneB = new unit("2 Bedroom", 2500, "1b");
		unit oneC = new unit("1 Bedroom", 1600, "1c");
		unit oneD = new unit("3 Bedroom", 3500, "1d");
		
		unit twoA = new unit("2 Bedroom", 2200, "2a");
		unit twoB = new unit("2 Bedroom", 2600, "2b");
		unit twoC = new unit("1 Bedroom", 1500, "2c");
		unit twoD = new unit("2 Bedroom", 1300, "2d");
		
		thirtyFourthStreet.add(oneA);
		thirtyFourthStreet.add(oneB);
		thirtyFourthStreet.add(oneC);
		thirtyFourthStreet.add(oneD);
		
		thirtyFourthStreet.add(twoA);
		thirtyFourthStreet.add(twoB);
		thirtyFourthStreet.add(twoC);
		thirtyFourthStreet.add(twoD);
		
		tenant josh = new tenant("Josh", oneA, "01/22/2017", "01/22/2018");
		tenant bob = new tenant("Bob", oneB, "01/22/2017", "01/22/2018");
		tenant tracy = new tenant("Tracy", oneC, "01/22/2017", "01/22/2018");
		tenant sam = new tenant("Sam", oneD, "01/22/2017", "01/22/2018");
		
		tenant samantha = new tenant("Samantha", twoA, "01/22/2017", "01/22/2018");
		tenant bruce = new tenant("Bruce", twoB, "01/22/2017", "01/22/2018");
		tenant rebecca = new tenant("Rebecca", twoC, "01/22/2017", "01/22/2018");
		tenant steve = new tenant("Steve", twoD, "01/22/2017", "01/22/2018");
		
		thirtyFourthStreetTenants.add(josh);
		thirtyFourthStreetTenants.add(bob);
		thirtyFourthStreetTenants.add(tracy);
		thirtyFourthStreetTenants.add(sam);
		thirtyFourthStreetTenants.add(samantha);
		thirtyFourthStreetTenants.add(bruce);
		thirtyFourthStreetTenants.add(rebecca);
		thirtyFourthStreetTenants.add(steve);
		/*
		System.out.println("Tracy, which apartment are you in?");
		System.out.println(tracy.apartment.id);
		System.out.println("How big is your unit?");
		System.out.println(tracy.apartment.size);
		System.out.println("What is your rent?");
		System.out.println(tracy.apartment.rent);
		*/
		
		body += "Tracy, which apartment are you in?\n";
		body += tracy.apartment.id + "\n";
		body += "How big is your unit?\n";
		body += tracy.apartment.size + "\n";
		body += "What is your rent?\n";
		body += tracy.apartment.rent + "\n";
		
		body += "Name everyone in my building and what they're paying.\n";
		for (tenant a : thirtyFourthStreetTenants){
		body += a.name + " " + a.apartment.id + " " + a.apartment.rent + "\n";
		}
		
		Email newEmail = new Email(emailTo, body, subject);
		newEmail.sendEmail();
	}
}
