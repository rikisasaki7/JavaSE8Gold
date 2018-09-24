/**
 * 
 */
package chapter10;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Riki
 * マルチスレッド
 * パラレルストリーム
 * ストリームの生成には<code>Collection</code>インタフェースか<code>BaseStream</code>インタフェースを使用する
 */
public class Sample10_21 {

	public static void main(String[]args){
		List<String> data = Arrays.asList("aaa", "bb", "c");
		Stream<String> pStream1 = data.parallelStream(); // パラレルストリームの生成。インタフェースは通常のStreamと一緒。
		System.out.println("pStream1: " + pStream1.isParallel());
		Stream<String> sStream2 = data.stream(); // 通常のストリームの生成
		System.out.println("sStream2: " + sStream2.isParallel());
		Stream<String> pStream2 = sStream2.parallel();
		System.out.println("pStream2: " + pStream2.isParallel());
		IntStream pStream3 = IntStream.range(0,10).parallel();
		System.out.println("pStream3: " + pStream3.isParallel());
	}
}
