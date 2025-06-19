package ezen.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class EventExampleFrame extends Frame {
	
	Button button1, button2, button3;
	TextField tf;
	Choice choice;
	
	public EventExampleFrame() {
		this("No-Title");
	}
	
	public EventExampleFrame(String title) {
		super(title);
		button1 = new Button("등록");
		button2 = new Button("목록");
		button3 = new Button("삭제");
		tf = new TextField(20);
		choice = new Choice();
		choice.add("LG 베어스");
		choice.add("두산 타이거즈");
		choice.add("삼성 자이언츠");
		choice.add("롯데 이글스");
	}
	
//	컴포넌트 배치
	public void init() {
		setLayout(new FlowLayout());
		add(button1);
		add(button2);
		add(button3);
		add(tf);
		add(choice);
	}
	
	public void showMessage(String message) {
		System.out.println(message);
	}
	
	public void showDialog() {
		Dialog dialog = new Dialog(this, true);
		dialog.setSize(300, 200);
		dialog.setVisible(true);
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dialog.setVisible(false);
				dialog.dispose();
			}			
		});
	}
	
	public void showList() {
		//-----
		System.out.println("목록 보여줍니다...");
	}
	
	public void removeList() {
		//-----
		System.out.println("삭제 처리합니다..");
	}
	
	public void exit() {
		setVisible(false);
		// OS로부터 얻어온 그래픽리소스 반납
		dispose();
		System.exit(0);
	}
	
	
//	이벤트 처리
	public void eventHandling() {
		// 이름있는 지역내부 클래스 정의
		class ActionHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				Object eventSource = e.getSource();
				if(eventSource == button2) {
					showList();
				}else if(eventSource == button3) {
					removeList();
				}
			}
		}
		
		
		// 익명 객체를 이용한 이벤트 처리...
		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int buttonType = e.getButton();
				if(buttonType == MouseEvent.BUTTON3) {
					showMessage("MouseClick......");
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				button1.setBackground(Color.RED);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				button1.setBackground(Color.YELLOW);
			}
		});
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
			
			@Override
			public void windowOpened(WindowEvent e) {
//				showDialog();
				
			}
		});
		
		
		// 목록버튼 액션 이벤트 처리
		button2.addActionListener(new ActionHandler());
		
		// 삭제버튼 액션 이벤트 처리
		button3.addActionListener(new ActionHandler());
	}
	
	
	public static void main(String[] args) {
		EventExampleFrame frame = new EventExampleFrame("이벤트 처리 예제");
		frame.init();
		frame.eventHandling();
		frame.setSize(500, 400);
		frame.setVisible(true);
	}
}






