import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class ChessBoard extends JPanel {
	int chess[][] = new int[11][11];
	int boxes[][] = new int[11][11]; // �����жϸ��ӵĹ���
	int player = 1;
	// int li[]=new int[4];
	// int poi;
	// ���̵Ĺ��췽��
	public ChessBoard() {
		// poi=0;
		setVisible(false);
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if (i % 2 == 0 && j % 2 == 0) {
					chess[i][j] = 0;
				} else if (i % 2 == 1 && j % 2 == 0) {
					chess[i][j] = 1;
				} else if (i % 2 == 0 && j % 2 == 1) {
					chess[i][j] = 1;
				} else {
					chess[i][j] = 0;
				}
			}
		}
		addMouseListener(new MouseAdapter() { // ����¼�����
			int x;
			int y;
			public void mouseClicked(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				zuobiao dots = new zuobiao(x, y);
				//System.out.println("zuobiao:"+dots.getX()+" "+dots.getY());
				//if(pla)
				changeword(dots.getX(), dots.getY());
				// System.out.print(player);
				//gameover();
				//repaint();
				computerdo();
				//gameover();
				//repaint();
			}
		});
	}
	public void computerdo() {
		int x;
		int y;
		if (!gameover()) {
			while (player == 2) {
				ComThink computerPlayer = new ComThink(chess, boxes);
				x = computerPlayer.getX();
				y = computerPlayer.getY();
				changeword(x, y);
				//System.out.println("computerDO:"+player);
				// repaint();
				// System.out.println(x);
				// System.out.println(y);
			}
		}
	}
	// ��ͼ����
			public void paintComponent(Graphics g) {
				// System.out.println("12");
				//System.out.println("paintComponent:"+player);
				super.paintComponent(g);
				for (int i = 0; i < 11; i++) {
					for (int j = 0; j < 11; j++) {
						if (i % 2 == 0 && j % 2 == 0) { // ��
							g.setColor(Color.black);
							g.fillOval(i * 40+10, j * 40+10, 10, 10);
						} else {
							if (i % 2 == 0 && j % 2 == 1) {
								g.setColor(Color.black); // �����
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
								if (boxes[i][j] == 1) {
									g.setColor(Color.GREEN);
								} else {
									g.setColor(Color.yellow);
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
	// ���»��巽��
	public void update(Graphics g) {
						paint(g);
	}
	// ÿ��һ���޸ľ�����Ӧֵ
	public void changeword(int x, int y) {
		int i = x;
		int j = y;
		if (chess[i][j] == 1) {
			if (i % 2 == 1 && j % 2 == 0) {
				chess[i][j] = -1;
				if (j == 0) {
					chess[i][j + 1]++;
					System.out.println("����ֵ��"+chess[i][j + 1]);
					boxes[i][j + 1] = player;// ���ַ����������һ��ִ�е���
					// System.out.println(chess[i][j+1]);
					if (chess[i][j + 1] != 4) {
						player = player % 2+1;// ����Υ��ȫ��ռ�У�����Ȩ��������һ����
						// System.out.println("a2");
					}
				} else if (j == 10) {
					chess[i][j - 1]++;
					System.out.println("����ֵ��"+chess[i][j -1]);
					boxes[i][j - 1] = player;
					// System.out.println(chess[i][j-1]);
					if (chess[i][j - 1] != 4) {
						player = player % 2+1;
					}
				} else {
					chess[i][j + 1]++;
					chess[i][j - 1]++;
					System.out.println("����ֵ��"+chess[i][j + 1]);
					System.out.println("����ֵ��"+chess[i][j - 1]);
					boxes[i][j - 1] = player;// ���ַ����������һ��ִ�е���
					boxes[i][j + 1] = player;// ���ַ����������һ��ִ�е���
					// System.out.println(chess[i][j-1]);
					// System.out.println(chess[i][j+1]);
					if (chess[i][j + 1] != 4 && chess[i][j - 1] != 4) {
						player = player% 2+1;
					}
				}
			} else if (i % 2 == 0 && j % 2 == 1) {
				chess[i][j] = -1;
				if (i == 0) {
					chess[i + 1][j]++;
					System.out.println("����ֵ��"+chess[i+1][j]);
					boxes[i + 1][j] = player;
					// System.out.println(chess[i+1][j]);
					if (chess[i + 1][j] !=4) {
						player = player% 2+1;
						//System.out.println("b");
					}
				} else if (i == 10) {
					chess[i - 1][j]++;
				//	System.out.println("����ֵ��"+chess[i-1][j]);
					boxes[i - 1][j] = player;
					// System.out.println(chess[i-1][j]);
					if (chess[i - 1][j] != 4) {
						player=player% 2+1;
					}
				} else {
					chess[i + 1][j]++;
					chess[i - 1][j]++;
				//	System.out.println("����ֵ��"+chess[i+1][j]);
					//System.out.println("����ֵ��"+chess[i-1][j]);
					boxes[i - 1][j] = player;
					boxes[i + 1][j] = player;
					// System.out.println(chess[i+1][j]);
					// System.out.println(chess[i-1][j]);
					if (chess[i + 1][j] !=4 && chess[i - 1][j]!=4) {
						player=player% 2+1;
					}
				}
			}
		}
		repaint();
		gameover();
	}
	// �ж��Ƿ������Ϸ��
	public boolean gameover() {
		int me = 0, com = 0;
		for (int m = 0; m < 11; m++) {
			for (int n = 0; n < 11; n++) {
				if (chess[m][n] == 4) {
					if (boxes[m][n] == 1) {
						me++;
					} else if (boxes[m][n] == 2) {
						com++;
					}
				}
			}
		}
		// System.out.println(me);
		//System.out.println("me+com:"+me+com);
		if (me + com == 25) {
			player=1;
			if (me > com) {
				// infoStr ="��ʤ����";
				JOptionPane.showMessageDialog(null, "��ʤ����!!!  �ȷ�Ϊ��"+me+" : "+com, "information",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "����ʤ��   �ȷ�Ϊ��"+me+" : "+com, "information",
						JOptionPane.INFORMATION_MESSAGE);
			}
			return true;
		} else
			return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dotsandboxes d = new dotsandboxes();
		d.setVisible(true);
		d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}