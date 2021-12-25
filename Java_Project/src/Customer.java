import java.util.Random;

public class Customer {
	static int customer_per_hour, positive = 50, negative = 50;

	public static void musterigelmeorani() {
		Random r = new Random();
		customer_per_hour = (int) (Restaurant.yildiz * Restaurant.nufus * (r.nextInt(10) + 1) / 400.0f);
	}

	public static double satisfaction() {

		return (double) positive / (positive + negative);
	}

	public static void memnuniyetHesap(int max, int value) {

		Random r = new Random();

		if (r.nextInt(max / 2) > value)
			negative += (max / 2) - value;
		else if (r.nextInt(max / 2) + max / 2 < value) {
			positive += value - (max / 2);
		}
//
	}


	

}
