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
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Grafik extends JPanel implements ActionListener{
	
	static long start;

	ArrayList<Staff> employeeSuggestion  = new ArrayList<>();
	ArrayList<Staff> employees  = new ArrayList<>();

	
	JPanel yanpanel = null;
	JPanel panel_yemekler = null;
	JPanel panel_malzemeler = null;
	JPanel siparis_panel = null;
	JPanel basvurular_panel = null;
	JPanel calisanlar_panel = null;

	boolean siparisPanelVisibility=false;
	int posx = -150;
	int posy = 100;
	BufferedImage img0 = null;
	BufferedImage img1 = null;
	BufferedImage img2 = null;
	BufferedImage img3 = null;
	BufferedImage img4 = null;
	BufferedImage img5 = null;
	BufferedImage img6 = null;
	BufferedImage img8 = null;
	BufferedImage img7 = null;
	BufferedImage[] customersimg = new BufferedImage[6];

	
	int c=0;
	int musterifoto=0;
	boolean new_customer = true, oyunudurdur = false;;
	JFrame jf = null;


	public void paintComponent(Graphics g) {
		super.paintComponent(g);

			long second = System.currentTimeMillis() - start;
			if (second / 1000 > 15) {
				if (Restaurant.saat < 24) {

					Restaurant.saat += 1;
					 start = System.currentTimeMillis();

				} else {
					Restaurant.saat = 1;
					employeeSuggestion.removeAll(employeeSuggestion);
					Staff temp= new Staff((int)Restaurant.yildiz);
					employeeSuggestion.add(temp);
					Restaurant.para-=Restaurant.kira;
				}

				Customer.musterigelmeorani();

				delete_menu(yanpanel);
				
				screate();
				

			}
				
		
		g.drawImage(img0, 150, -100, 1240, 800, null);
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
			//e.printStackTrace();
		}
	}

	void image_oku() {
		panel_yemekler = new JPanel();
		panel_malzemeler = new JPanel();
		siparis_panel = new JPanel();
		basvurular_panel = new JPanel();
		calisanlar_panel = new JPanel();
		
		this.setLayout(null);
		create_yanpanel();
		try {
			img0 = ImageIO.read(new File("image/background.jpg"));   //Arka plan
			img1 = ImageIO.read(new File("image/table.png")); //Masa
			img2 = ImageIO.read(new File("image/cashier.png")); //Kasiyer
			img3 = ImageIO.read(new File("image/cash_register.png")); //Kasa
			
			img4 = ImageIO.read(new File("image/kasarli_tost.png"));//Tost1
			img5 = ImageIO.read(new File("image/sucuklu_tost.png"));//Tost2
			img6 = ImageIO.read(new File("image/karisik_tost.png"));//Tost3
			
			img7 = ImageIO.read(new File("image/game_over.png"));
			
			customersimg[0] = ImageIO.read(new File("image/customer_man0.png")); //Müşteri
			customersimg[1] = ImageIO.read(new File("image/customer_man1.png")); //Müşteri
			customersimg[2] = ImageIO.read(new File("image/customer_man2.png"));//Müşteri
			customersimg[3] = ImageIO.read(new File("image/customer_muslim_woman.png"));//Müşteri
			customersimg[4] = ImageIO.read(new File("image/customer_old_woman.png"));//Müşteri
			customersimg[5] = ImageIO.read(new File("image/customer_woman.png"));//Müşteri
	

		} catch (IOException e) {
			//System.out.print("x");
		}

	}

	void ciz_karakter(Graphics g) {

		g.drawImage(customersimg[musterifoto], posx-30, posy, 140, 495, null);
		
		if(c==0) {
			img8=img5;
		}
		if(c==1) {
			img8=img6;
		}
		if(c==2) {
			img8=img4;
		}
		
		g.drawImage(img8, posx + 100, posy - 100, 199, 166, null);
		g.drawImage(img1, -75, 400, 1484, 255, null);
		g.drawImage(img2, 520, 250, 264, 725, null);
		g.drawImage(img3, 800, 300, 176, 195, null);
		if(Restaurant.para==0||Restaurant.para<0) {
			g.drawImage(img7, 250, 100, 880, 344, null);
			oyunudurdur=true;
		}
		// Son eklenen önceki eklenen fotoğrafların üstüne çıkar.
		

		if (posx == 550 && oyunudurdur == false) {
			oyunudurdur = true;
			if(siparisPanelVisibility==false)
			create_siparis_panel();
			
		}
		if (posx > 1200) {
			new_customer = true;
			Random r = new Random();
			c = r.nextInt(Restaurant.yemekler.size());
			musterifoto= r.nextInt(customersimg.length);
			posx -= 1300;

		} else {
			new_customer = false;

		}

		if (oyunudurdur == false) {
			if (Customer.customer_per_hour >= 0)

				posx += 5;
		}
	}

