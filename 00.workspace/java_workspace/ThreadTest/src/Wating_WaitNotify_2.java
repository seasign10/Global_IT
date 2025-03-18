class DataBox2{
	boolean isEmpty=true;
	int data;
	synchronized void inputData(int data) {
		if(!isEmpty) {
			try {wait();}catch(InterruptedException e) {} // waiting
		}
		this.data=data;
		isEmpty=false;
		System.out.println("입력 데이터: "+data);
		notify();
	}
	synchronized void outputData() {
		if(isEmpty) {
			try {wait();}catch(InterruptedException e) {} // waiting
		}
		isEmpty=true;
		System.out.println("출력 데이터: "+data);
		notify();
	}
}
public class Wating_WaitNotify_2 {

	public static void main(String[] args) {
		DataBox2 dataBox=new DataBox2();
		Thread t1=new Thread() {
			@Override
			public void run() {
				for(int i=1;i<9;i++) {
					dataBox.inputData(i);
				}
			};
		};
		Thread t2=new Thread() {
			@Override
			public void run() {
				for(int i=1;i<9;i++) {
					dataBox.outputData();
				}
			};
		};
		
		t1.start();
		t2.start();
	}

}
