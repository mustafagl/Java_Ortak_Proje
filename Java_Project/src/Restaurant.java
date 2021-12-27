import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Restaurant extends Grafik {

	static int para = 300, saat = 1, menugenisligi, nufus = 100, kira=300;
	static int[] kasar = { 20, 10 }, sucuk = { 20, 15 }, hamur = { 30, 5 };
	static String[] kasarli_tost = { "kasar", "hamur" }, 
					sucuklu_tost = { "sucuk", "hamur" },
					karisik_tost = { "kasar", "sucuk", "hamur" };
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
				yemekler.put("Ka�arl� Tost", kasarli_tost);
				yemekler.put("Sucuklu Tost", sucuklu_tost);
				yemekler.put("Kar���k Tost", karisik_tost);
			}
			if (calisanlar.get(i).Yetenek == "pizza") {
				yemekler.put("Ka�arl� Pizza", kasarli_tost);
				yemekler.put("Sucuklu Ka�arl� Pizza", sucuklu_tost);
			}			
		}

	}

}
