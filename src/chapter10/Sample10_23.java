/**
 * 
 */
package chapter10;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Riki
 * マルチスレッド
 * パラレルストリーム
 * シーケンシャル処理とパラレル処理の実行時間比較
 * ー＞マルチスレッドをするだけに十分なCPU、数が多いストリームのときには速度が早くなる可能性あり。
 * ー＞パラレルはその分分散に伴うオーバーヘッドが発生するため。（処理重いため）
 */
public class Sample10_23 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		IntStream stream = IntStream.rangeClosed(1, 3000);
		List<Integer> list = stream.boxed() // ボクシングするだけ
				.collect(Collectors.toList());
		long start = System.nanoTime();
		new Sample10_23().foo(list);
		System.out.print("time: ");
		System.out.println(System.nanoTime() - start);

	}
	
	void foo(List<Integer> list){
//		long count = list.stream().map(a -> task(a)).count(); // シーケンシャル処理、実行時間：「time: 18490082971」
		long count = list.parallelStream().map(a -> task(a)).count(); // パラレル処理、実行時間：「time: 4658524270」＜ー短い
		System.out.println("count: " + count);
	}
	
	int task(int num){
		try{
			Thread.sleep(5);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		return ++num;
	}
}
