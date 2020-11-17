package button;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*; 

class MyFrame extends JFrame{
	MyFrame(){
		initUI();
	}
	public final void initUI() {
		Set_button_textfield();									// ��ư�� textField���� ������ ���� ������ ������ �Լ� ����
		Set_gui();												// gui ������ ������ �Լ� ����
    }

	static boolean check=true;									// ���� �Լ����� ����ϴ� check �̱⿡ ���������� �Ҵ�
	
	public void Set_gui(){
        setTitle("GUI TITLE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = this.getContentPane();
        this.setLayout(new FlowLayout());
        setSize(300, 500);
        setVisible(true);
        
	}public void Set_button_textfield() {					
		JButton btn_insert1 = new JButton("1");    					//��ư, textField ����
        JButton reset = new JButton("reset ");
        JButton transform = new JButton("��ȯ");
        JButton btn_won_to_dollor = new JButton("�� -> �޷�");
        JButton btn_dollor_to_won = new JButton("�޷� -> ��");    
        TextField tf1 = new TextField(30);			//��
        TextField tf2 = new TextField(30);			//�޷�
        btn_won_to_dollor.setPreferredSize(new Dimension(200,50));
        btn_dollor_to_won.setPreferredSize(new Dimension(200,50));
        this.add(btn_insert1);
        this.add(tf1);  this.add(tf2);
        this.add(reset); this.add(transform);
        this.add(btn_won_to_dollor);	this.add(btn_dollor_to_won);

        btn_insert1.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e) {
				if(check) {											// ���� check�� true�� ���� : ���� ���°� ��->�޷�    tf1�� ���
					JButton b = (JButton)e.getSource();				// �̺κ��� ���߿� �ʰ� ��ư �� �����ö� ����ɲ��� 
					String oldtext = tf1.getText();					//
					String text = b.getText();						// ������ ���� �����ϰ� ���ο� ������ ����
					String newtext = oldtext + text;				// ���� ���� ���ο� ���� ��ġ��
					tf1.setText(newtext);							// ������ ���ڸ� tf1�� ����
				}
				else if(!check) {									// ���� check�� false�� ���� : ���� ���°� �޷�->��   tf2�� ���
					JButton b = (JButton)e.getSource();
					String oldtext = tf2.getText();					// ��ư�� �� ������ ����� ���� ����
					String text = b.getText();
					String newtext = oldtext + text;
					tf2.setText(newtext);
				}
			}
		});reset.addActionListener(new ActionListener(){			// ���� ��ư
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)e.getSource();
				tf1.setText("");									//tf1 �ؽ�Ʈ�� ��ĭ����
				tf2.setText("");									//tf2 �ؽ�Ʈ�� ��ĭ����
			}
		});btn_won_to_dollor.addActionListener(new ActionListener(){	//�� -> �޷� ��ư
			public void actionPerformed(ActionEvent e) {
				check = true;											// ���������� check �����Ŀ� ��ư�� �������� true�� ����
			}
		});btn_dollor_to_won.addActionListener(new ActionListener(){	//�޷� -> ��
			public void actionPerformed(ActionEvent e) {
				check = false;											// ��ư�� �������� false�� ����
			}
		});transform.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e) {
				if(check) {											// ���� check�� true�� ���� : ���� ���°� ��->�޷�
					String won = tf1.getText();						// tf1���� won�� stringŸ������ ����
					double dollor = Double.valueOf(won)*1100.0;		// won�� ����� ���� double�� Ÿ�Ժ�ȯ �� *1100.0 �Ͽ� ����  
					tf2.setText(String.valueOf(dollor));			// double�� dollor�� string���� Ÿ�Ժ�ȯ �� tf2�� ����
				}	
				else if(!check) {									// ���� check�� false��� ������ ����
					String dollor = tf2.getText();					// tf2���� double�� stringŸ������ ����
					double won = Double.valueOf(dollor)/1100.0 ;	// dollor�� ����� ���� double�� Ÿ�Ժ�ȯ �� *1100.0 �Ͽ� ����  
					tf1.setText(String.valueOf(won));				// double�� won�� string���� Ÿ�Ժ�ȯ �� tf1�� ����
				}
				
			}
		});
        
		
	}
}


public class button	{
	public static void main(String[] args) {
		new MyFrame();
	}

}
