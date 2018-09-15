/**
 * 
 */
package chapter10;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Riki
 * マルチスレッド
 * ArrayListとSetの同期化拡張
 * この他にも以下が提供されている。
 * <code>NavigableMap</code>インタフェース
 *  <code>SortedMap</code>インテフェースのサブインタフェース
 *  指定されたキーに対し、もっとも近い値を返す。
 *  実装クラスとしては<code>TreeMap</code>がある
 *  同期性をサポートしているのは<code>ConcurrentSkipListMap</code>
 * 
 * <code>NavigableSet</code>インタフェース
 *  <code>SortedSet</code>インテフェースのサブインタフェース
 *  指定されたキーに対し、もっとも近い値を返す。
 *  実装クラスとしては<code>TreeSet</code>がある
 *  同期性をサポートしているのは<code>ConcurrentSkipListSet</code>
 */
public class Sample10_12 {

	public static void main(String[]args){
//		ArrayList<String> list = new ArrayList<String>();
		List<String> list = new CopyOnWriteArrayList<>(); // ここがsample11と違う
		list.add("a");list.add("b");list.add("c");list.add("d");
		new Thread(() ->{
			Iterator<String> itr = list.iterator();
			while(itr.hasNext()){
				System.out.println("Thread-A:" + itr.next());
				try{
					Thread.sleep(5000);
				} catch (InterruptedException e){
					e.printStackTrace();
				}
			}
		}).start();
		try{
			Thread.sleep(1000);
		} catch (InterruptedException e){
			e.printStackTrace();
		}
		list.add("e"); System.out.println("main:add()"); // ThreadAで使用しているlistに変更を加えているため、
														 // <code>ConcurrentModificationException</code>が発生する。->sample12へ
		list.remove(2);System.out.println("main:remove()");
		for(String s : list){System.out.print(s);} // <-こっちにはeが反映されている。
		// CopyOnWriteArrayListはイテレータを作成した時点の状態を参照するため、
		// eは追加されていない。また、removeも出力結果に反映されていない。
	}	
}
