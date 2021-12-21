import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    MyFrame() {
        JLabel label = new JLabel();
        this.add(label);
        this.setTitle("Restoran Oyunu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1264,720); // Ekranýn boyutu
        this.setLocation(5,5);//Ekranýn ortsýnda gözükmesi için
        this.setVisible(true);

        ImageIcon background = new ImageIcon("src/abackground_new.jpg"); //Arka plan fotoðrafý
        ImageIcon icon =new ImageIcon("src/dark.PNG"); //Ýkon
        this.setIconImage(icon.getImage());
        label.setIcon(background);


        label.setHorizontalAlignment(JLabel.CENTER);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setIconTextGap(1000);

    }
}