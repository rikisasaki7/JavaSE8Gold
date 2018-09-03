/**
 * 
 */
package chapter10;

/**
 * @author Riki
 * マルチスレッド
 * 同期制御と排他制御
 * 排他制御をするためのsynchronized
 * synchronizedの構文：
 * １．メソッド単位で排他制御をするとき
 * synchronized void add(){...}
 * ２．部分的にブロック指定するとき
 * void add(){
 * 	 synchronized(ロック対象のオブジェクト){...}
 * }
 * ３．自オブジェクトをロック対象とする場合
 * void add(){
 *   synchronized(this){...}
 * }
 * ４．staticメソッドを対象とする場合
 *  - staticの場合はクラスファイルのロード後、java.lang.Classクラス型を持つオブジェクトがJVMによって用意される。
 *  - クラスに対応するClassオブジェクトのロックを取得する。
 * public synchronized static void methodA(){
 *   public static void methodB{
 *     synchronized(Share.class)
 *   }
 * }
 */
public class Sample10_06 {
	public static void main(String[]args){
		ShareShare share = new ShareShare();
		ThreadSyncShareA threadA = new ThreadSyncShareA(share);
		ThreadSyncShareB threadB = new ThreadSyncShareB(share);
		threadA.start();threadB.start();
	}
}

class ShareShare { // 共有して使用されるオブジェクト
	private int a = 0;
	private String b;
	// 排他制御をするため、synchronizedを付与
	public synchronized void set(){
		a++; b = "data";
		System.out.println("set() a: " + a + ", b: " + b);
	}
	//排他制御をするため、synchronizedを付与
	public synchronized void print(){
		a--; b = null;
		System.out.println("print() a: " + a + ", b: " + b);
	}
}

class ThreadSyncShareA extends Thread{
	private ShareShare share;
	public ThreadSyncShareA(ShareShare share){ this.share = share; }
	public void run(){
		for(int i=0;i<5;i++){ share.set(); }
	}
}

class ThreadSyncShareB extends Thread{
	private ShareShare share;
	public ThreadSyncShareB(ShareShare share){ this.share = share; }
	public void run(){
		for(int i=0;i<5;i++){ share.print(); }
	}
}