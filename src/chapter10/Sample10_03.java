/**
 * 
 */
package chapter10;

/**
 * @author Riki
 * マルチスレッド
 */
public class Sample10_03 {

	public static void main(String[]args){
		// 従来の匿名クラスを使用した実装
		new Thread(new Runnable(){
			public void run(){
				System.out.println("hello");				
			}
		}).start();
		
		// ラムダ式を使用した実装
		new Thread(() -> { // runメソッドは引数を持たないからこうなる
			System.out.println("hello!!");
		}).start();
	}
}
