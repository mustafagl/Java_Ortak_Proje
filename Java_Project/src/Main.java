import java.awt.Color;
import java.io.IOException;
import java.io.File;
import javax.sound.sampled.*;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
										   //Müzik için throws metodu.
		
		Scanner scanner = new Scanner(System.in);
		
		File music=new File("music/Frozen_in_Love__Aakash_Gandhi.wav");
		AudioInputStream audioStream=AudioSystem.getAudioInputStream(music);
		Clip clip=AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();														//Müzik baþlat
		clip.loop(1);														//Müzik Döngü Açýk
		
		long start = System.currentTimeMillis();
		Customer.musterigelmeorani();

		Restaurant.init_malzemeler();
		
		Grafik bs = new Grafik();
		bs.image_oku();
		Color mycolor = new Color(111, 90, 85);								//Arkaplan rengi
		bs.setBackground(mycolor);										
		JFrame jf = new JFrame("Restoran Oyunu");							//Pencere Ýsmi
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);						//Pencereyi kapatmak programýn sonlandýrmasýný saðlar.
		jf.setSize(1200, 638);												//Pencere Büyüklüðü
		jf.setVisible(true);												//Görünürlük
		jf.setResizable(false);												//Yeniden Boyutlandýrma
		jf.add(bs);
		jf.setLocationRelativeTo(null);										//Ekranda pencere ortalama
		
		ImageIcon image = new ImageIcon("image/restaurant_app_icon.png");	//Pencere ikonu
		jf.setIconImage(image.getImage());

		bs.employeeSuggestion.removeAll(bs.employeeSuggestion);
		Staff temp= new Staff(2);											//Çalýþan Sayýsý
		bs.employeeSuggestion.add(temp);
		
		Staff temp0= new Staff(2);
		temp0.Yetenek="tost";
		temp0.Maas=0;
		temp0.Seviye=5;
		bs.employees.add(temp0);
		Restaurant.init_yemekler(bs.employees);
		
		String response = "";
		
		while(!response.equals("Q")) {
			System.out.println("P = Müzik Oynat, S = Müzik Durdur, R = Müziði Yeniden Baþlat");
			System.out.print("Ne yapmak istersin? ");
			
			response = scanner.next();
			response = response.toUpperCase();								//Büyük harf uygula
			
			switch(response) {
				case ("P"): clip.start();
							clip.loop(1);
				break;
				case ("S"): clip.stop();
				break;
				case ("R"): clip.setMicrosecondPosition(0);					//Müziði yeniden baþlatma
				break;
				default: System.out.println("Geçerli bir cevap veriniz.");
			}
		 }
	}

}
