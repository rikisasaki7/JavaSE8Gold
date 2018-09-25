package chapter10;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/*
 * マルチスレッド
 * FORK/JOIN RecursiveTask 戻り値あり
  */
public class Sample10_31 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Double nums[] = new Double[10];
		ForkJoinTask<Double> task = new ExamRecursiveTask("main", nums, 0, 10);
		ForkJoinPool pool = new ForkJoinPool();
		Double sum = pool.invoke(task);
		System.out.println("sum: " + sum);

	}

}

class ExamRecursiveTask extends RecursiveTask<Double> { // 型パラメータは処理結果の型を指定する。
	private Double[] nums;
	private int start;
	private int end;
	public ExamRecursiveTask(String name, Double[]nums, int start, int end){
		System.out.println("name:" + name + ", start:" + start + ", end:" + end);
		this.nums = nums;
		this.start = start;
		this.end = end;
	}

	/*
	 * (非 Javadoc)
	 * @see java.util.concurrent.RecursiveTask#compute()
	 * タスクによって実行される計算処理を実装する。
	 */
	protected Double compute(){
		if(end - start <= 3){
			double sum = 0.0;
			for(int i=start;i<end;i++){
				nums[i] = Math.random() * 100;
				System.out.println("nums[" + i + "] " + nums[i]);
				sum += nums[i];
			}
			return sum;
		}else{
			int middle = start + (end - start)/2;
			System.out.println("start:" + start + ", middle:" + middle + ", end:" + end);
			ExamRecursiveTask task1 = new ExamRecursiveTask("f1", nums, start, middle);
			ExamRecursiveTask task2 = new ExamRecursiveTask("f2", nums, middle, end);
			task1.fork(); // １つのタスクをフォークし、パラレルに実行する？ - タスクを非同期で実行するための調整を行う？
			Double sum1 = task2.compute(); // タスクを処理する
//			task2.fork();
			Double sum2 = task1.join(); // task1.forkの実行結果を受け取っている。
//			Double sum1 = task2.join();
			return sum1 + sum2;
		}
	}

}
