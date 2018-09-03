/**
 * 
 */
package chapter10;

/**
 * @author Riki
 * マルチスレッド
 * interruptedやsleepなど、threadクラスのメソッド挙動確認
 * sleep終了後、即座に実行されるわけではない。実行可能状態に変わるだけであることに注意。
 * そのため、sleepで指定する時間はスレッドが再開されるまでの最短時間であるにとどまる。
 */
public class Sample10_04 {

	public static void main(String[]args){
		Thread threadA = new Thread(() ->{
			System.out.println("threadA: sleep開始");
			try{
				System.out.println(String.format("currentThread: %s", Thread.currentThread()));
				Thread.sleep(5000); // ThreadAのsleep
			} catch(InterruptedException e){
				System.out.println("threadA: 割り込みをキャッチしました。");
			}
			System.out.println("threadA: 処理再開");
		});
		threadA.start();
		System.out.println(String.format("getName: %s", threadA.getName()));
		System.out.println(String.format("getPriority: %d", threadA.getPriority()));
		threadA.setPriority(Thread.MAX_PRIORITY);
		System.out.println(String.format("getPriority: %d", threadA.getPriority()));
		
		try{
			System.out.println("main: sleep開始");
			Thread.sleep(2000); // mainのsleep
			System.out.println("main: sleep終了");
			threadA.interrupt();
			Thread.yield(); // 現在実行しているスレッドを一時的に休止し、他のスレッドに実行の機会を与える
			threadA.join(); // 実行中のスレッドが終わるまで待機する
		} catch(InterruptedException e){
			System.out.println("main: 割り込みをキャッチしました。");
		}
	}
}
