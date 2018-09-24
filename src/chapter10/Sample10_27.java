/**
 * 
 */
package chapter10;

import java.util.Arrays;

/**
 * @author Riki
 * マルチスレッド
 * reduceのパラレル処理
 */
public class Sample10_27 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Integer total = Arrays.asList(10, 20, 30, 40, 50)
				.parallelStream()
				.reduce(
						0, // 第一引：集約処理の初期値
						(sum, a) -> { // 第二引数：集約処理
							System.out.println("sum: " + sum + ", a: " + a);
							return sum += a;},
						(b, c) -> { // 第三引数：集約結果のマージ処理。パラレルストリームの場合のみ適用。
							System.out.println("b: " + b + ", c: " + c);
							return b + c;});
		System.out.println(total);
		// 要素を分割し、それぞれ第３引数で指定されたまーじ処理を実行していくイメージ。
		// 最後にはシーケンシャルな集約処理と同じ結果が返される。
	}
}
