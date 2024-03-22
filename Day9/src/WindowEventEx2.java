import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class Exit extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		System.exit(0);

	}
}

public class WindowEventEx2 extends Frame implements ActionListener{
	Panel p;
	Button input, exit;
	TextArea ta;

	public WindowEventEx2() {
		super("ActionEvent Test");

		Label ext = new Label("프로그래밍 종료");

		add(ext);

		setBounds(300, 300, 300, 200);
		setVisible(true);
		
		addWindowListener(new Exit());
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
		new WindowEventEx2();
	}

}