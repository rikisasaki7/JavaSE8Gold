/**
 * 
 */
package chapter10;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Riki
 * マルチスレッド
 * スレッドセーフなcollect
 * groupingByConcurrentメソッドとtoConcurentMapメソッド
 */
public class Sample10_29 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Stream<String> stream1 = Stream.of("belle", "aki", "maki", "aho", "bob").parallel();
		Map<String, List<String>> map1 = 
			stream1.collect(
					Collectors.groupingByConcurrent(s -> s.substring(0, 1))); // この関数に従ってグループ化したMapを返す 
					// グループ化したMapに対して行いたい処理があったら第二引数に指定する。
		System.out.println(map1);
		System.out.println("map1のクラス名：" + map1.getClass());
		
		Stream<String> stream2 = Stream.of("nao", "akko", "ami").parallel();
		Map<Integer, String> map2 = 
			stream2.collect(
					Collectors.toConcurrentMap(
						String::length, // 第一引数、キーを指定する
						s -> s, // 第二引数、値を指定する
						(s1, s2) -> s1 + " : " + s2)); // 第三引数、まーじ処理を指定する。
		System.out.println(map2);
		System.out.println("map2のクラス名：" + map2.getClass());
	}

}
