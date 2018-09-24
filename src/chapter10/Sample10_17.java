/**
 * 
 */
package chapter10;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Riki
 * マルチスレッド
 * タスクのスケジュール
 */
public class Sample10_17 {

	public static void main(String[]args){
		ScheduledExecutorService service = null;
		try{
			service = Executors.newSingleThreadScheduledExecutor();
			Runnable task = () -> System.out.println(new Date());
			// scheduleWithFixedDelay:
			// 第２引数：有効になるまでの時間
			// 第３引数：タスク終了してから次いつ実行するか
			// ↓だと、５秒後にタスクが実行され、以降、タスクが終了してから１秒ごとにタスクが実行される。　
//			service.scheduleWithFixedDelay(task, 5, 1, TimeUnit.SECONDS);
			
			// scheduleAtFixedDelay:
			// 第２引数：有効になるまでの時間
			// 第３引数：タスクが始まってから次いつ実行するか
			// ↓だと、５秒後にタスクが実行され、以降、タスクが開始されてから１秒ごとにタスクが実行される。　
			service.scheduleAtFixedRate(task, 5, 1, TimeUnit.SECONDS);
			Thread.sleep(10000);
		} catch (InterruptedException e){
			e.printStackTrace();
		} finally {
			if(service != null) service.shutdown();
		}
	}
}
