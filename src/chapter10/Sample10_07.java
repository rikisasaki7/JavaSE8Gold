/**
 * 
 */
package chapter10;

/**
 * @author Riki
 * マルチスレッド
 * 同期制御と排他制御
 * 同期制御
 */
public class Sample10_07 {
	public static void main(String[]args){
		SyncShare share = new SyncShare();
		ThreadSyncSyncShareA threadA = new ThreadSyncSyncShareA(share);
		ThreadSyncSyncShareB threadB = new ThreadSyncSyncShareB(share);
		threadA.start();threadB.start();
	}
}

class SyncShare{
	private int a = 0;
	private String b;
	// 排他制御をするため、synchronizedを付与
	// 同期制御をするため、waitを追加
	public synchronized void set(){
		System.out.println("set start");
		while(a != 0){
			try{
				System.out.println("set wait");
				wait();
				System.out.println("set wait解除");
			} catch(InterruptedException e){}
		}
		System.out.println("set notify1");
		notify();
		System.out.println("set notify2");
		a++; b = "data";
		System.out.println("set() a: " + a + ", b: " + b);
	}
	//排他制御をするため、synchronizedを付与
	public synchronized void print(){
		System.out.println("print start");
		while(b == null){
			try{
				System.out.println("print wait");
				wait();
				System.out.println("print wait解除");
			} catch(InterruptedException e){}
		}
		System.out.println("print notify1");
		notify();
		System.out.println("print notify2");
		a--; b = null;
		System.out.println("print() a: " + a + ", b: " + b);
	}	
}

class ThreadSyncSyncShareA extends Thread{
	private SyncShare share;
	public ThreadSyncSyncShareA(SyncShare share){ this.share = share; }
	public void run(){
		System.out.println(this.getName() + "start");
		for(int i=0;i<5;i++){ 
			System.out.println("A " + i);
			share.set(); 
		}
	}
}

class ThreadSyncSyncShareB extends Thread{
	private SyncShare share;
	public ThreadSyncSyncShareB(SyncShare share){ this.share = share; }
	public void run(){
		System.out.println(this.getName() + "start");
		for(int i=0;i<5;i++){
			System.out.println("B " + i);
			share.print(); 
		}
	}
}