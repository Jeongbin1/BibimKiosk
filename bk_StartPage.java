import java.awt.*;
import javax.swing.*;

public class bk_StartPage extends JPanel{
	
	static JButton btnstart;

	public bk_StartPage() {
		setLayout(null);
		
		btnstart = new JButton("시작하려면 클릭하세요");
		btnstart.setBounds(0, 500, 600, 265);
		btnstart.setFont(new Font("Pretendard", Font.BOLD, 25));
		btnstart.setBackground(new Color(234, 234, 234));
		btnstart.setBorderPainted(false);
		
		add(btnstart);
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		// draw image
		ImageIcon icon = new ImageIcon("./images/bibimbop.jpg");
		Image img = icon.getImage();
		g2.drawImage(img, 0, 0, 600, 500, this);
		
	}
}
