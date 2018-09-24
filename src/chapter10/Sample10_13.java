/**
 * 
 */
package chapter10;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Riki
 * Executorインタフェース - new Threadとかの代わりに使うやつ。threadプールとかsingleとかいろいろしてくれる
 * newSingleThreadExecutor
 */
public class Sample10_13 {

	public static void main(String[]args){
		ExecutorService service = null; // この書き方お作法みたい
		try{
			service = Executors.newSingleThreadExecutor(); // staticファクトリメソッド
			System.out.println("service.execute()");
			String s = "*";
			for(int i=0;i<3;i++){
				service.execute(() -> { // executeの引数は<code>Runnable</code>インタフェースなのでラムダ式が使える
					// また、Executorを継承しているためexecuteをつかえる
					System.out.print("thread task ");
					for(int a=0;a<5;a++){
						try{
							Thread.sleep(100);
							System.out.print(s);
						} catch (InterruptedException e){
							e.printStackTrace();
						}
					}
					System.out.println();
				});
			}
		} finally {
			service.shutdown(); // ExecutorServiceの終了。新しいタスクを受け付けない。登録済みのタスクは実行される。
//			System.out.println("shutdownNow=====-");
//			List<Runnable> l = service.shutdownNow(); // shutdownNowは即座にタスクを終了させ、待機していたタスクのリストを返す。
//													  // 実行した場合はInterruptedExceptionが発生する。
//			System.out.println(l);
			System.out.println("isShutDown:" + service.isShutdown()); //タスク受け入れをNGにする
			System.out.println("ex.shutdown()");
		}
		System.out.println("isTerminated: " + service.isTerminated()); // 全てのたすくが終了していればtrue
	}
}
