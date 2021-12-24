import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Main {
	static long start;

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Customer.musterigelmeorani();

		Restaurant.init_malzemeler();
		Restaurant.init_yemekler();
		
		Grafik bs = new Grafik();
		bs.image_oku();
		Color mycolor = new Color(111, 90, 85);
		bs.setBackground(mycolor);
		JFrame jf = new JFrame("Restoran Oyunu");
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);					//Pencereyi kapatmak programın sonlandırmasını sağlar.
		jf.setSize(1200, 638);
		jf.setVisible(true);											//Görünürlük
		jf.setResizable(false);											//Yeniden Boyutlandırma
		jf.add(bs);

		Staff temp = new Staff(2);
		bs.employeeSuggestion.add(temp);
		while (true) {
			long second = System.currentTimeMillis() - start;
			//System.out.println(second / 1000);
			if (second / 1000 > 100) {
				if (Restaurant.saat < 24) {

					Restaurant.saat += 1;
					 start = System.currentTimeMillis();

				} else {
					if((int)Restaurant.yildiz==2) {
						System.out.println("asdasdasklkas");
						bs.employeeSuggestion.removeAll(bs.employeeSuggestion);
						Staff temp0 = new Staff(2);
						bs.employeeSuggestion.add(temp0);
					}
					
					
					Restaurant.saat = 1;
				}

				Customer.musterigelmeorani();

				bs.delete_menu(bs.yanpanel);
				
				bs.screate();
				
				// System.out.println(Customer.customer_per_hour);

			}
		}
	}

}
