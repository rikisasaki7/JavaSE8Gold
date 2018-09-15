/**
 * 
 */
package chapter10;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Riki
 * マルチスレッド
 * 並列コレクション
 * １．BlockingQueue(LinkedBlockingQueue - リンクノードに基づいたFIFOブロッキングキュー)
 * その他コレクション：
 * SynchronousQueue - BlockingQueueインタフェースを実装した基本的なきゆー
 * ArrayBlockingQueue - 配列に基づいたFIFOブロッキングキュー
 * PriorityBlockingQueue - キュー内の要素を指定された順序でソートするブロッキングキュー
 * DelayQueue - 遅延時間が経過後に飲み要素を取得できるブロッキングキュー
 * 
 * ※メモ
 * BlockingQueueインタフェースを実装していないが、同様にスレッドセーフなQueueインタフェースの実装クラスとして
 * <code>ConcurrentLinkedQueue</code>クラスも存在する。
 * こちらはブロッキングを使用していないため、高速であるという特徴を持つ
 * 
 * ２．BlockingDeque(LinkedBlockingDeque)
 * ※DeQue:FIFOのキューから要素を取り出すこと
 */
public class Sample10_09 {
	public static void main(String[] args){
		// BlockingQueueの例
		BlockingQueue<Double> queue = new LinkedBlockingQueue<>(3); // ダイヤモンド演算子
		new Thread(() -> { // キューに要素を追加するメソッド
			int i = 0;
			while(i < 100){
				try{
					queue.offer(Math.random(), 2, TimeUnit.SECONDS); // 1:追加する要素、2:タイムアウト値、3:タイムアウト単位
					// offerはキューに要素がいっぱいな場合に待つためタイムアウトを設定している
					System.out.println("offer(): " + queue.size());
					i++;
				} catch (InterruptedException e){
					e.printStackTrace();
				}
			}
		}).start();
		
		new Thread(() -> { // キューから要素を取得及び削除するスレッド
			int i = 0;
			while(i < 100){
				try{
					double pNum = queue.poll(2, TimeUnit.SECONDS);
					// pollはキューが空の場合に待つのでタイムアウトを設定している
					System.out.println("poll(); " + pNum);
					i++;
				} catch (InterruptedException e){
					e.printStackTrace();
				}
			}
		}).start();
		
		// BlockingDequeの例
		new Thread(() -> {
			int i = 0;
			while(i < 100){
				try{
					BlockingDeque<String> dqueue = new LinkedBlockingDeque<>();
//					dqueue.offer("a");
					dqueue.add("a"); // addは例外をスローする、offerはスローしないとかの違いみたい
					dqueue.offer("b", 10, TimeUnit.NANOSECONDS);
					dqueue.offerFirst("c", 20, TimeUnit.SECONDS);
					dqueue.offerLast("d", 30, TimeUnit.MILLISECONDS);
					System.out.println("peek:" + dqueue.peek());
					System.out.println(dqueue.getFirst());
					System.out.println(dqueue.getLast());
					dqueue.poll();
					dqueue.poll(7, TimeUnit.NANOSECONDS);
					dqueue.pollFirst(7, TimeUnit.SECONDS);
					dqueue.pollLast(7, TimeUnit.MILLISECONDS);
					i++;
				} catch (InterruptedException e){
					e.printStackTrace();
				}
			}
		}).start();
	}

}
