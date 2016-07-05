import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.lang.*;

//www branch

public class HW5 extends JFrame {
	
	JRadioButton one = new JRadioButton("���餤��");
	JRadioButton two = new JRadioButton("�ߤW&�Ұ���");
	JLabel text1 = new JLabel("�j�H�G");
	JLabel text2 = new JLabel("�p�ġG");
	JLabel text1_2 = new JLabel("��");
	JLabel text2_2 = new JLabel("��");
	JTextField inp1 = new JTextField("0");
	JTextField inp2 = new JTextField("0");
	JButton btn1 = new JButton("�T�w���b");
	JButton btn2 = new JButton("�M��");
	int ad_price = 268 , ch_price = 120;
	
	MouseAdapter set_price = new MouseAdapter(){
		public void mouseClicked(MouseEvent e){
			if(one.isSelected()){
				ad_price = 268;
				ch_price = 120;
			}
			else if(two.isSelected()){
				ad_price = 368;
				ch_price = 150;
			}
		}
	};
	
	FocusAdapter check = new FocusAdapter(){
		public void focusLost(FocusEvent e){
			JTextField temp = (JTextField)e.getSource();
			if(temp.getText().equals(""))temp.setText("0");
		}
	};
	
	MouseAdapter ok = new MouseAdapter(){
		public void mouseClicked(MouseEvent e){
			int result=JOptionPane.showConfirmDialog(HW5.this,"�T�w�n�i�浲�b��?","",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
			if (result==JOptionPane.YES_OPTION){
				try{
					String dis = "";
					int ad_num = Integer.parseInt(inp1.getText());
					int ch_num = Integer.parseInt(inp2.getText());
					int total = ad_num + ch_num;
					int total_price = 0;
					dis = dis + "�j�H�@" + ad_num + "�H�@" + ad_num*ad_price + "��\n";
					total_price = total_price + ad_num*ad_price;
					dis = dis + "�p�ġ@" + ch_num + "�H�@" + ch_num*ch_price + "��\n";
					total_price = total_price + ch_num*ch_price;
					if(total >= 3){
						dis = dis + "�馩\n";
						int discount = total / 3;
						if(discount <= ch_num){
							dis = dis + "�p�ġ@" + discount + "�H�@" + -discount*ch_price + "��\n";
							total_price = total_price - discount*ch_price;
						}
						else{
							dis = dis + "�j�H�@" + (discount-ch_num) + "�H�@" + -(discount-ch_num)*ad_price + "��\n";
							total_price = total_price - (discount-ch_num)*ad_price;
							dis = dis + "�p�ġ@" + ch_num + "�H�@" + -ch_num*ch_price + "��\n";
							total_price = total_price - ch_num*ch_price;
						}
						if(total >= 10){
							dis = dis + "�Q�H�H�W�P��@" + -(int)Math.floor(total_price*0.05) + "��\n";
							total_price = total_price - (int)Math.floor(total_price*0.05);
						}
					}
					dis = dis + "�`�p\n";
					dis = dis + total_price +"��";
					
					JOptionPane.showMessageDialog(HW5.this,dis);
				}catch (Exception f){
					JOptionPane.showMessageDialog(HW5.this,"�H�ƥ�����J�Ʀr","ĵ�i", JOptionPane.WARNING_MESSAGE);
				}
			}
		}
	};
	
	MouseAdapter clear = new MouseAdapter(){
		public void mouseClicked(MouseEvent e){
			inp1.setText("0");
			inp2.setText("0");
		}
	};

	HW5() {
		System.out.println("hello passerby");
		Container cp = getContentPane(); 
		cp.setLayout(null);
		
		one.setBounds(10, 10, 100, 20);
		one.setSelected(true);
		one.addMouseListener(set_price);
		cp.add(one);
		
		two.setBounds(130, 10, 100, 20);
		two.addMouseListener(set_price);
		cp.add(two);
		
		text1.setBounds(10, 80, 100, 20);
		cp.add(text1);
		
		text2.setBounds(10, 150, 100, 20);
		cp.add(text2);
		
		inp1.setBounds(50, 80, 100, 20);
		inp1.setHorizontalAlignment(SwingConstants.RIGHT);
		inp1.addFocusListener(check);
		cp.add(inp1);
		
		inp2.setBounds(50, 150, 100, 20);
		inp2.setHorizontalAlignment(SwingConstants.RIGHT);
		inp2.addFocusListener(check);
		cp.add(inp2);
		
		text1_2.setBounds(160, 80, 100, 20);
		cp.add(text1_2);
		
		text2_2.setBounds(160, 150, 100, 20);
		cp.add(text2_2);
		
		btn1.setBounds(10, 220, 100, 20);
		btn1.addMouseListener(ok);
		cp.add(btn1);
		
		btn2.setBounds(150, 220, 100, 20);
		btn2.addMouseListener(clear);
		cp.add(btn2);
		
		ButtonGroup set = new ButtonGroup();
		set.add(one);
		set.add(two);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 280, 300);
		setVisible(true);
	}

	public static void main(String args[]) {
		new HW5();
	}
}