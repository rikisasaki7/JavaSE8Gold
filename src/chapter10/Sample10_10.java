/**
 * 
 */
package chapter10;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Riki
 * マルチスレッド
 * ConcurrentHashMapの利用
 */
public class Sample10_10 {

	public static void main(String[]args){
		Map<Integer, String> map = new ConcurrentHashMap<>();
		map.put(1, "aaa");
		map.put(2, "bbb");
		for(Integer key : map.keySet()){ map.remove(key); } // 普通のmapの時は例外が起きていたけど、今度は起きない。
	}
}
