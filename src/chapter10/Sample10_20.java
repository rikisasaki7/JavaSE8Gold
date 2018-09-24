/**
 * 
 */
package chapter10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Riki
 * マルチスレッド
 * アトミック - syncronizedが保証された各クラス群。ロック制御のコーディングをせずに計算などを行える。
 */
public class Sample10_20 {

	public static void main(String[]args) throws InterruptedException {
		IntegerTest obj = new IntegerTest();
		exec(() -> obj.addSyncInteger());
		exec(() -> obj.addAtomicInteger());
		obj.showData();
	}
	
	private static void exec(Runnable task) throws InterruptedException {
		ExecutorService service = null;
		try{
			service = Executors.newFixedThreadPool(100);
			for(int i=0;i<10000;i++){
				service.submit(task);
			}
			service.awaitTermination(10, TimeUnit.SECONDS);
		}finally{
			if(service != null) service.shutdown();
		}
	}
}

class IntegerTest {
	private Integer syncInteger;
	private final AtomicInteger atomicInteger;
	public IntegerTest(){
		syncInteger = 0;
		atomicInteger = new AtomicInteger(0);
	}
	
	synchronized public void addSyncInteger(){
		syncInteger++;
	}
	
	public void addAtomicInteger(){
		atomicInteger.getAndIncrement(); // 更新前の値を返す
//		atomicInteger.incrementAndGet(); // 更新後の値を返す
//		atomicInteger.addAndGet(5); // 更新した値を返す
//		atomicInteger.compareAndSet(1, 10); // 第１引数の値に一致した場合、第２引数で更新する。更新できたらtrueを返す
//		atomicInteger.get(); // 現在の値をただ返す
	}
	
	public void showData(){
		System.out.println("syncInt:" + syncInteger);
		System.out.println("atomicInt:" + atomicInteger);
	}
}