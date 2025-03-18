class KeyValue<K,V>{
	// 객체 생성시 지정된 인자로 타입이 지정됨
	private K key; // type 자리에 K
	private V value; // type 자리에 V
	public K getKey() {
		return key;
	}
	public V getValue() {
		return value;
	}
	public void setKey(K key) {
		this.key=key;
	}
	public void setValue(V value) {
		this.value=value;
	}
}
public class TowGeneric {

	public static void main(String[] args) {
		KeyValue<String, Integer> kv1=new KeyValue<>(); // <>생략시 타입 추론
		kv1.setKey("사과");
		kv1.setValue(1000);
		String key1=kv1.getKey();
		int value1=kv1.getValue();
		System.out.println("key: "+key1+", value: "+value1);
		
		// Void 사용하지 않겠다는 의미
		KeyValue<String, Void> kv2=new KeyValue<>(); // KeyType<> => type추론
		kv1.setKey("키 값만 사용");
		String key2=kv1.getKey();
		System.out.println("key: "+key2);
	}

}
