class MThread implements Runnable{
	@Override
	public void run() {
		// 쓰레드가 해야할 일
		for(int i=0; i<10000; i++) {
			System.out.println("Thread 1");
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
public class ThreadTest2 {

	public static void main(String[] args) {
		MThread t1=new MThread();
		Thread mythread1=new Thread(t1);
		mythread1.setDaemon(true); // 데몬쓰레드로 설정(start()전에 호출)
		mythread1.start(); // t1을 JVM에 등록. run()메서드가 바로 실행되는 것이 아님
		
		// 일반쓰레드는 다른 쓰레드 종료여부와 상관없이 자신의 작업이 종료될 때까지 계속 수행
		// 모든 일반쓰레드(사용자쓰레드)가 모두 종료되면 작업이 완료디지 않았어도 함께 종료
		System.out.println("main쓰레드 종료");
	}
}
