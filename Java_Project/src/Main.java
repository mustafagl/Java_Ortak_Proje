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
		Restaurant.init_yemekler();
		
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
		Staff temp= new Staff((int)Restaurant.yildiz);
		bs.employeeSuggestion.add(temp);

	}

}
