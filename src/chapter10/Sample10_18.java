/**
 * 
 */
package chapter10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Riki
 * マルチスレッド
 * スレッドのプール
 * ExecutorService.newCachedThreadPool <-サンプル
 * ExecutorService.newFixedThreadPool <-サンプル
 * ScheduledExecutorService.newScheduledThreadpool
 * 
 * newCachedThreadPoolを使うと結果はこんなになる。
 * 新規スレッドを作成するスレッドプールを作るが、以前に作成されたスレッドが利用可能であれば再利用する
 * pool-1-thread-2:start
 * pool-1-thread-4:start
 * pool-1-thread-3:start
 * pool-1-thread-1:start
 * pool-1-thread-5:start
 * pool-1-thread-2:end
 * pool-1-thread-3:end
 * pool-1-thread-5:end
 * pool-1-thread-1:end
 * pool-1-thread-4:end
 * 
 * newFixedThreadPoolを使うと結果はこんなになる。
 * 固定数のスレッドを再利用するスレッドプールを作成する。引数で指定したかずのスレッドが全てアクティブ（タスク実行中）
 * であると、スレッドが使用可能になるまで待機する。（以下は可能数に２を指定した場合）
 * pool-1-thread-2:start
 * pool-1-thread-1:start
 * pool-1-thread-1:end
 * pool-1-thread-2:end
 * pool-1-thread-1:start
 * pool-1-thread-2:start
 * pool-1-thread-2:end
 * pool-1-thread-1:end
 * pool-1-thread-2:start
 * pool-1-thread-2:end
 * 
 * 
 */
public class Sample10_18 {

	public static void main(String[]args){
		ExecutorService service = null;
		try{
//			service = Executors.newCachedThreadPool();
			service = Executors.newFixedThreadPool(2);
			Runnable task = () -> {
				String name = Thread.currentThread().getName();
				System.out.println(name + ":start");
				try{
					Thread.sleep(3000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				System.out.println(name + ":end");
			};
			for(int i=0;i<5;i++){
				service.execute(task);
			}
		} finally{
			if(service != null) service.shutdown();
		}
	}
}
