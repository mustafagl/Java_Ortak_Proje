import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.*;    
import javax.swing.*; 
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Grafik extends JPanel {

	JPanel yanpanel;

	int posx = -150;
	int posy = 100;
	BufferedImage img0 = null;
	BufferedImage img1 = null;
	BufferedImage img2 = null;
	boolean new_customer = true, oyunudurdur = false;;
	JFrame jf = null;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(img0, 0, 0, 1200, 600, null);
		// System.out.println(Customer.customer_per_hour);
		if (Customer.customer_per_hour >= 0 && new_customer == true) {
			Customer.customer_per_hour -= 1;
		}

		ciz_karakter(g);

		sleep(5);
		repaint();
	}

	void sleep(int sn) {
		try {
			Thread.sleep(sn);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	void image_oku() {
		this.setLayout(null);
		create_yanpanel();
		try {
			img0 = ImageIO.read(new File("src/background.jpeg"));
			img1 = ImageIO.read(new File("src/background.jpeg"));
			img2 = ImageIO.read(new File("src/man_back_1.png"));

		} catch (IOException e) {
			System.out.print("x");
		}

	}

	void ciz_karakter(Graphics g) {
		float scale = 1f;

		g.setColor(Color.white);
		g.fillRect((int) (posx * scale), (int) (posy * scale), (int) (100 * scale), (int) (100 * scale));
		g.setColor(Color.black);
		g.fillRect((int) ((30 + posx) * scale), (int) ((30 + posy) * scale), (int) (10 * scale), (int) (10 * scale));
		g.fillRect((int) ((70 + posx) * scale), (int) ((30 + posy) * scale), (int) (10 * scale), (int) (10 * scale));
		g.setColor(Color.red);
		g.fillRect((int) ((30 + posx) * scale), (int) ((70 + posy) * scale), (int) (50 * scale), (int) (10 * scale));
		g.setColor(Color.white);
		g.fillRect((int) ((40 + posx) * scale), (int) ((90 + posy) * scale), (int) (30 * scale), (int) (30 * scale));
		g.fillRect((int) ((-30 + posx) * scale), (int) ((120 + posy) * scale), (int) (160 * scale), (int) (20 * scale));
		g.fillRect((int) ((-30 + posx) * scale), (int) ((120 + posy) * scale), (int) (15 * scale), (int) (150 * scale));
		g.fillRect((int) ((115 + posx) * scale), (int) ((120 + posy) * scale), (int) (15 * scale), (int) (150 * scale));
		g.fillRect((int) ((-10 + posx) * scale), (int) ((120 + posy) * scale), (int) (120 * scale),
				(int) (150 * scale));
		g.fillRect((int) ((0 + posx) * scale), (int) ((270 + posy) * scale), (int) (30 * scale), (int) (100 * scale));
		g.fillRect((int) ((70 + posx) * scale), (int) ((270 + posy) * scale), (int) (30 * scale), (int) (100 * scale));

		g.drawImage(img1, posx + 100, posy, 200, 100, null);
		g.setColor(Color.black);
		String s = "Yemek";
		g.drawString(s, posx + 110, posy + 20);

		//
		g.setColor(Color.black);
		g.fillArc(400, 10, 400, 50, 0, 360);
		String x = "Restoran Oyunu";
		g.setColor(Color.white);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 32));
		g.drawString(x, 500, 45);
		Color c = new Color(171, 111, 21);
		g.setColor(c);
		g.fillRect(0, 400, 1200, 200);

		g.drawImage(img2, 600, 300, 200, 300, null);

		if (posx == 650 && oyunudurdur == false) {
			oyunudurdur = true;

			create_menu();


		}
		if (posx > 1200) {
			new_customer = true;

			posx -= 1300;

		} else {
			new_customer = false;

		}

		if (oyunudurdur == false) {
			if (Customer.customer_per_hour > 0)

				posx += 1;
		}
	}

	void create_menu() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5, 0));

		panel.setLocation(450, 100);

		panel.setSize(400, 300);
		panel.setBackground(Color.green);
	
		JLabel l1;
		l1 = new JLabel("Fiyat: ");
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 50, 25);  
		slider.setMinorTickSpacing(2);  
		slider.setMajorTickSpacing(10);  
		slider.setPaintTicks(true);  
		slider.setPaintLabels(true);  
		JPanel subpanel = new JPanel();
		subpanel.add(l1,BorderLayout.WEST);
		subpanel.add(slider,BorderLayout.EAST);
		panel.add(subpanel,BorderLayout.SOUTH);	
		
		
		Random r=new Random();

		JButton button;
		button= new JButton();
		button.setText("Tamamla");
		int c=r.nextInt(Restaurant.yemekler.size());
		int count=0;	
		for (Entry<String, String[]> me : Restaurant.yemekler.entrySet()) {
			if(c==count) {
				System.out.println(me.getKey());
				for(String i:me.getValue())
				{
					JLabel l1dn;
					l1dn = new JLabel(i+": ");
					JSlider sliderdn = new JSlider(JSlider.HORIZONTAL, 0, 15, 7);  
					sliderdn.setMinorTickSpacing(2);  
					sliderdn.setMajorTickSpacing(10);  
					sliderdn.setPaintTicks(true);  
					sliderdn.setPaintLabels(true);  
					JPanel subpaneldn = new JPanel();
					subpaneldn.add(l1dn,BorderLayout.WEST);
					subpaneldn.add(sliderdn,BorderLayout.EAST);
					panel.add(subpaneldn,BorderLayout.SOUTH);	
					
					button.addActionListener((ActionListener) new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
						Restaurant.para+=slider.getValue()/2;	
						Restaurant.malzemeler.get(i)[0]-=sliderdn.getValue();
						delete_menu(yanpanel);
						create_yanpanel();
						delete_menu(panel);
						oyunudurdur=false;
						posx+=1;

						}
					});
					
				}
					
				break;
			}	
			count++;
			
		}
		
		panel.add(button);

		

		this.add(panel);
		this.repaint();
		this.revalidate();
	}

	void delete_menu(JPanel p) {
		this.remove(p);
		this.repaint();
		this.revalidate();
	}

	void create_yanpanel() {

		yanpanel = new JPanel();
		yanpanel.setSize(120, 600);
		
		
		yanpanel.setLayout(new GridLayout(15, 0));

		yanpanel.setLocation(0, 0);

		yanpanel.setBackground(Color.white);

		JLabel l1, l2, l3, l4, l5, l6, l7;
		l1 = new JLabel("Para: " + Restaurant.para);
		l1.setBounds(10, 10, 80, 30);
		l2 = new JLabel("Saat: " + Restaurant.saat);
		l2.setBounds(10, 50, 80, 30);
		l3 = new JLabel("Yýldýz: " + Restaurant.yildiz);
		l3.setBounds(10, 90, 80, 30);
		
		l4 = new JLabel("Hamur: " + Restaurant.hamur[0]);
		l4.setBounds(10, 130, 80, 30);
		
		l5 = new JLabel("Kaþar: " + Restaurant.kasar[0]);
		l5.setBounds(10, 170, 80, 30);		

		l6 = new JLabel("Sucuk: " + Restaurant.sucuk[0]);
		l6.setBounds(210, 90, 80, 30);
		
		JButton button = new JButton();
		JButton button0 = new JButton();
		JButton button1 = new JButton();
		JButton button2 = new JButton();
		JButton button3 = new JButton();
		JButton button4 = new JButton();
		
		button.setText("Çalýþanlar");
		button.setBounds(10, 130, 80, 30);

		button0.setText("Ýþ ilanlarý");
		button0.setBounds(10, 250, 80, 30);

		button2.setText("Yemekler");
		button2.setBounds(10, 290, 80, 30);

		button2.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				create_yemekler_panel();

			}
		});		
		
		button3.setText("Malzemeler");
		button3.setBounds(10, 330, 80, 30);

		
		button4.setText("Saat Atla");
		button4.setBounds(10, 330, 80, 30);
		
		button4.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (Restaurant.saat < 24) {

					Restaurant.saat += 1;
					Main.start = System.currentTimeMillis();

				} else {
					Restaurant.saat = 0;
				}
			
				Customer.musterigelmeorani();
				System.out.println(Customer.customer_per_hour);
				delete_menu(yanpanel);
				create_yanpanel();


			}
		});

		button1.setText("Pause");
		button1.setBounds(10, 370, 80, 30);

		button1.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (oyunudurdur == false)
					oyunudurdur = true;
				else
					oyunudurdur = false;

			}
		});

		button3.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				create_malzemeler_panel();

			}
		});

		yanpanel.add(l1);
		yanpanel.add(l2);
		yanpanel.add(l3);
		yanpanel.add(l4);
		yanpanel.add(l5);
		yanpanel.add(l6);
		
		yanpanel.add(button);
		yanpanel.add(button0);
		yanpanel.add(button2);
		yanpanel.add(button3);
		yanpanel.add(button4);
		yanpanel.add(button1);

		this.add(yanpanel);

	}

	void create_malzemeler_panel() {
		JPanel panel_malzemeler = new JPanel();

		panel_malzemeler.setLayout(null);

		panel_malzemeler.setLocation(450, 100);

		panel_malzemeler.setSize(300, 300);
		panel_malzemeler.setBackground(Color.green);

		DefaultListModel<String> l1 = new DefaultListModel<>();
		DefaultListModel<String> l2 = new DefaultListModel<>();
		DefaultListModel<String> l3 = new DefaultListModel<>();

		for (Entry<String, int[]> me : Restaurant.malzemeler.entrySet()) {
			l1.addElement(me.getKey());
			l2.addElement(me.getValue()[0] + "");
			l3.addElement(me.getValue()[1] + "");

		}

		JButton cikisbtn = new JButton();

		cikisbtn.setText("X");
		cikisbtn.setBounds(250, 0, 50, 50);

		cikisbtn.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				delete_menu(panel_malzemeler);

			}
		});

		JList<String> list = new JList<>(l1);
		JList<String> list2 = new JList<>(l2);
		JList<String> list3 = new JList<>(l3);

		JButton button = new JButton();

		button.setText("+10");
		button.setBounds(100, 150, 100, 30);

		button.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedIndex() != -1) {
					Restaurant.malzemeler.get(list.getSelectedValue())[0] += 10;
					Restaurant.para -= Restaurant.malzemeler.get(list.getSelectedValue())[1];
					System.out.println(Restaurant.kasar[0]);
					System.out.println(Restaurant.para);
					delete_menu(yanpanel);
					create_yanpanel();
					System.out.println(list.getSelectedValue());
				}
			}
		});

		list3.setEnabled(false);
		list2.setEnabled(false);
		list.setBounds(25, 60, 50, 75);
		panel_malzemeler.add(list);
		list2.setBounds(125, 60, 50, 75);
		panel_malzemeler.add(list2);
		list3.setBounds(225, 60, 50, 75);
		panel_malzemeler.add(list3);
		panel_malzemeler.add(button);
		panel_malzemeler.add(cikisbtn);

		this.add(panel_malzemeler);
		this.repaint();
		this.revalidate();
	}
	
	void create_yemekler_panel() {
		JPanel panel = new JPanel();

		panel.setLayout(null);

		panel.setLocation(450, 100);

		panel.setSize(300, 300);
		panel.setBackground(Color.green);

		DefaultListModel<String> l1 = new DefaultListModel<>();


		for (Entry<String, String[]> me : Restaurant.yemekler.entrySet()) {
			l1.addElement(me.getKey());

		}


		JList<String> list = new JList<>(l1);

		list.setEnabled(false);
		list.setBounds(25, 25, 250, 250);
		
		panel.add(list);
	
		JButton cikisbtn = new JButton();

		cikisbtn.setText("X");
		cikisbtn.setBounds(250, 0, 50, 50);

		cikisbtn.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				
				delete_menu(panel);

			}
		});
		panel.add(cikisbtn);
		this.add(panel);
	}
	
}