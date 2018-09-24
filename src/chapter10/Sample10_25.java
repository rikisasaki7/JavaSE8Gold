/**
 * 
 */
package chapter10;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Riki
 * マルチスレッド
 */
public class Sample10_25 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Arrays.asList("1", "a", "b", "c", "d", "e")
			.parallelStream()
			.forEachOrdered(s -> System.out.print(s + " ")); // forEachOrdered：各要素が検出順に処理される終端操作。しかしパフォーマンスが悪くなる。
			// 実行結果：「1 a b c d e 」
		
		System.out.println(); // 改行
		
		List<String> list = new CopyOnWriteArrayList<String>();
		Arrays.asList("2", "a", "b", "c", "d", "e")
			.parallelStream()
			.map(s -> {
				list.add(s);
				return s.toUpperCase();})
			.forEachOrdered(s -> System.out.print(s + " "));
			// 実行結果：「2 A B C D E 」
		System.out.println(); // 改行
		for(String s : list){ System.out.print(s + " ");}
		// 実行結果：「e c d b a 2 」 ＜ー処理されているのはパラレルであることがわかる
	}
}
