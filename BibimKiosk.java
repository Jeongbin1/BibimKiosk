import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class BibimKiosk {
	
	JFrame jf;
	JPanel card, p1, p2, p3, p4;
	
	public BibimKiosk(String msg) {
		jf = new JFrame(msg);
		
		//add panel on card panel
		card = new JPanel(new CardLayout());
		p1 = new bk_StartPage();
		p2 = new bk_DishchoosePage();
		p3 = new bk_MenuPage();
		p4 = new bk_LastPage();
		card.add(p1);
		card.add(p2);
		card.add(p3);
		card.add(p4);
		
		jf.add(card);
		
		jf.setSize(600,800);
		jf.setVisible(true);
		
		CardLayout c = (CardLayout) card.getLayout();
		
		//event
		bk_StartPage.btnstart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.next(card);
			}
		});
		
		bk_DishchoosePage.btnBowls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.next(card);
			}
		});

		bk_DishchoosePage.btnCup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.next(card);
			}
		});

		bk_MenuPage.buttonNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.next(card);
			}
		});
		
		bk_LastPage.lastbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.next(card);
				bk_MenuPage.model.setNumRows(0);
				bk_MenuPage.sum = 0;
				bk_MenuPage.labelprice.setText("총 가격: " + bk_MenuPage.sum + "원");
				bk_LastPage.numberlabel.setText("대기번호: " + (int)(Math.random()*300));
			}
		});
	}
}
