/**
 * 
 */
package chapter10;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Riki
 * マルチスレッド
 * submit
 */
public class Sample10_14 {

	public static void main(String[] args){
		ExecutorService service = null;
		try{
			service = Executors.newSingleThreadExecutor();
			// タスクの登録と実行１
			Future<?> result1 = service.submit(() -> System.out.println("hello"));
			System.out.println(result1.get());
			// タスクの登録と実行２
			Future<Boolean> result2 = service.submit(() -> System.out.println("hello"), true);
			System.out.println(result2.get());
		} catch (InterruptedException | ExecutionException e){
			e.printStackTrace();
		} finally {
			if(service != null) service.shutdown();
		}		
	}

}
