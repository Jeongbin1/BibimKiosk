
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.*;

public class bk_MenuPage extends JPanel implements Runnable, ActionListener {
	
	JPanel pTop, pCenter, pBottom;
	JPanel pOp1, pOp2, pOp3, pOp4, pOp5;
	JLabel labeltitle;
	JButton option1, option2, option3, option4, option5, btnerase;
	static public JButton buttonNext;
	static public JLabel labeltime, labelprice;
	static public int sum = 0;
	
	JButton[] button = new JButton[8];
	ImageIcon[] icon = new ImageIcon[8];
	Image[] img = new Image[8];
	Image[]	changeImg = new Image[8];
	ImageIcon[] changeIcon = new ImageIcon[8];
	
	JTable table;
	static public DefaultTableModel model;
	
	public bk_MenuPage() {
		setLayout(new BorderLayout());
		
		// pTop		
		pTop = new JPanel();
		pTop.setBorder(BorderFactory.createEmptyBorder(15, 20, 5, 20));
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints constraint = new GridBagConstraints();
		pTop.setLayout(gridbag);
		pTop.setBackground(new Color(246, 246, 246));
		
		// pCenter
		pCenter = new JPanel(new CardLayout());
		pOp1 = new JPanel();
		pOp2 = new JPanel();
		pOp3 = new JPanel();
		pOp4 = new JPanel();
		pOp5 = new JPanel();
		pCenter.add(pOp1, "base");
		pCenter.add(pOp2, "protein");
		pCenter.add(pOp3, "toppings");
		pCenter.add(pOp4, "sauce");
		pCenter.add(pOp5, "extra");
		CardLayout c = (CardLayout) pCenter.getLayout();
		
		
		//********************************************************************************************************************
		// pTop - time/title
        Thread thread = new Thread(this);
        thread.start();
        
		constraint.gridwidth = GridBagConstraints.REMAINDER;
		constraint.fill = GridBagConstraints.HORIZONTAL;
		labeltime = new JLabel();
		labeltime.setHorizontalAlignment(JLabel.RIGHT);
		labeltime.setForeground(new Color(93, 93, 93));
		labeltime.setFont(new Font("Pretendard", Font.BOLD, 20));
		gridbag.setConstraints(labeltime, constraint);
		
		constraint.gridwidth = GridBagConstraints.REMAINDER;
		constraint.fill = GridBagConstraints.HORIZONTAL;
		labeltitle = new JLabel("ORDER");
		labeltitle.setHorizontalAlignment(JLabel.CENTER);
		gridbag.setConstraints(labeltitle, constraint);
		labeltitle.setFont(new Font("Pretendard", Font.BOLD, 30));
		labeltitle.setBorder(BorderFactory.createEmptyBorder(20,0,30,0));

		
		// pTop - option buttons
		constraint.gridwidth = 1;
		constraint.weightx = 5.0;
		option1 = new JButton("BASE");
		option1.setBackground(new Color(255, 193, 158));
		option1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.show(pCenter, "base");
			}
		});
		option1.setFont(new Font("Pretendard", Font.BOLD, 15));
		gridbag.setConstraints(option1, constraint);
		
		option2 = new JButton("PROTEIN");
		option2.setBackground(new Color(255, 193, 158));
		option2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.show(pCenter, "protein");
			}
		});
		option2.setFont(new Font("Pretendard", Font.BOLD, 15));
		gridbag.setConstraints(option2, constraint);
		
		option3 = new JButton("TOPPINGS");
		option3.setBackground(new Color(255, 193, 158));
		option3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.show(pCenter, "toppings");
			}
		});
		option3.setFont(new Font("Pretendard", Font.BOLD, 15));
		gridbag.setConstraints(option3, constraint);
		
		option4 = new JButton("SAUCE");
		option4.setBackground(new Color(255, 193, 158));
		option4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.show(pCenter, "sauce");
			}
		});
		option4.setFont(new Font("Pretendard", Font.BOLD, 15));
		gridbag.setConstraints(option4, constraint);
		
		constraint.gridheight = 1;
		constraint.gridwidth = GridBagConstraints.REMAINDER;
		option5 = new JButton("EXTRA");
		option5.setBackground(new Color(255, 193, 158));
		option5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.show(pCenter, "extra");
			}
		});
		option5.setFont(new Font("Pretendard", Font.BOLD, 15));
		gridbag.setConstraints(option5, constraint);
		
		pTop.add(labeltime);
		pTop.add(labeltitle);
		pTop.add(option1);
		pTop.add(option2);
		pTop.add(option3);
		pTop.add(option4);
		pTop.add(option5);

		//********************************************************************************************************************
		// pCenter - pOp1********************************************
		pOp1.setLayout(new GridLayout(2,4,20,20));
		pOp1.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
		pOp1.setBackground(new Color(234, 234, 234));
		
		// pCenter - pOp1 - menu image
		icon[0] = new ImageIcon("./images/쌀밥.jpg");
		icon[1] = new ImageIcon("./images/흑미밥.jpg");
		icon[2] = new ImageIcon("./images/현미밥.jpg");
		icon[3] = new ImageIcon("./images/lettuce.jpg");
		icon[4] = new ImageIcon("");
		icon[5] = new ImageIcon("");
		icon[6] = new ImageIcon("");
		icon[7] = new ImageIcon("");

		for (int i = 0; i <= 7; i++) {
			img[i] = icon[i].getImage();
			changeImg[i] = img[i].getScaledInstance(120,120,Image.SCALE_SMOOTH);
			changeIcon[i] = new ImageIcon(changeImg[i]);
		}
		
		// pCenter - pOp1 - menu buttons
		button[0] = new JButton("<HTML><body><center>쌀밥<br>1500원</center></body></HTML>", changeIcon[0]);
		button[1] = new JButton("<HTML><body><center>흑미밥<br>2000원</center></body></HTML>", changeIcon[1]);
		button[2] = new JButton("<HTML><body><center>현미밥<br>2000원</center></body></HTML>", changeIcon[2]);
		button[3] = new JButton("<HTML><body><center>lettuce<br>1000원</center></body></HTML>", changeIcon[3]);
		button[4] = new JButton("");
		button[5] = new JButton("");
		button[6] = new JButton("");
		button[7] = new JButton("");
		for (int i = 0; i <= 7; i++) {
			button[i].setVerticalTextPosition(JButton.BOTTOM);
			button[i].setHorizontalTextPosition(JButton.CENTER); 
			button[i].setFont(new Font("Pretendard", Font.BOLD, 13));
			button[i].setBorderPainted(false);
			button[i].setContentAreaFilled(false);
			button[i].addActionListener(this);
			pOp1.add(button[i]);
		}
		
		// pCenter - pOp2********************************************
		pOp2.setLayout(new GridLayout(2,4,20,20));
		pOp2.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
		pOp2.setBackground(new Color(234, 234, 234));
		
		// pCenter - pOp2 - menu image
		icon[0] = new ImageIcon("./images/beefbulgogi.jpg");
		icon[1] = new ImageIcon("./images/spicypork.jpg");
		icon[2] = new ImageIcon("./images/soychicken.jpg");
		icon[3] = new ImageIcon("./images/organictofu.jpg");
		icon[4] = new ImageIcon("");
		icon[5] = new ImageIcon("");
		icon[6] = new ImageIcon("");
		icon[7] = new ImageIcon("");

		for (int i = 0; i <= 7; i++) {
			img[i] = icon[i].getImage();
			changeImg[i] = img[i].getScaledInstance(120,120,Image.SCALE_SMOOTH);
			changeIcon[i] = new ImageIcon(changeImg[i]);
		}
		
		// pCenter - pOp2 - menu buttons
		button[0] = new JButton("<HTML><body><center>beef bulgogi<br>4500원</center></body></HTML>", changeIcon[0]);
		button[1] = new JButton("<HTML><body><center>spicy pork<br>4000원</center></body></HTML>", changeIcon[1]);
		button[2] = new JButton("<HTML><body><center>soy chicken<br>4000원</center></body></HTML>", changeIcon[2]);
		button[3] = new JButton("<HTML><body><center>organic tofu<br>3000원</center></body></HTML>", changeIcon[3]);
		button[4] = new JButton("");
		button[5] = new JButton("");
		button[6] = new JButton("");
		button[7] = new JButton("");
		for (int i = 0; i <= 7; i++) {
			button[i].setVerticalTextPosition(JButton.BOTTOM);
			button[i].setHorizontalTextPosition(JButton.CENTER); 
			button[i].setFont(new Font("Pretendard", Font.BOLD, 13));
			button[i].setBorderPainted(false);
			button[i].setContentAreaFilled(false);
			button[i].addActionListener(this);
			pOp2.add(button[i]);
		}
		
		// pCenter - pOp3********************************************
		pOp3.setLayout(new GridLayout(2,4,20,20));
		pOp3.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
		pOp3.setBackground(new Color(234, 234, 234));
		
		// pCenter - pOp3 - menu image
		icon[0] = new ImageIcon("./images/고사리.jpg");
		icon[1] = new ImageIcon("./images/시금치.jpg");
		icon[2] = new ImageIcon("./images/당근.png");
		icon[3] = new ImageIcon("./images/애호박.jpg");
		icon[4] = new ImageIcon("./images/콩나물.jpg");
		icon[5] = new ImageIcon("./images/무생채.jpg");
		icon[6] = new ImageIcon("./images/어린잎.jpg");
		icon[7] = new ImageIcon("./images/버섯.jpg");

		for (int i = 0; i <= 7; i++) {
			img[i] = icon[i].getImage();
			changeImg[i] = img[i].getScaledInstance(120,120,Image.SCALE_SMOOTH);
			changeIcon[i] = new ImageIcon(changeImg[i]);
		}
				
		// pCenter - pOp3 - menu buttons
		button[0] = new JButton("<HTML><body><center>고사리<br>1000원</center></body></HTML>", changeIcon[0]);
		button[1] = new JButton("<HTML><body><center>시금치<br>1000원</center></body></HTML>", changeIcon[1]);
		button[2] = new JButton("<HTML><body><center>당근<br>1000원</center></body></HTML>", changeIcon[2]);
		button[3] = new JButton("<HTML><body><center>애호박<br>1000원</center></body></HTML>", changeIcon[3]);
		button[4] = new JButton("<HTML><body><center>콩나물<br>1000원</center></body></HTML>", changeIcon[4]);
		button[5] = new JButton("<HTML><body><center>무생채<br>1000원</center></body></HTML>", changeIcon[5]);
		button[6] = new JButton("<HTML><body><center>어린잎<br>1000원</center></body></HTML>", changeIcon[6]);
		button[7] = new JButton("<HTML><body><center>버섯<br>1000원</center></body></HTML>", changeIcon[7]);
		for (int i = 0; i <= 7; i++) {
			button[i].setVerticalTextPosition(JButton.BOTTOM);
			button[i].setHorizontalTextPosition(JButton.CENTER); 
			button[i].setFont(new Font("Pretendard", Font.BOLD, 13));
			button[i].setBorderPainted(false);
			button[i].setContentAreaFilled(false);
			button[i].addActionListener(this);
			pOp3.add(button[i]);
		}
		
		// pCenter - pOp4********************************************
		pOp4.setLayout(new GridLayout(2,4,20,20));
		pOp4.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
		pOp4.setBackground(new Color(234, 234, 234));
		
		// pCenter - pOp4 - menu image
		icon[0] = new ImageIcon("./images/고추장.jpg");
		icon[1] = new ImageIcon("./images/강된장.jpg");
		icon[2] = new ImageIcon("./images/스리라차.jpg");
		icon[3] = new ImageIcon("./images/데리야끼.jpg");
		icon[4] = new ImageIcon("");
		icon[5] = new ImageIcon("");
		icon[6] = new ImageIcon("");
		icon[7] = new ImageIcon("");

		for (int i = 0; i <= 7; i++) {
			img[i] = icon[i].getImage();
			changeImg[i] = img[i].getScaledInstance(120,120,Image.SCALE_SMOOTH);
			changeIcon[i] = new ImageIcon(changeImg[i]);
		}
				
		// pCenter - pOp4 - menu buttons
		button[0] = new JButton("<HTML><body><center>고추장<br>800원</center></body></HTML>", changeIcon[0]);
		button[1] = new JButton("<HTML><body><center>강된장<br>1000원</center></body></HTML>", changeIcon[1]);
		button[2] = new JButton("<HTML><body><center>스리라차<br>500원</center></body></HTML>", changeIcon[2]);
		button[3] = new JButton("<HTML><body><center>데리야끼<br>700원</center></body></HTML>", changeIcon[3]);
		button[4] = new JButton("");
		button[5] = new JButton("");
		button[6] = new JButton("");
		button[7] = new JButton("");
		for (int i = 0; i <= 7; i++) {
			button[i].setVerticalTextPosition(JButton.BOTTOM);
			button[i].setHorizontalTextPosition(JButton.CENTER); 
			button[i].setFont(new Font("Pretendard", Font.BOLD, 13));
			button[i].setBorderPainted(false);
			button[i].setContentAreaFilled(false);
			button[i].addActionListener(this);
			pOp4.add(button[i]);
		}

		// pCenter - pOp5********************************************
		pOp5.setLayout(new GridLayout(2,4,20,20));
		pOp5.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
		pOp5.setBackground(new Color(234, 234, 234));
		
		// pCenter - pOp5 - menu image
		icon[0] = new ImageIcon("./images/계란후라이.jpg");
		icon[1] = new ImageIcon("./images/만두.jpg");
		icon[2] = new ImageIcon("./images/동치미.jpg");
		icon[3] = new ImageIcon("");
		icon[4] = new ImageIcon("");
		icon[5] = new ImageIcon("");
		icon[6] = new ImageIcon("");
		icon[7] = new ImageIcon("");

		for (int i = 0; i <= 7; i++) {
			img[i] = icon[i].getImage();
			changeImg[i] = img[i].getScaledInstance(120,120,Image.SCALE_SMOOTH);
			changeIcon[i] = new ImageIcon(changeImg[i]);
		}
				
		// pCenter - pOp5 - menu buttons
		button[0] = new JButton("<HTML><body><center>계란후라이<br>1000원</center></body></HTML>", changeIcon[0]);
		button[1] = new JButton("<HTML><body><center>곁들임 만두<br>3000원</center></body></HTML>", changeIcon[1]);
		button[2] = new JButton("<HTML><body><center>동치미<br>500원</center></body></HTML>", changeIcon[2]);
		button[3] = new JButton("");
		button[4] = new JButton("");
		button[5] = new JButton("");
		button[6] = new JButton("");
		button[7] = new JButton("");
		for (int i = 0; i <= 7; i++) {
			button[i].setVerticalTextPosition(JButton.BOTTOM);
			button[i].setHorizontalTextPosition(JButton.CENTER); 
			button[i].setFont(new Font("Pretendard", Font.BOLD, 13));
			button[i].setBorderPainted(false);
			button[i].setContentAreaFilled(false);
			button[i].addActionListener(this);
			pOp5.add(button[i]);
		}
		
		//********************************************************************************************************************
		// pBottom **********************************************************	
		pBottom = new JPanel();
		pBottom.setLayout(gridbag);
		pBottom.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
		pBottom.setBackground(new Color(246, 246, 246));
		

		String columns[] = {"주문내역", "가격"};
		String data[][]= {	};
		
		constraint.weightx = 1.0;
		constraint.weighty = 1.0;
		constraint.gridx = 0;
		constraint.gridy = 0;
		constraint.gridwidth = 2;
		constraint.gridheight = 3;
		model = new DefaultTableModel(data, columns);
		table = new JTable(model);
		//table.setModel(model);
		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setViewportView(table);
		jScrollPane.setPreferredSize(new Dimension(300,180));
		table.setFillsViewportHeight(true);
		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setFont(new Font("Pretendard", Font.PLAIN, 13));
		table.setFont(new Font("Pretendard", Font.PLAIN, 13));
		gridbag.setConstraints(jScrollPane, constraint);
		
		
		constraint.gridx = 2;
		constraint.gridy = 0;
		constraint.gridwidth = 1;
		constraint.gridheight = 1;
		labelprice = new JLabel("총 가격: " + sum + "원");
		labelprice.setFont(new Font("Pretendard", Font.PLAIN, 20));
		labelprice.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
		gridbag.setConstraints(labelprice, constraint);
		
		constraint.gridx = 2;
		constraint.gridy = 1;
		constraint.ipady = 15;
		constraint.insets = new Insets(0, 20, 0, 0);
		btnerase = new JButton("선택 메뉴 초기화");
		btnerase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setNumRows(0);
				sum = 0;
				labelprice.setText("총 가격: " + sum + "원");
			}
		});
		btnerase.setBackground(new Color(234, 234, 234));
		btnerase.setFont(new Font("Pretendard", Font.BOLD, 17));
		btnerase.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		gridbag.setConstraints(btnerase, constraint);

		constraint.gridx = 2;
		constraint.gridy = 2;
		constraint.ipady = 15;
		constraint.insets = new Insets(0, 20, 0, 0);
		buttonNext = new JButton("선택 완료");
		buttonNext.setBackground(new Color(255, 193, 158));
		buttonNext.setFont(new Font("Pretendard", Font.BOLD, 17));
		buttonNext.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		gridbag.setConstraints(buttonNext, constraint);
		
		pBottom.add(jScrollPane);
		pBottom.add(labelprice);
		pBottom.add(btnerase);
		pBottom.add(buttonNext);
		

		add("North", pTop);
		add("Center", pCenter); 
		add("South", pBottom);
	}
	
	public void actionPerformed(ActionEvent e) {
		String text = e.getActionCommand();
		String addtext[] = new String[2];
		addtext[0] = text.substring(text.indexOf("r>") +2, text.indexOf("<br>"));
		addtext[1] = text.substring(text.indexOf("<br>") +4, text.indexOf("</"));
		model.addRow(addtext);
		table.updateUI();
		int price = Integer.parseInt(text.substring(text.indexOf("<br>")+4, text.indexOf("원")));
		sum += price;
		labelprice.setText("총 가격: " + sum + "원");
	}

	@Override
	public void run() {
		while(true) {
			LocalDateTime Time = LocalDateTime.now();
	        labeltime.setText(Time.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
			
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
