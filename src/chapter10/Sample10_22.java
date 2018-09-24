/**
 * 
 */
package chapter10;

import java.util.Arrays;

/**
 * @author Riki
 * マルチスレッド
 * パラレルストリーム
 */
public class Sample10_22 {

	public static void main(String[]args){
		Arrays.asList("stream", "a", "b", "c", "d", "e")
			.stream()
			.forEach(s -> System.out.print(s + " ")); // シーケンシャルに処理するからこんなになる（結果は同じ）「stream a b c d e 」
		System.out.println(); // 改行
		
		Arrays.asList("parallelStream", "a", "b", "c", "d", "e")
		.parallelStream()
		.forEach(s -> System.out.print(s + " ")); // パラレルに処理するからこんなになる（結果は異なる）「c e a d b parallelStream 」
		
	}
}
