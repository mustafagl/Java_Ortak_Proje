import java.util.Random;

public class Customer {
	static int customer_per_hour;
	public static void musterigelmeorani() {
		Random r= new Random();
		customer_per_hour=(int) (Restaurant.yildiz*Restaurant.nufus*(r.nextInt(10)+1)/400.0f);
	}
	
}
