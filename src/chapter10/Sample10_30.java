package chapter10;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

/*
 * マルチスレッド
 * FORK/JOIN RecursiveAction 戻り値無
 */
public class Sample10_30 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Double[] nums = new Double[10];
		ForkJoinTask<?> task = new ExamRecursiveAction("main", nums, 0, 10);
		ForkJoinPool pool = new ForkJoinPool(); // タスクの実行には<code>ForkJoinPool</code>を使用する
		pool.invoke(task); // タスクを実行する。引数はRecursiveActionクラスを継承したクラス
	}

}

class ExamRecursiveAction extends RecursiveAction {

	private Double[] nums;
	private int start;
	private int end;
	public ExamRecursiveAction(String name, Double[]nums, int start, int end){
		System.out.println("name:" + name + ", start:" + start + ", end:" + end);
		this.nums = nums;
		this.start = start;
		this.end = end;
	}

	protected void compute(){
		if(end - start <= 3){ // 分割統治法を用いる。computeの中の分岐は丁度半分になるように設定する
			for(int i=start;i<end;i++){
				nums[i] = Math.random() * 100;
				System.out.println("nums[" + i + "] " + nums[i]);
			}
		}else{
			int middle = start + (end-start)/2;
			System.out.println("start:" + start + ", middle:" + middle + ", end:" + end);
			invokeAll(new ExamRecursiveAction("f1", nums, start, middle), new ExamRecursiveAction("f2", nums, middle, end));
		}
	}
}