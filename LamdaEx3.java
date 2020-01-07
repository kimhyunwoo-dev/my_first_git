package lamda;

@FunctionalInterface
interface MyFunction1{
	void myMethod();
}

class Outer{
	int val = 15;
	
	class Inner{
		int val=20;
		void method(int is) {
			int val=30;
			//i=10;	 	//여기서 지역변수를 바꾸게 되면 아래에서는 람다식을 사용하지 못하든가
						//여기서 지역변수를 바꾸지 않고 아래에서 람다식에서 지역변수를 바꾸지 못하든가
						//둘중 하나.
			
			MyFunction1 f= ()->{
				System.out.println("              i : " + is );
				System.out.println("            val : " + val);
//				System.out.println("            val : " + ++val);	//람다식내에서 지역변수 변경 제한
				System.out.println(" 	   this.val : " + ++this.val);
				System.out.println("Outer.this.val  : " + ++Outer.this.val);
			};
			f.myMethod();
		}
	}
}

public class LamdaEx3 {

	
	public static void main(String[] args) {
		Outer outer =new Outer();
		Outer.Inner inner = outer.new Inner();
		inner.method(100);
	}
}
