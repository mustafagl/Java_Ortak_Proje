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
										   //M�zik i�in throws metodu.
		
		Scanner scanner = new Scanner(System.in);
		
		File music=new File("music/Frozen_in_Love__Aakash_Gandhi.wav");
		AudioInputStream audioStream=AudioSystem.getAudioInputStream(music);
		Clip clip=AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();														//M�zik ba�lat
		clip.loop(1);														//M�zik D�ng� A��k
		
		long start = System.currentTimeMillis();
		Customer.musterigelmeorani();

		Restaurant.init_malzemeler();
		
		Grafik bs = new Grafik();
		bs.image_oku();
		Color mycolor = new Color(111, 90, 85);								//Arkaplan rengi
		bs.setBackground(mycolor);										
		JFrame jf = new JFrame("Restoran Oyunu");							//Pencere �smi
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);						//Pencereyi kapatmak program�n sonland�rmas�n� sa�lar.
		jf.setSize(1200, 638);												//Pencere B�y�kl���
		jf.setVisible(true);												//G�r�n�rl�k
		jf.setResizable(false);												//Yeniden Boyutland�rma
		jf.add(bs);
		jf.setLocationRelativeTo(null);										//Ekranda pencere ortalama
		
		ImageIcon image = new ImageIcon("image/restaurant_app_icon.png");	//Pencere ikonu
		jf.setIconImage(image.getImage());

		bs.employeeSuggestion.removeAll(bs.employeeSuggestion);
		Staff temp= new Staff(2);											//�al��an Say�s�
		bs.employeeSuggestion.add(temp);
		
		Staff temp0= new Staff(2);
		temp0.Yetenek="tost";
		temp0.Maas=0;
		temp0.Seviye=5;
		bs.employees.add(temp0);
		Restaurant.init_yemekler(bs.employees);
		
		String response = "";
		
		while(!response.equals("Q")) {
			System.out.println("P = M�zik Oynat, S = M�zik Durdur, R = M�zi�i Yeniden Ba�lat");
			System.out.print("Ne yapmak istersin? ");
			
			response = scanner.next();
			response = response.toUpperCase();								//B�y�k harf uygula
			
			switch(response) {
				case ("P"): clip.start();
							clip.loop(1);
				break;
				case ("S"): clip.stop();
				break;
				case ("R"): clip.setMicrosecondPosition(0);					//M�zi�i yeniden ba�latma
				break;
				default: System.out.println("Ge�erli bir cevap veriniz.");
			}
		 }
	}

}
