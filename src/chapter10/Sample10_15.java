/**
 * 
 */
package chapter10;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Riki
 * マルチスレッド
 * submit 2
 */
public class Sample10_15 {

	public static void main(String[]args){
		ExecutorService service = null;
		try{
			service = Executors.newSingleThreadExecutor();
			Future<Date> result = service.submit(() -> new Date()); // Sample10_14との違いはここ。submitの引数がCallableになっている。戻り値を返せる。
			System.out.println(result.get());
		} catch (InterruptedException | ExecutionException e){
			e.printStackTrace();
		} finally {
			if(service != null) service.shutdown();
		}
	}
}
