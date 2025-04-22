import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class bk_DishchoosePage extends JPanel{
	
	static public JButton btnBowls, btnCup;
	
	JPanel panel;
	JLabel infolabel, infolabel2;
	
	public bk_DishchoosePage() {
		
		setLayout(null);
		setBackground(new Color(246, 246, 246));

		//two info label 
		infolabel = new JLabel("<HTML><body><center>환영합니다<br>비빔밥을 담을 용기를 선택해주세요</center></body></HTML>");
		infolabel.setHorizontalAlignment(JLabel.CENTER);
		infolabel.setBounds(100, 110, 400, 100);
		infolabel.setFont(new Font("Pretendard", Font.BOLD, 17));
		add(infolabel);

		infolabel2 = new JLabel("포장은 cup을 선택한 경우에만 가능합니다");
		infolabel2.setHorizontalAlignment(JLabel.CENTER);
		infolabel2.setBounds(100, 480, 400, 100);
		infolabel2.setFont(new Font("Pretendard", Font.BOLD, 14));
		infolabel2.setForeground(new Color(241, 95, 95));
		
		add(infolabel2);
		
		//two buttons
		ImageIcon icon1 = new ImageIcon("./images/bowls.png");
		Image img1 = icon1.getImage();
		Image changeImg1 = img1.getScaledInstance(200,132,Image.SCALE_SMOOTH);
		ImageIcon changeIcon1 = new ImageIcon(changeImg1);
		btnBowls = new JButton("BOWLS", changeIcon1);
		btnBowls.setFont(new Font("Pretendard", Font.BOLD, 25));
		btnBowls.setVerticalTextPosition(JButton.BOTTOM);
		btnBowls.setHorizontalTextPosition(JButton.CENTER); 
		btnBowls.setBorderPainted(false);
		//btnBowls.setContentAreaFilled(false);
		btnBowls.setBackground(new Color(234, 234, 234));
		btnBowls.setBounds(45, 200, 250, 300);

		ImageIcon icon2 = new ImageIcon("./images/cup.png");
		Image img2 = icon2.getImage();
		Image changeImg2 = img2.getScaledInstance(200,132,Image.SCALE_SMOOTH);
		ImageIcon changeIcon2 = new ImageIcon(changeImg2);
		btnCup = new JButton("CUP", changeIcon2);
		btnCup.setFont(new Font("Pretendard", Font.BOLD, 25));
		btnCup.setVerticalTextPosition(JButton.BOTTOM);
		btnCup.setHorizontalTextPosition(JButton.CENTER); 
		btnCup.setBorderPainted(false);
		btnCup.setBackground(new Color(234, 234, 234));
		btnCup.setBounds(300, 200, 250, 300);
		
		add(btnBowls);
		add(btnCup);
		
	}

}
