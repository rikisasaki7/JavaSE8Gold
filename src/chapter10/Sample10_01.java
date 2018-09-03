/**
 * 
 */
package chapter10;

/**
 * @author Riki
 * マルチスレッド
 * ①Threadクラスのサブクラスを作成する
 */
public class Sample10_01 {

	public static void main(String[]args){
		// スレッドの作成
		ThreadA a = new ThreadA();
		ThreadB b = new ThreadB();
		// スレッドの実行開始
		a.start();
		b.start();
		// OSが管理している時分割で実行。出力はバラバラになる
	}
}

class ThreadA extends Thread { // スレッドクラス
	public void run(){
		for(int i=0;i<10;i++){
			System.out.print("A" + i + " ");
		}
	}
}

class ThreadB extends Thread { // スレッドクラス
	public void run(){
		for(int i=0;i<10;i++){
			System.out.print("B" + i + " ");
		}
	}
}