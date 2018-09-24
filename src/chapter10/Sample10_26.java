/**
 * 
 */
package chapter10;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author Riki
 * マルチスレッド
 * findAnyとfindFirst
 */
public class Sample10_26 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		List<String> data = Arrays.asList("c", "a", "d", "b");
		Optional<String> result1 = data.parallelStream().findFirst(); // パラレルでも変わらない。しかし処理が重くなる
		Optional<String> result2 = data.parallelStream().findAny();
		System.out.println(result1.get() + " " + result2.get());

		// 他にも順序に依存する以下メソッドは処理が重くなる。しかしパラレルでもシーケンシャルでも結果は変わらない。
		// limit
		// skip
		

	}

}
