/**
 * 
 */
package chapter10;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author Riki
 * マルチスレッド
 * タスクのスケジュール
 * -><code>ExecutorService</code>インタフェースを継承した
 *   <code>ScheduledExecutorService</code>インタフェースを使用する
 */
public class Sample10_16 {

	public static void main(String[]args){
		ScheduledExecutorService service = null;
		try{
			service = Executors.newSingleThreadScheduledExecutor(); // スケジュールをしたかったらこっちのstaticファクトリを使う
			// タスク１
			Runnable task1 = () -> System.out.println("task1");
			// タスク２
			Callable task2 = () -> new Date();

			// 第２引数経過後に有効になるタスクをスケジュールする
			// commandにRunnableを指定するので、戻り値の型パラメータは「?」
			ScheduledFuture<?> result1 = service.schedule(task1, 3, TimeUnit.SECONDS); 
			// commandにCallableを指定するので、戻り値の型パラメータは「Date」
			ScheduledFuture<?> result2 = service.schedule(task2, 1, TimeUnit.MILLISECONDS);
		} finally {
			if(service != null) service.shutdown();
		}
	}
}
