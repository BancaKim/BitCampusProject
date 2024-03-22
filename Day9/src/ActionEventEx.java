import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionEventEx extends Frame implements ActionListener {
	Panel p;
	Button input, exit;
	TextArea ta;

	public ActionEventEx() {
		super("ActionEvent Test");
		p = new Panel();
		input = new Button("input");
		exit = new Button("exit");
		ta = new TextArea();

		input.addActionListener(this); // 이벤트 소스와 이벤트 핸들러 연결
		exit.addActionListener(this); // 이벤트 소스와 이벤트 핸들러 연결

		p.add(input);
		p.add(exit);

		add(p, BorderLayout.NORTH);
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
		new ActionEventEx();
	}
}
