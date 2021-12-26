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
		clip.start();							//M�zik ba�lat
		clip.loop(1);							//M�zik D�ng� A��k
		
		long start = System.currentTimeMillis();
		Customer.musterigelmeorani();

		Restaurant.init_malzemeler();
		Restaurant.init_yemekler();
		
		Grafik bs = new Grafik();
		bs.image_oku();
		Color mycolor = new Color(111, 90, 85);
		bs.setBackground(mycolor);
		JFrame jf = new JFrame("Restoran Oyunu");
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);					//Pencereyi kapatmak program�n sonland�rmas�n� sa�lar.
		jf.setSize(1200, 638);
		jf.setVisible(true);											//G�r�n�rl�k
		jf.setResizable(false);											//Yeniden Boyutland�rma
		jf.add(bs);

		bs.employeeSuggestion.removeAll(bs.employeeSuggestion);
		Staff temp= new Staff((int)Restaurant.yildiz);
		bs.employeeSuggestion.add(temp);

	}

}
