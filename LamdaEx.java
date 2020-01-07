package lamda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@FunctionalInterface
interface MyFunction{
	public abstract int max(int a,int b);
}


public class LamdaEx {

	public static void main(String[] args) {
		
		
		List<String> list = Arrays.asList("abc","aaa","bbb","ddd","aaa");
		Collections.sort(list, (s1,s2)-> s2.compareTo(s1));
	
		MyFunction f = (a,b)->a>b ? a:b;
		
		LamdaEx.aMethod(f);
	}
	
	public static void aMethod(MyFunction f) {
		System.out.println(f.max(10, 20));
	}
	
	
}
