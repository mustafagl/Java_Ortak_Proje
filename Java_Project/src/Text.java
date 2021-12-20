import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class Text extends JFrame {
    int total =0;
    public Text(){
        JFrame frame= new JFrame();
        frame.setTitle("Restoran Oyunu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(1264,841); // Ekranın boyutu
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JTextField text = new JTextField(10);

        frame.getContentPane().setLayout(new FlowLayout());

        JLabel label1= new JLabel();
        label1.setForeground(Color.blue); //Siparis yazısının rengi
        label1.setText("Sipariş: ");
        frame.getContentPane().add(label1);

        ImageIcon background = new ImageIcon("src/abackground_new.jpg"); //Arka plan fotoğrafı
        label1.setIcon(background);

        ImageIcon icon =new ImageIcon("src/dark.PNG"); //İkon
        frame.setIconImage(icon.getImage());

        JButton button =new JButton("Gönder");

        frame.getContentPane().add(text);
        frame.getContentPane().add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label1.setText(text.getText() +" dışında başka bir şey ister misiniz?");
                String text1 = text.getText().toLowerCase(Locale.ROOT);
                switch (text1){
                    case "hamburger":
                        total+=40;
                        break;
                    case "taco":
                        total+=25;
                        break;
                    case "pizza":
                        total+=50;
                        break;
                    case "coca-cola":
                        total+=8;
                        break;
                    case "ayran":
                        total+=6;
                        break;
                    case "hayır":
                        label1.setText("Toplam tutar: "+(total));
                        break;
                    case "çık":
                        System.exit(0);
                    default:
                        label1.setText("Bu ürün bulunmuyor başka bir şey ister misiniz?");
                }

            }
        });


        text.setFont(new Font("Consolas",Font.ITALIC,20)); //Yazı fontu ve boyutu
        text.setForeground(Color.red); //Yazının rengi
        text.setBackground(Color.black);
        text.setCaretColor(Color.green); //Çizgi rengi

    }
}
