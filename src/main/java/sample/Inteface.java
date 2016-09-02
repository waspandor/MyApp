package sample;
import java.util.Scanner;

public class Inteface {

	static Barbers barbers = new Barbers();

	public static void main(String[] args) throws Throwable {

		barbers.findLocalBarbers("n12qp");

		String s;
		Scanner in = new Scanner(System.in);

		System.out.println("");
		System.out.println("Please type in a selection:");
		s = in.nextLine();

		barbers.returnMoreInfo(s);

	}




}
