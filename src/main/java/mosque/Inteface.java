package mosque;
import java.util.Scanner;

public class Inteface {

	static Barbers barbers = new Barbers();

	public static void main(String[] args) throws Throwable {

		String s;
		Scanner in = new Scanner(System.in);


		System.out.println("");
		System.out.println("Please enter your postcode:");
		s = in.nextLine();

		barbers.findLocalMosques(s);

		System.out.println("");
		System.out.println("Please type in a selection:");
		s = in.nextLine();

		barbers.returnMoreInfo(s);

		Mosque mosque = new Mosque(s);
		mosque.test();
		mosque.returnAll();

//		System.out.println(mosque.getFajr());
//		System.out.println(mosque.getZuhr());
//		System.out.println(mosque.getAsr());
//		System.out.println(mosque.getMaghrib());
//		System.out.println(mosque.getEsha());
	}




}
