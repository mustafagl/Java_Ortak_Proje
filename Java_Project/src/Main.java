import java.awt.Color;
import java.io.IOException;
import java.io.File;
import javax.sound.sampled.*;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel {

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		File music=new File("music/Frozen_in_Love__Aakash_Gandhi.wav");
		AudioInputStream audioStream=AudioSystem.getAudioInputStream(music);
		Clip clip=AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();							//Müzik baþlat
		clip.loop(1);							//Müzik Döngü Açýk
		
		long start = System.currentTimeMillis();
		Customer.musterigelmeorani();

		Restaurant.init_malzemeler();
		
		Grafik bs = new Grafik();
		bs.image_oku();
		Color mycolor = new Color(111, 90, 85);
		bs.setBackground(mycolor);
		JFrame jf = new JFrame("Restoran Oyunu");
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);					//Pencereyi kapatmak programýn sonlandýrmasýný saðlar.
		jf.setSize(1200, 638);
		jf.setVisible(true);											//Görünürlük
		jf.setResizable(false);											//Yeniden Boyutlandýrma
		jf.add(bs);


		bs.employeeSuggestion.removeAll(bs.employeeSuggestion);
		Staff temp= new Staff(2);
		bs.employeeSuggestion.add(temp);
		
		Staff temp0= new Staff(2);
		temp0.Yetenek="tost";
		temp0.Maas=0;
		temp0.Seviye=5;
		bs.employees.add(temp0);
		Restaurant.init_yemekler(bs.employees);
	}

}
