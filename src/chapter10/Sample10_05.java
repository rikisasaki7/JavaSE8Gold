/**
 * 
 */
package chapter10;

/**
 * @author Riki
 * マルチスレッド
 * 排他制御と同期制御
 */
public class Sample10_05 {

	public static void main(String[]args){
		Share share = new Share();
		ThreadSyncA threadA = new ThreadSyncA(share);
		ThreadSyncB threadB = new ThreadSyncB(share);
		threadA.start();threadB.start();
	}
}

class Share { // 共有して使用されるオブジェクト
	private int a = 0;
	private String b;
	public void set(){
		a++; b = "data";
		System.out.println("set() a: " + a + ", b: " + b);
	}
	public void print(){
		a--; b = null;
		System.out.println("print() a: " + a + ", b: " + b);
	}
}

class ThreadSyncA extends Thread{
	private Share share;
	public ThreadSyncA(Share share){ this.share = share; }
	public void run(){
		for(int i=0;i<5;i++){ share.set(); }
	}
}

class ThreadSyncB extends Thread{
	private Share share;
	public ThreadSyncB(Share share){ this.share = share; }
	public void run(){
		for(int i=0;i<5;i++){ share.print(); }
	}

}