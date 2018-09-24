/**
 * 
 */
package chapter10;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author Riki
 * マルチスレッド
 * collect
 */
public class Sample10_28 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		List<String> data = Arrays.asList("orange", "banana", "lemon");
		List<String> list = 
			data.parallelStream()
				.collect(
					() -> new CopyOnWriteArrayList<>(), //第一引数、collectの結果を格納するオブジェクト
					(plist, s) -> plist.add(s.toUpperCase()), // 第二引数、要素ごとに行う処理
					(alist, blist) -> alist.addAll(blist)); // 第三引数、集約結果のマージ処理
		for(String s : list){System.out.print(s + " ");}
		
		System.out.println(); // 改行
		
		Set<String> set = 
			data.parallelStream()
				.collect(
					CopyOnWriteArraySet::new, // メソッド参照を使用した例
					Set::add,
					Set::addAll);
		for(String e : set){System.out.print(e + " ");}

	}

}
