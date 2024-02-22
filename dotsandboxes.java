
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.*;
public class dotsandboxes extends JFrame{
	Startlistener startl;           //��ʼ��ť����
	ChessBoard 	chessboard;               // ������
	JButton start ;					//��ʼ��ť	
	public static int 	player= 1 ;				//�û���ʾ��Ϊ1�����Ա�ʶ��Ϊ-1 //���췽��
	dotsandboxes(){
	setTitle("�����");
	setSize(450,500);
	setLocation(200,200);
	startl= new Startlistener();
	chessboard = new ChessBoard();
	start= new JButton("�� ʼ");
	start.addActionListener(startl);
	add(start,BorderLayout.SOUTH);
	add(chessboard,BorderLayout.CENTER);
	chessboard.setBackground(Color.pink);
	}
	public void paintComponent(Graphics g) {
		// System.out.println("12");
		//System.out.println("paintComponent:"+player);
		super.paintComponents(g);
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if (i % 2 == 0 && j % 2 == 0) { // ��
					g.setColor(Color.black);
					g.fillOval(i * 40+10, j * 40+10, 10, 10);
				} else {
					int[][] chess = null;
					if (i % 2 == 0 && j % 2 == 1) {
						g.setColor(Color.red); // �����
						if (chess[i][j] == -1) {
							g.fillRoundRect(i * 40+10, j * 40 - 20, 5, 70, 10, 10);
						} else {
							g.drawRoundRect(i * 40+10, j * 40 -20, 5, 70, 10, 10);// (i*40,j*40-20
																					// ,
																					// 20,
																					// 60,
																					// true);
						}
					} else if (i % 2 == 1 && j % 2 == 0) { // �����
						g.setColor(Color.BLACK);
						if (chess[i][j] == -1) {
							// g.fill3DRect(i*40-20,j*40 , 60, 20, false);
							g.fillRoundRect(i * 40 - 20, j * 40+10, 70, 5, 10, 10);
						}
						g.drawRoundRect(i * 40 - 20, j * 40+10, 70, 5, 10, 10);
					} else { // �м�
						int[][] boxes = null;
						if (boxes[i][j] == 1) {
							g.setColor(Color.GREEN);
						} else {
							g.setColor(Color.blue);
						}
						if (chess[i][j] == 4) {
							//g.drawString("me", i*40-5, j*40-5);
							g.fillRoundRect(i * 40 - 25, j * 40 - 25, 75, 75,
									10, 10);
						}
					}
				}
			}
		}
	}
	public class Startlistener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
	    if(e.getSource()==start){
				chessboard.setVisible(true);
				start.setEnabled(false);
			}
		}
	}
}