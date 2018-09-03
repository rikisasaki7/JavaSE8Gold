/**
 * 
 */
package chapter10;

/**
 * @author Riki
 * マルチスレッド
 * ②Runnableインタフェースを実装する
 *
 */
public class Sample10_02 {

	public static void main(String[]args){
		ThreadRunnableA threadA = new ThreadRunnableA();
		ThreadRunnableB threadB = new ThreadRunnableB();		
		Thread a = new Thread(threadA);
		Thread b = new Thread(threadB);
		a.start();
		b.start();
	}
}

class ThreadRunnableA implements Runnable {
	public void run(){
		for(int i=0;i<10;i++){
			System.out.print("A" + i + " ");
		}
	}
}
class ThreadRunnableB implements Runnable {
	public void run(){
		for(int i=0;i<10;i++){
			System.out.print("B" + i + " ");
		}
	}
}