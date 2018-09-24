/**
 * 
 */
package chapter10;

import java.util.Arrays;

/**
 * @author Riki
 * マルチスレッド
 * パラレル処理でのパイプライン
 * ー＞中間処理と終端処理は別々だから、パラレルストリームの場合はパラレルに処理される。
 * ー＞実行結果は実行ごとに異なる。
 */
public class Sample10_24 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Arrays.asList("seq", "hana", "ken", "mika") // シーケンシャルストリーム
			.stream()
			.map(s -> {
				System.out.print(s + " ");
				return s.toUpperCase();})
			.forEach(s -> System.out.print(s + " ")); // 結果：「seq SEQ hana HANA ken KEN mika MIKA 」
			// map中間処理の後にforEach終端処理が実行されている。
		
		System.out.println(); // 改行

		Arrays.asList("parallel", "hana", "ken", "mika") // パラレルストリーム
			.parallelStream()
			.map(s -> {
				System.out.print(s + " ");
				return s.toUpperCase();})
			.forEach(s -> System.out.print(s + " ")); // 結果：「ken KEN mika MIKA hana parallel HANA PARALLEL 」
			// map中間処理とforEachの終端処理が並行で行われている。
	}

}
