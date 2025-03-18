class MyThread1 extends Thread{
	@Override
	public void run() {
		try {
			Thread.sleep(3000);
		}catch(InterruptedException e) {
			System.out.println("sleep()진행 중 interrupted()발생");
			for(long i=0;i<1000000000L;i++) {} // 시간지연
		}
	}
}
public class TimeWaiting_Sleep {

	public static void main(String[] args) {
		 MyThread1 myThread=new MyThread1();
		 myThread.start();
		 try {
			Thread.sleep(100);
		}catch(InterruptedException e) {}
		 System.out.println("My Thread State1 = "+myThread.getState());
		 myThread.interrupt(); // Thread interrupt
		try {
			Thread.sleep(100);
		}catch(InterruptedException e) {}
		System.out.println("My Thread State2 = "+myThread.getState());					
	}

}
