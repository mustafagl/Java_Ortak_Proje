import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Restaurant {

	static int para = 300, saat = 1, menugenisligi, nufus = 100, kira=300;
	static int[] kasar = { 20, 10 }, sucuk = { 20, 15 }, hamur = { 30, 5 };
	static String[] kasarlitost = { "kasar", "hamur" }, sucuklutost = { "sucuk", "hamur" },
			karisiktost = { "kasar", "sucuk", "hamur" };
	static float yildiz = 2.7f;
	int calisansayisi;

	static Map<String, int[]> malzemeler = new HashMap<String, int[]>();
	static Map<String, String[]> yemekler = new HashMap<String, String[]>();

	static void init_malzemeler() {

		malzemeler.put("kasar", kasar);
		malzemeler.put("sucuk", sucuk);
		malzemeler.put("hamur", hamur);

	}

	static void init_yemekler(ArrayList<Staff> calisanlar) {

		for (int i = 0; i < calisanlar.size(); i++) {
			if (calisanlar.get(i).Yetenek == "tost") {
				yemekler.put("kasarlitost", kasarlitost);
				yemekler.put("sucuklutost", sucuklutost);
				yemekler.put("karisiktost", karisiktost);
			}
			if (calisanlar.get(i).Yetenek == "pizza") {
				yemekler.put("Ka�arl� Pizza", kasarlitost);
				yemekler.put("Sucuklu Ka�arl� Pizza", sucuklutost);
			}			
		}

	}

}
