/**
 * 
 */
package chapter10;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Riki
 * マルチスレッド
 * 並列コレクション
 */
public class Sample10_08 {

	public static void main(String[] args){
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "tanaka");
		map.put(2, "urail");
//		map.remove(1);
//		map.remove(2);
		for(Integer key : map.keySet()){map.remove(key);}
		// スレッドが反復処理をしている間に、そのコレクションを操作することは許されない。
		// forより上のremoveをコメントアウトすると<code>ConcurrentModificationException</code>が発生する。
		// フェイルファストイテレータと呼ばれる↓
		// https://docs.oracle.com/javase/jp/8/docs/api/java/util/ConcurrentModificationException.html

		// 反復処理中にコレクションに変更がある場合に即座に例外を投げるように作られているイテレータ
		// この例でいうとkeysetでイテレータ取得したから。
		// スレッドセーフなイテレータを使用する必要がある。SE5以前はsynchronizedを使用していた。
		
		// SE5以前の例
//		List list = Collections.synchronizedList(new ArrayList());
	}
}
