import java.util.Random;

public class Staff {

	public int Maas, Seviye;
	String Ad, Yetenek;
	String [] allYetenek={"kasa","tost","pizza"};
	
	
	
	Staff(int Seviye){

		this.Seviye = Seviye;
		Random r = new Random();
		if (Seviye == 2) {
			Maas = r.nextInt(500) + 1000;
			Yetenek=allYetenek[r.nextInt(allYetenek.length)];
			if(Yetenek.equals("kasa")) {
				Ad="kasiyer";
			}
			else
				Ad="şef";
		}

		
	}

}




