class MyThread extends Thread{
	@Override
	public void run() {
		// 쓰레드가 해야할 일
		for(int i=0; i<100; i++) {
			System.out.println("Thread 1");
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class MyThread2 extends Thread{
	// 쓰레드가 해야할 일
	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println("Thread 2");
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
public class ThreadTest {

	public static void main(String[] args) {
		MyThread t1=new MyThread();
		t1.start(); // t1을 JVM에 등록. run()메서드가 바로 실행되는 것이 아님
		MyThread2 t2=new MyThread2();
		t2.start(); // t2을 JVM에 등록. run()메서드가 바로 실행되는 것이 아님
		
		// 1과 2가 번갈아 출력(동시에 출력되고 있는 것)
	}

}
