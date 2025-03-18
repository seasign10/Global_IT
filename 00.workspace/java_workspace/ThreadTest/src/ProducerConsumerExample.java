class SharedBuffer {
    private int data;
    private boolean available = false;

    // 데이터 생성 (생산자)
    public synchronized void produce(int data) throws InterruptedException {
        while (available) {
            wait();  // 소비자가 소비할 때까지 대기
        }
        this.data = data;
        available = true;
        System.out.println("생산자: " + data + " 생산");
        notify();  // 소비자에게 데이터가 준비되었음을 알림
    }

    // 데이터 소비 (소비자)
    public synchronized int consume() throws InterruptedException {
        while (!available) {
            wait();  // 생산자가 데이터를 생산할 때까지 대기
        }
        available = false;
        System.out.println("소비자: " + data + " 소비");
        notify();  // 생산자에게 자리를 비워주었음을 알림
        return data;
    }
}

class Producer extends Thread {
    private SharedBuffer buffer;

    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                buffer.produce(i);  // 데이터를 생산
                Thread.sleep(1000);  // 1초 대기
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer extends Thread {
    private SharedBuffer buffer;

    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                buffer.consume();  // 데이터를 소비
                Thread.sleep(1500);  // 1.5초 대기
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ProducerConsumerExample {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();  // 공유 버퍼 생성

        Producer producer = new Producer(buffer);  // 생산자 생성
        Consumer consumer = new Consumer(buffer);  // 소비자 생성

        producer.start();  // 생산자 스레드 시작
        consumer.start();  // 소비자 스레드 시작
    }
}
