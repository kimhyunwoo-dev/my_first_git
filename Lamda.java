package lamda;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface MyFunction2<T>{
	boolean run(T x);
}

public class Lamda {
	static List<Integer> list = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		for(int i=0; i<10; i++) {
			list.add(i);
		}
		
		//MyFunction2 f = x-> x%2==0 || x%3==0; 
		removeIf((Integer x)-> x%2==0 );
		
		list.forEach(action-> System.out.println(action));
	}
	
	public static void removeIf(MyFunction2<Integer> f) {
		for(int i=0; i<list.size(); i++) {
			if(f.run(list.get(i))) {
				System.out.println(list.get(i));
				list.remove(i);
			}
		}
		
	}
}
