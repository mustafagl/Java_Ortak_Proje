import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Restaurant {

	static int para = 300, saat = 1, menugenisligi, nufus = 100;
	static int[] kasar = { 100, 10 }, sucuk = { 50, 15 }, hamur = { 150, 5 };
	static String[] kasarlitost= {"kasar","hamur"},sucuklutost={"sucuk","hamur"},karisiktost={"kasar","sucuk","hamur"};
	static float yildiz = 2.7f;
	int calisansayisi;

	static Map<String, int[]> malzemeler = new HashMap<String, int[]>();
	static Map<String, String[]> yemekler = new HashMap<String, String[]>();

	static void init_malzemeler() {

		malzemeler.put("kasar", kasar);
		malzemeler.put("sucuk", sucuk);
		malzemeler.put("hamur", hamur);



	}
	
	static void init_yemekler() {

		yemekler.put("kasarlitost", kasarlitost);
		yemekler.put("sucuklutost", sucuklutost);
		yemekler.put("karisiktost", karisiktost);

	

	}	
	

}
