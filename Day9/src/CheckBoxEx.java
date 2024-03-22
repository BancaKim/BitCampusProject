import java.awt.Checkbox;
import java.awt.Frame;
import java.awt.Panel;

public class CheckBoxEx {

	public static void main(String[] args) {
		Frame f = new Frame("Test Start");
		Panel p = new Panel();
		
		Checkbox ck1 = new Checkbox("One",true);
		Checkbox ck2 = new Checkbox("Two");
		Checkbox ck3 = new Checkbox("Three");

		p.add(ck1);
		p.add(ck2);
		p.add(ck3);
		
		f.add(p);
		
		f.setSize(300,100);
		f.setVisible(true);
	}

}
