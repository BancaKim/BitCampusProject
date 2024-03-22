import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TextEventEx extends Frame implements ActionListener {
	Panel p;
	Button clear, exit;
	TextArea input;
	TextArea ta;

	public TextEventEx() {
		super("ActionEvent Test");
		p = new Panel();
		WindowAdapter adapter = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}};
			
		clear = new Button("Clear");
		exit = new Button("exit");
		
		input = new TextArea();
		ta = new TextArea();

		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
//				clearAction();
			}
		}); // 이벤트 소스와 이벤트 핸들러 연결
		exit.addActionListener(this); // 이벤트 소스와 이벤트 핸들러 연결

		
		
		
		p.add(clear);
		p.add(exit);

		add(p, BorderLayout.SOUTH);
		add(input, BorderLayout.NORTH);
		add(ta, BorderLayout.CENTER);

		setBounds(300, 300, 300, 200);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String name;
		name = ae.getActionCommand();

		if (name.equals("input"))
			ta.append("button input.\n");  
		else {
			ta.append("exit. \n");
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
			}
			System.exit(0);
		}

	}

	public static void main(String[] args) {
		new TextEventEx();
	}
//
//	@Override
//	public void textValueChanged(TextEvent e) {
//		// TODO Auto-generated method stub
//		
	}
}
