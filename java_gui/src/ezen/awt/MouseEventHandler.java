package ezen.awt;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEventHandler extends MouseAdapter {
	
	EventExampleFrame frame;
	
	public MouseEventHandler(EventExampleFrame frame) {
		this.frame = frame;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("등록버튼이 클릭되었습니다..");
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		frame.button1.setBackground(Color.BLUE);		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		frame.button1.setBackground(Color.YELLOW);	
	}

}
