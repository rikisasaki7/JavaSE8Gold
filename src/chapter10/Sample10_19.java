/**
 * 
 */
package chapter10;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Riki
 * マルチスレッド
 * スレッドプール
 * CyclicBarrier - 特定の処理に全てのスレッドが到達するまで待たせる
 * 
 * exec内でawaitをしない場合は以下出力　＜ーパラレルでRunnableタスクが実行される
 * a a b a b c c b c 
 * 
 * exec内でawaitをする場合は以下出力　＜ー待機が効いた状態でRunnableタスクが実行される
 * a a a b b b task c c c 
 * taskについては下の記述を参照
 */
public class Sample10_19 {

	void a() {System.out.print("a ");}
	void b() {System.out.print("b ");}
	void c() {System.out.print("c ");}
	
	void exec(CyclicBarrier c1, CyclicBarrier c2){
		try{
			a();
			c1.await();
			b();
			c2.await();
			c();
		}catch(BrokenBarrierException | InterruptedException e){
			e.printStackTrace();
		}
	}

	public static void main(String[]args){
		ExecutorService service = null;
		try{
			service = Executors.newFixedThreadPool(3);
			CyclicBarrier c1 = new CyclicBarrier(3); // 待機状態にするスレッド数を指定する。
			CyclicBarrier c2 = new CyclicBarrier(3, // Runnableでは、最後バリアポイントを通過したスレッドに実行させるタスクを定義する。
					() -> System.out.print("task "));
			for(int i=0;i<3;i++){
				service.execute(() -> new Sample10_19().exec(c1, c2));
			}
		}finally{
			if(service != null) service.shutdown();
		}
	}
}