void create_siparis_panel() {
		delete_menu(basvurular_panel);
		delete_menu(calisanlar_panel);
		delete_menu(panel_yemekler);
		delete_menu(panel_malzemeler);
		siparisPanelVisibility = true;
		siparis_panel = new JPanel();

		siparis_panel.setLayout(new GridLayout(10, 0));

		siparis_panel.setLocation(450, 100);

		siparis_panel.setSize(400, 500);
		siparis_panel.setBackground(new Color(0, 0, 0, 0));

		JLabel l1;
		l1 = new JLabel("Fiyat: ");
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 50, 25);
		slider.setMinorTickSpacing(2);
		slider.setMajorTickSpacing(10);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		JPanel subpanel = new JPanel();
		subpanel.add(l1, BorderLayout.WEST);
		subpanel.add(slider, BorderLayout.EAST);

		Random r = new Random();

		JButton button;
		button = new JButton();
		button.setText("Tamamla");
		int count = 0;

		for (Entry<String, String[]> me : Restaurant.yemekler.entrySet()) {
			if (c == count) {

				JLabel l;
				l = new JLabel(me.getKey(), SwingConstants.CENTER);
				l.setOpaque(true);
				siparis_panel.add(l);
				siparis_panel.add(subpanel, BorderLayout.SOUTH);

				for (String i : me.getValue()) {
					JLabel l1dn;
					l1dn = new JLabel(i + ": ");
					JSlider sliderdn = new JSlider(JSlider.HORIZONTAL, 0, 16, 8);
					sliderdn.setMinorTickSpacing(1);
					sliderdn.setMajorTickSpacing(4);
					sliderdn.setPaintTicks(true);
					sliderdn.setPaintLabels(true);
					JPanel subpaneldn = new JPanel();
					subpaneldn.add(l1dn, BorderLayout.WEST);
					subpaneldn.add(sliderdn, BorderLayout.EAST);
					siparis_panel.add(subpaneldn, BorderLayout.SOUTH);

					button.addActionListener((ActionListener) new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							siparisPanelVisibility = false;
							if (Restaurant.malzemeler.get(i)[0] >= sliderdn.getValue()) {
								Restaurant.malzemeler.get(i)[0] -= sliderdn.getValue();

								Customer.memnuniyetHesap(sliderdn.getMaximum(), sliderdn.getValue());

								//System.out.println();

								Customer.negative++;
								//System.out.println(Customer.satisfaction());
							} else {
								Restaurant.malzemeler.get(i)[0] = 0;
								Customer.negative+=10;
							}
							oyunudurdur = false;
							posx += 5;
							delete_menu(yanpanel);
							create_yanpanel();

						}
					});

				}

				break;
			}
			count++;

		}

		button.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random r = new Random();

				if (r.nextInt(slider.getMaximum() / 2)+(slider.getMaximum() / 2) > slider.getValue())
					Restaurant.para += slider.getValue();
				delete_menu(yanpanel);
				create_yanpanel();

				delete_menu(siparis_panel);

			}
		});

		siparis_panel.add(button);

		this.add(siparis_panel);
	}
	void delete_menu(JPanel p) {
		this.remove(p);
		this.repaint();
		this.revalidate();
	}

	void create_yanpanel() {

		yanpanel = new JPanel();
		yanpanel.setSize(210, 600);

		yanpanel.setLayout(new GridLayout(16, 0, 0, 2));

		yanpanel.setLocation(0, 0);

		yanpanel.setBackground(new Color(100, 20, 50, 254));

		JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
		l1 = new JLabel("  Para: " + Restaurant.para, SwingConstants.CENTER);
		l1.setForeground(Color.white);
		
		l2 = new JLabel("  Saat: " + Restaurant.saat, SwingConstants.CENTER);
		l2.setForeground(Color.white);
		float tempyildiz=0;
		for(Staff c :employees) {
			tempyildiz+=(float)(c.Seviye*Customer.satisfaction());
		}
		tempyildiz=Math.min(tempyildiz, 5);
		Restaurant.yildiz=tempyildiz;
		
		l3 = new JLabel("  Yıldız: " + Restaurant.yildiz, SwingConstants.CENTER);
		l3.setForeground(Color.white);

		l4 = new JLabel("  Hamur: " + Restaurant.hamur[0], SwingConstants.CENTER);
		l4.setForeground(Color.white);

		l5 = new JLabel("  Kaşar: " + Restaurant.kasar[0], SwingConstants.CENTER);
		l5.setForeground(Color.white);

		l6 = new JLabel("  Sucuk: " + Restaurant.sucuk[0], SwingConstants.CENTER);
		l6.setForeground(Color.white);

		l7 = new JLabel("  Sıradaki Müşteri: " + Customer.customer_per_hour, SwingConstants.CENTER);
		l7.setForeground(Color.white);

		l8 = new JLabel("  Memnuniyeti: " + Customer.satisfaction(), SwingConstants.CENTER);
		l8.setForeground(Color.white);

		l9 = new JLabel("  Kira: " + Restaurant.kira, SwingConstants.CENTER);
		l9.setForeground(Color.white);
		
		l10 = new JLabel(" Müzik konsoldan kapatıp açılabilir.", SwingConstants.CENTER);
		l10.setForeground(Color.white);
		l10.setFont(new Font("Calibri", Font.ITALIC, 13));
		
		JButton button = new JButton();
		JButton button0 = new JButton();
		JButton button1 = new JButton();
		JButton button2 = new JButton();
		JButton button3 = new JButton();
		JButton button4 = new JButton();

		button.setBackground(new Color(69, 17, 17, 200));
		button.setForeground(Color.white);

		button.setText("Çalışanlar");
		button.setBounds(10, 130, 80, 30);

		button.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (siparisPanelVisibility == false) {
					delete_menu(panel_yemekler);
					delete_menu(panel_malzemeler);
					delete_menu(basvurular_panel);
					delete_menu(calisanlar_panel);

					create_calisanlar_panel();
				}
			}
		});

		button0.setText("İş Başvuruları");
		button0.setBackground(new Color(69, 17, 17, 200));
		button0.setForeground(Color.white);
		button0.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (siparisPanelVisibility == false) {
					delete_menu(panel_yemekler);
					delete_menu(panel_malzemeler);
					delete_menu(basvurular_panel);
					delete_menu(calisanlar_panel);

					create_is_basvurulari_panel();
				}
			}
		});

		button1.setText("Yemekler");
		button1.setBackground(new Color(69, 17, 17, 200));
		button1.setForeground(Color.white);
		button1.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (siparisPanelVisibility == false) {
					delete_menu(panel_yemekler);
					delete_menu(panel_malzemeler);
					delete_menu(basvurular_panel);
					delete_menu(calisanlar_panel);

					create_yemekler_panel();
				}
			}
		});

		button2.setText("Malzemeler");
		button2.setBackground(new Color(69, 17, 17, 200));
		button2.setForeground(Color.white);
		button2.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (siparisPanelVisibility == false) {
					delete_menu(panel_yemekler);
					delete_menu(panel_malzemeler);
					delete_menu(basvurular_panel);
					delete_menu(calisanlar_panel);

					create_malzemeler_panel();

				}

			}
		});

		button3.setText("Saat Atla");
		button3.setBackground(new Color(69, 17, 17, 200));
		button3.setForeground(Color.white);
		button3.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (Restaurant.saat < 24) {

					Restaurant.saat += 1;
					start = System.currentTimeMillis();

				} else {
					Restaurant.para-=Restaurant.kira;
					Restaurant.saat = 0;
				}

				Customer.musterigelmeorani();
				delete_menu(yanpanel);
				create_yanpanel();
			}
		});

		button4.setText("Oyunu Durdur");
		button4.setBackground(new Color(69, 17, 17, 200));
		button4.setForeground(Color.white);
		button4.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (oyunudurdur == false)
					oyunudurdur = true;
				else
					oyunudurdur = false;

			}
		});
		 
		yanpanel.add(l1);
		yanpanel.add(l2);
		yanpanel.add(l3);
		yanpanel.add(l4);
		yanpanel.add(l5);
		yanpanel.add(l6);
		yanpanel.add(l7);
		yanpanel.add(l8);
		yanpanel.add(l9);
		yanpanel.add(l10);

		yanpanel.add(button);
		yanpanel.add(button0);
		yanpanel.add(button1);
		yanpanel.add(button2);
		yanpanel.add(button3);
		yanpanel.add(button4);

		this.add(yanpanel);

	}

	void create_malzemeler_panel() {
		panel_malzemeler = new JPanel();
		panel_malzemeler.setLayout(null);

		panel_malzemeler.setLocation(450, 100);

		panel_malzemeler.setSize(300, 300);
		panel_malzemeler.setBackground(new Color(222, 222, 222, 200));

		DefaultListModel<String> l1 = new DefaultListModel<>();
		DefaultListModel<String> l2 = new DefaultListModel<>();
		DefaultListModel<String> l3 = new DefaultListModel<>();

		for (Entry<String, int[]> me : Restaurant.malzemeler.entrySet()) {
			l1.addElement(me.getKey());
			l2.addElement(me.getValue()[0] + "");
			l3.addElement(me.getValue()[1] + "");

		}

		ImageIcon close=new ImageIcon("image/close.png");
		JButton cikisbtn = new JButton();

		cikisbtn.setBackground(Color.white);
		cikisbtn.addActionListener(this);
		cikisbtn.setBounds(275, 0, 25, 25);
		cikisbtn.setMargin(new Insets(0, 0, 0, 0));
		cikisbtn.setFocusable(false);
		cikisbtn.setIcon(close);

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
		button.setBounds(100, 200, 100, 30);
		button.setBackground(new Color(69, 17, 17, 200));
		button.setForeground(Color.white);
		button.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedIndex() != -1) {
					Restaurant.malzemeler.get(list.getSelectedValue())[0] += 10;
					Restaurant.para -= Restaurant.malzemeler.get(list.getSelectedValue())[1];
					//System.out.println(Restaurant.kasar[0]);
					//System.out.println(Restaurant.para);
					delete_menu(yanpanel);
					create_yanpanel();
					//System.out.println(list.getSelectedValue());
					delete_menu(panel_malzemeler);
					create_malzemeler_panel();

				}
			}
		});
		list.setBackground(new Color(0, 0, 0, 200));
		list2.setBackground(new Color(0, 0, 0, 200));
		list3.setBackground(new Color(0, 0, 0, 200));
		list.setForeground(Color.white);
		list2.setForeground(Color.white);
		list3.setForeground(Color.white);

		list3.setEnabled(false);
		list2.setEnabled(false);
		list.setBounds(25, 60, 50, 100);
		panel_malzemeler.add(list);
		list2.setBounds(125, 60, 50, 100);
		panel_malzemeler.add(list2);
		list3.setBounds(225, 60, 50, 100);
		panel_malzemeler.add(list3);
		panel_malzemeler.add(button);
		panel_malzemeler.add(cikisbtn);

		this.add(panel_malzemeler);
		this.repaint();
		this.revalidate();
	}	
	void screate() {
		create_yanpanel();
	}


	void create_yemekler_panel() {

		Restaurant.init_yemekler(employees);

		panel_yemekler = new JPanel();

		panel_yemekler.setLayout(null);

		panel_yemekler.setLocation(450, 100);

		panel_yemekler.setSize(300, 300);

		panel_yemekler.setBackground(new Color(222, 222, 222, 200));

		DefaultListModel<String> l1 = new DefaultListModel<>();

		for (Entry<String, String[]> me : Restaurant.yemekler.entrySet()) {

			l1.addElement(me.getKey());

		}

		JList<String> list = new JList<>(l1);
		list.setBackground(new Color(0, 0, 0, 200));

		list.setEnabled(false);
		list.setBounds(25, 25, 240, 250);
		
		ImageIcon close=new ImageIcon("image/close.png");

		JButton cikisbtn = new JButton();

		cikisbtn.setBackground(Color.white);
		cikisbtn.addActionListener(this);
		cikisbtn.setBounds(275, 0, 25, 25);
		cikisbtn.setMargin(new Insets(0, 0, 0, 0));
		cikisbtn.setFocusable(false);
		cikisbtn.setIcon(close);
		
		cikisbtn.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				delete_menu(panel_yemekler);

			}
		});
		panel_yemekler.add(cikisbtn);

		panel_yemekler.add(list);

		this.add(panel_yemekler);
	}


	void create_is_basvurulari_panel() {

		basvurular_panel = new JPanel();

		basvurular_panel.setLayout(null);

		basvurular_panel.setLocation(450, 100);

		basvurular_panel.setSize(300, 300);

		basvurular_panel.setBackground(new Color(222, 222, 222, 200));

		DefaultListModel<String> l1 = new DefaultListModel<>();

		for (Staff s : employeeSuggestion) {
			l1.addElement("Ad: " + s.Ad + " Yetenek: " + s.Yetenek + " Maaş:" + s.Maas + " Seviye:" + s.Seviye);

		}

		JList<String> list = new JList<>(l1);
		list.setBackground(new Color(0, 0, 0, 200));
		list.setForeground(Color.white);
		list.setBounds(15, 25, 270, 250);

		JButton button = new JButton();

		button.setText("İşe al");
		button.setBounds(100, 200, 100, 30);
		button.setBackground(new Color(69, 17, 17, 200));
		button.setForeground(Color.white);
		button.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedIndex() != -1) {

					employees.add(employeeSuggestion.get(list.getSelectedIndex()));
					employeeSuggestion.remove(list.getSelectedIndex());
					delete_menu(basvurular_panel);
					create_is_basvurulari_panel();

					delete_menu(yanpanel);
					create_yanpanel();


				}
			}
		});
		
		ImageIcon close=new ImageIcon("image/close.png");

		JButton cikisbtn = new JButton();
		
		cikisbtn.setBackground(Color.white);
		cikisbtn.addActionListener(this);
		cikisbtn.setBounds(275, 0, 25, 25);
		cikisbtn.setMargin(new Insets(0, 0, 0, 0));
		cikisbtn.setFocusable(false);
		cikisbtn.setIcon(close);

		cikisbtn.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				delete_menu(basvurular_panel);

			}
		});

		basvurular_panel.add(button);

		basvurular_panel.add(cikisbtn);

		basvurular_panel.add(list);

		this.add(basvurular_panel);

	}

	
