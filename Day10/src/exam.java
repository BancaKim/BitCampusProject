


public class exam {
	
	public static void main(String[] args) {
		A a = new B();
		a.methodA();
		a.methodC();
		
	}
}

class A {
	public void methodA() {System.out.println("print A");}
	public void methodC() {System.out.println("print C");}
}
	
class B extends A{
	public B() {System.out.println("print B");}
	public void methodC() {System.out.println("print CCC");}
	public void methodD() {System.out.println("print D");
	}
}