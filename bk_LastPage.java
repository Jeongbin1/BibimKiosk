import java.awt.*;
import javax.swing.*;

public class bk_LastPage extends JPanel{

	static JButton lastbutton;
	JLabel infolabel;
	static JLabel numberlabel;
	
	public bk_LastPage() {
		setLayout(null);
		setBackground(new Color(246, 246, 246));
		
		infolabel = new JLabel("<HTML><body><center>�ֹ��� �����Ǿ����ϴ�<br>��� ��ȣ�� �� Ȯ�����ּ���</center></body></HTML>");
		infolabel.setHorizontalAlignment(JLabel.CENTER);
		infolabel.setBounds(100, 90, 400, 100);
		infolabel.setFont(new Font("Pretendard", Font.BOLD, 13));
		add("North",infolabel);
		
		numberlabel = new JLabel("����ȣ: " + (int)(Math.random()*300));
		numberlabel.setBounds(220, 470, 200, 100);
		numberlabel.setFont(new Font("Pretendard", Font.BOLD, 30));
		add("Center",numberlabel);
		
		lastbutton = new JButton("ó������");
		lastbutton.setBounds(175, 570, 250, 50);
		lastbutton.setBackground(new Color(234, 234, 234));
		lastbutton.setBorderPainted(false);
		lastbutton.setFont(new Font("Pretendard", Font.PLAIN, 17));
		add(lastbutton);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		// draw image
		ImageIcon icon = new ImageIcon("./images/bibimbop3.jpg");
		Image img = icon.getImage();
		g2.drawImage(img, 120, 170, 360, 300, this);
		
	}
}
