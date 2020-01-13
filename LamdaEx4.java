package lamda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@FunctionalInterface
interface MyFunction4<T,U>{
	void accept(T t, U u);
}



//제네릭은 메소드에서도 적용할 수 있다는점.
//HASHMAP의 반복문사용을 익숙해져야된다.
//MAP 인터페이스의 forEach함수를 직접구현한 함수 myForEach
public class LamdaEx4 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<10; i++) {
			list.add(i);
		}
		
		list.forEach((Integer action)-> System.out.print(action+","));
		System.out.println();
			
		list.removeIf(x-> x%2==0 || x%3==0);	//Predicate<T> 인터페이스 T는 매개변수 반환값은 BOOLEAN
		System.out.println(list);
		
		list.replaceAll(i-> i*10);		//10씩 곱하기 uUnaryOperator<T> 인터페이스  T가 매개변수 T가 리턴값 매개변수와 리턴값이 같다.
		System.out.println(list);
		
		Map<String, String> map = new HashMap<>();
		map.put("1","1");
		map.put("2","2");
		map.put("3","3");
		map.put("4","4");
		
		Map<Integer, Integer> map2 = new HashMap<>();
		map2.put(1,1);
		map2.put(2,2);
		map2.put(3,3);
		map2.put(4,4);
		
		map.forEach((k,v)->System.out.println("{"+k+","+v+"}") );
		
		myForEach((k,v)->System.out.println("{"+k+","+v+"}"),map);
		myForEach((k,v)->System.out.println("{"+k+","+v+"} my"),map2);
	}
	
	

	public static<T,U> void myForEach(MyFunction4<T,U>  f,Map<T,U> map) {		
		for(T key : map.keySet()){
			f.accept(key, map.get(key));
		}
	}
}
