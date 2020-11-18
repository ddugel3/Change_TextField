# Change_TextField



 
 1 .현재 상태가 '원 -> 달러' 인지 '달러 -> 원'인지를 판달할수 있는 '''boolean check'''를 생성해서 구현
``` java
private boolean check = true;
//기존 상태는 교수님이 제시하신 '원 -> 달러' 를 check = true 의 상태로 지정
```

2. check의 상태에 따라 변경되는 TextField
``` java
if(check) {										              // 원 -> 달러의 상태
  JButton b = (JButton)e.getSource();			
  String oldtext = tf1.getText();				
  String text = b.getText();					
  String newtext = oldtext + text;
  tf1.setText(newtext);							        // tf1에 값 기록
}
else if(!check) {                           // 달러 -> 원의 상태
  JButton b = (JButton)e.getSource();
  String oldtext = tf2.getText();			
  String text = b.getText();
  String newtext = oldtext + text;
  tf2.setText(newtext);							        // tf2에 값 기록
}

// 이후 필요한 주석은 코드안에 기록
```

3. 상태를 바꾸는 버튼 구현
  - 버튼을 클릭할때마다 
``` java
check = true;
check = false;
```

4. 리셋 버튼
  - TextField 초기화
  
5. 변환 버튼
  - String 타입 변수를 계산하기 위해 타입변환하는 함수 구현
  
6. 숫자 입력 버튼


간단하게 총 6개의 기능을 구현하는 코드 작성
  
