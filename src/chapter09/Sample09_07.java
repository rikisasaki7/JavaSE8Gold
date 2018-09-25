package chapter09;

import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * nio2
 * relativizeメソッド
 */
public class Sample09_07 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Path p1 = Paths.get("X");
		Path p2 = Paths.get("Y/Z");
		System.out.println("X -> Y 相対パス：" + p1.relativize(p2));
			// - 「X -> Y 相対パス：..\Y」と出力
		System.out.println("Y -> X 相対パス：" + p2.relativize(p1));
		// - 「X -> Y 相対パス：..\Y」と出力

		// - 「X -> Y 相対パス：..\Y\Z」
		// - 「Y -> X 相対パス：..\..\X」

	}

}