void create_calisanlar_panel() {

		calisanlar_panel = new JPanel();

		calisanlar_panel.setLayout(null);

		calisanlar_panel.setLocation(450, 100);

		calisanlar_panel.setSize(300, 300);

		calisanlar_panel.setBackground(new Color(222, 222, 222, 200));

		DefaultListModel<String> l1 = new DefaultListModel<>();

		for (Staff s : employees) {
			l1.addElement("Ad: " + s.Ad + " Yetenek: " + s.Yetenek + " Maaş:" + s.Maas + " Seviye:" + s.Seviye);

		}

		JList<String> list = new JList<>(l1);
		list.setBackground(new Color(0, 0, 0, 200));
		list.setForeground(Color.white);
		list.setBounds(15, 25, 270, 250);

		JButton button = new JButton();

		button.setText("Kov");
		button.setBounds(100, 200, 100, 30);
		button.setBackground(new Color(69, 17, 17, 200));
		button.setForeground(Color.white);
		button.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedIndex() != -1 && list.getSelectedIndex() != 0) {

					employees.remove(list.getSelectedIndex());
					delete_menu(calisanlar_panel);
					create_calisanlar_panel();
					delete_menu(yanpanel);
					create_yanpanel();


				}
			}
		});
		ImageIcon close=new ImageIcon("image/close.png");
		
		JButton cikisbtn = new JButton();

		cikisbtn.setBackground(Color.white);
		cikisbtn.addActionListener(this);
		cikisbtn.setBounds(275, 0, 25, 25);
		cikisbtn.setMargin(new Insets(0, 0, 0, 0));
		cikisbtn.setFocusable(false);
		cikisbtn.setIcon(close);

		cikisbtn.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				delete_menu(calisanlar_panel);

			}
		});

		calisanlar_panel.add(button);

		calisanlar_panel.add(cikisbtn);

		calisanlar_panel.add(list);

		this.add(calisanlar_panel);

	}
 
@Override
public void actionPerformed(ActionEvent e) {
	
}
	
}
