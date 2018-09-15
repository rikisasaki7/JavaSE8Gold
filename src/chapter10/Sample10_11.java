/**
 * 
 */
package chapter10;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Riki
 * マルチスレッド
 * ArrayListとSetの同期化拡張
 */
public class Sample10_11 {

	public static void main(String[]args){
		ArrayList<String> list = new ArrayList<String>();
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
	}
}
