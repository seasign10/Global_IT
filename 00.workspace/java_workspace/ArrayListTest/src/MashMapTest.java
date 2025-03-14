import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MashMapTest {

	public static void main(String[] args) {
		Map<String,String> colors=new HashMap<String,String>();
		colors.put("red", "#ff0000");
		colors.put("green", "#00ff00");
		colors.put("blue", "#0000ff");
		System.out.println(colors.get("red"));
		System.out.println(colors.get("green"));
		System.out.println(colors.get("blue"));
		
		// 키 읽어오기
		Set<String> keySet=colors.keySet();
		for(String k:keySet) {
			System.out.println(colors.get(k));
		}
	}

}
