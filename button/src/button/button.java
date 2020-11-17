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
		Set_button_textfield();									// 버튼과 textField들의 생성과 설정 동작이 구현된 함수 실행
		Set_gui();												// gui 설정이 구현된 함수 실행
    }

	static boolean check=true;									// 여러 함수에서 사용하는 check 이기에 전역변수로 할당
	
	public void Set_gui(){
        setTitle("GUI TITLE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = this.getContentPane();
        this.setLayout(new FlowLayout());
        setSize(300, 500);
        setVisible(true);
        
	}public void Set_button_textfield() {					
		JButton btn_insert1 = new JButton("1");    					//버튼, textField 생성
        JButton reset = new JButton("reset ");
        JButton transform = new JButton("변환");
        JButton btn_won_to_dollor = new JButton("원 -> 달러");
        JButton btn_dollor_to_won = new JButton("달러 -> 원");    
        TextField tf1 = new TextField(30);			//원
        TextField tf2 = new TextField(30);			//달러
        btn_won_to_dollor.setPreferredSize(new Dimension(200,50));
        btn_dollor_to_won.setPreferredSize(new Dimension(200,50));
        this.add(btn_insert1);
        this.add(tf1);  this.add(tf2);
        this.add(reset); this.add(transform);
        this.add(btn_won_to_dollor);	this.add(btn_dollor_to_won);

        btn_insert1.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e) {
				if(check) {											// 만약 check가 true면 실행 : 현재 상태가 원->달러    tf1에 기록
					JButton b = (JButton)e.getSource();				// 이부분은 나중에 너가 버튼 값 가져올때 쓰면될꺼야 
					String oldtext = tf1.getText();					//
					String text = b.getText();						// 변수의 값을 저장하고 새로운 값으로 저장
					String newtext = oldtext + text;				// 기존 값과 새로운 값을 합치기
					tf1.setText(newtext);							// 합쳐진 문자를 tf1에 저장
				}
				else if(!check) {									// 만약 check가 false면 실행 : 현재 상태가 달러->월   tf2에 기록
					JButton b = (JButton)e.getSource();
					String oldtext = tf2.getText();					// 버튼의 값 저장위 방식은 위와 동일
					String text = b.getText();
					String newtext = oldtext + text;
					tf2.setText(newtext);
				}
			}
		});reset.addActionListener(new ActionListener(){			// 리셋 버튼
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)e.getSource();
				tf1.setText("");									//tf1 텍스트를 빈칸으로
				tf2.setText("");									//tf2 텍스트를 빈칸으로
			}
		});btn_won_to_dollor.addActionListener(new ActionListener(){	//원 -> 달러 버튼
			public void actionPerformed(ActionEvent e) {
				check = true;											// 전역변수로 check 만든후에 버튼이 눌러지면 true로 변경
			}
		});btn_dollor_to_won.addActionListener(new ActionListener(){	//달러 -> 원
			public void actionPerformed(ActionEvent e) {
				check = false;											// 버튼이 눌러지면 false로 변경
			}
		});transform.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e) {
				if(check) {											// 만약 check가 true면 실행 : 현재 상태가 원->달러
					String won = tf1.getText();						// tf1값을 won에 string타입으로 저장
					double dollor = Double.valueOf(won)*1100.0;		// won을 계산을 위해 double로 타입변환 후 *1100.0 하여 저장  
					tf2.setText(String.valueOf(dollor));			// double형 dollor을 string으로 타입변환 후 tf2에 저장
				}	
				else if(!check) {									// 만약 check가 false라면 조전문 실행
					String dollor = tf2.getText();					// tf2값을 double에 string타입으로 저장
					double won = Double.valueOf(dollor)/1100.0 ;	// dollor를 계산을 위해 double로 타입변환 후 *1100.0 하여 저장  
					tf1.setText(String.valueOf(won));				// double형 won을 string으로 타입변환 후 tf1에 저장
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
